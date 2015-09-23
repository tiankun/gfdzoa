package com.gfdz.controller.zhb;
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

import com.gfdz.entity.zhb.BhgpdjEntity;
import com.gfdz.service.zhb.BhgpdjServiceI;

/**   
 * @Title: Controller
 * @Description: 不合格产品登记
 * @author ant
 * @date 2015-05-29 14:25:08
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/bhgpdjController")
public class BhgpdjController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BhgpdjController.class);

	@Autowired
	private BhgpdjServiceI bhgpdjService;
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
	 * 不合格产品登记列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "bhgpdjList")
	public ModelAndView bhgpdjList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/bhgpdjList");
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
	public void datagrid(BhgpdjEntity bhgpdj,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BhgpdjEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bhgpdj, request.getParameterMap());
		this.bhgpdjService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除不合格产品登记
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(BhgpdjEntity bhgpdj, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		bhgpdj = systemService.getEntity(BhgpdjEntity.class, bhgpdj.getId());
		message = "不合格产品登记删除成功";
		bhgpdjService.delete(bhgpdj);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加不合格产品登记
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(BhgpdjEntity bhgpdj, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(bhgpdj.getId())) {
			message = "不合格产品登记更新成功";
			BhgpdjEntity t = bhgpdjService.get(BhgpdjEntity.class, bhgpdj.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(bhgpdj, t);
				bhgpdjService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "不合格产品登记更新失败";
			}
		} else {
			message = "不合格产品登记添加成功";
			bhgpdjService.save(bhgpdj);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 不合格产品登记列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(BhgpdjEntity bhgpdj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bhgpdj.getId())) {
			bhgpdj = bhgpdjService.getEntity(BhgpdjEntity.class, bhgpdj.getId());
			req.setAttribute("bhgpdjPage", bhgpdj);
		}
		return new ModelAndView("com/gfdz/zhb/bhgpdj");
	}
}
