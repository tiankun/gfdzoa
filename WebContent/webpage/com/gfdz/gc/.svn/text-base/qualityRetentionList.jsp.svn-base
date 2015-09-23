<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>质量保证金发放</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="qualityRetentionList" title="质量保证金发放" actionUrl="qualityRetentionController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目名称" field="projectId" ></t:dgCol>
   <t:dgCol title="质保金" field="retentionMoney" ></t:dgCol>
   <t:dgCol title="申请金额" field="applyMoney" ></t:dgCol>
   <t:dgCol title="批准金额" field="approvalMoney" ></t:dgCol>
   <t:dgCol title="核对金额" field="checkMoney" ></t:dgCol>
   <t:dgCol title="操作组" field="actionGroup" ></t:dgCol>
   <t:dgCol title="申请人" field="applyPerson" ></t:dgCol>
   <t:dgCol title="申请日期" field="applyDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="qualityRetentionController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="qualityRetentionController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="qualityRetentionController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="qualityRetentionController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 </body>
 </html>