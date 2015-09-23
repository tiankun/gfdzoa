package com.gfdz.service.impl.hr;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.hr.PerformanceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("performanceService")
@Transactional
public class PerformanceServiceImpl extends CommonServiceImpl implements PerformanceServiceI {
	
}