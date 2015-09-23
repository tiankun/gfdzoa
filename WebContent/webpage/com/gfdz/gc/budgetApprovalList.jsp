<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>预算审批表附件</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="budgetApprovalList" title="预算审批表附件" queryMode="group" actionUrl="budgetApprovalController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="所属项目" field="project.projectName" query="true"></t:dgCol>
   <t:dgCol title="建设单位" field="construction" query="true"></t:dgCol>
   <t:dgCol title="编制说明" field="remark" ></t:dgCol>
   <t:dgCol title="编制人" field="compilin" ></t:dgCol>
   <t:dgCol title="编制日期" field="compilingDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="审核意见" field="review" ></t:dgCol>
   <t:dgCol title="审核人" field="auditPerson" ></t:dgCol>
   <t:dgCol title="审核日期" field="reviewDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="财务意见" field="financialAudit" ></t:dgCol>
   <t:dgCol title="经办人" field="treasuryAttache" ></t:dgCol>
   <t:dgCol title="经办日期" field="financialDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="审批意见" field="approvalOpinion" ></t:dgCol>
   <t:dgCol title="批准人" field="approvalPerson" ></t:dgCol>
   <t:dgCol title="批准日期" field="approvalDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="budgetApprovalController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="budgetApprovalController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="budgetApprovalController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="budgetApprovalController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 </body>
 </html>