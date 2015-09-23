<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="htdjList" checkbox="true" fitColumns="false" title="合同信息登记" actionUrl="htdjController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="类别编号"  field="lxbh" query="true"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同编号"  field="htbh"  query="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同名称"  field="htmc"  query="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同内容"  field="htnr"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同单位"  field="htdw"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同日期"  field="htrq"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同金额"  field="htje"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="存档份数"  field="cdfs"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="经办人"  field="jbr"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="存放位置"  field="cfwz"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="createName" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="编辑时间"  field="updateDate" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="编辑人"  field="updateName" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="htdjController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="htdjController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="htdjController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="htdjController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="htdjController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/gfdz/zhb/htdjList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'htdjController.do?upload', "htdjList");
}

//导出
function ExportXls() {
	JeecgExcelExport("htdjController.do?exportXls","htdjList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("htdjController.do?exportXlsByT","htdjList");
}
 </script>