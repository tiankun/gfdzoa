<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript" charset="utf-8">
	/*
	 *	excel导出
	 */
	function courseListExportXls() {
		JeecgExcelExport("courseController.do?exportXls","courseList");
	}
	function courseListExportXlsByT() {
		JeecgExcelExport("courseController.do?exportXlsByT","courseList");
	}
	function courseListWordXlsByT() {
		JeecgExcelExport("courseController.do?exportDocByT","courseList");
	}
	function courseListExportXlsByTe() {
		JeecgExcelExport("courseController.do?exportXlsByTest","courseList");
	}
	function attendanceListImportXls() {
		openuploadwin('Excel导入', 'attendanceController.do?upload', "courseList");
		
	}
	
</script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="attendanceList" title="考勤记录" actionUrl="attendanceController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="用户名称" field="username" ></t:dgCol>
   <t:dgCol title="部门" field="depart"></t:dgCol>
   <t:dgCol title="考勤日期" field="attendanceDate" ></t:dgCol>
   <t:dgCol title="上午考勤" field="attendanceAm" ></t:dgCol>
   <t:dgCol title="下午考勤" field="attendancePm" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="attendanceController.do?del&id={id}" />
   
 	<t:dgToolBar title="录入" icon="icon-add" onclick="attendanceListImportXls()"  ></t:dgToolBar>
 <%--   <t:dgToolBar title="录入" icon="icon-add" url="attendanceController.do?addorupdate" funname="add"></t:dgToolBar> --%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="attendanceController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="attendanceController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>