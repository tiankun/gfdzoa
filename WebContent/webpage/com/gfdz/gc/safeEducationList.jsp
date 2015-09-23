<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="safeEducationList" title="安全教育" actionUrl="safeEducationController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目名称" field="project.projectName" width="100"></t:dgCol>
   <t:dgCol title="主讲人" field="lecturer" width="100"></t:dgCol>
   <t:dgCol title="受教育人" field="trainee" width="100"></t:dgCol>
   <t:dgCol title="培训日期" field="educationDate" formatter="yyyy-MM-dd" width="100"></t:dgCol>
   <t:dgCol title="培训类别" field="educationType" width="100"></t:dgCol>
   <t:dgCol title="教育内容" field="educationContent" width="100"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="safeEducationController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="safeEducationController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="safeEducationController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" width="1200" height="600" icon="icon-search" url="safeEducationController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>