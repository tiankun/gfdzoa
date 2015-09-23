package com.gfdz.service.impl.hr;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.hr.LeaveOfficeService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("leaveOfficeService")
@Transactional
public class LeaveOfficeServiceImpl extends CommonServiceImpl implements LeaveOfficeService {
	
}