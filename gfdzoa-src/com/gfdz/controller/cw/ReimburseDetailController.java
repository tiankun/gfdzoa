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

import com.gfdz.entity.cw.ReimburseDetailEntity;
import com.gfdz.service.cw.ReimburseDetailServiceI;

/**   
 * @Title: Controller
 * @Description: 财务报账明细
 * @author ant
 * @date 2015-05-28 13:53:11
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/reimburseDetailController")
public class ReimburseDetailController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ReimburseDetailController.class);

	@Autowired
	private ReimburseDetailServiceI reimburseDetailService;
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
	 * 财务报账明细列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "reimburseDetail")
	public ModelAndView reimburseDetail(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/cw/reimburseDetailList");
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
	public void datagrid(ReimburseDetailEntity reimburseDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ReimburseDetailEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, reimburseDetail, request.getParameterMap());
		this.reimburseDetailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除财务报账明细
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ReimburseDetailEntity reimburseDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		reimburseDetail = systemService.getEntity(ReimburseDetailEntity.class, reimburseDetail.getId());
		message = "财务报账明细删除成功";
		reimburseDetailService.delete(reimburseDetail);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加财务报账明细
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ReimburseDetailEntity reimburseDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(reimburseDetail.getId())) {
			message = "财务报账明细更新成功";
			ReimburseDetailEntity t = reimburseDetailService.get(ReimburseDetailEntity.class, reimburseDetail.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(reimburseDetail, t);
				reimburseDetailService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "财务报账明细更新失败";
			}
		} else {
			message = "财务报账明细添加成功";
			reimburseDetailService.save(reimburseDetail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 财务报账明细列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ReimburseDetailEntity reimburseDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(reimburseDetail.getId())) {
			reimburseDetail = reimburseDetailService.getEntity(ReimburseDetailEntity.class, reimburseDetail.getId());
			req.setAttribute("reimburseDetailPage", reimburseDetail);
		}
		return new ModelAndView("com/gfdz/cw/reimburseDetail");
	}
}
