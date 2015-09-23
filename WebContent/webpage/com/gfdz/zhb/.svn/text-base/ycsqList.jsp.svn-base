<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="ycsqList" checkbox="true" fitColumns="false" title="用车申请" actionUrl="ycsqController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型编号"  field="lxbh"    queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="申请人"  field="sqr"    queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="申请时间"  field="sqsj"    queryMode="single" query="true" width="120" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="计划开始时间"  field="jhkssj"    queryMode="single" query="true"  width="120" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="计划结束时间"  field="jhjssj"    queryMode="single" query="true"  width="120" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="用车原因"  field="ycyy"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请状态"  field="sqzt"    queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="ycsqController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="ycsqController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ycsqController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ycsqController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ycsqController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/gfdz/zhb/ycsqList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#ycsqListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#ycsqListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ycsqController.do?upload', "ycsqList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ycsqController.do?exportXls","ycsqList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ycsqController.do?exportXlsByT","ycsqList");
}
 </script>