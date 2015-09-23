<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="purchaseExecuteConfirmList" title="项目材料采购到货记录" actionUrl="purchaseExecuteConfirmController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="detailedId" field="detailedId" ></t:dgCol>
   <t:dgCol title="confirmNumber" field="confirmNumber" ></t:dgCol>
   <t:dgCol title="confirmTime" field="confirmTime" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="sjSuppliers" field="sjSuppliers" ></t:dgCol>
   <t:dgCol title="confirmUser" field="confirmUser" ></t:dgCol>
   <t:dgCol title="remark" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="purchaseExecuteConfirmController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="purchaseExecuteConfirmController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="purchaseExecuteConfirmController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="purchaseExecuteConfirmController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>