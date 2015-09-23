<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="zzxxList" title="证章信息" actionUrl="zzxxController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="类型编号" field="lxbh" ></t:dgCol>
   <t:dgCol title="证章名称" field="zzmc" ></t:dgCol>
   <t:dgCol title="责任部门" field="zrbm" ></t:dgCol>
   <t:dgCol title="责任人" field="zrr" ></t:dgCol>
   <t:dgCol title="存放位置" field="cfwz" ></t:dgCol>
   <t:dgCol title="备注" field="bz" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zzxxController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="zzxxController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zzxxController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zzxxController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>