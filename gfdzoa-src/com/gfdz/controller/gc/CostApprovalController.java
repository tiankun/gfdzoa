package com.gfdz.controller.gc;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.gc.CostApprovalEntity;
import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.service.gc.CostApprovalService;
import com.gfdz.util.workflow.Variable;

/**   
 * @Title: Controller
 * @Description: 成本合算
 * @author ant
 * @date 2015-05-28 14:49:42
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/costApprovalController")
public class CostApprovalController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CostApprovalController.class);

	@Autowired
	private CostApprovalService costApprovalService;
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 成本合算列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "costApprovalList")
	public ModelAndView costApprovalList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/costApprovalList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(CostApprovalEntity costApproval,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CostApprovalEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, costApproval, request.getParameterMap());
		this.costApprovalService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除成本合算
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(CostApprovalEntity costApproval, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		costApproval = systemService.getEntity(CostApprovalEntity.class, costApproval.getId());
		message = "成本合算删除成功";
		costApprovalService.delete(costApproval);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加成本合算
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(CostApprovalEntity costApproval, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(costApproval.getId())) {
			message = "成本合算更新成功";
			CostApprovalEntity t = costApprovalService.get(CostApprovalEntity.class, costApproval.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(costApproval, t);
				costApprovalService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "成本合算更新失败";
			}
		} else {
			message = "成本合算添加成功";
			costApprovalService.costWorkFlowStart(costApproval,request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 成本合算列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(CostApprovalEntity costApproval, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(costApproval.getId())) {
			costApproval = costApprovalService.getEntity(CostApprovalEntity.class, costApproval.getId());
			req.setAttribute("costApproval", costApproval);
		}
		return new ModelAndView("com/gfdz/gc/costApproval");
	}
	
	
	
	@RequestMapping(params = "taskCompletePageSelect")
	public ModelAndView taskCompletePageSelect(
			@RequestParam("processInstanceId") String processInstanceId,
			@RequestParam("taskId") String taskId,@RequestParam("taskKey") String taskKey,HttpServletRequest request,Model model) {
			
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
			
			String businessKey = processInstance.getBusinessKey();

			CostApprovalEntity costApproval = costApprovalService.get(CostApprovalEntity.class,businessKey);
		
			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskId", taskId);
			model.addAttribute("costApproval",costApproval);
			model.addAttribute("taskKey", taskKey);
			
			if(taskKey.equals(ProcessConstantsUtil.getSubmitOrModify())){
				return new ModelAndView("com/gfdz/gc/costApprovalEdit");
			}else{
				return new ModelAndView("com/gfdz/gc/costApprovalHandle");
			}
	}
	
	/**
	 * 
	  * @Title: completeTask
	  * @Description: 完成任务
	  * @param taskId
	  * @param var
	  * @param request
	  * @return AjaxJson
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月24日 下午2:33:12
	 */
	@RequestMapping(params = "completeTask")
	@ResponseBody
	public AjaxJson completeTask(CostApprovalEntity costApproval,Variable var,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			costApprovalService.completeTask(costApproval, request);
			String message = "办理成功";
			j.setMsg(message);
		} catch (Exception e) {
			String message = "办理失败";
			j.setMsg(message);
			e.printStackTrace();
		}
		return j;
	}
	
	/**
	 * 
	  * @Title: zzsqDetail
	  * @Description: 查看审批详细信息
	  * @param leave
	  * @param req
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月24日 下午2:34:07
	 */
	@RequestMapping(params = "costApprovalDetail")
	public ModelAndView costApprovalDetail(CostApprovalEntity costApproval, HttpServletRequest req) {
		        
		String pid = req.getParameter("pid");
		costApproval = costApprovalService.findUniqueByProperty(CostApprovalEntity.class,"processinstanceId", pid);
		req.setAttribute("pid", pid);
		req.setAttribute("costApproval", costApproval);
		return new ModelAndView("com/gfdz/gc/costApprovalDetail");
	}
	
	@RequestMapping(params = "getCostApproval")
	@ResponseBody
	public JSONObject getCostApproval(HttpServletRequest req) {
		String pId = req.getParameter("pId");
		ProjectInfoEntity projectInfo= costApprovalService.get(ProjectInfoEntity.class,pId);
		JSONObject json = new JSONObject();
		String buildType = projectInfo.getBuildType();
		
		/**历史工资数据数据*/
		String hql1 = "select id,nvl(sdsgf,0) sdsgf,nvl(bgje,0) bgje from gc_cost_approval where PROJECT_ID=? ";
		List<Map<String, Object>>  costApprovalList1 = costApprovalService.findForJdbc(hql1,pId);
		if(costApprovalList1!=null && costApprovalList1.size()>0){
			for (int i = 0; i < costApprovalList1.size(); i++) {
				json = JSONHelper.map2json(costApprovalList1.get(0));
			}
		}
		
		CostApprovalEntity costApproval = costApprovalService.findUniqueByProperty(CostApprovalEntity.class, "project.id", pId);
		if(costApproval!=null){
			costApproval.setProject(null);
			JSONObject jsObject = JSONObject.fromObject(costApproval);
			jsObject.put("project", "");
			json.putAll(jsObject);
			json.put("zbj", costApproval.getSdsgf()!=null?new DecimalFormat("##0.00").format(costApproval.getSdsgf()*0.05):0);
			json.put("bgzbj", costApproval.getBgje()!=null?new DecimalFormat("##0.00").format(costApproval.getBgje()*0.05) :0);
			json.put("bzjhj",(costApproval.getSdsgf()!=null?costApproval.getSdsgf()*0.05:0)+(costApproval.getBgje()!=null?costApproval.getBgje()*0.05 :0));
			json.put("hj", (costApproval.getSdsgf()!=null?costApproval.getSdsgf():0)+(costApproval.getBgje()!=null?costApproval.getBgje() :0));
		}
		/**工资数据数据*/
		String hql = "select t.sdsgf,t.bgje,t.project_id,t1.a jzbyje,t1.b jzbyzbj, t1.c jzbhzj,t2.a jzsyje,t2.b jzsyzbj,t2.c jzsyhzj "
				+ "from gc_cost_approval t,"
				+ "(SELECT t.project_id id, sum(nvl(t.amount,0)) a,sum(nvl(t.guarantee_money,0)) b, sum(nvl(t.mutual_money,0))c FROM GC_Wages_Declare t WHERE  t.declare_date<to_date('2015-08-10','yyyy-MM-dd') group by  t.project_id ) t1,"
				+ "(SELECT t.project_id id, sum(nvl(t.amount,0)) a,sum(nvl(t.guarantee_money,0)) b, sum(nvl(t.mutual_money,0))c FROM GC_Wages_Declare t WHERE  t.declare_date<to_date('2015-06-10','yyyy-MM-dd') group by  t.project_id) t2 "
				+ "where t.project_id = t1.id and t.project_id = t2.id and t.project_id=?";
		List<Map<String, Object>>  wagesDeclareList = costApprovalService.findForJdbc(hql,pId);
		if(wagesDeclareList!=null && wagesDeclareList.size()>0){
			JSONObject js = new JSONObject();
			for (int i = 0; i < wagesDeclareList.size(); i++) {
				js = JSONHelper.map2json(wagesDeclareList.get(0));
			}
			json.putAll(js);
			
			json.put("jzbybl", new DecimalFormat("##0.00").format(Double.valueOf(json.get("jzbyje").toString() !=null ? json.get("jzbyje").toString():"0") /Double.valueOf(json.get("sdsgf").toString())));
			json.put("jzsybl", new DecimalFormat("##0.00").format(Double.valueOf(json.get("jzsyje").toString() !=null ? json.get("jzsyje").toString():"0") /Double.valueOf(json.get("sdsgf").toString())));
			
		}else{
			json.put("jzbyje", 0);
			json.put("jzsyje", 0);
			json.put("jzbybl", 0);
			json.put("jzsybl", 0);
		}
		
		
		/**进度数据*/
		String sql= "select case when t.ctype=1  then nvl(round(sum(t.amount)/sum(t1.purchase_amount)*100,2),0) "
				+ "when t.ctype=2 then nvl(round(sum(t.amount)/sum(t1.purchase_amount)*100,2),0) "
				+ "when t.ctype=3 then nvl(round(sum(t.amount)/sum(t1.purchase_amount)*100,2),0) end amount, t.ctype c1 "
				+ "from GC_PROJECT_SCHEDULE_DETAIL t "
				+ "left join gc_material_base t1 on t.ctype=t1.ctype and t1.material_name=t.material "
				+ "where t1.t1.project_id= ? "
				+ "group by t.ctype,t1.ctype order by t.ctype asc";
		List<Map<String, Object>> jds = costApprovalService.findForJdbc(sql,pId);
		
		double gwjd=0d;
		double xljd=0d;
		double sbjd=0d;
		if(jds!=null && jds.size()>0){
			for (int i = 0; i < jds.size(); i++) {
				if("1".equals(jds.get(i).get("c1"))){
					gwjd=Double.valueOf(jds.get(i).get("amount").toString());
				}else if("2".equals(jds.get(i).get("c1"))){
					sbjd=Double.valueOf(jds.get(i).get("amount").toString());
				}else if("3".equals(jds.get(i).get("c1"))){
					xljd=Double.valueOf(jds.get(i).get("amount").toString());
				}
			}
		}
		json.put("msg", true);
		if("1".equals(buildType)){//管网线缆设备
			json.put("gwjd",gwjd);
			json.put("xljd",xljd);
			json.put("sbjd",sbjd);
			json.put("ztjd",new DecimalFormat("#0.00").format((sbjd+gwjd+xljd)/3));
		}else if("2".equals(buildType)){//管网线缆
			json.put("gwjd",gwjd);
			json.put("xljd",xljd);
			json.put("sbjd",sbjd);
			json.put("ztjd",gwjd*0.6+xljd*.4);
		}else if("3".equals(buildType)){//线缆设备
			json.put("gwjd",gwjd);
			json.put("xljd",xljd);
			json.put("sbjd",sbjd);
			json.put("ztjd",sbjd*0.6+xljd*.4);
		}else if("4".equals(buildType)){//线缆
			json.put("gwjd",gwjd);
			json.put("xljd",xljd);
			json.put("sbjd",sbjd);
			json.put("ztjd",xljd);
		}else if("5".equals(buildType)){//管网
			json.put("gwjd",gwjd);
			json.put("xljd",xljd);
			json.put("sbjd",sbjd);
			json.put("ztjd",gwjd);
		}else if("6".equals(buildType)){//设备
			json.put("gwjd",gwjd);
			json.put("xljd",xljd);
			json.put("sbjd",sbjd);
			json.put("ztjd",sbjd);
		}else{
			json.put("msg",false);
		}
		return json;
	}
}
