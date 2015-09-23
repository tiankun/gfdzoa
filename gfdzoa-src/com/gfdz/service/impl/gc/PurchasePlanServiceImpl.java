package com.gfdz.service.impl.gc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.gc.MaterialBaseEntity;
import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.entity.gc.PurchasePlanDetailEntity;
import com.gfdz.entity.gc.PurchasePlanEntity;
import com.gfdz.entity.workflow.WorkFlowSetEntity;
import com.gfdz.service.gc.CodeServiceI;
import com.gfdz.service.gc.PurchasePlanServiceI;

@Service("purchasePlanService")
@Transactional
public class PurchasePlanServiceImpl extends CommonServiceImpl implements PurchasePlanServiceI {
	@Autowired
	private IdentityService identityService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	protected TaskService taskService;

	@Autowired
	protected CodeServiceI codeService;

	@Override
	public void purchasePlanSave(PurchasePlanEntity plan, String[] mId, Integer[] num, Double[] price, String[] note, Date[] otd) {
		if (mId == null || mId.length == 0) {
			throw new RuntimeException("请先添加采购明细！");
		}
		if (StringUtil.isEmpty(plan.getProject().getId())) {
			throw new RuntimeException("请先选择项目！");
		}
		ProjectInfoEntity pro = this.get(ProjectInfoEntity.class, plan.getProject().getId());
		if (pro == null) {
			throw new RuntimeException("没有找到对应的工程！");
		}
		plan.setUser(ResourceUtil.getSessionUserName());
		plan.setAdvance(plan.getAdvance() == null ? 0f : plan.getAdvance());
		plan.setBillCode(codeService.getCode("CGSQ", 4));
		this.save(plan);

		Set<String> set = new HashSet<String>();
		for (int i = 0; i < mId.length; i++) {
			MaterialBaseEntity mater = this.get(MaterialBaseEntity.class, mId[i]);
			mater.setPurchaseAmount(num[i]);
			mater.setPurchasePrice(price[i]);
			mater.setRemark(note[i]);
			PurchasePlanDetailEntity pd = new PurchasePlanDetailEntity();
			pd.setMaterial(mater);
			pd.setRemark(note[i]);
			pd.setPurchasePlan(plan);
			pd.setRequireTime(otd[i]);
			pd.setCp(mater.getCp());
			pd.setState(0);
			this.save(pd);
			set.add(mId[i]);
		}

		if (set.size() != mId.length) {
			throw new RuntimeException("请检查材料采购明细数据是否有重复！");
		}

		// 流程处理
		WorkFlowSetEntity workFlowSet = this.findUniqueByProperty(WorkFlowSetEntity.class, "entityName", plan.getClass().getSimpleName());
		if (workFlowSet == null) {
			throw new RuntimeException("请先配置采购申请的流程！");
		}
		ProcessInstance processInstance = null;
		// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
		identityService.setAuthenticatedUserId(plan.getUser().getId());

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put(ProcessConstantsUtil.getApplyUserId(), plan.getUser().getId());
		processInstance = runtimeService.startProcessInstanceByKey(workFlowSet.getProcessKey(), plan.getId(), variables);
		String processInstanceId = processInstance.getId();
		plan.setProcessInstanceId(processInstanceId);

		// 获取并执行当前流程实例的下一步任务
		TaskQuery query = taskService.createTaskQuery().processInstanceBusinessKey(plan.getId()).active();
		Task task = query.singleResult();
		taskService.complete(task.getId(), variables);

	}

	@Override
	public void updatePurchasePlan(PurchasePlanEntity plan, String[] mId, Integer[] num, Double[] price, String[] note, Date[] otd) throws Exception {
		TaskQuery query = taskService.createTaskQuery().processInstanceBusinessKey(plan.getId()).active();
		Task task = query.singleResult();
		if (!"buyerRecheck,purchaseAppy".contains(task.getTaskDefinitionKey())) {
			throw new RuntimeException("流程正在审核中，暂时无法修改！");
		}

		if (mId == null || mId.length == 0) {
			throw new RuntimeException("请先添加采购明细！");
		}
		if (StringUtil.isEmpty(plan.getProject().getId())) {
			throw new RuntimeException("请先选择项目！");
		}
		ProjectInfoEntity pro = this.get(ProjectInfoEntity.class, plan.getProject().getId());
		if (pro == null) {
			throw new RuntimeException("没有找到对应的工程！");
		}

		PurchasePlanEntity newPlan = this.get(PurchasePlanEntity.class, plan.getId());

		MyBeanUtils.copyBeanNotNull2Bean(plan, newPlan);

		// 删除采购执行单
		this.deleteAllEntitie(plan.getPs());

		this.deleteAllEntitie(newPlan.getPds());

		Set<String> set = new HashSet<String>();
		for (int i = 0; i < mId.length; i++) {
			MaterialBaseEntity mater = this.get(MaterialBaseEntity.class, mId[i]);
			mater.setPurchaseAmount(num[i]);
			mater.setPurchasePrice(price[i]);
			mater.setRemark(note[i]);
			PurchasePlanDetailEntity pd = new PurchasePlanDetailEntity();
			pd.setMaterial(mater);
			pd.setRemark(note[i]);
			pd.setPurchasePlan(plan);
			pd.setRequireTime(otd[i]);
			pd.setCp(mater.getCp());
			pd.setState(0);
			this.save(pd);
			set.add(mId[i]);
		}
		
		if (set.size() != mId.length) {
			throw new RuntimeException("请检查材料采购明细数据是否有重复！");
		}

		Map<String, Object> variables = taskService.getVariables(task.getId());
		taskService.complete(task.getId(), variables);

	}
}