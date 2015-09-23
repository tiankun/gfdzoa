<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>客户订单管理</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript" src="plug-in/tools/dataformat.js"></script>
</head>
<body>
<div id="main_ordercg_list" class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;height: 300px">
	<t:datagrid name="orderList" checkbox="false" fitColumns="false" title="订单表" 
	actionUrl="orderController.do?datagrid&orderType=0" idField="id" fit="true" queryMode="group"
	onClick="queryOrderDetailByRowData"
	>
	   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="订单编号"  field="orderNumber" query="true"    queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="采购时间"  field="orderDate" query="true"  queryMode="single" formatter="yyyy-MM-dd" width="120"></t:dgCol>
	  	<t:dgCol title="采购金额"  field="orderMoney"   queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="发票说明"  field="orderNote"   queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="创建人"  field="createName"   queryMode="single"  width="120"></t:dgCol>
<%-- 	   <t:dgCol title="用户名称"  field="createBy"  queryMode="single"  width="120"></t:dgCol> --%>
	   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" queryMode="single"  width="120"></t:dgCol>
	<%--    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol> --%>
	<%--    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol> --%>
	   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	   <t:dgDelOpt title="删除" url="orderController.do?doDel&id={id}" />
	   <t:dgToolBar title="录入" width="900" height="500" icon="icon-add" url="orderController.do?goAdd" funname="cgadd"></t:dgToolBar>
	   <t:dgToolBar title="追加采购单" width="900" height="500" icon="icon-edit" url="orderController.do?goUpdate" funname="goUpdate"></t:dgToolBar>
<%-- 	   <t:dgToolBar title="批量删除"  icon="icon-remove" url="orderController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%-- 	   <t:dgToolBar title="查看" icon="icon-search" url="orderController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
	<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
	<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
	<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
</div>
</div>
	<div data-options="region:'south', title:'客户订单明细',
	collapsed:true,split:true, border:false,
	onExpand : function(){
		li_south = 1;
	},
	onCollapse : function() {
	    li_south = 0;
	}"
	style="width: 100%; overflow: hidden;">
<div class="easyui-panel" style="padding: 0px;height: 200px;" fit="true" border="false" id="ordercgListpanel">
</div>
</div>
<script src = "webpage/com/buss/order/orderList.js"></script>		
<script type="text/javascript">
$(function() {
	var li_south = 0;
});

function cgadd(title,url,name,w,h){
	 $.dialog({
			content : 'url:orderController.do?cgAdd',
			zIndex : 1000,
			title : "采购订单",
			lock : true,
			parent : windowapi,
			width : 1000,
			height : 550,
			left : '50%',
			top : '50%',
			opacity : 0.4,
			button : [ {
				name : '保存',
				callback : function(){
				  	var iframe = this.iframe.contentWindow;
				  	iframe.saveData();
				  	return false;
				},
				focus : true
			}, {
				name : '关闭',
				callback : function() {
					
				}
			} ]
		});

}

function goUpdate(title,url,name,w,h){
	var rowsData = $('#'+name).datagrid('getSelections');
	if (!rowsData || rowsData.length==0) {
		tip('请选择要追加的订单');
		return;
	}
	if (rowsData.length>1) {
		tip('请选择一条记录再编辑');
		return;
	}
	var id = rowsData[0].id;
	
	 $.dialog({
			content : 'url:orderController.do?goUpdate&flags=cg&id='+id,
			zIndex : 1000,
			title : "采购订单",
			lock : true,
			parent : windowapi,
			width : 1000,
			height : 550,
			left : '50%',
			top : '50%',
			opacity : 0.4,
			button : [ {
				name : '保存',
				callback : function(){
				  	var iframe = this.iframe.contentWindow;
				  	iframe.saveData();
				  	return false;
				},
				focus : true
			}, {
				name : '关闭',
				callback : function() {
					
				}
			} ]
		});

}

function queryOrderDetailByRowData(rowIndex,rowData){
	if(li_south == 0){
	   $('#main_ordercg_list').layout('expand','south'); 
	}
 	$('#ordercgListpanel').panel("refresh", "orderController.do?orderDetailList&orderId="+rowData.id);
}

$(document).ready(function(){
	//给时间控件加上样式
	$("#orderListtb").find("input[name='orderDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("#orderListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
});

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'orderController.do?upload', "orderList");
}

//导出
function ExportXls() {
	JeecgExcelExport("orderController.do?exportXls","orderList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("orderController.do?exportXlsByT","orderList");
}
</script>
</body>
</html>
