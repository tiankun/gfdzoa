package com.gfdz.service.impl.gc;

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
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.gc.WagesDeclareEntity;
import com.gfdz.entity.workflow.WorkFlowSetEntity;
import com.gfdz.service.gc.WagesDeclareService;

@Service("wagesDeclareService")
@Transactional
public class WagesDeclareServiceImpl extends CommonServiceImpl implements WagesDeclareService {
	@Autowired
    private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	@Override
	public void wagesWorkFlowStart(WagesDeclareEntity wagesDeclare,HttpServletRequest request) {

		//由session取到登录用户id
		String applyUserId = ResourceUtil.getSessionUserName().getId();
		wagesDeclare.setDeclare(applyUserId);
		this.save(wagesDeclare);
	    String processKey = request.getParameter("processKey");
        if(!StringUtil.isNotEmpty(processKey)){
        	WorkFlowSetEntity workFlowSet = this.findUniqueByProperty(WorkFlowSetEntity.class, "entityName", wagesDeclare.getClass().getSimpleName());
        	processKey = workFlowSet.getProcessKey();
        }
		
		String businessKey = wagesDeclare.getId().toString();
        ProcessInstance processInstance = null;
        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        identityService.setAuthenticatedUserId(applyUserId);

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put(ProcessConstantsUtil.getApplyUserId(),applyUserId);
        processInstance = runtimeService.startProcessInstanceByKey(processKey, businessKey, variables);
        String processInstanceId = processInstance.getId();
        wagesDeclare.setProcessinstanceId(processInstanceId);
        
    	//获取并执行当前流程实例的下一步任务
		Task task = taskService.createTaskQuery().processInstanceBusinessKey(businessKey).active().singleResult();
		variables.put(ProcessConstantsUtil.getDeptLeaderId(), ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
		taskService.complete(task.getId(),variables);
	}

	@Override
	public void completeTask(WagesDeclareEntity wagesDeclare,HttpServletRequest request) {
		String taskId = request.getParameter("taskId");	//任务id
		String taskKey = request.getParameter("taskKey");	//任务步骤
		String auditType = request.getParameter("auditType");//是否同意
		String postil = request.getParameter("postil");      //批注信息
		Map<String, Object> variables = taskService.getVariables(taskId);
		if(taskKey.equals(ProcessConstantsUtil.getDeptLeaderAudit())){
			variables.put(ProcessConstantsUtil.getDeptLeaderPass(), "0".equals(auditType) ? false : true);
			variables.put(ProcessConstantsUtil.getLeaderManagerId(), ResourceUtil.getSessionUserName().getCurrentDepart().getManagerLeader().getId());
		}else if(taskKey.equals(ProcessConstantsUtil.getLeaderManagerAudit())){
			variables.put(ProcessConstantsUtil.getLeaderManagerPass(), "0".equals(auditType) ? false : true);
			variables.put(ProcessConstantsUtil.getApplyUserId(),request.getParameter("applyUserId"));
		}else if(taskKey.equals(ProcessConstantsUtil.getAccountantId())){
			taskService.claim(taskId, ResourceUtil.getSessionUserName().getId());
			variables.put(ProcessConstantsUtil.getTreasurerPass(),  "0".equals(auditType) ? false : true);
			variables.put(ProcessConstantsUtil.getIsOverBudget(),  "0".equals(auditType) ? false : true);

		}else if(taskKey.equals(ProcessConstantsUtil.getSubmitOrModify())){
			this.saveOrUpdate(wagesDeclare);
			variables.put(ProcessConstantsUtil.getDeptLeaderId(), ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
		}
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		if(postil!=null){
			taskService.addComment(taskId, task.getProcessInstanceId(), postil);
		}
		
		taskService.complete(taskId, variables);
		
	}
	
}