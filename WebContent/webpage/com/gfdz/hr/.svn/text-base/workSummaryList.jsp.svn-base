<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="workSummaryList" title="工作总结" actionUrl="workSummaryController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="提交日期" field="summaryDate" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="周数" field="summaryWeeks" ></t:dgCol>
   <t:dgCol title="总结内容" field="summaryNote" ></t:dgCol>
   <t:dgCol title="用户" field="summaryUser" ></t:dgCol>
   <t:dgCol title="查看次数" field="summaryNum" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="workSummaryController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="workSummaryController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="workSummaryController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="workSummaryController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>