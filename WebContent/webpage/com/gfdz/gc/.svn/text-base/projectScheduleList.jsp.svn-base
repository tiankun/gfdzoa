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
	 $('#projectScheduleList').datagrid('reload');
	}
</script>
</head>
<body>
<div id="main_projectSchedule_list" class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="projectScheduleList" title="工程信息表" onClick="queryProjectScheduleDetail"
  	actionUrl="projectScheduleController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目名称" field="project.projectName" width="100"></t:dgCol>
   <t:dgCol title="开始日期" field="startDate" formatter="yyyy-MM-dd" width="100"></t:dgCol>
   <t:dgCol title="截止日期" field="endDate" formatter="yyyy-MM-dd" width="100"></t:dgCol>
   <t:dgCol title="月形象进度" field="imageProgress" width="100"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="projectScheduleController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" width="100%" url="projectScheduleController.do?addorupdate" funname="toAdd"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" width="100%" url="projectScheduleController.do?addorupdate" funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" width="100%" url="projectScheduleController.do?addorupdate" funname="detail"></t:dgToolBar>
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
<div class="easyui-panel" style="padding: 0px;height: 250px;" fit="true" border="false" id="projectSchedulePanel">
</div>
</div>
<script type="text/javascript">
$(function() {
	var li_south = 0;
});


function queryProjectScheduleDetail(rowIndex,rowData){
	if(li_south == 0){
	   $('#main_projectSchedule_list').layout('expand','south'); 
	}
 	$('#projectSchedulePanel').panel("refresh", "projectScheduleController.do?projectScheduleDetailList&pId="+rowData.id);
}

$(document).ready(function(){
	//给时间控件加上样式
	$("#projectMaterialListtb").find("input[name='orderDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("#projectMaterialListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
});
</script>
</body>
</html>