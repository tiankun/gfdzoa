package com.gfdz.service.zhb;
import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.zhb.YcsqEntity;

public interface YcsqServiceI extends CommonService{
	/**
	 * 
	  * @Title: ycsqWorkFlowStart
	  * @Description: 启动一个用车申请流程
	  * @param ycsq
	  * @param request void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月6日 上午10:13:06
	 */
	public void ycsqWorkFlowStart(YcsqEntity ycsq, HttpServletRequest request);
	
	/**
	 * 
	  * @Title: completeTask
	  * @Description: 用车申请业务办理
	  * @param ycsq
	  * @param request void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月20日 上午9:32:02
	 */
	public void completeTask(YcsqEntity ycsq, HttpServletRequest request);

}
