<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="payfordetailList" checkbox="true" fitColumns="false" title="款项支付子表" actionUrl="payfordetailController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="材料"  field="cp"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="采购执行子表"  field="cgzx"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="材料数量 "  field="num"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="材料单价"  field="price"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="付款金额"  field="money"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="付款申请人"  field="userId"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="付款时间"  field="odate"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="供应商"  field="gysml"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="款项支付主表"  field="payfor"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请事由"  field="applyreason"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="附件数量"  field="fujnum"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目"  field="project"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="payfordetailController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="payfordetailController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="payfordetailController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="payfordetailController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="payfordetailController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/gfdz/cw/payfordetailList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'payfordetailController.do?upload', "payfordetailList");
}

//导出
function ExportXls() {
	JeecgExcelExport("payfordetailController.do?exportXls","payfordetailList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("payfordetailController.do?exportXlsByT","payfordetailList");
}
 </script>