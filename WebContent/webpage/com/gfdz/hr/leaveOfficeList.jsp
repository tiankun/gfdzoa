<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="leaveOfficeList" title="个人离职表" actionUrl="leaveOfficeController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="人员id" field="personId" ></t:dgCol>
   <t:dgCol title="部门id" field="departId" ></t:dgCol>
   <t:dgCol title="申请时间" field="applyType" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="审核状态" field="state" ></t:dgCol>
   <t:dgCol title="离职原因" field="leaveReason" ></t:dgCol>
   <t:dgCol title="流程id" field="processId" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="leaveOfficeController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="leaveOfficeController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="leaveOfficeController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="leaveOfficeController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>