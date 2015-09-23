<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>项目设计管理</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript" src="plug-in/tools/dataformat.js"></script>
<script type="text/javascript">
function refreshGrid(){
	 $('#projectMaterialList').datagrid('reload');
	}
</script>
</head>
<body>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="materialBaseList" title="项目材料审计" actionUrl="materialBaseController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目编号" field="projectId" ></t:dgCol>
   <t:dgCol title="设备名称" field="materialName" ></t:dgCol>
   <t:dgCol title="品牌" field="brand" ></t:dgCol>
   <t:dgCol title="规格型号" field="model" ></t:dgCol>
   <t:dgCol title="技术参数" field="parameter" ></t:dgCol>
   <t:dgCol title="单位" field="unit" ></t:dgCol>
   <t:dgCol title="设计数量" field="designAmount" ></t:dgCol>
   <t:dgCol title="采购数量" field="purchaseAmount" ></t:dgCol>
   <t:dgCol title="实到数量" field="receiveAmount" ></t:dgCol>
   <t:dgCol title="安装数量" field="installAmount" ></t:dgCol>
   <t:dgCol title="移交数量" field="transferAmount" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="materialBaseController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="materialBaseController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="materialBaseController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="materialBaseController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 </body>
 </html>