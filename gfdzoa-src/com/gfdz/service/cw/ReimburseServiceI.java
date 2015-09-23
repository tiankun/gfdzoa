package com.gfdz.service.cw;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.cw.ReimburseEntity;

public interface ReimburseServiceI extends CommonService{
	/**
	 * 
	  * @Title: reimburseWorkFlowStart
	  * @Description: 启动报账流程
	  * @param reimburse
	  * @param request void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月6日 上午10:45:42
	 */
	public void reimburseWorkFlowStart(ReimburseEntity reimburse,HttpServletRequest request);
	public void updateReimburse(ReimburseEntity reimburse,HttpServletRequest request) throws Exception;

}
