package com.gfdz.service.impl.cw;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.cw.ExpensesPlanDetailServiceI;

@Service("expensesPlanDetailService")
@Transactional
public class ExpensesPlanDetailServiceImpl extends CommonServiceImpl implements ExpensesPlanDetailServiceI {
	
}