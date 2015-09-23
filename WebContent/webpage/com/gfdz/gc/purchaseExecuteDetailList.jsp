<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="purchaseExecuteDetailList" title="项目材料采购执行详细" actionUrl="purchaseExecuteDetailController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="采购单主键" field="projectPlanId" ></t:dgCol>
   <t:dgCol title="采购申请物品主键" field="projectMaterialId" ></t:dgCol>
   <t:dgCol title="计划数量" field="amount" ></t:dgCol>
   <t:dgCol title="采购单价" field="price" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="purchaseExecuteDetailController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="purchaseExecuteDetailController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="purchaseExecuteDetailController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="purchaseExecuteDetailController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>