<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="reimburseDetailList" title="财务报账明细" actionUrl="reimburseDetailController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="报账主表id" field="reimburseId" ></t:dgCol>
   <t:dgCol title="类型" field="paytype" ></t:dgCol>
   <t:dgCol title="其他类型说明" field="other" ></t:dgCol>
   <t:dgCol title="支付金额" field="paymoney" ></t:dgCol>
   <t:dgCol title="单据数" field="documentsnum" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="reimburseDetailController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="reimburseDetailController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="reimburseDetailController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="reimburseDetailController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>