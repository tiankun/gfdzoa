package com.gfdz.controller.hr;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ProcessConstantsUtil;
import org.jeecgframework.core.util.QueryUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSTerritory;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.pojo.base.TSUserOrg;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.hr.TravelEntity;
import com.gfdz.service.hr.TravelServiceI;
import com.gfdz.util.workflow.Variable;

/**   
 * @Title: Controller
 * @Description: 出差记录
 * @author ant
 * @date 2015-05-28 11:17:17
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/travelController")
public class TravelController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TravelController.class);
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	
	@Autowired
	private TravelServiceI travelService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 出差记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "travelList")
	public ModelAndView travelList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/travelList");
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
	public void datagrid(TravelEntity travel,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TravelEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, travel, request.getParameterMap());
		this.travelService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除出差记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TravelEntity travel, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		travel = systemService.getEntity(TravelEntity.class, travel.getId());
		message = "出差记录删除成功";
		travelService.delete(travel);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}

	/**
	 * 出差记录列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TravelEntity travel, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(travel.getId())) {
			travel = travelService.getEntity(TravelEntity.class, travel.getId());
			if(travel.getTravelOtheruser()!=null && !"".equals(travel.getTravelOtheruser())){
				String sql = "from TSUserOrg t where t.tsUser.id in('"+travel.getTravelOtheruser().replace(",", "','")+"')";
				List<TSUserOrg> list = travelService.findHql(sql);
				req.setAttribute("travelOtheruser", list);
			}
			req.setAttribute("travel", travel);
		}
		req.setAttribute("user", ResourceUtil.getSessionUserName());
		List<TSTerritory> listArea = travelService.findByProperty(TSTerritory.class, "TSTerritory.id", "1");
		req.setAttribute("listArea", listArea);
		return new ModelAndView("com/gfdz/hr/travel");
	}

	/**
	 * 添加出差记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TravelEntity travel, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(travel.getId())) {
			message = "出差记录更新成功";
			TravelEntity t = travelService.get(TravelEntity.class, travel.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(travel, t);
				travelService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "出差记录更新失败";
			}
		} else {
			message = "出差记录添加成功";
			travelService.travelWorkFlowStart(travel,request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 
	  * @Title: travelDetail
	  * @Description: 出差申请详细信息
	  * @param travel
	  * @param req
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月6日 上午10:23:39
	 */
	@RequestMapping(params = "travelDetail")
	public ModelAndView travelDetail(TravelEntity travel, HttpServletRequest req) {
		String pid = req.getParameter("pid");
		travel = travelService.findUniqueByProperty(TravelEntity.class,"processinstanceid", pid);
		req.setAttribute("pid", pid);
		req.setAttribute("travel", travel);
		return new ModelAndView("com/gfdz/hr/travelDetail");
	}
	
	/**
	 * 
	  * @Title: taskCompletePageSelect
	  * @Description: 用车申请任务处理页面跳转
	  * @param processInstanceId
	  * @param taskId
	  * @param taskKey
	  * @param request
	  * @param model
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月6日 上午10:24:14
	 */
	@RequestMapping(params = "taskCompletePageSelect")
	public ModelAndView taskCompletePageSelect(
			@RequestParam("processInstanceId") String processInstanceId,
			@RequestParam("taskId") String taskId,@RequestParam("taskKey") String taskKey,HttpServletRequest request,Model model) {
			
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
			
			String businessKey = processInstance.getBusinessKey();

			TravelEntity travel = travelService.get(TravelEntity.class,businessKey);
		
			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskId", taskId);
			model.addAttribute("travel",travel);
			model.addAttribute("taskKey", taskKey);
			
			if(taskKey.equals(ProcessConstantsUtil.getSubmitOrModify())){
				List<TSTerritory> listArea = travelService.findByProperty(TSTerritory.class, "TSTerritory.id", "1");
				request.setAttribute("listArea", listArea);
				if(travel.getTravelOtheruser()!=null && !"".equals(travel.getTravelOtheruser())){
					String sql = "from TSUser t where t.id in('"+travel.getTravelOtheruser().replace(",", "','")+"')";
					List<TSUser> list = travelService.findHql(sql);
					String  realName = "";
					for (int i = 0; i < list.size(); i++) {
						if("".equals(realName)){
							realName=list.get(i).getRealName();
						}
					}
					request.setAttribute("travelOtherusers", realName);
				}
				return new ModelAndView("com/gfdz/hr/travelEdit");
			}else{
				return new ModelAndView("com/gfdz/hr/travelHandle");
			}
	}
	
	/**
	 * 
	  * @Title: completeTask
	  * @Description: 出差申请任务处理
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
	public AjaxJson completeTask(TravelEntity travel,Variable var,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			travelService.completeTask(travel, request);
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
	  * @Title: getAddr
	  * @Description: 获取地址下级目录
	  * @param parentId
	  * @return JSONArray
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月8日 下午2:06:13
	 */
	@ResponseBody
	@RequestMapping(params = "getAddr")
	public JSONArray getAddr(String parentId) {
		List<TSTerritory> list = null;
		if (StringUtil.isNotEmpty(parentId)) {
			list = travelService.findHql("select new TSTerritory(s.id,s.territoryName) from TSTerritory s where s.TSTerritory.id=?  ", parentId);
		} 
		List<String> entityName = new ArrayList<String>();
		entityName.add("id");
		entityName.add("territoryName");
		return QueryUtils.entityList2JSONArray(list, entityName, null);
	}
	
	/**
	 * 
	  * @Title: getCriterion
	  * @Description: 获取出差标准
	  * @param parentId
	  * @return String
	  * @throws 
	  * @exception
	  * @author fly
	 * @throws ParseException 
	  * @date 2015年7月8日 下午2:06:38
	 */
	@ResponseBody
	@RequestMapping(params = "getCriterion")
	public String getCriterion(HttpServletRequest request) throws ParseException {
		String persons =  request.getParameter("persons");//出差人员id
		String city =  request.getParameter("city");     //出差地点
		String beginDate =  request.getParameter("beginDate"); //开始时间
		String endDate =  request.getParameter("endDate");   //结束时间
		String vehicle =  request.getParameter("vehicle");   //交通方式
		String stayType =  request.getParameter("stayType");   //住宿方式
		Date end = DateUtils.date_sdf.parse(endDate);
		Date begin = DateUtils.date_sdf.parse(beginDate);
		int x =(int) ((end.getTime()-begin.getTime())/24 / 3600 / 1000);
		String sql="SELECT t3.standard FROM HR_BUSINESS_STANDARD t3 where t3.rolelevel = (select max(t1.rolelevel) from t_s_role t1 where t1.id in(SELECT t.roleid FROM t_s_role_user t where t.userid in ('"+persons.replaceAll(",", "','")+"') group by t.roleid))and t3.arealevel =(select t2.territorylevel from t_s_TERRITORY t2 where t2.id = '"+city+"')";
		List<Map<String, Object>> list = travelService.findForJdbc(sql);//标准list
		double standard = Double.valueOf(list.get(0).get("standard")+"");
		String countSql= "SELECT sum(case when t.sex=1 then 1 else 0 end) wm ,sum(case when t.sex=0 then 1 else 0 end) m FROM hr_person_info t where t.id in ('"+persons.replaceAll(",", "','")+"')";
		List<Map<String, Object>> list2 = travelService.findForJdbc(countSql);//男女数量
		int wm = Integer.valueOf(list2.get(0).get("wm")+"");//女数量
		int m = Integer.valueOf(list2.get(0).get("m")+"");//男数量
		double sum = 0d;
		if(x>0){
			//计算正常出差补贴标准
			if(wm%2>0){
				sum+=standard*(1.2*(wm/2)+1)*x;
			}else{
				sum+=standard*1.2*(wm/2)*x;
			}
			if(m%2>0){
				sum+=standard*(1.2*(m/2)+1)*x;
			}else{
				sum+=standard*1.2*(m/2)*x;
			}
			
			//计算不同交通工具补贴
			if("4".equals(vehicle)||"5".equals(vehicle)){
				sum=sum*0.85;
			}else if("6".equals(vehicle)){
				
			}
					
			//计算不同住宿补贴
			if("1".equals(stayType)){
				sum=sum*0.3;
			}else if("2".equals(stayType)){
				sum=sum*0.6;
			}else if("3".equals(stayType)){
				sum=sum*0.15;
			}else {
				
			}
		}else{
			sum=15*(m+wm);
		}
		
		
		return sum+"";
	}
	
}
