<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="travelList" title="出差记录" actionUrl="travelController.do?datagrid" 
  	idField="id" fit="true" queryMode="group">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="申请人" field="travelUser" query="true" width="100"></t:dgCol>
   <t:dgCol title="部门" field="depart" query="true" width="100"></t:dgCol>
   <t:dgCol title="开始时间" field="beginDate" formatter="yyyy-MM-dd hh:mm:ss" query="true" width="100"></t:dgCol>
   <t:dgCol title="结束时间" field="endDate" formatter="yyyy-MM-dd hh:mm:ss" query="true" width="100"></t:dgCol>
   <t:dgCol title="审批状态" field="state" query="true" width="100"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="travelController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="travelController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="travelController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="travelController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>