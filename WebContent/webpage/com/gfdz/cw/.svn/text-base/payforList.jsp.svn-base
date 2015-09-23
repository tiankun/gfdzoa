<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="payforList" fitColumns="true" title="款项支付" actionUrl="payforController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="供应商" field="skId.gsmc" query="true"></t:dgCol>
   <t:dgCol title="金额" field="totalMoney"></t:dgCol>
   <t:dgCol title="申请人" field="user.realName"></t:dgCol>
   <t:dgCol title="申请时间" field="odate"></t:dgCol>
   <t:dgCol title="申请说明" field="note"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="payforController.do?del&id={id}" />
   <t:dgToolBar title="录入" width="1200" height="600" icon="icon-add" url="payforController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" width="1200" height="600" icon="icon-edit" url="payforController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" width="1200" height="600" icon="icon-search" url="payforController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 </body>
 </html>