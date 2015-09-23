<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="cplxList" title="产品类型表" actionUrl="cplxController.do?treeGrid" 
  	 treegrid="true" idField="id" pagination="false">
   <t:dgCol title="编号" field="id" hidden="true" treefield="id"/>
   <t:dgCol title="类型名称" field="lxmc" treefield="text" width="100"/>
   <t:dgCol title="编号" field="code" treefield="src" width="100"/>
   <t:dgCol title="操作" field="opt" width="100"/>
   <t:dgDelOpt title="删除" url="cplxController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="cplxController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="cplxController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="cplxController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>