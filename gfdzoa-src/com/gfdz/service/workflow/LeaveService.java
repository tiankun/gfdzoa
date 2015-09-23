package com.gfdz.service.workflow;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.workflow.Leave;

public interface LeaveService extends CommonService {
	
	
	/**
	 * 启动请假流程
	 * @param leave
	 */
	public void leaveWorkFlowStart(Leave entity);

}
