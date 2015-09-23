<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="purchaseExecuteList" title="项目材料采购执行" actionUrl="purchaseExecuteController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="采购单主键" field="projectPlanId" ></t:dgCol>
   <t:dgCol title="创建时间" field="inputTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="创建人" field="inputUser" ></t:dgCol>
   <t:dgCol title="供货单位" field="suppliers" ></t:dgCol>
   <t:dgCol title="流程id" field="processinstanceid" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="purchaseExecuteController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="purchaseExecuteController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="purchaseExecuteController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="purchaseExecuteController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>