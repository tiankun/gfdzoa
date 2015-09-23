<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="advanceList" title="暂支表" actionUrl="advanceController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="用户" field="userId.realName" ></t:dgCol>
   <t:dgCol title="部门" field="depart.departname" ></t:dgCol>
   <t:dgCol title="申请时间" field="applyTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="申请金额" field="applyMoney" ></t:dgCol>
   <t:dgCol title="借支类型" field="advanceType" dictionary="advanceType"></t:dgCol>
   <t:dgCol title="申请原因" field="applyReason" dictionary="applyReason"></t:dgCol>
   <t:dgCol title="收款单位" field="payeename" ></t:dgCol>
   <t:dgCol title="付款单位(km,kj)" field="fukuanUnit" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="advanceController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="advanceController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="advanceController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="advanceController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>