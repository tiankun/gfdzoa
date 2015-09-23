<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript" charset="utf-8">
	/*
	 *	excel导出
	 */
	function performanceListExportXls() {
		JeecgExcelExport("performanceController.do?exportXls","performanceList");
	}
	function performanceListExportXlsByT() {
		JeecgExcelExport("performanceController.do?exportXlsByT","performanceList");
	}
	function performanceListWordXlsByT() {
		JeecgExcelExport("performanceController.do?exportDocByT","performanceList");
	}
	function performanceListExportXlsByTe() {
		JeecgExcelExport("performanceController.do?exportXlsByTest","performanceList");
	}
	function performanceListImportXls() {
		openuploadwin('Excel导入', 'performanceController.do?upload', "performanceList");
	}
	
</script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="performanceList" title="绩效考核" queryMode="group"
  actionUrl="performanceController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="用户名" field="user.realName" width="100" query="true"></t:dgCol>
   <t:dgCol title="部门" field="depart.departname" width="100" query="true"></t:dgCol>
   <t:dgCol title="考核日期" field="performanceDate" formatter="yyyy-MM-dd" width="100" query="true" queryMode="group" extend="{class:{value:'easyui-datebox'}}"></t:dgCol>
   <t:dgCol title="结果" field="results" width="100"></t:dgCol>
   <t:dgCol title="备注" field="note" width="100"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="performanceController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="performanceController.do?performance" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="performanceController.do?performance" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="performanceController.do?performance" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导出Excel" icon="icon-search" onclick="performanceListExportXls();"></t:dgToolBar> --%>
<%-- 	<t:dgToolBar title="导入Excel" icon="icon-search" onclick="performanceListImportXls()"></t:dgToolBar> --%>
<%-- 	<t:dgToolBar title="Excel模板导出" icon="icon-search" onclick="performanceListExportXlsByT()"></t:dgToolBar> --%>
<%-- 	<t:dgToolBar title="Excel模板导出统计" icon="icon-search" onclick="performanceListExportXlsByTe()"></t:dgToolBar> --%>
<%-- 	<t:dgToolBar title="Word模板导出" icon="icon-search" onclick="performanceListWordXlsByT()"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>