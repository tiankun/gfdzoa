<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="purchasePlanDetailList" title="项目材料采购计划 " actionUrl="purchasePlanDetailController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="采购计划主键" field="projectPlanId" ></t:dgCol>
   <t:dgCol title="材料主键" field="projectMaterialId" ></t:dgCol>
   <t:dgCol title="计划数量" field="planNumber" ></t:dgCol>
   <t:dgCol title="计划单价" field="planPrice" ></t:dgCol>
   <t:dgCol title="申请说明" field="palanExplain" ></t:dgCol>
   <t:dgCol title="审核数量" field="examineNumber" ></t:dgCol>
   <t:dgCol title="审核单价" field="examinePrice" ></t:dgCol>
   <t:dgCol title="审批说明" field="examineExplain" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="purchasePlanDetailController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="purchasePlanDetailController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="purchasePlanDetailController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="purchasePlanDetailController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>