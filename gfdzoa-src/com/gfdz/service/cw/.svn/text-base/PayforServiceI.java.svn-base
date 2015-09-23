package com.gfdz.service.cw;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.cw.PayforEntity;

public interface PayforServiceI extends CommonService {

	/**
	 * 支付申请保存
	 * 
	 * @author WU
	 * @date 2015-8-20 下午4:19:24
	 * @param payfor
	 * @param pId
	 * @param money
	 */
	public void payforSave(PayforEntity payfor, String[] pId, Double[] money, String[] note);

	/**
	 * 支付申请流程审批
	 * 
	 * @author WU
	 * @date 2015-8-19 上午11:24:09
	 * @param request
	 */
	public void completeTask(HttpServletRequest request) throws Exception;
}
