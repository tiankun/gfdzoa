package org.jeecgframework.core.util;

import java.util.ResourceBundle;

/**
 * 流程常量工具类
 * 
 * @author fly
 * 
 */
public class ProcessConstantsUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("processConstants");

	/**
	 * 
	 * @Title: getApplyUserId
	 * @Description: 获取申请人key
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午3:55:17
	 */

	public static String getApplyUserId() {
		return bundle.getString("KEY_APPLY_USER_ID");
	}

	/**
	 * 
	 * @Title: getDeptLeaderId
	 * @Description: 获取部门经理key
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:07:46
	 */
	public static String getDeptLeaderId() {
		return bundle.getString("KEY_DEPT_LEADER_ID");
	}

	/**
	 * 
	 * @Title: getDeptLeaderPass
	 * @Description: 部门经理是否同意
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:11:10
	 */
	public static String getDeptLeaderPass() {
		return bundle.getString("KEY_DEPT_LEADER_PASS");
	}

	/**
	 * 
	 * @Title: getLeaderManagerId
	 * @Description: 分管领导id
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:11:14
	 */
	public static String getLeaderManagerId() {
		return bundle.getString("KEY_LEADER_MANAGER_ID");
	}

	/**
	 * 
	 * @Title: getLeaderManagerpass
	 * @Description: 分管领导是否同意
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:11:18
	 */
	public static String getLeaderManagerPass() {
		return bundle.getString("KEY_LEADER_MANAGER_PASS");
	}

	/**
	 * 
	 * @Title: getLeaveDays
	 * @Description: 获取请假天数
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:11:22
	 */
	public static String getLeaveDays() {
		return bundle.getString("KEY_DAYS");
	}

	/**
	 * 
	 * @Title: getIsCheckOut
	 * @Description: 证章是否外借
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:11:26
	 */
	public static String getIsCheckOut() {
		return bundle.getString("KEY_ISCHECKOUT");
	}

	/**
	 * 
	 * @Title: getBorrowUserId
	 * @Description: 确认归还人id
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:11:31
	 */
	public static String getBorrowUserId() {
		return bundle.getString("KEY_BORROW_USER_ID");
	}

	/**
	 * 
	 * @Title: getSubmitOrModify
	 * @Description: 获取提交申请描述
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:26:44
	 */
	public static String getSubmitOrModify() {
		return bundle.getString("KEY_SUBMITORMODIFY");
	}

	/**
	 * 
	 * @Title: getDeptLeaderAudit
	 * @Description: 获取部门经理描述
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:27:06
	 */
	public static String getDeptLeaderAudit() {
		return bundle.getString("KEY_DEPTLEADERAUDIT");
	}

	/**
	 * 
	 * @Title: getLeaderManagerAudit
	 * @Description: 获取分管领导描述
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:27:12
	 */
	public static String getLeaderManagerAudit() {
		return bundle.getString("KEY_LEADERMANAGERAUDIT");
	}

	/**
	 * 
	 * @Title: getReceiveConfirm
	 * @Description: 获取确认领用描述
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:27:15
	 */
	public static String getReceiveConfirm() {
		return bundle.getString("KEY_RECEIVECONFIRM");
	}

	/**
	 * 
	 * @Title: getReturnConfirm
	 * @Description: 获取确认归还描述
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年6月25日 下午4:27:19
	 */
	public static String getReturnConfirm() {
		return bundle.getString("KEY_RETURNCONFIRM");
	}

	/**
	 * 
	 * @Title: getOfficeLeaderId
	 * @Description: 综合办经理id
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:16:09
	 */
	public static String getOfficeLeaderId() {
		return bundle.getString("KEY_OFFICE_LEADER_ID");
	}

	/**
	 * 
	 * @Title: getOfficeLeaderPass
	 * @Description: 综合办经理审批结果
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:17:03
	 */
	public static String getOfficeLeaderPass() {
		return bundle.getString("KEY_OFFICE_PASS");
	}

	/**
	 * 
	 * @Title: getSendCarId
	 * @Description: 派车人id
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:18:15
	 */
	public static String getSendCarId() {
		return bundle.getString("KEY_SEND_CAR_ID");
	}

	/**
	 * 
	 * @Title: getSendCar
	 * @Description: 派车关键字
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:19:03
	 */
	public static String getSendCar() {
		return bundle.getString("KEY_SENDCAR");
	}

	/**
	 * 
	 * @Title: getTreasurerId
	 * @Description: 财务主管id
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:20:25
	 */
	public static String getTreasurerId() {
		return bundle.getString("KEY_TREASURER_ID");
	}

	/**
	 * 
	 * @Title: getIsExpenditure
	 * @Description: 是否暂支
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:21:42
	 */
	public static String getIsExpenditure() {
		return bundle.getString("KEY_ISEXPENDITURE");
	}

	/**
	 * 
	 * @Title: getIsPlane
	 * @Description: 是否飞机
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:22:02
	 */
	public static String getIsPlane() {
		return bundle.getString("KEY_ISPLANE");
	}

	/**
	 * 
	 * @Title: getOfficeLeaderAudit
	 * @Description: 综合办经理关键字
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:22:53
	 */
	public static String getOfficeLeaderAudit() {
		return bundle.getString("KEY_OFFICELEADERAUDIT");
	}

	/**
	 * 
	 * @Title: getTreasurerAudit
	 * @Description: 财务主管关键字
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:23:52
	 */
	public static String getTreasurerAudit() {
		return bundle.getString("KEY_TREASURERAUDIT");
	}

	/**
	 * 
	 * @Title: getAccountantId
	 * @Description: 会计id
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:39:48
	 */
	public static String getAccountantId() {
		return bundle.getString("KEY_ACCOUNTANT_ID");
	}

	/**
	 * 
	 * @Title: getccountantPass
	 * @Description: 会计审批通过标识
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:39:52
	 */
	public static String getAccountantPass() {
		return bundle.getString("KEY_ACCOUNTANT_PASS");
	}

	/**
	 * 
	 * @Title: getCashierId
	 * @Description: 出纳id
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:39:56
	 */
	public static String getCashierId() {
		return bundle.getString("KEY_CASHIER_ID");
	}

	/**
	 * 
	 * @Title: getAccountantAudit
	 * @Description: 会计审批关键字
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:39:59
	 */
	public static String getAccountantAudit() {
		return bundle.getString("KEY_ACCOUNTANTAUDIT");
	}

	/**
	 * 
	 * @Title: getCashierExecute
	 * @Description: 出纳执行关键字
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月3日 下午3:40:02
	 */
	public static String getCashierExecute() {
		return bundle.getString("KEY_CASHIER_EXECUTE");
	}

	/**
	 * 
	 * @Title: getTreasurerPass
	 * @Description: 财务主管审批通过标识
	 * @return String
	 * @throws
	 * @exception
	 * @author fly
	 * @date 2015年7月15日 下午4:42:53
	 */
	public static String getTreasurerPass() {
		return bundle.getString("KEY_TREASURER_PASS");
	}

	/**
	 * 工程部经理
	 * 
	 * @author WU
	 * @date 2015-8-4 下午5:26:14
	 * @return
	 */
	public static String getEngineeringManager() {
		return bundle.getString("KEY_ENGINEERING_MANAGER");
	}

	/**
	 * 采购员审批
	 * 
	 * @author WU
	 * @date 2015-8-5 下午5:20:55
	 * @return
	 */
	public static String getBuyerPass() {
		return bundle.getString("KEY_BUYER_PASS");
	}

	/**
	 * 采购单
	 * 
	 * @author WU
	 * @date 2015-8-7 下午1:52:42
	 * @return
	 */
	public static String getBuyer() {
		return bundle.getString("KEY_BUYER");
	}

	/**
	 * 采购审批员(采购复核员)
	 * 
	 * @author WU
	 * @date 2015-8-5 下午5:24:59
	 * @return
	 */
	public static String getBuyerId() {
		return bundle.getString("KEY_BUYER_ID");
	}

	/**
	 * 预付款
	 * 
	 * @author WU
	 * @date 2015-8-7 上午9:50:37
	 * @return
	 */
	public static String getYfk() {
		return bundle.getString("KEY_YFK");
	}

	/**
	 * 采购执行
	 * 
	 * @author WU
	 * @date 2015-8-7 上午10:43:05
	 * @return
	 */
	public static String getPurchasingExecutive() {
		return bundle.getString("KEY_PURCHASING_EXECUTIVE");
	}

	/**
	 * 到货通知
	 * 
	 * @author WU
	 * @date 2015-8-7 上午10:48:02
	 * @return
	 */
	public static String getArrivalNotice() {
		return bundle.getString("KEY_ARRIVAL_NOTICE");
	}

	/**
	 * 采购申请
	 * 
	 * @author WU
	 * @date 2015-8-7 上午10:48:02
	 * @return
	 */
	public static String getPurchaseAppy() {
		return bundle.getString("KEY_PURCHASE_APPY");
	}

	/**
	 * 采购员复核
	 * 
	 * @author WU
	 * @date 2015-8-7 上午10:48:02
	 * @return
	 */
	public static String getBuyerRecheck() {
		return bundle.getString("KEY_BUYER_RECHECK");
	}

	/**
	 * 发票作废
	 * @param args
	 */
	public static String getInvalidInvoice() {
		return bundle.getString("KEY_INVALID_INVOICE");
	}
	/**
	 * 收款入账
	 * @param args
	 */
	public static String getAccountPayee() {
		return bundle.getString("KEY_ACCOUNT_PAYEE");
	}
	/**
	 * 作废
	 * @param args
	 */
	public static String getInvalid() {
		return bundle.getString("KEY_INVALID");
	}
	/**
	 * 入账
	 * @param args
	 */
	public static String getAccount() {
		return bundle.getString("KEY_ACCOUNT");
	}
	
	
	/**
	 * 
	  * @Title: getIsOverBudget
	  * @Description: 超出预算
	  * @return String
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月18日 上午10:10:06
	 */
	public static String getIsOverBudget() {
		return bundle.getString("KEY_ISOVERBUDGET");
	}
	
	public static void main(String[] args) {
		org.jeecgframework.core.util.LogUtil.info(getOfficeLeaderAudit());
	}
}
