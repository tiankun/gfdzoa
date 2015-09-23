package com.gfdz.service.impl.gc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.gc.PurchaseDetailServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("purchaseDetailService")
@Transactional
public class PurchaseDetailServiceImpl extends CommonServiceImpl implements PurchaseDetailServiceI {
	
}