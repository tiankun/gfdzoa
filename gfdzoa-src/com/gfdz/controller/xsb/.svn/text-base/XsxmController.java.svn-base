package com.gfdz.controller.xsb;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.entity.xsb.XsxmEntity;
import com.gfdz.service.xsb.XsxmServiceI;

/**   
 * @Title: Controller
 * @Description: 销售项目表
 * @author ant
 * @date 2015-05-28 13:42:10
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/xsxmController")
public class XsxmController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(XsxmController.class);

	@Autowired
	private XsxmServiceI xsxmService;
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
	 * 销售项目表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "xsxmList")
	public ModelAndView xsxmList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/xsb/xsxmList");
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
	public void datagrid(ProjectInfoEntity xsxm,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ProjectInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, xsxm, request.getParameterMap());
		this.xsxmService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除销售项目表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ProjectInfoEntity xsxm, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		xsxm = systemService.getEntity(XsxmEntity.class, xsxm.getId());
		message = "销售项目表删除成功";
		xsxmService.delete(xsxm);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加销售项目表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ProjectInfoEntity xsxm, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(xsxm.getId())) {
			message = "销售项目表更新成功";
			ProjectInfoEntity t = xsxmService.get(ProjectInfoEntity.class, xsxm.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(xsxm, t);
				xsxmService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "销售项目表更新失败";
			}
		} else {
			message = "销售项目表添加成功";
			xsxmService.save(xsxm);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 销售项目表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ProjectInfoEntity xsxm, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(xsxm.getId())) {
			xsxm = xsxmService.getEntity(ProjectInfoEntity.class, xsxm.getId());
			req.setAttribute("projectInfo", xsxm);
		}
		req.setAttribute("username", ResourceUtil.getSessionUserName().getRealName());
		return new ModelAndView("com/gfdz/xsb/xsxm");
	}
	
	/**
	  * @Title: xsmx
	  * @Description: 跳转添加销售记录
	  * @param xsxm
	  * @param req
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月30日 下午1:52:53
	 */
	@RequestMapping(params = "xsmx")
	public ModelAndView xsmx(ProjectInfoEntity xsxm, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(xsxm.getId())) {
			xsxm = xsxmService.getEntity(ProjectInfoEntity.class, xsxm.getId());
			req.setAttribute("projectInfo", xsxm);
		}
		return new ModelAndView("com/gfdz/xsb/xsmx");
	}
	
	/**
	 * 
	  * @Title: saveXsmx
	  * @Description:保存销售明细
	  * @param xsxm
	  * @param request
	  * @return AjaxJson
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年7月30日 下午3:44:30
	 */
	@RequestMapping(params = "saveXsmx")
	@ResponseBody
	public AjaxJson saveXsmx(XsxmEntity xsxm, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(xsxm.getId())) {
			message = "销售记录更新成功";
			XsxmEntity t = xsxmService.get(XsxmEntity.class, xsxm.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(xsxm, t);
				xsxmService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "销售项目表更新失败";
			}
		} else {
			message = "销售记录添加成功";
			xsxmService.save(xsxm);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 
	  * @Title: xsmxDetailList
	  * @Description: 跳转销售日志列表
	  * @param pId
	  * @param request
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月3日 上午9:29:02
	 */
	@RequestMapping(params = "xsmxDetailList")
	public ModelAndView xsmxDetailList(String pId,HttpServletRequest request) {
		return new ModelAndView("com/gfdz/xsb/xsmxDetailList");
	}
	
	/**
	 * 
	  * @Title: xsmxDetailData
	  * @Description: 销售日志记录
	  * @param xsxm
	  * @param request
	  * @param response
	  * @param dataGrid void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月3日 上午9:30:13
	 */
	@RequestMapping(params = "xsmxDetailData")
	public void xsmxDetailData(XsxmEntity xsxm,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(XsxmEntity.class, dataGrid);
		//查询条件组装器
		cq.add(Restrictions.eq("project.id", request.getParameter("pId")));
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, xsxm, request.getParameterMap());
		this.xsxmService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
}
