package com.gfdz.service.impl.gc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.gc.ProjectTaskServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("projectTaskService")
@Transactional
public class ProjectTaskServiceImpl extends CommonServiceImpl implements ProjectTaskServiceI {
	
}