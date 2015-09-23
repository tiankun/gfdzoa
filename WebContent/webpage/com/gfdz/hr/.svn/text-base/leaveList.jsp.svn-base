<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="leaveList" title="请假管理" actionUrl="leaveController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="请假人" field="leaveUser.realName" ></t:dgCol>
   <t:dgCol title="请假类型" field="leaveType.typeName" ></t:dgCol>
   <t:dgCol title="请假天数" field="leaveDays" ></t:dgCol>
   <t:dgCol title="开始时间" field="beginDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="开始区间" field="beginScope" replace="上午_0,下午_1"></t:dgCol>
   <t:dgCol title="结束时间" field="endDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="结束区间" field="endScope" replace="上午_0,下午_1"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="leaveController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="leaveController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="leaveController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="leaveController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>