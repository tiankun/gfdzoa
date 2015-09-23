package com.gfdz.service.gc;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.gc.ProjectScheduleEntity;

public interface ProjectScheduleServiceI extends CommonService{
	/**
	  * @Title: saveProjectSchedule
	  * @Description: TODO void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月13日 下午3:02:50
	 */
	public void saveProjectSchedule(ProjectScheduleEntity projectSchedule,HttpServletRequest request);
}
