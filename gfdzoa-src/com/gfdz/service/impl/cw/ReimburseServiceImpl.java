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

import com.gfdz.entity.cw.ReimburseDetailEntity;
import com.gfdz.entity.cw.ReimburseEntity;
import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.service.cw.ReimburseServiceI;

@Service("reimburseService")
@Transactional
public class ReimburseServiceImpl extends CommonServiceImpl implements ReimburseServiceI {
	@Autowired
    private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	ProjectInfoEntity  pi;	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void reimburseWorkFlowStart(ReimburseEntity reimburse,HttpServletRequest request) {
		//由session取到登录用户id
		TSUser applyUser = ResourceUtil.getSessionUserName();
	    
	    List<ProjectInfoEntity> listp=this.findHql("from ProjectInfoEntity p where p.id=?", new Object[]{request.getParameter("projectId.id")});
	    
	    
	    if(listp.size()>0){
	    	pi=listp.get(0);
	    }
	    reimburse.setUserId(applyUser);
	    reimburse.setDepart(applyUser.getCurrentDepart());
		reimburse.setProjectId(pi);
		this.save(reimburse);
		
		List<ReimburseDetailEntity> list = reimburse.getReimburseDetail();	
		if(list!=null && list.size()>0){
			for (int k = list.size()-1;k >= 0 ;k--) {
				ReimburseDetailEntity rd = list.get(k);
				if(rd!=null){
					rd.setReimburse(reimburse);
					this.save(rd);
				}
			}
		}
//	    String processKey = request.getParameter("processKey");
//        if(!StringUtil.isNotEmpty(processKey)){
//        	WorkFlowSetEntity workFlowSet = this.findUniqueByProperty(WorkFlowSetEntity.class, "entityName", reimburse.getClass().getSimpleName());
//        	processKey = workFlowSet.getProcessKey();
//        }
//		
//		String businessKey = reimburse.getId().toString();
//        ProcessInstance processInstance = null;
//        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
//        identityService.setAuthenticatedUserId(applyUser.getId());
//
//        Map<String, Object> variables = new HashMap<String, Object>();
//        variables.put(ProcessConstantsUtil.getApplyUserId(),applyUser.getId());
//        processInstance = runtimeService.startProcessInstanceByKey(processKey, businessKey, variables);
//        String processInstanceId = processInstance.getId();
//        reimburse.setProcessinstanceid(processInstanceId);
//        
//    	//获取并执行当前流程实例的下一步任务
//		Task task = null;
//		TaskQuery query = taskService.createTaskQuery().taskCandidateOrAssigned(applyUser.getId()).active();
//	    List<Task> todoList = query.list();
//	    for (Task tmp : todoList) {
//			if(tmp.getProcessInstanceId().equals(processInstance.getId())){
//				task = tmp;
//				break;
//			}
//		}
//		variables.put(ProcessConstantsUtil.getDeptLeaderId(), ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
//		taskService.complete(task.getId(),variables);
//        logger.info("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"leave", businessKey, processInstanceId, variables});
//		
//		
	}

	@Override
	public void updateReimburse(ReimburseEntity reimburse,
			HttpServletRequest request) throws Exception {
		List<ReimburseDetailEntity> list = this.findByProperty(ReimburseDetailEntity.class, "reimburse.id", reimburse.getId());
		if(list.size()>0){
			for (ReimburseDetailEntity  reimburseDetail : list) {
				this.delete(reimburseDetail);
			}
		}
		ReimburseEntity t = this.get(ReimburseEntity.class, reimburse.getId());
			MyBeanUtils.copyBeanNotNull2Bean(reimburse, t);
			t.setReimburseDetail(null);
			this.saveOrUpdate(t);
			if(reimburse.getReimburseDetail()!=null&&reimburse.getReimburseDetail().size()>0){
				
				for (ReimburseDetailEntity  reimburseDetail : reimburse.getReimburseDetail()) {
					reimburseDetail.setReimburse(t);
					if(reimburseDetail!=null && reimburseDetail.getPaymoney()!=null){
						this.save(reimburseDetail);
					}
				}
				
			}
		
	}
	
}