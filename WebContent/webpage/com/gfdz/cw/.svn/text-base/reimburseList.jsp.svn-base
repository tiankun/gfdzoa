<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="reimburseList" title="财务报账主表" actionUrl="reimburseController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="申请人" field="userId.realName" ></t:dgCol>
   <t:dgCol title="项目" field="projectId.projectName" ></t:dgCol>
   <t:dgCol title="申请时间" field="applyDate" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="申请金额" field="applyMoney" ></t:dgCol>
   <t:dgCol title="审定金额" field="validationMoney" ></t:dgCol>
   <t:dgCol title="支付方式" field="advanceType" dictionary="advanceType"></t:dgCol>
   <t:dgCol title="收款单位" field="skdw" ></t:dgCol>
   <t:dgCol title="付款单位" field="fukuanUnit" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="打印时间" field="print" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="作废时间" field="zfTime" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="作废人" field="zfPerson" ></t:dgCol>
   <t:dgCol title="作废原因" field="zfReason" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="reimburseController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="reimburseController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="reimburseController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="reimburseController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>