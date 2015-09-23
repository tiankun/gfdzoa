package com.gfdz.service.impl.hr;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.hr.InterviewService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("interviewService")
@Transactional
public class InterviewServiceImpl extends CommonServiceImpl implements InterviewService {
	
}