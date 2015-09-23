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

import com.gfdz.entity.zhb.ZhbPlanaditEntity;
import com.gfdz.entity.zhb.ZhbPlancpEntity;
import com.gfdz.entity.zhb.ZhbPlanlistEntity;
import com.gfdz.page.zhb.ZhbPlanaditPage;
import com.gfdz.service.zhb.ZhbPlanaditServiceI;
import com.gfdz.service.zhb.ZhbPlancpServiceI;

/**   
 * @Title: Controller
 * @Description: 计划采购申请审核
 * @author onlineGenerator
 * @date 2015-07-20 11:41:07
 * @version V1.0   
 *
 */
@Scope("prototype") 
@Controller
@RequestMapping("/zhbPlanaditController")
public class ZhbPlanaditController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZhbPlanaditController.class);

	@Autowired
	private ZhbPlanaditServiceI zhbPlanaditService;
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private ZhbPlancpServiceI zhbPlancpService;


	/**
	 * 计划采购申请审核列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "zhbPlanaditList")
	public ModelAndView zhbPlanadit(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/planaudit/zhbPlancpList");
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
	public void datagrid(ZhbPlanaditEntity zhbPlanadit,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZhbPlanaditEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zhbPlanadit);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zhbPlanaditService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除计划采购申请审核
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZhbPlanaditEntity zhbPlanadit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		zhbPlanadit = systemService.getEntity(ZhbPlanaditEntity.class, zhbPlanadit.getId());
		String message = "计划采购申请审核删除成功";
		try{
			zhbPlanaditService.delMain(zhbPlanadit);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "计划采购申请审核删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除计划采购申请审核
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "计划采购申请审核删除成功";
		try{
			for(String id:ids.split(",")){
				ZhbPlanaditEntity zhbPlanadit = systemService.getEntity(ZhbPlanaditEntity.class,
				id
				);
				zhbPlanaditService.delMain(zhbPlanadit);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "计划采购申请审核删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加计划采购申请审核
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZhbPlanaditEntity zhbPlanadit,ZhbPlanaditPage zhbPlanaditPage, HttpServletRequest request) {
		List<ZhbPlanlistEntity> zhbPlanlistList =  zhbPlanaditPage.getZhbPlanlistList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			zhbPlanaditService.addMain(zhbPlanadit, zhbPlanlistList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "计划采购申请审核添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新计划采购申请审核
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZhbPlanaditEntity zhbPlanadit,ZhbPlanaditPage zhbPlanaditPage, HttpServletRequest request) {
		List<ZhbPlanlistEntity> zhbPlanlistList =  zhbPlanaditPage.getZhbPlanlistList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			zhbPlanaditService.updateMain(zhbPlanadit, zhbPlanlistList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新计划采购申请审核失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 计划采购申请审核新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZhbPlanaditEntity zhbPlanadit, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zhbPlanadit.getId())) {
			
			zhbPlanadit = zhbPlanaditService.getEntity(ZhbPlanaditEntity.class, zhbPlanadit.getId());
			req.setAttribute("zhbPlanaditPage", zhbPlanadit);
		}
		return new ModelAndView("com/gfdz/zhb/planaudit/zhbPlanadit-add");
	}
	
	/**
	 * 计划采购申请审核编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate( ZhbPlancpEntity zhbPlancp, HttpServletRequest req) {
		Object id0 = zhbPlancp.getId();
		String id1 = req.getParameter("id");
		if (StringUtil.isNotEmpty(zhbPlancp.getId())) {
			zhbPlancp = zhbPlancpService.getEntity(ZhbPlancpEntity.class, zhbPlancp.getId());;
			req.setAttribute("zhbPlancpPage", zhbPlancp);
		}
		
		
		return new ModelAndView("com/gfdz/zhb/planaudit/zhbPlanadit-update");
	}
	
	
	/**
	 * 加载明细列表[计划采购材料清单]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zhbPlanlistList")
	public ModelAndView zhbPlanlistList(ZhbPlancpEntity zhbPlancp, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = zhbPlancp.getId();
		//Object id0 = zhbPlanadit.getId();
		//===================================================================================
		//查询-计划采购材料清单
	    String hql0 = "from ZhbPlanlistEntity where 1 = 1 AND pLANCP_ID = ?  ";
	    try{
	    	List<ZhbPlanlistEntity> zhbPlanlistEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("zhbPlanlistList", zhbPlanlistEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/gfdz/zhb/planaudit/zhbPlanlistList");
	}
	
}
