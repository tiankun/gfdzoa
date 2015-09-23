package com.gfdz.service.gc;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.gc.CostApprovalEntity;

public interface CostApprovalService extends CommonService{
	
	public void costWorkFlowStart(CostApprovalEntity costApproval,HttpServletRequest request);

	public void completeTask(CostApprovalEntity costApproval,HttpServletRequest request);
}
