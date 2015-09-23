package com.gfdz.controller.hr;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.NewExpr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateWordConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.demo.entity.test.CourseEntity;
import org.jeecgframework.web.system.pojo.base.TSUserOrg;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gfdz.entity.hr.PerformanceBean;
import com.gfdz.entity.hr.PerformanceEntity;
import com.gfdz.service.hr.PerformanceServiceI;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**   
 * @Title: Controller
 * @Description: 绩效考核
 * @author ant
 * @date 2015-05-28 11:13:24
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/performanceController")
public class PerformanceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PerformanceController.class);

	@Autowired
	private PerformanceServiceI performanceService;
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
	 * 绩效考核列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "performanceList")
	public ModelAndView performanceList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/performanceList");
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
	public void datagrid(PerformanceEntity performance,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PerformanceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, performance, request.getParameterMap());
		this.performanceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除绩效考核
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(PerformanceEntity performance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		performance = systemService.getEntity(PerformanceEntity.class, performance.getId());
		message = "绩效考核删除成功";
		performanceService.delete(performance);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	
	/**
	 * 绩效考核列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "performance")
	public ModelAndView performance(PerformanceEntity performance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(performance.getId())) {
			performance = performanceService.getEntity(PerformanceEntity.class, performance.getId());
			req.setAttribute("performancePage", performance);
		}
		List<TSUserOrg> list= performanceService.findByProperty(TSUserOrg.class, "tsDepart.id", ResourceUtil.getSessionUserName().getCurrentDepart().getId());
		req.setAttribute("list", list);
		req.setAttribute("date",new Date());
		return new ModelAndView("com/gfdz/hr/performance");
	}
	
	
	/**
	 * 添加绩效考核
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(PerformanceBean performanceBean,PerformanceEntity performance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(performance.getId())) {
			message = "绩效考核更新成功";
			PerformanceEntity t = performanceService.get(PerformanceEntity.class, performance.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(performance, t);
				performanceService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "绩效考核更新失败";
			}
		} else {
			message = "绩效考核添加成功";
			if(performanceBean.getPerformances()!=null && performanceBean.getPerformances().size()>0){
				for (PerformanceEntity perfor : performanceBean.getPerformances()) {
					
					performanceService.save(perfor);
				}
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	
	/**
	 * 导出excel
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(CourseEntity course,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap map) {

        CriteriaQuery cq = new CriteriaQuery(CourseEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, course, request.getParameterMap());
        List<CourseEntity> courses = this.performanceService.getListByCriteriaQuery(cq,false);

        map.put(NormalExcelConstants.FILE_NAME,"用户信息");
        map.put(NormalExcelConstants.CLASS,CourseEntity.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("课程列表", "导出人:Jeecg",
                "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,courses);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;

	}
	/**
	 * 导出excel 使模板
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByTest")
	public String exportXlsByTest(CourseEntity course,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("month", 10);
        Map<String,Object> temp;
        for(int i = 1;i<8;i++){
            temp = new HashMap<String, Object>();
            temp.put("per", i*10);
            temp.put("mon", i*1000);
            temp.put("summon", i*10000);
            map.put("i"+i, temp);
        }
        modelMap.put(TemplateExcelConstants.FILE_NAME,"工资统计信息");
        modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("export/template/exportTemp.xls",1));
        modelMap.put(TemplateExcelConstants.MAP_DATA,map);
        return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(CourseEntity course,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(CourseEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, course, request.getParameterMap());
        List<CourseEntity> courses = this.performanceService.getListByCriteriaQuery(cq,false);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("year", "2013");
        map.put("sunCourses", courses.size());
        Map<String,Object> obj = new HashMap<String, Object>();
        map.put("obj", obj);
        obj.put("name", courses.size());
        modelMap.put(TemplateExcelConstants.FILE_NAME,"课程信息");
        modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("export/template/exportTemp.xls"));
        modelMap.put(TemplateExcelConstants.MAP_DATA,map);
        modelMap.put(TemplateExcelConstants.CLASS,CourseEntity.class);
        modelMap.put(TemplateExcelConstants.LIST_DATA,courses);
        return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	/**
	 * 导出Word 使模板
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportDocByT")
	public String exportDocByT(CourseEntity course,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(CourseEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, course, request.getParameterMap());
		List<CourseEntity> courses = this.performanceService.getListByCriteriaQuery(cq,false);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("Q1", "289782002");
		map.put("Q2", "106259349");
		map.put("Q3", "106838471");
		map.put("w1", "175449166");
		map.put("w2", "287090836");
		map.put("Author", "scott");
		map.put("email", "scott@jeecg.org");
		map.put("list", courses);
		modelMap.put(TemplateWordConstants.FILE_NAME,"Word测试");
		modelMap.put(TemplateWordConstants.MAP_DATA,map);
		modelMap.put(TemplateWordConstants.URL,"export/template/test.docx");
		return TemplateWordConstants.JEECG_TEMPLATE_WORD_VIEW;
	}

	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<PerformanceEntity> list =  ExcelImportUtil.importExcelByIs(file.getInputStream(),PerformanceEntity.class,params);
				for (PerformanceEntity performance : list) {
					if(performance.getUser()!=null){
						performanceService.save(performance);
					}
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	
	@RequestMapping(params = "upload")
	public String upload(HttpServletRequest req) {
		return "com/gfdz/hr/performanceUpload";
	}
}
