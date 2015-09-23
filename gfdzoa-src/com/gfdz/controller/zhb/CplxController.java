package com.gfdz.controller.zhb;
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

import com.gfdz.entity.zhb.CplxEntity;
import com.gfdz.service.zhb.CplxServiceI;

/**   
 * @Title: Controller
 * @Description: 产品类型表
 * @author ant
 * @date 2015-05-28 11:57:00
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/cplxController")
public class CplxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CplxController.class);

	@Autowired
	private CplxServiceI cplxService;
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
	 * 产品类型表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "cplxList")
	public ModelAndView cplxList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/zhb/cplxList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 * @return 
	 */

	@RequestMapping(params = "treeGrid")
	@ResponseBody
	public List<TreeGrid> treeGrid(CplxEntity cplx,HttpServletRequest request, HttpServletResponse response, TreeGrid treegrid) {
		CriteriaQuery cq = new CriteriaQuery(CplxEntity.class);
		if("yes".equals(request.getParameter("isSearch"))) {
			treegrid.setId(null);
			cplx.setId(null);
		} 
		if(null != cplx.getCode()) {
			HqlGenerateUtil.installHql(cq, cplx);
		}
		if (treegrid.getId() != null) {
			cq.eq("parent.id", treegrid.getId());
		} else {
			cq.isNull("parent");
		}
		cq.add();
		List<TreeGrid> list = cplxService.getListByCriteriaQuery(cq, false);
		if(list.size() == 0 && cplx.getCode() != null) { 
			cq = new CriteriaQuery(CplxEntity.class);
			CplxEntity parent = new CplxEntity();
			cplx.setParent(parent);
			HqlGenerateUtil.installHql(cq, cplx);
			list = cplxService.getListByCriteriaQuery(cq, false);
		}
		List<TreeGrid> treeGrids = new ArrayList<TreeGrid>();
		TreeGridModel treeGridModel = new TreeGridModel();
		treeGridModel.setTextField("lxmc");
		treeGridModel.setParentText("parent_lxmc");
		treeGridModel.setParentId("parent_id");
		treeGridModel.setSrc("code");
		treeGridModel.setIdField("id");
		treeGridModel.setChildList("children");
		treeGrids = cplxService.treegrid(list, treeGridModel);
		return treeGrids;
	}

	/**
	 * 删除产品类型表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(CplxEntity cplx, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		cplx = systemService.getEntity(CplxEntity.class, cplx.getId());
		message = "产品类型表删除成功";
		cplxService.delete(cplx);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加产品类型表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(CplxEntity cplx, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(cplx.getId())) {
			message = "产品类型表更新成功";
			CplxEntity t = cplxService.get(CplxEntity.class, cplx.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(cplx, t);
				cplxService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "产品类型表更新失败";
			}
		} else {
			message = "产品类型表添加成功";
			cplxService.save(cplx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 产品类型表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(CplxEntity cplx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(cplx.getId())) {
			cplx = cplxService.getEntity(CplxEntity.class, cplx.getId());
			req.setAttribute("cplxPage", cplx);
		}
		return new ModelAndView("com/gfdz/zhb/cplx");
	}
	
	
	/**
	 * 
	  * @Title: getChildren
	  * @Description: 得到树结构
	  * @param request
	  * @param comboTree
	  * @return List<ComboTree>
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年6月3日 下午2:39:33
	 */
	@RequestMapping(params = "getChildren")
	@ResponseBody
	public List<ComboTree> getChildren(HttpServletRequest request, ComboTree comboTree) {
		CriteriaQuery cq = new CriteriaQuery(CplxEntity.class);
		if (comboTree.getId() != null) {
			cq.eq("parent.id", comboTree.getId());
		} else {
			cq.isNull("parent");
		}
		cq.add();
		List<CplxEntity> list = cplxService.getListByCriteriaQuery(cq, false);
		ComboTreeModel comboTreeModel = new ComboTreeModel("id", "lxmc", "children");
		List<ComboTree> comboTrees = systemService.ComboTree(list, comboTreeModel, null, false);
		return comboTrees;

	}
}
