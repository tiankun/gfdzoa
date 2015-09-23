<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="orderfxList" fitColumns="false" title="订单表" actionUrl="orderController.do?orderfxData" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="订单编号"  field="orderNumber" query="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="销售价"  field="sales"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="成本价"  field="cost"    queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="人力成本"  field="humanCost"    queryMode="single"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="税收"  field="tax"    queryMode="single"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="交通、通讯费用"  field="otherCost" queryMode="single"  width="120"></t:dgCol> --%>
   <t:dgCol title="总利润"  field="profit"    queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="总公司"  field="zgsProfit" queryMode="single"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="合作伙伴"  field="partnersProfit" queryMode="single"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="运营团队"  field="teamProfit" queryMode="single"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="备注"  field="cnote"  queryMode="single"  width="120"></t:dgCol> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/order/orderList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 	//给时间控件加上样式
	$("#orderListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
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