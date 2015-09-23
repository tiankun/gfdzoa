package com.gfdz.service.impl.hr;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.hr.AttendanceEntity;
import com.gfdz.service.hr.AttendanceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.demo.entity.test.CourseEntity;
import org.jeecgframework.web.demo.entity.test.StudentEntity;

@Service("attendanceService")
@Transactional
public class AttendanceServiceImpl extends CommonServiceImpl implements AttendanceServiceI {
	public void saveAttendance(AttendanceEntity attendance){
		this.save(attendance);
		/*
		 * this.save(course.getTeacher());
		this.save(course);
		for (StudentEntity s :course.getStudents()){
			s.setCourse(course);
		}
		this.batchSave(course.getStudents());
		 * */
	} ;
}