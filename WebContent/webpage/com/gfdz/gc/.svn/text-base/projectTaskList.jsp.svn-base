<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>任务计划</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
   </head>
 <body style="overflow-y: hidden" scroll="no">
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="projectTaskList" title="工程项目计划表" actionUrl="projectTaskController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目名称" field="project.projectName" width="100"></t:dgCol>
   <t:dgCol title="填报时间" field="createDate" formatter="yyyy-MM-dd" width="100"></t:dgCol>
   <t:dgCol title="费用总额" field="totalCost" width="100"></t:dgCol>
   <t:dgCol title="责任人" field="responsible" width="100"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="projectTaskController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="projectTaskController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="projectTaskController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" width="1200" height="600" icon="icon-search" url="projectTaskController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 </body>
 </html>