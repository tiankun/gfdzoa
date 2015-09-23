package com.gfdz.service.impl.gc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.gfdz.entity.cw.InOutRecordEntity;
import com.gfdz.entity.gc.PurchaseDetailEntity;
import com.gfdz.entity.gc.PurchaseEntity;
import com.gfdz.entity.gc.PurchasePlanDetailEntity;
import com.gfdz.entity.gc.PurchasePlanEntity;
import com.gfdz.service.gc.CodeServiceI;
import com.gfdz.service.gc.PurchaseServiceI;

@Service("purchaseService")
@Transactional
public class PurchaseServiceImpl extends CommonServiceImpl implements PurchaseServiceI {
	@Autowired
	private TaskService taskService;
	@Autowired
	private CodeServiceI codeService;

	@Override
	@SuppressWarnings("unchecked")
	public void purchaseSave(PurchaseEntity p, String[] pdId) {
		if (pdId == null || pdId.length == 0) {
			throw new RuntimeException("请先选择要生成采购单的记录！");
		}
		p.setInputTime(new Date());
		p.setUser(ResourceUtil.getSessionUserName());
		p.setAdvance(p.getAdvance() == null ? 0d : p.getAdvance());
		p.setBillCode(codeService.getCode("CGZX", 4));
		p.setBillType("CGZX");
		this.save(p);

		Criteria crt = getSession().createCriteria(PurchasePlanDetailEntity.class);
		crt.add(Restrictions.in("id", pdId));
		List<PurchasePlanDetailEntity> ppdList = crt.list();
		if (ppdList.size() != pdId.length) {
			throw new RuntimeException("采购申请材料数据异常，请于管理员联系！");
		}
		Double money = 0d;
		for (int i = 0; i < ppdList.size(); i++) {
			PurchaseDetailEntity pd = new PurchaseDetailEntity();
			pd.setPpd(ppdList.get(i));
			pd.setMaterial(ppdList.get(i).getMaterial());
			pd.setPurchase(p);
			pd.setCp(ppdList.get(i).getCp());
			money += ppdList.get(i).getMaterial().getPurchaseAmount() * ppdList.get(i).getMaterial().getPurchasePrice();
			this.save(pd);
			ppdList.get(i).setState(1);
		}
		p.setYfMoney(money);
		p.setPayMoney(0d);
		p.setPayMoney(0d);

	}

	@Override
	public void completeTask(HttpServletRequest request) throws Exception {
		String taskId = request.getParameter("taskId"); // 任务id
		String taskKey = request.getParameter("taskKey"); // 任务步骤
		String auditType = request.getParameter("auditType");
		boolean isPass = "1".equals(auditType);
		String postil = request.getParameter("postil"); // 批注信息
		String planId = request.getParameter("plan.id");
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		Map<String, Object> variables = taskService.getVariables(taskId);

		// 采购申请
		if (ProcessConstantsUtil.getPurchaseAppy().equals(taskKey)) {
			variables.put(ProcessConstantsUtil.getApplyUserId(), ResourceUtil.getSessionUserName().getId());
			this.complete(task, postil, variables);

			// 采购员复核
		} else if (ProcessConstantsUtil.getBuyerRecheck().equals(taskKey)) {

			// 检查是否已经生成采购执行单
			if (isPass) {
				Criteria crit = getSession().createCriteria(PurchasePlanDetailEntity.class);
				crit.add(Restrictions.eq("state", 0));
				crit.add(Restrictions.eq("purchasePlan.id", planId));
				crit.setProjection(Projections.rowCount());
				int count = Integer.parseInt(crit.uniqueResult().toString());
				if (count > 0) {
					throw new RuntimeException("请先把所有的材料明细生成采购执行单！");
				}
				PurchasePlanEntity plan = this.get(PurchasePlanEntity.class, planId);
				plan.setAdvance(0d);
				for (int i = 0; i < plan.getPs().size(); i++) {
					plan.setAdvance(plan.getAdvance() + plan.getPs().get(i).getAdvance());
				}
			}
			// 签收
			taskService.claim(taskId, ResourceUtil.getSessionUserName().getId());

			variables.put(ProcessConstantsUtil.getBuyerPass(), isPass);
			variables.put(ProcessConstantsUtil.getBuyer(), ResourceUtil.getSessionUserName().getId());
			this.complete(task, postil, variables);

			if (isPass) {
				// 获取并执行当前流程实例的下一步任务
				TaskQuery query = taskService.createTaskQuery().processInstanceId(task.getProcessInstanceId()).active();
				Task task1 = query.singleResult();
				TSDepart depart = findUniqueByProperty(TSDepart.class, "description", "engineeringAudit");
				variables.put(ProcessConstantsUtil.getEngineeringManager(), depart.getDepartManager().getId());
				this.complete(task1, postil, variables);
			}

			// 部门经理审批(工程部)
		} else if (ProcessConstantsUtil.getEngineeringManager().equals(taskKey)) {
			variables.put(ProcessConstantsUtil.getDeptLeaderPass(), isPass);
			TSDepart depart = findUniqueByProperty(TSDepart.class, "description", "officeAudit");
			variables.put(ProcessConstantsUtil.getOfficeLeaderId(), depart.getDepartManager().getId());
			this.complete(task, postil, variables);

			// 综合办审批
		} else if (ProcessConstantsUtil.getOfficeLeaderId().equals(taskKey)) {

			PurchasePlanEntity plan = this.get(PurchasePlanEntity.class, planId);
			variables.put(ProcessConstantsUtil.getYfk(), plan.getAdvance() == null ? 0 : plan.getAdvance());
			variables.put(ProcessConstantsUtil.getOfficeLeaderPass(), isPass);

			// 财务审批
			if (plan.getAdvance() != null && plan.getAdvance() > 0) {
				// variables.put(ProcessConstantsUtil.getAccountantId(),"");

				// 分管领导审批
			} else {
				TSDepart depart = findUniqueByProperty(TSDepart.class, "description", "engineeringAudit");
				variables.put(ProcessConstantsUtil.getLeaderManagerId(), depart.getManagerLeader());
			}
			this.complete(task, postil, variables);

			// 财务审批
		} else if (ProcessConstantsUtil.getAccountantId().equals(taskKey)) {

			// 签收
			taskService.claim(taskId, ResourceUtil.getSessionUserName().getId());

			variables.put(ProcessConstantsUtil.getAccountantPass(), isPass);
			TSDepart depart = findUniqueByProperty(TSDepart.class, "description", "treasurerAudit");
			variables.put(ProcessConstantsUtil.getTreasurerId(), depart.getDepartManager().getId());
			this.complete(task, postil, variables);

			// 财务主管审批
		} else if (ProcessConstantsUtil.getTreasurerId().equals(taskKey)) {
			variables.put(ProcessConstantsUtil.getTreasurerPass(), isPass);
			TSDepart depart = findUniqueByProperty(TSDepart.class, "description", "engineeringAudit");
			variables.put(ProcessConstantsUtil.getLeaderManagerId(), depart.getManagerLeader().getId());
			this.complete(task, postil, variables);

			// 分管领导审批
		} else if (ProcessConstantsUtil.getLeaderManagerId().equals(taskKey)) {
			variables.put(ProcessConstantsUtil.getLeaderManagerPass(), isPass);
			PurchasePlanEntity plan = this.get(PurchasePlanEntity.class, planId);

			// 财务出纳
			if (plan.getAdvance() != null && plan.getAdvance() > 0) {
				// variables.put(ProcessConstantsUtil.getCashierId(), "");

				// 采购执行
			} else {
				variables.put(ProcessConstantsUtil.getPurchasingExecutive(), variables.get(ProcessConstantsUtil.getBuyer()));
			}
			this.complete(task, postil, variables);

			// 财务出纳
		} else if (ProcessConstantsUtil.getCashierId().equals(taskKey)) {

			List<PurchaseEntity> pList = this.findByProperty(PurchaseEntity.class, "plan.id", planId);
			String payDate = request.getParameter("payDate");
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			for (int i = 0; i < pList.size(); i++) {
				if (pList.get(i).getAdvance() != null && pList.get(i).getAdvance() > 0) {
					InOutRecordEntity inout = new InOutRecordEntity();
					inout.setBillCode(pList.get(i).getBillCode());
					inout.setBillType(pList.get(i).getBillType());
					inout.setInoutType(-1);
					inout.setPayoutMoney(pList.get(i).getAdvance());
					inout.setUser(ResourceUtil.getSessionUserName());
					inout.setPayTime(sd.parse(payDate));
					inout.setPayType(Integer.parseInt(request.getParameter("payType")));
					this.save(inout);

					pList.get(i).setPayMoney(pList.get(i).getPayMoney() + inout.getPayoutMoney());
					if (pList.get(i).getQkMoney() == 0 && pList.get(i).getDays() != null) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(sd.parse(payDate));
						cal.add(Calendar.DAY_OF_YEAR, pList.get(i).getDays());
						pList.get(i).setArrivalDate(cal.getTime());
					}
				}
			}

			// 签收
			taskService.claim(taskId, ResourceUtil.getSessionUserName().getId());

			variables.put(ProcessConstantsUtil.getPurchasingExecutive(), variables.get(ProcessConstantsUtil.getBuyer()));
			this.complete(task, postil, variables);

			// 采购执行
		} else if (ProcessConstantsUtil.getPurchasingExecutive().equals(taskKey)) {

			String[] ids = request.getParameterValues("ids");
			if (ids == null) {
				throw new RuntimeException("请选择已到货的采购执行单！");
			}
			DetachedCriteria dc = DetachedCriteria.forClass(PurchaseDetailEntity.class);
			dc.add(Restrictions.in("purchase.id", ids));
			List<PurchaseDetailEntity> pdList = this.findByDetached(dc);
			if (pdList == null || pdList.size() == 0) {
				throw new RuntimeException("系统异常请与管理员联系！");
			}
			for (int i = 0; i < pdList.size(); i++) {
				pdList.get(i).getPurchase().setArriving(1);
				pdList.get(i).getMaterial().setReceiveAmount(pdList.get(i).getMaterial().getPurchaseAmount());
			}

			Criteria crit = getSession().createCriteria(PurchaseEntity.class);
			crit.add(Restrictions.eq("plan.id", planId));
			crit.add(Restrictions.isNull("arriving"));
			crit.setProjection(Projections.rowCount());
			int count = Integer.parseInt(crit.uniqueResult().toString());
			if (count == 0) {
				variables.put(ProcessConstantsUtil.getArrivalNotice(), variables.get(ProcessConstantsUtil.getApplyUserId()));
				this.complete(task, postil, variables);
			}
			// 到货通知
		} else if (ProcessConstantsUtil.getArrivalNotice().equals(taskKey)) {
			this.complete(task, postil, variables);

		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PurchasePlanDetailEntity> getPurchase(String id, String[] pdId) {
		Criteria crit = getSession().createCriteria(PurchasePlanDetailEntity.class);
		crit.add(Restrictions.in("id", pdId));
		return crit.list();
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

	@Override
	public JSONObject arrivalNotice() throws Exception {
		JSONObject obj = new JSONObject();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "select t.bill_code code,t.purchase_plan_id pId from GC_PURCHASE t where t.arriving is null and t.arrival_date=to_date(?,'yyyy-MM-dd') and t.user_id=?";
		List<Map<String, Object>> list = this.findForJdbc(sql, sd.format(new Date()), ResourceUtil.getSessionUserName().getId());
		JSONArray array = new JSONArray();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Task task = taskService.createTaskQuery().processInstanceBusinessKey(list.get(i).get("PID").toString()).active().singleResult();
				if (task != null) {
					JSONObject o = new JSONObject();
					o.put("code", list.get(i).get("CODE"));
					o.put("taskId", task.getId());
					o.put("taskKey", task.getTaskDefinitionKey());
					o.put("pId", task.getProcessInstanceId());
					array.add(o);
				}
			}
		}
		obj.put("row", array);
		return obj;
	}

	@Override
	public void delPurchas(PurchaseEntity p) {
		p = this.get(PurchaseEntity.class, p.getId());
		for (int i = 0; i < p.getPd().size(); i++) {
			p.getPd().get(i).getPpd().setState(0);
		}
		this.delete(p);
	}
}