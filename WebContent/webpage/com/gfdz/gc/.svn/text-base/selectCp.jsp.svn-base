<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>产品选择</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="cpList" title="产品表" actionUrl="cpController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="供应商" field="gysml.gsmc" width="100"></t:dgCol>
   <t:dgCol title="产品名称" field="cpmc" width="100" query="true"></t:dgCol>
   <t:dgCol title="类型" field="lxbh.lxmc" width="100" query="true"></t:dgCol>
   <t:dgCol title="品牌" field="brand" dictionary="goodsBrand" width="100" query="true"></t:dgCol>
   <t:dgCol title="规格" field="standard" width="100"></t:dgCol>
   <t:dgCol title="单位" field="unit" width="100"></t:dgCol>
   <t:dgCol title="备注" field="bz" width="100"></t:dgCol>
   <t:dgToolBar title="查看" icon="icon-search" url="cpController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 </body>
 <script type="text/javascript">
	function retCp() {
		var row = $('#cpList').datagrid('getSelections');
		return row;
	}
</script>
 </html>