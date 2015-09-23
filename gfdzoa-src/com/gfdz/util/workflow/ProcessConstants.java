package com.gfdz.util.workflow;

/**
 * 流程变量定义
 * 需要和流程中定义的变量名相同
 * @author jc
 */
public class ProcessConstants {
	/**
	 * 申请人ID
	 */
	public static final String KEY_APPLY_USER_ID = "applyUserId";//ID
	/**
	 * 部门经理ID
	 */
	public static final String KEY_DEPT_LEADER_ID = "deptLeaderId";//部门经理ID
	/**
	 * 分管领导ID
	 */
	public static final String KEY_LEADER_ID = "leaderId";//分管领导ID	
	/**
	 * 部门经理是否审批通过
	 */
	public static final String KEY_DEPT_LEADER_PASS = "deptLeaderPass";//部门经理是否审批通过
	
	/**
	 * 分管领导是否审批通过
	 */
	public static final String KEY_LEADER_PASS = "leaderPass";//分管领导是否审批通过
	/**
	 * 人事是否审批通过
	 */
	public static final String KEY_HR_PASS = "hrPass";//人事是否审批通过
	/**
	 * 申请是否重新调整
	 */
	public static final String KEY_LEAVE_REAPPLY = "reApply";//请假是否重新调整
	
	/**
	 * 会计人员ID
	 */
	public static final String KEY_ACCOUNTANT_ID = "accountantId";
	/**
	 * 会计是否审批通过
	 */
	public static final String KEY_ACCOUNTANT_PASS = "accountantPass";
	
	/**
	 * 财务主管人员ID
	 */
	public static final String KEY_TREASURER_ID = "treasurerId";
	/**
	 * 财务主管是否审批通过
	 */
	public static final String KEY_TREASURER_PASS = "treasurerPass";
}
