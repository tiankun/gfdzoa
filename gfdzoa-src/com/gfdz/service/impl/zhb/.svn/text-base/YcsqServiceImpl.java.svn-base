package com.gfdz.service.impl.zhb;
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
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.workflow.WorkFlowSetEntity;
import com.gfdz.entity.zhb.YcsqEntity;
import com.gfdz.service.zhb.YcsqServiceI;

@Service("ycsqService")
@Transactional
public class YcsqServiceImpl extends CommonServiceImpl implements YcsqServiceI {

	@Autowired
    private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void ycsqWorkFlowStart(YcsqEntity ycsq, HttpServletRequest request) {
		//由session取到登录用户id
		String applyUserId = ResourceUtil.getSessionUserName().getId();
		ycsq.setSqr(applyUserId);
		this.save(ycsq);
	    String processKey = request.getParameter("processKey");
        if(!StringUtil.isNotEmpty(processKey)){
        	WorkFlowSetEntity workFlowSet = this.findUniqueByProperty(WorkFlowSetEntity.class, "entityName", ycsq.getClass().getSimpleName());
        	processKey = workFlowSet.getProcessKey();
        }
		
		String businessKey = ycsq.getId().toString();
        ProcessInstance processInstance = null;
        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        identityService.setAuthenticatedUserId(applyUserId);

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put(ProcessConstantsUtil.getApplyUserId(),applyUserId);
        processInstance = runtimeService.startProcessInstanceByKey(processKey, businessKey, variables);
        String processInstanceId = processInstance.getId();
        ycsq.setProcessinstanceid(processInstanceId);
        
    	//获取并执行当前流程实例的下一步任务
        Task task = null;
		TaskQuery query = taskService.createTaskQuery().processInstanceBusinessKey(businessKey).active();
		task = query.singleResult();
		variables.put(ProcessConstantsUtil.getDeptLeaderId(), ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
		taskService.complete(task.getId(),variables);
        logger.info("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"leave", businessKey, processInstanceId, variables});
		
		
	}

	@Override
	public void completeTask(YcsqEntity ycsq, HttpServletRequest request) {
		String taskId = request.getParameter("taskId");	//任务id
		String taskKey = request.getParameter("taskKey");	//任务步骤
		String auditType = request.getParameter("auditType");//是否同意
		String postil = request.getParameter("postil");      //批注信息
		Map<String, Object> variables = taskService.getVariables(taskId);
		if(taskKey.equals(ProcessConstantsUtil.getDeptLeaderAudit())){
			variables.put(ProcessConstantsUtil.getDeptLeaderPass(), "0".equals(auditType) ? false : true);
			TSDepart tsDepart = this.findUniqueByProperty(TSDepart.class, "description", ProcessConstantsUtil.getOfficeLeaderAudit());
			variables.put(ProcessConstantsUtil.getOfficeLeaderId(), tsDepart.getDepartManager().getId());
		}else if(taskKey.equals(ProcessConstantsUtil.getOfficeLeaderAudit())){
			variables.put(ProcessConstantsUtil.getOfficeLeaderPass(), "0".equals(auditType) ? false : true);
			variables.put(ProcessConstantsUtil.getSendCarId(),request.getParameter("sendCarId"));
		}else if(taskKey.equals(ProcessConstantsUtil.getSubmitOrModify())){
			this.saveOrUpdate(ycsq);
			variables.put(ProcessConstantsUtil.getDeptLeaderId(), ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
		}
		
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		if(postil!=null){
			taskService.addComment(taskId, task.getProcessInstanceId(), postil);
		}
		
		taskService.complete(taskId, variables);
	}

	
}