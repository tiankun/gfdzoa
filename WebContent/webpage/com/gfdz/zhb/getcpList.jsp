<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="cpList" title="产品表" actionUrl="cpController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="产品名称" field="cpmc" width="100" query="true"></t:dgCol>
   <t:dgCol title="类型" field="lxbh.lxmc" width="100" query="true"></t:dgCol>
   <t:dgCol title="品牌" field="brand" dictionary="goodsBrand" width="100"></t:dgCol>
   <t:dgCol title="规格" field="standard" width="100"></t:dgCol>
   <t:dgCol title="单位" field="unit.gsmc" width="100"></t:dgCol>
   <t:dgCol title="备注" field="bz" width="100"></t:dgCol>
   <%-- <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="cpController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="cpController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="cpController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="cpController.do?addorupdate" funname="detail"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>