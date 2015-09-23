<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="expensesPlanList" title="费用开支计划" actionUrl="expensesPlanController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="申请人" field="userId.realName" ></t:dgCol>
   <t:dgCol title="部门" field="depart.departname" ></t:dgCol>
   <t:dgCol title="申请时间" field="applyTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="预支时间" field="advanceTime" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="申请金额" field="totalSum" ></t:dgCol>
   <t:dgCol title="最终审批金额" field="finalSum" ></t:dgCol>
   <t:dgCol title="是否要综合办购买" field="buy" dictionary="yesorno"></t:dgCol>
   <t:dgCol title="审批状态" field="remark" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="打印时间" field="print" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="expensesPlanController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="expensesPlanController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="expensesPlanController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="expensesPlanController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>