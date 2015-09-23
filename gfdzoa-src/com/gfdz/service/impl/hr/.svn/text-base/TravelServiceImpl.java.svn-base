package com.gfdz.service.impl.hr;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.cw.AdvanceEntity;
import com.gfdz.entity.cw.InOutRecordEntity;
import com.gfdz.entity.hr.TravelEntity;
import com.gfdz.entity.hr.TravelPathEntity;
import com.gfdz.entity.workflow.WorkFlowSetEntity;
import com.gfdz.service.gc.CodeServiceI;
import com.gfdz.service.hr.TravelServiceI;

@Service("travelService")
@Transactional
public class TravelServiceImpl extends CommonServiceImpl implements TravelServiceI {

	@Autowired
    private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	@Autowired
    private CodeServiceI codeServiceI;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void travelWorkFlowStart(TravelEntity travel,HttpServletRequest request) {
		//由session取到登录用户id
		String applyUserId = ResourceUtil.getSessionUserName().getId();
		travel.setTravelUser(ResourceUtil.getSessionUserName());
		this.save(travel);
		//如有暂支出则生成暂支单
		if("1".equals(travel.getIszanzhi())){
			AdvanceEntity advance = new AdvanceEntity();
			advance.setBillCode(codeServiceI.getCode("ZZD", 4));
			advance.setApplyMoney(travel.getZzmoney());
			advance.setApplyTime(new Date());
			advance.setUserId(ResourceUtil.getSessionUserName());
			advance.setDepart(ResourceUtil.getSessionUserName().getCurrentDepart());
			//收支记录表
			InOutRecordEntity inOut = new InOutRecordEntity();
			inOut.setBillType("ZZD");
			inOut.setInoutType(-1);
			inOut.setBillCode(advance.getBillCode());
			inOut.setPayoutMoney(advance.getApplyMoney());
			inOut.setPayType(2);
			inOut.setPayTime(new Date());
		}

		List<TravelPathEntity> list = travel.getTravelPaths();	
		if(list!=null && list.size()>0){
			for (int k = list.size()-1;k >= 0 ;k--) {
				TravelPathEntity tp = list.get(k);
				if(tp!=null && tp.getProvince()!=null){
					tp.setTravel(travel);
					this.save(tp);
				}
			}
		}
		
	    String processKey = request.getParameter("processKey");
        if(!StringUtil.isNotEmpty(processKey)){
        	WorkFlowSetEntity workFlowSet = this.findUniqueByProperty(WorkFlowSetEntity.class, "entityName", travel.getClass().getSimpleName());
        	processKey = workFlowSet.getProcessKey();
        }
		
		String businessKey = travel.getId().toString();
        ProcessInstance processInstance = null;
        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        identityService.setAuthenticatedUserId(applyUserId);

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put(ProcessConstantsUtil.getApplyUserId(),applyUserId);
        processInstance = runtimeService.startProcessInstanceByKey(processKey, businessKey, variables);
        String processInstanceId = processInstance.getId();
        travel.setProcessinstanceid(processInstanceId);
        
    	//获取并执行当前流程实例的下一步任务
		Task task = null;
		TaskQuery query = taskService.createTaskQuery().processInstanceBusinessKey(businessKey).active();
		task = query.singleResult();
		variables.put(ProcessConstantsUtil.getDeptLeaderId(), ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
		taskService.complete(task.getId(),variables);
        logger.info("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"leave", businessKey, processInstanceId, variables});
		
	}

	@Override
	public void updateTravel(TravelEntity travel) throws Exception {
		List<TravelPathEntity> list = this.findByProperty(TravelPathEntity.class, "travel.id", travel.getId());
		if(list!=null && list.size()>0){
			for (TravelPathEntity  travelPath : list) {
				this.delete(travelPath);
			}
		}
		TravelEntity t = this.findUniqueByProperty(TravelEntity.class,"id", travel.getId());
		MyBeanUtils.copyBeanNotNull2Bean(travel, t);
		t.setTravelPaths(null);
		this.saveOrUpdate(t);
		if(travel.getTravelPaths()!=null && travel.getTravelPaths().size()>0){
			for (TravelPathEntity  travelPath :  travel.getTravelPaths()) {
				if(travelPath!=null && travelPath.getCounty()!=null &&travelPath.getCounty().getId()!=null){
					travelPath.setTravel(t);
					this.save(travelPath);
				}
			}
		}
		
	}

	@Override
	public void completeTask(TravelEntity travel, HttpServletRequest request)
			throws Exception {
		String taskId = request.getParameter("taskId");	//任务id
		String taskKey = request.getParameter("taskKey");	//任务步骤
		String auditType = request.getParameter("auditType");//是否同意
		String postil = request.getParameter("postil");      //批注信息
		String iszanzhi = request.getParameter("iszanzhi");
		String isplane = request.getParameter("isplane");
		Map<String, Object> variables = taskService.getVariables(taskId);
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		if(taskKey.equals(ProcessConstantsUtil.getDeptLeaderAudit())){
			variables.put(ProcessConstantsUtil.getDeptLeaderPass(), "0".equals(auditType) ? false : true);
			variables.put(ProcessConstantsUtil.getIsExpenditure(), "0".equals(iszanzhi) ? false : true);
			variables.put(ProcessConstantsUtil.getIsPlane(), isplane.contains("1") ? true : false);
			TSDepart tsDepart = this.findUniqueByProperty(TSDepart.class, "description", ProcessConstantsUtil.getTreasurerAudit());
			variables.put(ProcessConstantsUtil.getTreasurerId(),tsDepart.getDepartManager().getId());
			variables.put(ProcessConstantsUtil.getLeaderManagerId(), ResourceUtil.getSessionUserName().getCurrentDepart().getManagerLeader().getId());
		}else if(taskKey.equals(ProcessConstantsUtil.getLeaderManagerAudit())){
			variables.put(ProcessConstantsUtil.getLeaderManagerPass(), "0".equals(auditType) ? false : true);
		}else if(taskKey.equals(ProcessConstantsUtil.getTreasurerAudit())){
			variables.put(ProcessConstantsUtil.getTreasurerPass(), "0".equals(auditType) ? false : true);
			variables.put(ProcessConstantsUtil.getLeaderManagerId(), ResourceUtil.getSessionUserName().getCurrentDepart().getManagerLeader().getId());
		}else if(taskKey.equals(ProcessConstantsUtil.getSubmitOrModify())){
			variables.put(ProcessConstantsUtil.getDeptLeaderId(), ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
			this.updateTravel(travel);
		}
		if(postil!=null){
			taskService.addComment(taskId, task.getProcessInstanceId(), postil);
		}
		
		taskService.complete(taskId, variables);
	}
	
	
	
}