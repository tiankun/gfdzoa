package com.gfdz.controller.zhb;

import java.util.List;
import java.text.SimpleDateFormat;
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
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.gfdz.entity.zhb.ZhbCgzxEntity;
import com.gfdz.entity.zhb.ZhbCgzxzEntity;
import com.gfdz.page.zhb.ZhbCgzxzPage;
import com.gfdz.service.zhb.ZhbCgzxzServiceI;


/**   
 * @Title: Controller
 * @Description: 采购执行主表
 * @author onlineGenerator
 * @date 2015-07-16 16:36:23
 * @version V1.0   
 *
 */
@Scope("prototype") 
@Controller
@RequestMapping("/zhbCgzxzController")
public class ZhbCgzxzController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZhbCgzxzController.class);

	@Autowired
	private ZhbCgzxzServiceI zhbCgzxzService;
	@Autowired
	private SystemService systemService;


	/**
	 * 采购执行主表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "zhbCgzxzList")
	public ModelAndView zhbCgzxz(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/cgzx/zhbCgzxzList");
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
	public void datagrid(ZhbCgzxzEntity zhbCgzxz,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZhbCgzxzEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zhbCgzxz);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zhbCgzxzService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除采购执行主表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZhbCgzxzEntity zhbCgzxz, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		zhbCgzxz = systemService.getEntity(ZhbCgzxzEntity.class, zhbCgzxz.getId());
		String message = "采购执行主表删除成功";
		try{
			zhbCgzxzService.delMain(zhbCgzxz);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购执行主表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除采购执行主表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "采购执行主表删除成功";
		try{
			for(String id:ids.split(",")){
				ZhbCgzxzEntity zhbCgzxz = systemService.getEntity(ZhbCgzxzEntity.class,
				id
				);
				zhbCgzxzService.delMain(zhbCgzxz);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "采购执行主表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加采购执行主表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZhbCgzxzEntity zhbCgzxz,ZhbCgzxzPage zhbCgzxzPage, HttpServletRequest request) {
		List<ZhbCgzxEntity> zhbCgzxList =  zhbCgzxzPage.getZhbCgzxList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			zhbCgzxzService.addMain(zhbCgzxz, zhbCgzxList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购执行主表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新采购执行主表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZhbCgzxzEntity zhbCgzxz,ZhbCgzxzPage zhbCgzxzPage, HttpServletRequest request) {
		List<ZhbCgzxEntity> zhbCgzxList =  zhbCgzxzPage.getZhbCgzxList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			zhbCgzxzService.updateMain(zhbCgzxz, zhbCgzxList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新采购执行主表失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 采购执行主表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZhbCgzxzEntity zhbCgzxz, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zhbCgzxz.getId())) {
			zhbCgzxz = zhbCgzxzService.getEntity(ZhbCgzxzEntity.class, zhbCgzxz.getId());
			req.setAttribute("zhbCgzxzPage", zhbCgzxz);
		}
		return new ModelAndView("com/gfdz/zhb/cgzx/zhbCgzxz-add");
	}
	
	/**
	 * 采购执行主表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZhbCgzxzEntity zhbCgzxz, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zhbCgzxz.getId())) {
			zhbCgzxz = zhbCgzxzService.getEntity(ZhbCgzxzEntity.class, zhbCgzxz.getId());
			req.setAttribute("zhbCgzxzPage", zhbCgzxz);
		}
		return new ModelAndView("com/gfdz/zhb/cgzx/zhbCgzxz-update");
	}
	
	
	/**
	 * 加载明细列表[执行材料明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zhbCgzxList")
	public ModelAndView zhbCgzxList(ZhbCgzxzEntity zhbCgzxz, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = zhbCgzxz.getId();
		//===================================================================================
		//查询-执行材料明细
	    String hql0 = "from ZhbCgzxEntity where 1 = 1 AND cGSQ_ID = ? ";
	    try{
	    	List<ZhbCgzxEntity> zhbCgzxEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("zhbCgzxList", zhbCgzxEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/gfdz/zhb/cgzx/zhbCgzxList");
	}
	
}
