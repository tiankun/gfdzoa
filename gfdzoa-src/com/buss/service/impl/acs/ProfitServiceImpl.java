package com.buss.service.impl.acs;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.acs.ProfitServiceI;

@Service("profitService")
@Transactional
public class ProfitServiceImpl extends CommonServiceImpl implements ProfitServiceI {
	
}