package com.gfdz.service.hr;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.hr.TravelEntity;

public interface TravelServiceI extends CommonService{

	/**
	 * 
	  * @Title: travelWorkFlowStart
	  * @Description: 启动出差流程
	  * @param travel
	  * @param request void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月20日 上午10:10:03
	 */
	public void travelWorkFlowStart(TravelEntity travel,HttpServletRequest request);
	
	/**
	 * 
	  * @Title: updateTravel
	  * @Description: 修改出差申请
	  * @param travel
	  * @throws Exception void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月20日 上午10:38:00
	 */
	public void updateTravel(TravelEntity travel) throws Exception;
	
	/**
	 * 
	  * @Title: completeTask
	  * @Description: 办理出差审批任务
	  * @param travel
	  * @param request
	  * @throws Exception void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月20日 上午8:39:54
	 */
	public void completeTask(TravelEntity travel,HttpServletRequest request)throws Exception;


}
