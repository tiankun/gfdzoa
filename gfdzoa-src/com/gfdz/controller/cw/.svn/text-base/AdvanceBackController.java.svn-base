package com.gfdz.controller.cw;
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

import com.gfdz.entity.cw.AdvanceBackEntity;
import com.gfdz.service.cw.AdvanceBackServiceI;

/**   
 * @Title: Controller
 * @Description: 暂支还款表
 * @author ant
 * @date 2015-05-28 13:50:37
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/advanceBackController")
public class AdvanceBackController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AdvanceBackController.class);

	@Autowired
	private AdvanceBackServiceI advanceBackService;
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
	 * 暂支还款表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "advanceBackList")
	public ModelAndView advanceBackList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/cw/advanceBackList");
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
	public void datagrid(AdvanceBackEntity advanceBack,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AdvanceBackEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, advanceBack, request.getParameterMap());
		this.advanceBackService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除暂支还款表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(AdvanceBackEntity advanceBack, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		advanceBack = systemService.getEntity(AdvanceBackEntity.class, advanceBack.getId());
		message = "暂支还款表删除成功";
		advanceBackService.delete(advanceBack);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加暂支还款表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(AdvanceBackEntity advanceBack, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(advanceBack.getId())) {
			message = "暂支还款表更新成功";
			AdvanceBackEntity t = advanceBackService.get(AdvanceBackEntity.class, advanceBack.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(advanceBack, t);
				advanceBackService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "暂支还款表更新失败";
			}
		} else {
			message = "暂支还款表添加成功";
			advanceBackService.save(advanceBack);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 暂支还款表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(AdvanceBackEntity advanceBack, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(advanceBack.getId())) {
			advanceBack = advanceBackService.getEntity(AdvanceBackEntity.class, advanceBack.getId());
			req.setAttribute("advanceBackPage", advanceBack);
		}
		return new ModelAndView("com/gfdz/cw/advanceBack");
	}
}
