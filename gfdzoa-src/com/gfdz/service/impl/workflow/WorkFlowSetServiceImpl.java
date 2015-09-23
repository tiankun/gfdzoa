package com.gfdz.service.impl.workflow;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.workflow.WorkFlowSetService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("workFlowSetService")
@Transactional
public class WorkFlowSetServiceImpl extends CommonServiceImpl implements WorkFlowSetService {
	
}