package com.gfdz.service.impl.cw;


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
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.cw.BillEntity;
import com.gfdz.entity.workflow.WorkFlowSetEntity;
import com.gfdz.service.cw.BillServiceI;

@Service("billService")
@Transactional
public class BillServiceImpl extends CommonServiceImpl implements BillServiceI {
	@Autowired
    private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void billWorkFlowStart(BillEntity bill, HttpServletRequest request) {
		//由session取到登录用户id
				TSUser applyUserId = ResourceUtil.getSessionUserName();
				bill.setUserId(applyUserId);
				this.save(bill);
			    String processKey = request.getParameter("processKey");
		        if(!StringUtil.isNotEmpty(processKey)){
		        	WorkFlowSetEntity workFlowSet = this.findUniqueByProperty(WorkFlowSetEntity.class, "entityName", bill.getClass().getSimpleName());
		        	processKey = workFlowSet.getProcessKey();
		        }
				
				String businessKey = bill.getId().toString();
		        ProcessInstance processInstance = null;
		        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
		        identityService.setAuthenticatedUserId(applyUserId.getId());

		        Map<String, Object> variables = new HashMap<String, Object>();
		        variables.put(ProcessConstantsUtil.getApplyUserId(),applyUserId.getId());
		        processInstance = runtimeService.startProcessInstanceByKey(processKey, businessKey, variables);
		        String processInstanceId = processInstance.getId();
		        bill.setProcessinstanceid(processInstanceId);
		        
		    	//获取并执行当前流程实例的下一步任务
				Task task = null;
				TaskQuery query = taskService.createTaskQuery().taskCandidateOrAssigned(applyUserId.getId()).active();
			    List<Task> todoList = query.list();
			    for (Task tmp : todoList) {
					if(tmp.getProcessInstanceId().equals(processInstance.getId())){
						task = tmp;
						break;
					}
				}
				variables.put(ProcessConstantsUtil.getDeptLeaderId(), ResourceUtil.getSessionUserName().getCurrentDepart().getDepartManager().getId());
				taskService.complete(task.getId(),variables);
		        logger.info("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"leave", businessKey, processInstanceId, variables});
				
				
			}
		
	}
	
