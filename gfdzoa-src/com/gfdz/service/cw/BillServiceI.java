package com.gfdz.service.cw;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.cw.BillEntity;

public interface BillServiceI extends CommonService{
	public void billWorkFlowStart(BillEntity bill,HttpServletRequest request);
}
