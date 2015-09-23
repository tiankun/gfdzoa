<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="zzsqList" title="证章申请信息" actionUrl="zzsqController.do?datagrid" 
  idField="id" fit="true" queryMode="group">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="借用项目" field="jyxm" ></t:dgCol>
   <t:dgCol title="使用时间" field="sysj" formatter="yyyy-MM-dd" query="true"></t:dgCol>
   <t:dgCol title="借用用途" field="jyyt" query="true"></t:dgCol>
   <t:dgCol title="使用份数" field="syfs" ></t:dgCol>
   <t:dgCol title="备注" field="bz" ></t:dgCol>
   <t:dgCol title="申请人" field="sqr" ></t:dgCol>
   <t:dgCol title="申请时间" field="sqsj" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="流程id" field="processinstanceid" ></t:dgCol>
   <t:dgCol title="申请状态" field="sqzt" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zzsqController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="zzsqController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zzsqController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zzsqController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>