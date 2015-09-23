package com.gfdz.controller.zhb;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.gfdz.entity.zhb.SfwdjEntity;
import com.gfdz.service.zhb.SfwdjServiceI;

/**   
 * @Title: Controller
 * @Description: 收发文登记表
 * @author ant
 * @date 2015-05-28 11:46:41
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/sfwdjController")
public class SfwdjController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SfwdjController.class);

	@Autowired
	private SfwdjServiceI sfwdjService;
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
	 * 收发文登记表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sfwdjList")
	public ModelAndView sfwdjList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/sfwdjList");
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
	public void datagrid(SfwdjEntity sfwdj,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SfwdjEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sfwdj, request.getParameterMap());
		this.sfwdjService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除收发文登记表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SfwdjEntity sfwdj, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		sfwdj = systemService.getEntity(SfwdjEntity.class, sfwdj.getId());
		message = "收发文登记表删除成功";
		sfwdjService.delete(sfwdj);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加收发文登记表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SfwdjEntity sfwdj, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sfwdj.getId())) {
			message = "收发文登记表更新成功";
			SfwdjEntity t = sfwdjService.get(SfwdjEntity.class, sfwdj.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(sfwdj, t);
				sfwdjService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "收发文登记表更新失败";
			}
		} else {
			message = "收发文登记表添加成功";
			sfwdjService.save(sfwdj);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 收发文登记表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SfwdjEntity sfwdj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sfwdj.getId())) {
			sfwdj = sfwdjService.getEntity(SfwdjEntity.class, sfwdj.getId());
			
			Map sfwlxMap = new HashMap();
			sfwlxMap.put(1, "收文");
			sfwlxMap.put(2, "发文");
			req.setAttribute("sfwlxMap", sfwlxMap);
			
			req.setAttribute("sfwdjPage", sfwdj);
		}
		return new ModelAndView("com/gfdz/zhb/sfwdj");
	}
}
