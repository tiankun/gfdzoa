package com.gfdz.service.gc;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.gc.BudgetApprovalEntity;

public interface BudgetApprovalService extends CommonService {

	/**
	 * 
	 * @author WU
	 * @date 2015-8-12 下午4:06:44
	 * @param budgetApproval
	 */
	public void budgetApproval(BudgetApprovalEntity budgetApproval) throws Exception;

	/**
	 * 
	 * @author WU
	 * @date 2015-8-12 下午5:25:57
	 * @param request
	 */
	public void completeTask(BudgetApprovalEntity budgetApproval, HttpServletRequest request);

}
