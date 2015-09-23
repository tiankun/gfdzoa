package com.gfdz.controller.hr;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.ComboTree;
import org.jeecgframework.core.common.model.json.TreeGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.vo.easyui.ComboTreeModel;
import org.jeecgframework.tag.vo.easyui.TreeGridModel;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.hr.LeaveTypeEntity;
import com.gfdz.service.hr.LeaveTypeServiceI;

/**   
 * @Title: Controller
 * @Description: 请假类型
 * @author ant
 * @date 2015-06-05 11:40:34
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/leaveTypeController")
public class LeaveTypeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LeaveTypeController.class);

	@Autowired
	private LeaveTypeServiceI leaveTypeService;
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
	 * 请假类型列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "leaveTypeList")
	public ModelAndView leaveTypeList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/leaveTypeList");
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
	@ResponseBody
	public List<TreeGrid> datagrid(LeaveTypeEntity leaveType,HttpServletRequest request, HttpServletResponse response,TreeGrid treeGrid) {
		CriteriaQuery cq = new CriteriaQuery(LeaveTypeEntity.class);
		if("yes".equals(request.getParameter("isSearch"))) {
			treeGrid.setId(null);
			leaveType.setId(null);
		} 
		if(null != leaveType.getParent()) {
			HqlGenerateUtil.installHql(cq, leaveType);
		}
		if (treeGrid.getId() != null ) {
			cq.eq("parent.id", treeGrid.getId());
		} else {
			cq.isNull("parent");
		}
		cq.add();
		List<TreeGrid> list = leaveTypeService.getListByCriteriaQuery(cq, false);
		if(list.size() == 0 && leaveType.getTypeName() != null) { 
			cq = new CriteriaQuery(LeaveTypeEntity.class);
			LeaveTypeEntity parent = new LeaveTypeEntity();
			leaveType.setParent(parent);
			HqlGenerateUtil.installHql(cq, leaveType);
			list = leaveTypeService.getListByCriteriaQuery(cq, false);
		}
		List<TreeGrid> treeGrids = new ArrayList<TreeGrid>();
		TreeGridModel treeGridModel = new TreeGridModel();
		treeGridModel.setTextField("typeName");
		treeGridModel.setParentText("parent_typeName");
		treeGridModel.setParentId("parent_id");
		treeGridModel.setSrc("leaveDays");
		treeGridModel.setIdField("id");
		treeGridModel.setChildList("children");
		treeGrids = leaveTypeService.treegrid(list, treeGridModel);
		return treeGrids;
	}

	
	/**
	 * 
	  * @Title: getChildren
	  * @Description: 获取子节点
	  * @param request
	  * @param comboTree
	  * @return List<ComboTree>
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月5日 上午11:56:54
	 */
	@RequestMapping(params = "getChildren")
	@ResponseBody
	public List<ComboTree> getChildren(HttpServletRequest request, ComboTree comboTree) {
		CriteriaQuery cq = new CriteriaQuery(LeaveTypeEntity.class);
		if (comboTree.getId() != null) {
			cq.eq("parent.id", comboTree.getId());
		} else {
			cq.isNull("parent");
		}
		cq.add();
		List<LeaveTypeEntity> list = leaveTypeService.getListByCriteriaQuery(cq, false);
		ComboTreeModel comboTreeModel = new ComboTreeModel("id", "typeName", "children");
		List<ComboTree> comboTrees = systemService.ComboTree(list, comboTreeModel, null, false);
		return comboTrees;

	}
	
	/**
	 * 删除请假类型
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(LeaveTypeEntity leaveType, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		leaveType = systemService.getEntity(LeaveTypeEntity.class, leaveType.getId());
		message = "请假类型删除成功";
		leaveTypeService.delete(leaveType);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加请假类型
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(LeaveTypeEntity leaveType, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(leaveType.getId())) {
			message = "请假类型更新成功";
			LeaveTypeEntity t = leaveTypeService.get(LeaveTypeEntity.class, leaveType.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(leaveType, t);
				leaveTypeService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "请假类型更新失败";
			}
		} else {
			message = "请假类型添加成功";
			leaveTypeService.save(leaveType);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 请假类型列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(LeaveTypeEntity leaveType, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(leaveType.getId())) {
			leaveType = leaveTypeService.getEntity(LeaveTypeEntity.class, leaveType.getId());
			req.setAttribute("leaveTypePage", leaveType);
		}
		return new ModelAndView("com/gfdz/hr/leaveType");
	}
}
