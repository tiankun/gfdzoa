<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>技术移交记录</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
 <body style="overflow-y: hidden" scroll="no">
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="jsTransferList" title="技术移交记录表" actionUrl="jsTransferController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目编号" field="projectId" ></t:dgCol>
   <t:dgCol title="交底时间" field="transferTiem" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="交底人" field="lecturer" ></t:dgCol>
   <t:dgCol title="备注说明" field="remarks" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="jsTransferController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="jsTransferController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="jsTransferController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看"  width="1200"  height="600" icon="icon-search" url="jsTransferController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 </body>
 </html>