package com.gfdz.service.impl.gc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.gc.BudgetApprovalEntity;
import com.gfdz.entity.workflow.WorkFlowSetEntity;
import com.gfdz.service.gc.BudgetApprovalService;

@Service("budgetApprovalService")
@Transactional
public class BudgetApprovalServiceImpl extends CommonServiceImpl implements BudgetApprovalService {
	@Autowired
	private IdentityService identityService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	protected TaskService taskService;

	@Override
	public void budgetApproval(BudgetApprovalEntity budgetApproval) throws Exception {
		if (StringUtil.isNotEmpty(budgetApproval.getId())) {
			BudgetApprovalEntity t = this.get(BudgetApprovalEntity.class, budgetApproval.getId());
			if (t.getIsverify() == 1) {
				throw new RuntimeException("预（结）算审核中...不也许修改！");
			}
			MyBeanUtils.copyBeanNotNull2Bean(budgetApproval, t);
			this.saveOrUpdate(t);
		} else {
			budgetApproval.setIsverify(0);
			this.save(budgetApproval);

			// 流程处理
			WorkFlowSetEntity workFlowSet = this.findUniqueByProperty(WorkFlowSetEntity.class, "entityName", budgetApproval.getClass().getSimpleName());
			if (workFlowSet == null) {
				throw new RuntimeException("请先配置预（结）算审批流程！");
			}
			ProcessInstance processInstance = null;
			// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
			identityService.setAuthenticatedUserId(ResourceUtil.getSessionUserName().getId());

			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put(ProcessConstantsUtil.getApplyUserId(), ResourceUtil.getSessionUserName().getId());
			processInstance = runtimeService.startProcessInstanceByKey(workFlowSet.getProcessKey(), budgetApproval.getId(), variables);
			String processInstanceId = processInstance.getId();
			budgetApproval.setProcessInstanceId(processInstanceId);

			// 获取并执行当前流程实例的下一步任务
			TSDepart depart = ResourceUtil.getSessionUserName().getCurrentDepart();
			variables.put(ProcessConstantsUtil.getDeptLeaderId(), depart.getDepartManager().getId());
			variables.put(ProcessConstantsUtil.getLeaderManagerId(), depart.getManagerLeader().getId());

			TaskQuery query = taskService.createTaskQuery().processInstanceBusinessKey(budgetApproval.getId()).active();
			Task task = query.singleResult();
			taskService.complete(task.getId(), variables);
		}
	}

	@Override
	public void completeTask(BudgetApprovalEntity budgetApproval, HttpServletRequest request) {
		String taskId = request.getParameter("taskId"); // 任务id
		String taskKey = request.getParameter("taskKey"); // 任务步骤
		String auditType = request.getParameter("auditType");
		boolean isPass = "1".equals(auditType);
		String postil = request.getParameter("postil"); // 批注信息
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		Map<String, Object> variables = taskService.getVariables(taskId);
		BudgetApprovalEntity budget = this.get(BudgetApprovalEntity.class, budgetApproval.getId());
		budget.setIsverify(isPass ? 1 : 0);

		// 申请
		if ("apply".equals(taskKey)) {
			budgetApproval.setIsverify(0);
			budgetApproval.setProcessInstanceId(budget.getProcessInstanceId());
			this.getSession().merge(budgetApproval);
			this.complete(task, postil, variables);

			// 部门经理
		} else if (ProcessConstantsUtil.getDeptLeaderId().equals(taskKey)) {
			variables.put(ProcessConstantsUtil.getDeptLeaderPass(), isPass);
			variables.put("flag", budget.getType());
			// 财务部审核
			if (budget.getType() == 1) {
				TSDepart depart = this.findUniqueByProperty(TSDepart.class, "description", "treasurerAudit");
				variables.put(ProcessConstantsUtil.getTreasurerId(), depart.getDepartManager().getId());
				// 分管领导审核
			} else {

			}
			this.complete(task, postil, variables);

			// 财务部审核
		} else if (ProcessConstantsUtil.getTreasurerId().equals(taskKey)) {
			variables.put(ProcessConstantsUtil.getTreasurerPass(), isPass);
			this.complete(task, postil, variables);

			// 分管领导审核
		} else if (ProcessConstantsUtil.getLeaderManagerId().equals(taskKey)) {
			variables.put(ProcessConstantsUtil.getLeaderManagerPass(), isPass);
			this.complete(task, postil, variables);
		}
	}

	/**
	 * 执行任务
	 * 
	 * @author WU
	 * @date 2015-8-6 上午10:28:06
	 * @param taskId
	 * @param postil
	 * @param variables
	 */
	private void complete(Task task, String postil, Map<String, Object> variables) {
		taskService.addComment(task.getId(), task.getProcessInstanceId(), postil == null ? "" : postil);
		taskService.complete(task.getId(), variables);
	}
}