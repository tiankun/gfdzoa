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
import com.gfdz.entity.zhb.CpEntity;
import com.gfdz.page.zhb.ZhbPlancpPage;
import com.gfdz.service.zhb.ZhbPlancpServiceI;


/**   
 * @Title: Controller
 * @Description: 采购计划申请
 * @author onlineGenerator
 * @date 2015-07-20 11:05:49
 * @version V1.0   
 *
 */
@Scope("prototype") 
@Controller
@RequestMapping("/zhbPlancpController")
public class ZhbPlancpController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZhbPlancpController.class);

	@Autowired
	private ZhbPlancpServiceI zhbPlancpService;
	@Autowired
	private SystemService systemService;


	/**
	 * 采购计划申请列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "zhbPlancpList")
	public ModelAndView zhbPlancp(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/plancp/zhbPlancpList");
	}
	/**
	 * 采购计划申请审批页面列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "zhbPlanaditList")
	public ModelAndView PlancpauditList(HttpServletRequest request) {
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
	public void datagrid(ZhbPlancpEntity zhbPlancp,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZhbPlancpEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zhbPlancp);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zhbPlancpService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除采购计划申请
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZhbPlancpEntity zhbPlancp, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		zhbPlancp = systemService.getEntity(ZhbPlancpEntity.class, zhbPlancp.getId());
		String message = "采购计划申请删除成功";
		try{
			zhbPlancpService.delMain(zhbPlancp);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购计划申请删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除采购计划申请
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "采购计划申请删除成功";
		try{
			for(String id:ids.split(",")){
				ZhbPlancpEntity zhbPlancp = systemService.getEntity(ZhbPlancpEntity.class,
				id
				);
				zhbPlancpService.delMain(zhbPlancp);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "采购计划申请删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加采购计划申请
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZhbPlancpEntity zhbPlancp,ZhbPlancpPage zhbPlancpPage, HttpServletRequest request) {
		List<ZhbPlanlistEntity> zhbPlanlistList =  zhbPlancpPage.getZhbPlanlistList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			zhbPlancpService.addMain(zhbPlancp, zhbPlanlistList);
			
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购计划申请添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新采购计划申请
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZhbPlancpEntity zhbPlancp,ZhbPlancpPage zhbPlancpPage, HttpServletRequest request) {
		List<ZhbPlanlistEntity> zhbPlanlistList =  zhbPlancpPage.getZhbPlanlistList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			zhbPlancpService.updateMain(zhbPlancp, zhbPlanlistList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新采购计划申请失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 采购计划申请新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZhbPlancpEntity zhbPlancp, HttpServletRequest req) {
		boolean  i= StringUtil.isNotEmpty(zhbPlancp.getId());
		if (StringUtil.isNotEmpty(zhbPlancp.getId())) {
			zhbPlancp = zhbPlancpService.getEntity(ZhbPlancpEntity.class, zhbPlancp.getId());
			req.setAttribute("zhbPlancpPage", zhbPlancp);
		}
		return new ModelAndView("com/gfdz/zhb/plancp/zhbPlancp-add");
	}
	
	/**
	 * 采购计划申请编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZhbPlancpEntity zhbPlancp, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zhbPlancp.getId())) {
			zhbPlancp = zhbPlancpService.getEntity(ZhbPlancpEntity.class, zhbPlancp.getId());
			req.setAttribute("zhbPlancpPage", zhbPlancp);
		}
		return new ModelAndView("com/gfdz/zhb/plancp/zhbPlancp-update");
	}
	
	
	/**
	 * 加载明细列表[采购申请材料详细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zhbPlanlistList")
	public ModelAndView zhbPlanlistList(ZhbPlancpEntity zhbPlancp, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = zhbPlancp.getId();
		//Object id0 = zhbPlancp.getId();
		//===================================================================================
		//查询-采购申请材料详细
	    String hql0 = "from ZhbPlanlistEntity  where 1 = 1   AND pLANCP_ID = ? ";
	    try{
	    	List<ZhbPlanlistEntity> zhbPlanlistEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("zhbPlanlistList", zhbPlanlistEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/gfdz/zhb/plancp/zhbPlanlistList");
	}
	
}
