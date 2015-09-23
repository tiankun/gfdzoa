<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>项目设计管理</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="projectScheduleDetailList" title="项目进度明细表" actionUrl="projectScheduleController.do?projectScheduleData&pId=${param.pId }" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="材料名称" field="material.cpmc" width="100"></t:dgCol>
   <t:dgCol title="品牌" field="material.brand" width="100"></t:dgCol>
   <t:dgCol title="规格" field="material.standard" width="100"></t:dgCol>
   <t:dgCol title="单位" field="material.unit" width="100"></t:dgCol>
   <t:dgCol title="数量" field="amount" width="100"></t:dgCol>
   <t:dgCol title="使用部位" field="position" width="100"></t:dgCol>
   <t:dgCol title="备注" field="remarks" width="100"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="projectScheduleDetailController.do?del&id={id}" /> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="projectScheduleDetailController.do?addorupdate" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="projectScheduleDetailController.do?addorupdate" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="projectScheduleDetailController.do?addorupdate" funname="detail"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 </body>
 </html>