package com.gfdz.service.impl.cw;
import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.cw.PayforDetailEntity;
import com.gfdz.service.cw.PayforDetailServiceI;

@Service("payfordetailService")
@Transactional
public class PayforDetailServiceImpl extends CommonServiceImpl implements PayforDetailServiceI {

	@Override
	public void payforDetailWorkFlowStart(PayforDetailEntity payforDetail,
			HttpServletRequest request) {
		
		
	}

	@Override
	public void updatePayforDetail(PayforDetailEntity payforDetail,
			HttpServletRequest request) throws Exception {
		
		
	}

	

}