<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="noticeList" title="通知公告"  fitColumns="true"
  actionUrl="noticeController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true" width="10"></t:dgCol>
   <t:dgCol title="标题" field="noticeTitle"  width="50"></t:dgCol>
   <t:dgCol title="类型" field="noticeType"  dictionary="noteType" width="10"></t:dgCol>
<%--    <t:dgCol title="附件" field="noticeFiles" ></t:dgCol> --%>
<%--    <t:dgCol title="附件数量" field="noticeFilesNum" ></t:dgCol> --%>
   <t:dgCol title="备注" field="noticeRemarks" width="50"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="10"></t:dgCol>
   <t:dgDelOpt title="删除" url="noticeController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="noticeController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" width="1200" height="600" icon="icon-edit"  url="noticeController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" width="1200" height="600" icon="icon-search" url="noticeController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>