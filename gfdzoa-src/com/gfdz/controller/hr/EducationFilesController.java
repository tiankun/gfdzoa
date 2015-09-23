package com.gfdz.controller.hr;
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

import com.gfdz.entity.hr.EducationFilesEntity;
import com.gfdz.service.hr.EducationFilesService;

/**   
 * @Title: Controller
 * @Description: 学历信息附件
 * @author ant
 * @date 2015-07-01 16:26:17
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/educationFilesController")
public class EducationFilesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EducationFilesController.class);

	@Autowired
	private EducationFilesService educationFilesService;
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
	 * 学历信息附件列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "educationFilesList")
	public ModelAndView educationFilesList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/educationFilesList");
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
	public void datagrid(EducationFilesEntity educationFiles,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(EducationFilesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, educationFiles, request.getParameterMap());
		this.educationFilesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除学历信息附件
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(EducationFilesEntity educationFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		educationFiles = systemService.getEntity(EducationFilesEntity.class, educationFiles.getId());
		message = "学历信息附件删除成功";
		educationFilesService.delete(educationFiles);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加学历信息附件
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(EducationFilesEntity educationFiles, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(educationFiles.getId())) {
			message = "学历信息附件更新成功";
			EducationFilesEntity t = educationFilesService.get(EducationFilesEntity.class, educationFiles.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(educationFiles, t);
				educationFilesService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "学历信息附件更新失败";
			}
		} else {
			message = "学历信息附件添加成功";
			educationFilesService.save(educationFiles);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 学历信息附件列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(EducationFilesEntity educationFiles, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(educationFiles.getId())) {
			educationFiles = educationFilesService.getEntity(EducationFilesEntity.class, educationFiles.getId());
			req.setAttribute("educationFiles", educationFiles);
		}
		return new ModelAndView("com/gfdz/hr/educationFiles");
	}
}
