package com.gfdz.service.gc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.gc.PurchaseEntity;
import com.gfdz.entity.gc.PurchasePlanDetailEntity;

public interface PurchaseServiceI extends CommonService {
	/**
	 * 保存生成采购执行单
	 * 
	 * @author WU
	 * @date 2015-7-31 上午11:29:26
	 * @param purchase
	 * @param id
	 */
	public void purchaseSave(PurchaseEntity purchase, String[] pdId);

	/**
	 * 采购流程下一步
	 * 
	 * @author WU
	 * @date 2015-8-7 上午9:26:02
	 * @param req
	 */
	public void completeTask(HttpServletRequest req) throws Exception;

	/**
	 * 获取要生成的采购单数据
	 * 
	 * @author WU
	 * @date 2015-8-7 下午4:31:57
	 */
	public List<PurchasePlanDetailEntity> getPurchase(String id, String[] pdId);

	/**
	 * 全额预付款的到货通知
	 * 
	 * @author WU
	 * @date 2015-8-28 下午5:17:01
	 * @return
	 */
	public JSONObject arrivalNotice() throws Exception;

	/**
	 * 删除采购单
	 * 
	 * @author WU
	 * @date 2015年9月10日 上午9:47:44
	 * @param p
	 */
	public void delPurchas(PurchaseEntity p);
}
