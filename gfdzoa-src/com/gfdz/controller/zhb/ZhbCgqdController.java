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

import com.gfdz.entity.zhb.ZhbCgclEntity;
import com.gfdz.entity.zhb.ZhbCgqdEntity;
import com.gfdz.page.zhb.ZhbCgqdPage;
import com.gfdz.service.zhb.ZhbCgqdServiceI;


/**   
 * @Title: Controller
 * @Description: 配给采购申请单
 * @author onlineGenerator
 * @date 2015-07-27 11:16:08
 * @version V1.0   
 *
 */
@Scope("prototype") 
@Controller
@RequestMapping("/zhbCgqdController")
public class ZhbCgqdController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ZhbCgqdController.class);

	@Autowired
	private ZhbCgqdServiceI zhbCgqdService;
	@Autowired
	private SystemService systemService;


	/**
	 * 配给采购申请单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "zhbCgqdList")
	public ModelAndView zhbCgqd(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/cgqd/zhbCgqdList");
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
	public void datagrid(ZhbCgqdEntity zhbCgqd,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ZhbCgqdEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, zhbCgqd);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.zhbCgqdService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除配给采购申请单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ZhbCgqdEntity zhbCgqd, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		zhbCgqd = systemService.getEntity(ZhbCgqdEntity.class, zhbCgqd.getId());
		String message = "配给采购申请单删除成功";
		try{
			zhbCgqdService.delMain(zhbCgqd);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "配给采购申请单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除配给采购申请单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "配给采购申请单删除成功";
		try{
			for(String id:ids.split(",")){
				ZhbCgqdEntity zhbCgqd = systemService.getEntity(ZhbCgqdEntity.class,
				id
				);
				zhbCgqdService.delMain(zhbCgqd);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "配给采购申请单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加配给采购申请单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ZhbCgqdEntity zhbCgqd,ZhbCgqdPage zhbCgqdPage, HttpServletRequest request) {
		List<ZhbCgclEntity> zhbCgclList =  zhbCgqdPage.getZhbCgclList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			zhbCgqdService.addMain(zhbCgqd, zhbCgclList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "配给采购申请单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新配给采购申请单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ZhbCgqdEntity zhbCgqd,ZhbCgqdPage zhbCgqdPage, HttpServletRequest request) {
		List<ZhbCgclEntity> zhbCgclList =  zhbCgqdPage.getZhbCgclList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			zhbCgqdService.updateMain(zhbCgqd, zhbCgclList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新配给采购申请单失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 配给采购申请单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ZhbCgqdEntity zhbCgqd, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zhbCgqd.getId())) {
			zhbCgqd = zhbCgqdService.getEntity(ZhbCgqdEntity.class, zhbCgqd.getId());
			req.setAttribute("zhbCgqdPage", zhbCgqd);
		}
		return new ModelAndView("com/gfdz/zhb/cgqd/zhbCgqd-add");
	}
	
	/**
	 * 配给采购申请单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ZhbCgqdEntity zhbCgqd, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(zhbCgqd.getId())) {
			zhbCgqd = zhbCgqdService.getEntity(ZhbCgqdEntity.class, zhbCgqd.getId());
			req.setAttribute("zhbCgqdPage", zhbCgqd);
		}
		return new ModelAndView("com/gfdz/zhb/cgqd/zhbCgqd-update");
	}
	
	
	/**
	 * 加载明细列表[采购申请材料]
	 * 
	 * @return
	 */
	@RequestMapping(params = "zhbCgclList")
	public ModelAndView zhbCgclList(ZhbCgqdEntity zhbCgqd, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = zhbCgqd.getId();
		//===================================================================================
		//查询-采购申请材料
	    String hql0 = "from ZhbCgclEntity where 1 = 1 AND cGQD_ID = ? ";
	    try{
	    	List<ZhbCgclEntity> zhbCgclEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("zhbCgclList", zhbCgclEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/gfdz/zhb/cgqd/zhbCgclList");
	}
	
}
