<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="xsmxDetail" title="销售日志明细" actionUrl="xsxmController.do?xsmxDetailData&pId=${param.pId }" 
  idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true" ></t:dgCol>
   <t:dgCol title="日期" field="logDate" formatter="yyyy-MM-dd" width="50"></t:dgCol>
   <t:dgCol title="日志" field="description" width="200"></t:dgCol>
   <t:dgCol title="备注说明" field="remark" width="100"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
 </body>
 </html>