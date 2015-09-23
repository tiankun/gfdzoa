package com.gfdz.service.impl.hr;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.hr.PersonChangeService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("personChangeService")
@Transactional
public class PersonChangeServiceImpl extends CommonServiceImpl implements PersonChangeService {
	
}