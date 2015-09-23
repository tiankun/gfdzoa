package com.gfdz.service.impl.gc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.gc.SafetyCheckServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("safetyCheckService")
@Transactional
public class SafetyCheckServiceImpl extends CommonServiceImpl implements SafetyCheckServiceI {
	
}