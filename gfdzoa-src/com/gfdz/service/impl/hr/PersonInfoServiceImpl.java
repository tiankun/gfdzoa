package com.gfdz.service.impl.hr;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.hr.PersonInfoService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("personInfoService")
@Transactional
public class PersonInfoServiceImpl extends CommonServiceImpl implements PersonInfoService {
	
}