package com.gfdz.service.impl.gc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.gc.ProjectScheduleDetailServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("projectScheduleDetailService")
@Transactional
public class ProjectScheduleDetailServiceImpl extends CommonServiceImpl implements ProjectScheduleDetailServiceI {
	
}