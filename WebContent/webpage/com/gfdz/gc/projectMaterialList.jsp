<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<div id="main_projectMaterial_list" class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;height: 300px">
  <t:datagrid name="projectMaterialList" title="项目设计表" actionUrl="projectInfoController.do?datagrid" 
  idField="id" fit="true" queryMode="true" onClick="queryMaterialDetail">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目名称" field="projectName" query="true"></t:dgCol>
   <t:dgCol title="客户名称" field="customer" ></t:dgCol>
   <t:dgCol title="联系人" field="contacts" ></t:dgCol>
   <t:dgCol title="联系电话" field="contactPhone" ></t:dgCol>
   <t:dgCol title="合同编号" field="agreementNumber" query="true"></t:dgCol>
   <t:dgCol title="合同金额" field="moneyAmount" ></t:dgCol>
   <t:dgCol title="项目经理" field="projectManager.realName" query="true"></t:dgCol>
   <t:dgCol title="销售经理" field="salesManager.realName" query="true"></t:dgCol>
   <t:dgCol title="项目状态" field="projectStatus" query="true" dictionary="projectstate"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="xsxmController.do?del&id={id}" />
   <t:dgToolBar title="编辑项目" icon="icon-edit" url="projectInfoController.do?addorupdate" funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="项目设计添加" icon="icon-add" width="100%" height="100%" url="projectInfoController.do?projectMaterial" funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="projectInfoController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <div data-options="region:'south',
	collapsed:true,split:true, border:false,
	onExpand : function(){
		li_south = 1;
	},
	onCollapse : function() {
	    li_south = 0;
	}"
	style="width: 100%; overflow: hidden;">
<div class="easyui-panel" style="padding: 0px;height: 250px;" fit="true" border="false" id="materialPanel">
</div>
</div>
<script type="text/javascript">
$(function() {
	var li_south = 0;
});


function queryMaterialDetail(rowIndex,rowData){
	if(li_south == 0){
	   $('#main_projectMaterial_list').layout('expand','south'); 
	}
 	$('#materialPanel').panel("refresh", "projectInfoController.do?materialList&pId="+rowData.id);
}

$(document).ready(function(){
	//给时间控件加上样式
	$("#projectMaterialListtb").find("input[name='orderDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("#projectMaterialListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
});

//导出
function ExportXls() {
	JeecgExcelExport("orderController.do?exportXls","orderList");
}
</script>
 </body>
 </html>