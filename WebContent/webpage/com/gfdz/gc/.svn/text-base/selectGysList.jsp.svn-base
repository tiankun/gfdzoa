<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="gysmlList" fitColumns="true" title="供应商名录" actionUrl="gysmlController.do?datagrid" idField="id" fit="true">
    <div class="datagrid-toolbar" id=gysmlListtb style="height:24px;padding:5px" >
     <div style="padding-left:10px;">
               供应商编号：<input type="text" name="gysbh"/>
               公司名称：<input type="text" name="gsmc"/>
               负责人：<input type="text" name="fzr"/>
      <a class="easyui-linkbutton l-btn" style="float: right;" onclick="searchReset('gysmlList')" href="#" iconcls="icon-reload">重置</a>
	  <a class="easyui-linkbutton l-btn" style="float: right;margin-right:5px;" onclick="gysmlListsearch()" href="#" iconcls="icon-search">查询</a>
	</div>
	</div>
   <t:dgCol title="主键" field="id"  hidden="true"  ></t:dgCol>
   <t:dgCol title="类型编号" field="lxbh" ></t:dgCol>
   <t:dgCol title="供应商编号" field="gysbh" ></t:dgCol>
   <t:dgCol title="公司名称" field="gsmc" ></t:dgCol>
   <t:dgCol title="公司电话" field="gsdh" ></t:dgCol>
   <t:dgCol title="公司传真" field="gscz" ></t:dgCol>
   <t:dgCol title="公司地址" field="gsdz" ></t:dgCol>
   <t:dgCol title="负责人" field="fzr" ></t:dgCol>
   <t:dgCol title="负责人电话" field="fzrdh" ></t:dgCol>
   <t:dgCol title="联系人" field="lxr" ></t:dgCol>
   <t:dgCol title="联系人电话" field="lxrdh" ></t:dgCol>
   <t:dgCol title="备注" field="bz" ></t:dgCol>
  </t:datagrid>
  </div>
 </div>
</body>
 <script type="text/javascript">
 function getGys(){
	 return $("#gysmlList").datagrid('getSelected');
 }
 </script>
 </html>