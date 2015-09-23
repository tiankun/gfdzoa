package com.gfdz.service.impl.cw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.util.IoUtil;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.cw.InOutRecordEntity;
import com.gfdz.entity.cw.PayforDetailEntity;
import com.gfdz.entity.cw.PayforEntity;
import com.gfdz.entity.gc.PurchaseEntity;
import com.gfdz.entity.workflow.WorkFlowSetEntity;
import com.gfdz.service.cw.PayforServiceI;

@Service("payforService")
@Transactional
public class PayforServiceImpl extends CommonServiceImpl implements PayforServiceI {
	@Autowired
	private IdentityService identityService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	protected TaskService taskService;

	@Override
	public void payforSave(PayforEntity payfor, String[] pId, Double[] money, String[] note) {

		if (pId == null || pId.length == 0) {
			throw new RuntimeException("请先添加申请付款的明细！");
		}

		payfor.setDepart(ResourceUtil.getSessionUserName().getCurrentDepart());
		payfor.setUser(ResourceUtil.getSessionUserName());
		this.save(payfor);

		Double total = 0d;
		for (int i = 0; i < pId.length; i++) {
			PurchaseEntity p = this.get(PurchaseEntity.class, pId[i]);
			PayforDetailEntity pd = new PayforDetailEntity();
			pd.setApplyreason(note[i]);
			pd.setPayfor(payfor);
			pd.setPurchase(p);
			pd.setMoney(money[i]);
			pd.setGysml(p.getGys());
			pd.setCreateDate(new Date());
			pd.setProject(p.getProject());
			pd.setUser(payfor.getUser());
			total += money[i];
			this.save(pd);
		}
		payfor.setTotalMoney(total);

		// 流程处理
		WorkFlowSetEntity workFlowSet = this.findUniqueByProperty(WorkFlowSetEntity.class, "entityName", payfor.getClass().getSimpleName());
		if (workFlowSet == null) {
			throw new RuntimeException("请先配置采购申请的流程！");
		}
		// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
		identityService.setAuthenticatedUserId(payfor.getUser().getId());

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put(ProcessConstantsUtil.getApplyUserId(), payfor.getUser().getId());
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(workFlowSet.getProcessKey(), payfor.getId(), variables);
		payfor.setProcessInstanceId(processInstance.getId());

		// 获取并执行当前流程实例的下一步任务
		TaskQuery query = taskService.createTaskQuery().processInstanceBusinessKey(payfor.getId()).active();
		Task task = query.singleResult();

		variables.put(ProcessConstantsUtil.getDeptLeaderId(), payfor.getDepart().getDepartManager().getId());
		variables.put(ProcessConstantsUtil.getLeaderManagerId(), payfor.getDepart().getManagerLeader().getId());
		taskService.complete(task.getId(), variables);
	}

	@Override
	public void completeTask(HttpServletRequest request) throws Exception {
		String taskId = request.getParameter("taskId"); // 任务id
		String taskKey = request.getParameter("taskKey"); // 任务步骤
		String auditType = request.getParameter("auditType");
		boolean isPass = "1".equals(auditType);
		String postil = request.getParameter("postil"); // 批注信息
		String id = request.getParameter("id");
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		Map<String, Object> variables = taskService.getVariables(taskId);

		// 支付申请
		if ("apply".equals(taskKey)) {
			this.complete(task, postil, variables);

			// 部门经理审批
		} else if (ProcessConstantsUtil.getDeptLeaderId().equals(taskKey)) {
			variables.put(ProcessConstantsUtil.getDeptLeaderPass(), isPass);
			this.complete(task, postil, variables);

			// 会计审批
		} else if (ProcessConstantsUtil.getAccountantId().equals(taskKey)) {

			taskService.claim(taskId, ResourceUtil.getSessionUserName().getId());

			variables.put(ProcessConstantsUtil.getAccountantPass(), isPass);
			TSDepart depart = findUniqueByProperty(TSDepart.class, "description", "treasurerAudit");
			variables.put(ProcessConstantsUtil.getTreasurerId(), depart.getDepartManager().getId());
			this.complete(task, postil, variables);

			// 财务主管
		} else if (ProcessConstantsUtil.getTreasurerId().equals(taskKey)) {
			variables.put(ProcessConstantsUtil.getTreasurerPass(), isPass);
			this.complete(task, postil, variables);

			// 分管领导
		} else if (ProcessConstantsUtil.getLeaderManagerId().equals(taskKey)) {
			variables.put(ProcessConstantsUtil.getLeaderManagerPass(), isPass);
			this.complete(task, postil, variables);

			// 出纳出账
		} else if ("cashierExpenditure".equals(taskKey)) {
			// 签收
			taskService.claim(taskId, ResourceUtil.getSessionUserName().getId());
			variables.put(ProcessConstantsUtil.getCashierId(), ResourceUtil.getSessionUserName().getId());
			this.complete(task, postil, variables);
			// 出纳出账
			List<PayforDetailEntity> list = this.findByProperty(PayforDetailEntity.class, "payfor.id", id);
			if (list == null || list.size() == 0) {
				throw new RuntimeException("支付申请数据异常，请与管理员联系！");
			}
			String payDate = request.getParameter("payDate");
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			for (int i = 0; i < list.size(); i++) {
				InOutRecordEntity inout = new InOutRecordEntity();
				inout.setBillCode(list.get(i).getPurchase().getBillCode());
				inout.setBillType(list.get(i).getPurchase().getBillType());
				inout.setInoutType(-1);
				inout.setPayoutMoney(list.get(i).getMoney());
				inout.setUser(ResourceUtil.getSessionUserName());
				inout.setPayTime(sd.parse(payDate));
				inout.setPayType(list.get(i).getPayfor().getPayType());
				this.save(inout);
				list.get(i).getPurchase().setPayMoney(list.get(i).getPurchase().getPayMoney() + inout.getPayoutMoney());
			}
			
			// 发票登记
		} else if ("invoiceRegister".equals(taskKey)) {
			String makeCodeDate = request.getParameter("makeCodeDate");
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			List<PayforDetailEntity> list = this.findByProperty(PayforDetailEntity.class, "payfor.id", id);
			if (list == null || list.size() == 0) {
				throw new RuntimeException("支付申请数据异常，请与管理员联系！");
			}

			for (int i = 0; i < list.size(); i++) {
				InOutRecordEntity inout = findUniqueByProperty(InOutRecordEntity.class, "billCode", list.get(i).getPurchase().getBillCode());
				inout.setMakeCodeDate(sd.parse(makeCodeDate));
				inout.setCode(request.getParameter("code"));
			}
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