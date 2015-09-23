package com.gfdz.controller.hr;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.PinyinUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.hr.PersonInfoEntity;
import com.gfdz.service.hr.PersonInfoService;

/**   
 * @Title: Controller
 * @Description: 人员信息表
 * @author ant
 * @date 2015-06-11 11:20:00
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/personInfoController")
public class PersonInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PersonInfoController.class);

	@Autowired
	private PersonInfoService personInfoService;
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
	 * 
	  * @Title: personInfoList
	  * @Description: 人才库管理跳转
	  * @param request
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月15日 上午9:25:10
	 */
	@RequestMapping(params = "personInfoList")
	public ModelAndView personInfoList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/personInfoList");
	}

	/**
	 * 
	  * @Title: datagrid
	  * @Description: 人才库管理列表查询
	  * @param personInfo
	  * @param request
	  * @param response
	  * @param dataGrid void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月15日 上午9:25:42
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(PersonInfoEntity personInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PersonInfoEntity.class, dataGrid);
		//查询条件组装器
		cq.add(Restrictions.in("personState", new Object[]{"0","1"}));
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, personInfo, request.getParameterMap());
		this.personInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 
	  * @Title: employeeList
	  * @Description: 员工管理跳转
	  * @param request
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月15日 上午9:28:16
	 */
	@RequestMapping(params = "employeeList")
	public ModelAndView employeeList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/employeeList");
	}
	
	/**
	 * 
	  * @Title: employeeListData
	  * @Description: 查询员工管理数据
	  * @param personInfo
	  * @param request
	  * @param response
	  * @param dataGrid void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月15日 上午9:28:21
	 */
	@RequestMapping(params = "employeeListData")
	public void employeeListData(PersonInfoEntity personInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PersonInfoEntity.class, dataGrid);
		//查询条件组装器
		cq.add(Restrictions.not(Restrictions.in("personState", new Object[]{"0","1"})));
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, personInfo, request.getParameterMap());
		this.personInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除人员信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PersonInfoEntity personInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		personInfo = systemService.getEntity(PersonInfoEntity.class, personInfo.getId());
		message = "人员信息表删除成功";
		personInfoService.delete(personInfo);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加人员信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PersonInfoEntity personInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtil.isNotEmpty(personInfo.getId())) {
			message = "人员信息表更新成功";
			PersonInfoEntity t = personInfoService.get(PersonInfoEntity.class, personInfo.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(personInfo, t);
				personInfoService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "人员信息表更新失败";
			}
		} else {
			message = "人员信息表添加成功";
			String realName=personInfo.getRealName();
			personInfo.setUserName(PinyinUtil.converterToSpell(realName.substring(0,1))+""+PinyinUtil.getPinYinHeadChar(realName.substring(1)));
			personInfo.setPassword("123456");
			personInfoService.save(personInfo);
			j.setObj(personInfo);
			
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		map.put("personid", personInfo.getId());
		j.setAttributes(map);
		j.setMsg(message);
		return j;
	}

	/**
	 * 人员信息表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(PersonInfoEntity personInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(personInfo.getId())) {
			personInfo = personInfoService.getEntity(PersonInfoEntity.class, personInfo.getId());
			req.setAttribute("personInfo", personInfo);
			req.setAttribute("personId",personInfo.getId());
		}else if(StringUtil.isNotEmpty(req.getParameter("personId"))){
			personInfo = personInfoService.getEntity(PersonInfoEntity.class, req.getParameter("personId"));
			req.setAttribute("personInfo", personInfo);
			req.setAttribute("personId", req.getParameter("personId"));
		}else if(StringUtil.isNotEmpty(req.getParameter("id"))){
			personInfo = personInfoService.getEntity(PersonInfoEntity.class, req.getParameter("id"));
			req.setAttribute("personInfo", personInfo);
			req.setAttribute("personId", req.getParameter("id"));
		}
		return new ModelAndView("com/gfdz/hr/personInfo");
	}
	
	/**
	 * 
	  * @Title: personBaseInfo
	  * @Description: 基本信息跳转
	  * @param personInfo
	  * @param req
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月15日 上午10:16:35
	 */
	@RequestMapping(params = "personBaseInfo")
	public ModelAndView personBaseInfo(PersonInfoEntity personInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(personInfo.getId())) {
			personInfo = personInfoService.getEntity(PersonInfoEntity.class, personInfo.getId());
			req.setAttribute("personInfo", personInfo);
		}else if(StringUtil.isNotEmpty(req.getParameter("personId"))){
			personInfo = personInfoService.getEntity(PersonInfoEntity.class, req.getParameter("personId"));
			req.setAttribute("personInfo", personInfo);
		}
		return new ModelAndView("com/gfdz/hr/personBaseInfo");
	}
}
