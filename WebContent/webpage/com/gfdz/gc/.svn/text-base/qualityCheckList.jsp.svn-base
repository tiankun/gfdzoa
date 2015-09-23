<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="qualityCheckList" title="质量管理" actionUrl="qualityCheckController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
     <t:dgCol title="项目名称" field="project.projectName" width="100"></t:dgCol>
   <t:dgCol title="项目经理" field="projectManager" width="100"></t:dgCol>
   <t:dgCol title="操作组" field="constructionTeam" width="100"></t:dgCol>
   <t:dgCol title="质检员" field="qualityPerson" width="100"></t:dgCol>
   <t:dgCol title="检查地点" field="inspectionPlace" width="100"></t:dgCol>
   <t:dgCol title="问题描述" field="question" width="100"></t:dgCol>
   <t:dgCol title="巡检日期" field="qualityDate" formatter="yyyy-MM-dd" width="100"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="qualityCheckController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="qualityCheckController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="qualityCheckController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" width="1200" height="600" icon="icon-search" url="qualityCheckController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>