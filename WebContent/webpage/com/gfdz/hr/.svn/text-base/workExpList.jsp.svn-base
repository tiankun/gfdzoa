<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="workExpList" title="人员工作经历" actionUrl="workExpController.do?datagrid&personId=${param.personId}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="人员id" hidden="true" field="personId" ></t:dgCol>
   <t:dgCol title="开始时间" field="beginDate" formatter="yyyy-MM" width="10"></t:dgCol>
   <t:dgCol title="结束时间" field="endDate" formatter="yyyy-MM" width="10"></t:dgCol>
   <t:dgCol title="单位" field="unit"  width="20"></t:dgCol>
   <t:dgCol title="职务" field="position"  width="10"></t:dgCol>
   <t:dgCol title="证明人" field="certifier"  width="10"></t:dgCol>
   <t:dgCol title="联系方式" field="phone"  width="10"></t:dgCol>
   <t:dgCol title="离职原因" field="leaveReason"  width="20"></t:dgCol>
   <t:dgCol title="备注" field="remark"  width="20"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="10"></t:dgCol>
   <t:dgDelOpt title="删除" url="workExpController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="workExpController.do?addorupdate&personId=${param.personId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="workExpController.do?addorupdate&personId=${param.personId}" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="workExpController.do?addorupdate&personId=${param.personId}" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>