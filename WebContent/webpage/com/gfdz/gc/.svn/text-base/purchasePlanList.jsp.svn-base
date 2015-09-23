<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE >
<html>
<head>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="purchasePlanList" queryMode="group" title="项目材料采购计划 " actionUrl="purchasePlanController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="单号" field="billCode" query="true"></t:dgCol>
   <t:dgCol title="所属项目" field="project.projectName" query="true"></t:dgCol>
   <t:dgCol title="申请人" field="user.realName"></t:dgCol>
   <t:dgCol title="申请时间" field="applyTime" formatter="yyyy-MM-dd hh:mm:ss" query="true"></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="purchasePlanController.do?del&id={id}" />
   <t:dgToolBar title="采购申请" width="100%" icon="icon-add" url="purchasePlanController.do?addorupdate" funname="toAdd"></t:dgToolBar>
   <t:dgToolBar title="采购编辑" width="100%" icon="icon-add" url="purchasePlanController.do?addorupdate" funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="purchasePlanController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 </body>
 <script>
 
 function refreshGrid(){
	 $("#purchasePlanList").datagrid('reload');  
 }
  $("input[name='applyTime']").addClass("easyui-datebox");
 </script>
 </html>