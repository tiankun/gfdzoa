package com.gfdz.service.impl.cw;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.cw.ExpensesPlanDetailEntity;
import com.gfdz.entity.cw.ExpensesPlanEntity;
import com.gfdz.service.cw.ExpensesPlanServiceI;

@Service("expensesPlanService")
@Transactional
public class ExpensesPlanServiceImpl extends CommonServiceImpl implements ExpensesPlanServiceI {
	@Autowired
    private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void expensesPlanWorkFlowStart(ExpensesPlanEntity expensesPlan,HttpServletRequest request) {
		//由session取到登录用户id
		TSUser applyUser = ResourceUtil.getSessionUserName();
		expensesPlan.setUserId(applyUser);
		expensesPlan.setDepart(applyUser.getCurrentDepart());
		this.save(expensesPlan);
		
		List<ExpensesPlanDetailEntity> list = expensesPlan.getExpensesPlanDetail();	
		if(list!=null && list.size()>0){
			for (int k = list.size()-1;k >= 0 ;k--) {
				ExpensesPlanDetailEntity ep = list.get(k);
				if(ep!=null){
					ep.setExpensesPlan(expensesPlan);
					this.save(ep);
				}
			}
		}
		/* String processKey = request.getParameter("processKey");
        if(!StringUtil.isNotEmpty(processKey)){
        	WorkFlowSetEntity workFlowSet = this.findUniqueByProperty(WorkFlowSetEntity.class, "entityName", expensesPlan.getClass().getSimpleName());
        	processKey = workFlowSet.getProcessKey();
        }
		
		String businessKey = expensesPlan.getId().toString();
        ProcessInstance processInstance = null;
        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        identityService.setAuthenticatedUserId(applyUser.getId());

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put(ProcessConstantsUtil.getApplyUserId(),applyUser.getId());
        processInstance = runtimeService.startProcessInstanceByKey(processKey, businessKey, variables);
        String processInstanceId = processInstance.getId();
        expensesPlan.setProcessinstanceid(processInstanceId);
        
    	//获取并执行当前流程实例的下一步任务
		Task task = null;
		TaskQuery query = taskService.createTaskQuery().taskCandidateOrAssigned(applyUser.getId()).active();
	    List<Task> todoList = query.list();
	    for (Task tmp : todoList) {
			if(tmp.getProcessInstanceId().equals(processInstance.getId())){
				task = tmp;
				break;
			}
		}
		variables.put(ProcessConstantsUtil.getDeptLeaderId(), ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
		taskService.complete(task.getId(),variables);
        logger.info("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"leave", businessKey, processInstanceId, variables});*/
		
		
	}
	@Override
	public void updateExpensesPlan(ExpensesPlanEntity expensesPlan,
			HttpServletRequest request) throws Exception {

		List<ExpensesPlanDetailEntity> list = this.findByProperty(ExpensesPlanDetailEntity.class, "expensesPlan.id", expensesPlan.getId());
		if(list.size()>0){
			for (ExpensesPlanDetailEntity  expensesPlanDetailEntity : list) {
				this.delete(expensesPlanDetailEntity);
			}
		}
		ExpensesPlanEntity t = this.get(ExpensesPlanEntity.class, expensesPlan.getId());
			MyBeanUtils.copyBeanNotNull2Bean(expensesPlan, t);
			t.setExpensesPlanDetail(null);
			this.saveOrUpdate(t);
			if(expensesPlan.getExpensesPlanDetail()!=null&&expensesPlan.getExpensesPlanDetail().size()>0){
				
				for (ExpensesPlanDetailEntity  expensesPlanDetail : expensesPlan.getExpensesPlanDetail()) {
					expensesPlanDetail.setExpensesPlan(t);
					if(expensesPlanDetail!=null && expensesPlanDetail.getPlanMoney()!=null){
						this.save(expensesPlanDetail);
					}
				}
				
			}
		
	
		
	}
}