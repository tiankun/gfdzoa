<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="costApprovalList" title="工程费用核定" actionUrl="costApprovalController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目编号" field="project.projectName" ></t:dgCol>
   <t:dgCol title="审定施工费" field="sdsgf" ></t:dgCol>
   <t:dgCol title="增减变更金额" field="bgje" ></t:dgCol>
   <t:dgCol title="管网进度" field="gwjd" ></t:dgCol>
   <t:dgCol title="线缆进度" field="xljd" ></t:dgCol>
   <t:dgCol title="设备进度" field="sbjd" ></t:dgCol>
   <t:dgCol title="总体进度" field="ztjd" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="costApprovalController.do?del&id={id}" />
   <t:dgToolBar title="录入" width="800" height="450" icon="icon-add" url="costApprovalController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" width="800" height="450" icon="icon-edit" url="costApprovalController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" width="800" height="450" icon="icon-search" url="costApprovalController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>