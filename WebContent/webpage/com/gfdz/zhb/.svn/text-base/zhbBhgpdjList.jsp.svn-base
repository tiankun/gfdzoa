<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="zhbBhgpdjList" checkbox="true" fitColumns="false" title="不合格品登记" actionUrl="zhbBhgpdjController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="产品名称"  field="cpmc"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="规格型号"  field="ggxh"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="供方名称"  field="gfmc"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="不合格原因"  field="bhgyy"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="不合格数量"  field="bhgsl"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="经办人"  field="jbr"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="经办时间"  field="jbsj"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="不合格品处置"  field="bhgpcz"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="批准人"  field="pzr"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="批准时间"  field="pzsj"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zhbBhgpdjController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="zhbBhgpdjController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zhbBhgpdjController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zhbBhgpdjController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zhbBhgpdjController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/gfdz/bhg/zhbBhgpdjList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#zhbBhgpdjListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zhbBhgpdjListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zhbBhgpdjController.do?upload', "zhbBhgpdjList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zhbBhgpdjController.do?exportXls","zhbBhgpdjList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zhbBhgpdjController.do?exportXlsByT","zhbBhgpdjList");
}
 </script>