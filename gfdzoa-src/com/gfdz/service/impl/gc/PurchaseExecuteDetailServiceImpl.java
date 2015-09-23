package com.gfdz.service.impl.gc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.gc.PurchaseExecuteDetailServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("purchaseExecuteDetailService")
@Transactional
public class PurchaseExecuteDetailServiceImpl extends CommonServiceImpl implements PurchaseExecuteDetailServiceI {
	
}