package com.gfdz.service.impl.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.workflow.Leave;
import com.gfdz.service.workflow.LeaveService;
import com.gfdz.util.workflow.ProcessConstants;

@Service("leavesServices")
@Transactional
public class LeaveServiceImpl extends CommonServiceImpl implements LeaveService {
	
	@Autowired
    private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 启动请假流程
	 * @param leave
	 */
	public void leaveWorkFlowStart(Leave entity){
        this.save(entity);
        logger.debug("save entity: {}", entity);
        
        String businessKey = entity.getId().toString();
        ProcessInstance processInstance = null;
        try {
            // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
            identityService.setAuthenticatedUserId(entity.getUserId());

            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put(ProcessConstants.KEY_APPLY_USER_ID,entity.getUserId() );
            processInstance = runtimeService.startProcessInstanceByKey("leaveProcess", businessKey, variables);
            String processInstanceId = processInstance.getId();
            entity.setProcessInstanceId(processInstanceId);
            
        	//获取并执行当前流程实例的下一步任务
    		Task task = null;
    		TaskQuery query = taskService.createTaskQuery().taskCandidateOrAssigned(entity.getUserId()).active();
    	    List<Task> todoList = query.list();
    	    for (Task tmp : todoList) {
    			if(tmp.getProcessInstanceId().equals(processInstance.getId())){
    				task = tmp;
    				break;
    			}
    		}
    		variables.put(ProcessConstants.KEY_DEPT_LEADER_ID, ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
    		taskService.complete(task.getId(),variables);
            logger.debug("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"leave", businessKey, processInstanceId, variables});
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
		
	}
	
}
