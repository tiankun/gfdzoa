package com.gfdz.service.hr;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.demo.entity.test.CourseEntity;
import org.jeecgframework.web.demo.entity.test.StudentEntity;

import com.gfdz.entity.hr.AttendanceEntity;

public interface AttendanceServiceI extends CommonService{
	public void saveAttendance(AttendanceEntity attendance); 
}
