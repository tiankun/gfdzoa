package com.gfdz.service.gc;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.gc.WagesDeclareEntity;

public interface WagesDeclareService extends CommonService{
	public void wagesWorkFlowStart(WagesDeclareEntity wagesDeclare,HttpServletRequest request);

	public void completeTask(WagesDeclareEntity wagesDeclare,HttpServletRequest request);

}
