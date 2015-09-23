package com.gfdz.controller.gc;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.gfdz.entity.gc.MaterialBaseEntity;
import com.gfdz.service.gc.MaterialBaseServiceI;

/**   
 * @Title: Controller
 * @Description: 项目材料审计
 * @author ant
 * @date 2015-05-28 14:50:48
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/materialBaseController")
public class MaterialBaseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaterialBaseController.class);

	@Autowired
	private MaterialBaseServiceI materialBaseService;
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
	 * 项目材料审计列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "materialBaseList")
	public ModelAndView materialBaseList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/materialBaseList");
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
	public void datagrid(MaterialBaseEntity materialBase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaterialBaseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, materialBase, request.getParameterMap());
		this.materialBaseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除项目材料审计
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(MaterialBaseEntity materialBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		materialBase = systemService.getEntity(MaterialBaseEntity.class, materialBase.getId());
		message = "项目材料审计删除成功";
		materialBaseService.delete(materialBase);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加项目材料审计
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(MaterialBaseEntity materialBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(materialBase.getId())) {
			message = "项目材料审计更新成功";
			MaterialBaseEntity t = materialBaseService.get(MaterialBaseEntity.class, materialBase.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(materialBase, t);
				materialBaseService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "项目材料审计更新失败";
			}
		} else {
			message = "项目材料审计添加成功";
			materialBaseService.save(materialBase);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 项目材料审计列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(MaterialBaseEntity materialBase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(materialBase.getId())) {
			materialBase = materialBaseService.getEntity(MaterialBaseEntity.class, materialBase.getId());
			req.setAttribute("materialBasePage", materialBase);
		}
		return new ModelAndView("com/gfdz/gc/materialBase");
	}
	
}
