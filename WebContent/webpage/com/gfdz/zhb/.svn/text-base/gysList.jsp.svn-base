<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="gysmlList" checkbox="true" fitColumns="false" title="供应商名录" actionUrl="gysmlController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型编号"  field="lxbh"    queryMode="single" width="120"></t:dgCol>
   <t:dgCol title="供应商编号"  field="gysbh"    queryMode="single" query="true"  width="120"></t:dgCol>
   <t:dgCol title="公司名称"  field="gsmc"    queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="公司电话"  field="gsdh"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公司传真"  field="gscz"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公司地址"  field="gsdz"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="负责人"  field="fzr"    queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="负责人电话"  field="fzrdh"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系人"  field="lxr"    queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="联系人电话"  field="lxrdh"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"    queryMode="single"  width="120"></t:dgCol>
  <%--  <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="gysmlController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="gysmlController.do?addorupdate" funname="add" width="800" height="580"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="gysmlController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="gysmlController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="gysmlController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "/webpage/com/gfdz/gys/gysmlList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#gysmlListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#gysmlListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'gysmlController.do?upload', "gysmlList");
}

//导出
function ExportXls() {
	JeecgExcelExport("gysmlController.do?exportXls","gysmlList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("gysmlController.do?exportXlsByT","gysmlList");
}
 </script>