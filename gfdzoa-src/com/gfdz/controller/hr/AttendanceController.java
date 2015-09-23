package com.gfdz.controller.hr;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.demo.entity.test.CourseEntity;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gfdz.entity.hr.AttendanceEntity;
import com.gfdz.service.hr.AttendanceServiceI;

/**   
 * @Title: Controller
 * @Description: 考勤记录
 * @author ant
 * @date 2015-05-28 11:14:14
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/attendanceController")
public class AttendanceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AttendanceController.class);

	@Autowired
	private AttendanceServiceI attendanceService;
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
	 * 考勤记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "attendanceList")
	public ModelAndView attendanceList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/attendanceList");
	}
	/**
	 * 考勤记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "lookattendanceList")
	public ModelAndView attendanceList1(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/lookattendanceList");
	}
	/**
	 * 考勤记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "countattendanceList")
	public ModelAndView countattendanceList(HttpServletRequest request) {
		return new ModelAndView("com/gfdz/hr/countattendanceList");
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
	public void datagrid(AttendanceEntity attendance,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AttendanceEntity.class, dataGrid);
		//查询条件组装器 
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, attendance, request.getParameterMap());
		this.attendanceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	/*@RequestMapping(params = "datagrid1")
	public void datagrid1(AttendanceEntity attendance,HttpServletRequest request, HttpServletResponse response) {
		String sql="select t.* from ATTENDANCE t where t.DEPARTNAME=?  order by t.NORM_REALNAME, t.NORM_DATE ";
		List<Map<String, Object>> list=this.systemService.findForJdbcParam(sql, 1, 999999, new Object[]{"工程部"});
	    JSON li=(JSON) JSON.toJSON(list);
	    response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		try {
			PrintWriter pw=response.getWriter();
			pw.write(li.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	   
	}*/
	
	
	@RequestMapping(params = "lookdatagrid")
	public void lookdatagrid(AttendanceEntity attendance,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AttendanceEntity.class, dataGrid);
		List<Object> param = new ArrayList<Object>();
		String sql="select t.* from ATTENDANCE t where 1=1";
		String whereSql="";
		String normRealname = request.getParameter("normRealname");
		String needtype = request.getParameter("needtype");
		String departName = request.getParameter("departName");
		String normDate_begin =  request.getParameter("normDate_begin");
		String normDate_end =  request.getParameter("normDate_end");
		//当查询条件是人名时
		if(!"".equals(normRealname)&&normRealname!=null){
			whereSql += " and t.normRealname='"+normRealname+"'";
		}
		//当查询条件是当天考勤状态时
		if(!"".equals(needtype)&&needtype!=null){
			whereSql += " and t.needtype='"+needtype+"'";
		}
		//当搜索条件是部门时
		if(!"".equals(departName)&&departName!=null){
			whereSql +=" and t.NORMUSERID in (select user_id from T_S_DEPART a, T_S_USER_ORG b where a.id = b.org_id and a.departname = '"+departName+"')";
		}
		//当查询条件是时间时
		if(!"".equals(normDate_begin)&&normDate_begin!=null){
			whereSql += " and to_date('"+normDate_begin+"','yyyy-mm-dd')<= normdate and normdate <= to_date('"+normDate_end+"','yyyy-mm-dd')";
		}
		sql+=whereSql+" order by t.NORMREALNAME, t.NORMDATE";
		//List<Map<String, Object>> list=this.systemService.findForJdbc(sql,  new Object[]{"工程部"});
	   // JSON li=(JSON) JSON.toJSON(list);
	    String countsql = "select count(*) from (" + sql.toString() + ")";
		List<Map<String, Object>> maplist = systemService.findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
		Long count = systemService.getCountForJdbcParam(countsql, null);
		dataGrid.setTotal(count.intValue());
		dataGrid.setResults(maplist);
		dataGrid.setField("normDate,normRealname,needtype,departName,normdepartname");
		TagUtil.datagrid(response, dataGrid);
	}
	/**
	 * 考勤记录列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "gotocoucount")
	public ModelAndView gotocoucount(AttendanceEntity attendance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(attendance.getId())) {
			attendance = attendanceService.getEntity(AttendanceEntity.class, attendance.getId());
			req.setAttribute("attendancePage", attendance);
		}
		return new ModelAndView("/com/gfdz/hr/countattendanceList.jsp");
	}
	@RequestMapping(params = "countdatagrid")
	public void countdatagrid(AttendanceEntity attendance,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AttendanceEntity.class, dataGrid);
		List<Object> param = new ArrayList<Object>();
		String sql1="select m.normonth, m.normUserId,"
                    +" m.normRealname,m.normdepartname,"
                    +" sum(case m.needtype when '迟到' then m.needDays else 0 end) late,"
                    +" sum(case m.needtype when '放假' then m.needDays else 0 end) recess,"
                    +" sum(case m.needtype when '缺勤' then m.needDays else 0 end) absenteeism,"
                    +" sum(case m.needtype when '正常上班' then m.needDays else 0 end) normalworking"
                    +" from (select t.normonth,"
                    +" t.normUserId,"
                    +" t.normRealname,"
                    +" t.needtype,"
                    +" t.normdepartname,"
                    +" count(t.needtype) needDays"
                    +" from (select p.*,"
                    +" case when p.normDate >= to_date('2014/10/01', 'yyyy/mm/dd') and p.normDate <= to_date('2014/10/10', 'yyyy/mm/dd') then '1月' "
                    +"   when p.normDate >= to_date('2014/10/11', 'yyyy/mm/dd') and p.normDate <= to_date('2014/10/20', 'yyyy/mm/dd') then '2月' "
                    +"    when p.normDate >= to_date('2014/10/21', 'yyyy/mm/dd') and p.normDate <= to_date('2014/10/31', 'yyyy/mm/dd') then '3月' "
                    +"    else '4月' end as normonth "
                    +" from ATTENDANCE p) t where 1 = 1";
		String whereSql="";
		String sql2 = "group by t.normonth, t.normUserId, t.needtype, t.normRealname,t.normdepartname"
         +" order by t.normUserId) m"
         +" group by m.normUserId, m.normRealname, m.normdepartname, m.normonth order by m.normonth";
		String sql = "";
		String normRealname = request.getParameter("normRealname");
		String needtype = request.getParameter("needtype");
		String normdepartname = request.getParameter("normdepartname");
		String normDate_begin =  request.getParameter("normDate_begin");
		String normDate_end =  request.getParameter("normDate_end");
		//当查询条件是人名时
		if(!"".equals(normRealname)&&normRealname!=null){
			whereSql += " and t.normRealname='"+normRealname+"'";
		}
		//当查询条件是当天考勤状态时
		if(!"".equals(needtype)&&needtype!=null){
			whereSql += " and t.needtype='"+needtype+"'";
		}
		//当搜索条件是部门时
		if(!"".equals(normdepartname)&&normdepartname!=null){
			whereSql +=" and t.NORMUSERID in (select user_id from T_S_DEPART a, T_S_USER_ORG b where a.id = b.org_id and a.departname = '"+normdepartname+"')";
		}
		//当查询条件是时间时
		if(!"".equals(normDate_begin)&&normDate_begin!=null){
			whereSql += " and to_date('"+normDate_begin+"','yyyy-mm-dd')<= normdate and normdate <= to_date('"+normDate_end+"','yyyy-mm-dd')";
		}
		sql+=sql1 + whereSql + sql2;
		//List<Map<String, Object>> list=this.systemService.findForJdbc(sql,  new Object[]{"工程部"});
	   // JSON li=(JSON) JSON.toJSON(list);
	    String countsql = "select count(*) from (" + sql.toString() + ")";
		List<Map<String, Object>> maplist = systemService.findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
		Long count = systemService.getCountForJdbcParam(countsql, null);
		dataGrid.setTotal(count.intValue());
		dataGrid.setResults(maplist);
		dataGrid.setField("normonth,normRealname,normdepartname,late,recess,absenteeism,normalworking");
		TagUtil.datagrid(response, dataGrid);
	}
	/**
	 * 删除考勤记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(AttendanceEntity attendance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		attendance = systemService.getEntity(AttendanceEntity.class, attendance.getId());
		message = "考勤记录删除成功";
		attendanceService.delete(attendance);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加考勤记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(AttendanceEntity attendance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(attendance.getId())) {
			message = "考勤记录更新成功";
			AttendanceEntity t = attendanceService.get(AttendanceEntity.class, attendance.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(attendance, t);
				attendanceService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "考勤记录更新失败";
			}
		} else {
			message = "考勤记录添加成功";
			attendanceService.save(attendance);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 考勤记录列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "attendance")
	public ModelAndView attendance(AttendanceEntity attendance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(attendance.getId())) {
			attendance = attendanceService.getEntity(AttendanceEntity.class, attendance.getId());
			req.setAttribute("attendancePage", attendance);
		}
		return new ModelAndView("com/gfdz/hr/attendance");
	}
	/*
	 *文件上传页面跳转
	 * */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("com/gfdz/hr/attendanceUpload");
	}
	/*
	 *文件上传解析 
	 * */
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(0);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<AttendanceEntity> listAttendance =  ExcelImportUtil.importExcelByIs(file.getInputStream(),AttendanceEntity.class,params);
				for (AttendanceEntity attendance : listAttendance) {
					if(attendance.getUsername()!=null){
						attendanceService.saveAttendance(attendance);
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
}
