<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="zhbCgqdList" checkbox="true" fitColumns="false" title="配给采购申请单" actionUrl="zhbCgqdController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="project.projectName"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户主键"  field="userId"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请时间"  field="inputTime"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="到货联系人"  field="linkman"    queryMode="single" query="true"  width="120"></t:dgCol>
   <t:dgCol title="到货联系人电话"  field="contactNumber"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="applyRemark"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态标记"  field="flag"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zhbCgqdController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" width="900" icon="icon-add" url="zhbCgqdController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" width="900" icon="icon-edit" url="zhbCgqdController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zhbCgqdController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" width="900" icon="icon-search" url="zhbCgqdController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/gfdz/zhb/zhbCgqdList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#zhbCgqdListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zhbCgqdListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zhbCgqdController.do?upload', "zhbCgqdList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zhbCgqdController.do?exportXls","zhbCgqdList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zhbCgqdController.do?exportXlsByT","zhbCgqdList");
}
 </script>