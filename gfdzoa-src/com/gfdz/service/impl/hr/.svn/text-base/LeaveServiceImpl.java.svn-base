package com.gfdz.service.impl.hr;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.hr.LeaveEntity;
import com.gfdz.entity.workflow.WorkFlowSetEntity;
import com.gfdz.service.hr.LeaveService;

@Service("leaveService")
@Transactional
public class LeaveServiceImpl extends CommonServiceImpl implements LeaveService {
	
	@Autowired
    private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	

	@Override
	public void leaveWorkFlowStart(LeaveEntity entity,HttpServletRequest request) {
		String userId = ResourceUtil.getSessionUserName().getId();
		entity.setLeaveUser(ResourceUtil.getSessionUserName());
        this.save(entity);
        logger.debug("save entity: {}", entity);
        String processKey = request.getParameter("processKey");
        if(!StringUtil.isNotEmpty(processKey)){
        	WorkFlowSetEntity workFlowSet = this.findUniqueByProperty(WorkFlowSetEntity.class, "entityName", entity.getClass().getSimpleName());
        	processKey = workFlowSet.getProcessKey();
        }
        
        String businessKey = entity.getId().toString();
        ProcessInstance processInstance = null;
        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        identityService.setAuthenticatedUserId(userId);

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put(ProcessConstantsUtil.getApplyUserId(),userId );
        processInstance = runtimeService.startProcessInstanceByKey(processKey, businessKey, variables);
        String processInstanceId = processInstance.getId();
        entity.setProcessinstanceid(processInstanceId);
        
    	//获取并执行当前流程实例的下一步任务
		Task task = null;
		TaskQuery query = taskService.createTaskQuery().taskCandidateOrAssigned(userId).active();
	    List<Task> todoList = query.list();
	    for (Task tmp : todoList) {
			if(tmp.getProcessInstanceId().equals(processInstance.getId())){
				task = tmp;
				break;
			}
		}
		variables.put(ProcessConstantsUtil.getDeptLeaderId(), ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
		taskService.complete(task.getId(),variables);
		
		if(userId.equals(ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId())){
			 query = taskService.createTaskQuery().taskCandidateOrAssigned(userId).active();
    	     todoList = query.list();
    	    for (Task tmp : todoList) {
    			if(tmp.getProcessInstanceId().equals(processInstance.getId())){
    				task = tmp;
    				break;
    			}
    		}
    	    
    	    variables.put(ProcessConstantsUtil.getDeptLeaderPass(), true);
			variables.put(ProcessConstantsUtil.getLeaveDays(),3);
			variables.put(ProcessConstantsUtil.getLeaderManagerId(), ResourceUtil.getSessionUserName().getCurrentDepart().getManagerLeader().getId());
    		taskService.complete(task.getId(),variables);
		}
        logger.debug("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"leave", businessKey, processInstanceId, variables});
	
	}


	@Override
	public void completeTask(LeaveEntity leave, HttpServletRequest request) {
		String taskId = request.getParameter("taskId");	//任务id
		String taskKey = request.getParameter("taskKey");	//任务步骤
		String auditType = request.getParameter("auditType");//是否同意
		String postil = request.getParameter("postil");      //批注信息
		String leaveDays = request.getParameter("leaveDays"); //请假天数
		Map<String, Object> variables = taskService.getVariables(taskId);
		if(taskKey.equals(ProcessConstantsUtil.getDeptLeaderAudit())){
			variables.put(ProcessConstantsUtil.getDeptLeaderPass(), "0".equals(auditType) ? false : true);
			variables.put(ProcessConstantsUtil.getLeaveDays(), Double.valueOf(leaveDays));
			variables.put(ProcessConstantsUtil.getLeaderManagerId(), ResourceUtil.getSessionUserName().getCurrentDepart().getManagerLeader().getId());
		}else if(taskKey.equals(ProcessConstantsUtil.getLeaderManagerAudit())){
			variables.put(ProcessConstantsUtil.getLeaderManagerPass(), "0".equals(auditType) ? false : true);
		}else if(taskKey.equals(ProcessConstantsUtil.getSubmitOrModify())){
			this.saveOrUpdate(leave);
			variables.put(ProcessConstantsUtil.getDeptLeaderId(), ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
		}
		
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		taskService.addComment(taskId, task.getProcessInstanceId(), postil);
		taskService.complete(taskId, variables);
	}
	
}