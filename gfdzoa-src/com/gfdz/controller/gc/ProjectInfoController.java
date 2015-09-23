package com.gfdz.controller.gc;
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
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.gc.MaterialBaseEntity;
import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.service.gc.ProjectInfoServiceI;

/**   
 * @Title: Controller
 * @Description: 工程信息表
 * @author ant
 * @date 2015-05-28 14:51:47
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/projectInfoController")
public class ProjectInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ProjectInfoController.class);

	@Autowired
	private ProjectInfoServiceI projectInfoService;
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
	 * 工程信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "projectInfoList")
	public ModelAndView projectInfoList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/projectInfoList");
	}
	
	/**
	 * 工程信息表列表  弹出框
	 * 
	 * @return
	 */
	@RequestMapping(params = "projectList")
	public ModelAndView projectList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/projectList");
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
	public void datagrid(ProjectInfoEntity projectInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ProjectInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, projectInfo, request.getParameterMap());
		this.projectInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除工程信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ProjectInfoEntity projectInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		projectInfo = systemService.getEntity(ProjectInfoEntity.class, projectInfo.getId());
		message = "工程信息表删除成功";
		projectInfoService.delete(projectInfo);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加工程信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ProjectInfoEntity projectInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(projectInfo.getId())) {
			message = "工程信息表更新成功";
			ProjectInfoEntity t = projectInfoService.get(ProjectInfoEntity.class, projectInfo.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(projectInfo, t);
				projectInfoService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "工程信息表更新失败";
			}
		} else {
			message = "工程信息表添加成功";
			projectInfoService.save(projectInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 工程信息表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ProjectInfoEntity projectInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(projectInfo.getId())) {
			projectInfo = projectInfoService.getEntity(ProjectInfoEntity.class, projectInfo.getId());
			req.setAttribute("projectInfo", projectInfo);
		}
		return new ModelAndView("com/gfdz/gc/projectInfo");
	}
	
	
	/**
	 * 
	  * @Title: projectMaterialList
	  * @Description: 项目材料设计跳转
	  * @param request
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月7日 上午9:24:07
	 */
	@RequestMapping(params = "projectMaterialList")
	public ModelAndView projectMaterialList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/projectMaterialList");
	}
	
	/**
	 * 
	  * @Title: projectMaterial
	  * @Description: 添加项目材料设计跳转
	  * @param request
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月7日 上午9:24:35
	 */
	@RequestMapping(params = "projectMaterial")
	public ModelAndView projectMaterial(ProjectInfoEntity projectInfo,HttpServletRequest request) {
		if (StringUtil.isNotEmpty(projectInfo.getId())) {
			projectInfo = projectInfoService.getEntity(ProjectInfoEntity.class, projectInfo.getId());
			request.setAttribute("projectInfo", projectInfo);
		}
		return new ModelAndView("com/gfdz/gc/projectMaterial");
	}
	
	/**
	 * 
	  * @Title: saveMaterial
	  * @Description: 保存设计材料
	  * @param projectInfo
	  * @param request
	  * @return AjaxJson
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月7日 上午9:36:53
	 */
	@RequestMapping(params = "saveMaterial")
	@ResponseBody
	public AjaxJson saveMaterial(ProjectInfoEntity projectInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(projectInfo.getId())) {
			message = "工程信息表更新成功";
			ProjectInfoEntity t = projectInfoService.get(ProjectInfoEntity.class, projectInfo.getId());
			try {
				projectInfoService.updateProject(projectInfo,request);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "工程信息表更新失败";
			}
		} else {
			message = "工程信息表添加成功";
			projectInfoService.saveProject(projectInfo,request);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	  * @Title: selectCp
	  * @Description: 产品材料选择
	  * @param request
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月11日 下午2:06:27
	 */
	@RequestMapping(params = "selectCp")
	public ModelAndView selectCp(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/selectCp");
	}
	
	
	/**
	 * 
	  * @Title: materialList
	  * @Description: 项目设计材料清单跳转
	  * @param request
	  * @return ModelAndView
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月11日 下午2:04:09
	 */
	@RequestMapping(params = "materialList")
	public ModelAndView materialList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/gc/materialList");
	}
	
	/**
	 * 
	  * @Title: materialListData
	  * @Description: 项目设计材料清单数据
	  * @param materialBase
	  * @param request
	  * @param response
	  * @param dataGrid void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月11日 下午2:04:15
	 */
	@RequestMapping(params = "materialListData")
	public void materialListData(MaterialBaseEntity materialBase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaterialBaseEntity.class, dataGrid);
		//查询条件组装器
		String pId = request.getParameter("pId");
		cq.add(Restrictions.eq("project.id", pId));
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, materialBase, request.getParameterMap());
		projectInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
}
