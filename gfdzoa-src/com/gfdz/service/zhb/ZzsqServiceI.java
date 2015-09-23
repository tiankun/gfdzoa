package com.gfdz.service.zhb;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.zhb.ZzsqEntity;

public interface ZzsqServiceI extends CommonService{
	
	/**
	 * 
	  * @Title: zzsqWorkFlowStart
	  * @Description: 开始证章申请流程
	  * @param zzsq void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月16日 下午3:52:50
	 */
	public void zzsqWorkFlowStart(ZzsqEntity zzsq,HttpServletRequest request);
	
	/**
	 * 
	  * @Title: completeTask
	  * @Description: 证章申请处理
	  * @param zzsq
	  * @param request void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月20日 上午9:29:39
	 */
	public void completeTask(ZzsqEntity zzsq,HttpServletRequest request);

}
