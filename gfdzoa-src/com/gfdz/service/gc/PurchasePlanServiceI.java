package com.gfdz.service.gc;

import java.util.Date;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.gc.PurchasePlanEntity;

public interface PurchasePlanServiceI extends CommonService {

	/**
	 * 新增申请采购
	 * 
	 * @author WU
	 * @date 2015-7-29 下午5:16:55
	 * @param plan
	 * @param id
	 * @param num
	 * @param price
	 * @param remark
	 */
	public void purchasePlanSave(PurchasePlanEntity plan, String[] mId, Integer[] num, Double[] price, String[] note, Date[] otd);

	/**
	 * 修改申请采购
	 * 
	 * @author WU
	 * @date 2015年9月8日 下午4:05:32
	 * @param plan
	 * @param dId
	 * @param mId
	 * @param num
	 * @param price
	 * @param note
	 * @param otd
	 */
	public void updatePurchasePlan(PurchasePlanEntity plan, String[] mId, Integer[] num, Double[] price, String[] note, Date[] otd) throws Exception;

}
