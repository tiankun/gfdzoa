<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="getGoodsNum" checkbox="true" fitColumns="true" title="商品名称" 
  actionUrl="orderController.do?getGoodsNum"  idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true" width="120"></t:dgCol>
<%--    <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol> --%>
   <t:dgCol title="商品名称"  field="goodsname" query="true"  width="120"></t:dgCol>
   <t:dgCol title="品牌"  field="goodsband" dictionary="goodsBrand"  query="true"  width="120"></t:dgCol>
   <t:dgCol title="商品型号"  field="goodsmodel" query="true"  width="120"></t:dgCol>
   <t:dgCol title="订单数量"  field="ddnum" width="120"></t:dgCol>
   <t:dgCol title="采购数量"  field="cgnum"  width="120"></t:dgCol>
   <t:dgCol title="库存量"  field="kcnum"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="goodsController.do?doDel&id={id}" /> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="goodsController.do?goAdd" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="goodsController.do?goUpdate" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="goodsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="goodsController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/goods/getGoodsNum.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 	//给时间控件加上样式
	$("#getGoodsNumtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("#getGoodsNumtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'goodsController.do?upload', "getGoodsNum");
}

//导出
function ExportXls() {
	JeecgExcelExport("goodsController.do?exportXls","getGoodsNum");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("goodsController.do?exportXlsByT","getGoodsNum");
}
 </script>