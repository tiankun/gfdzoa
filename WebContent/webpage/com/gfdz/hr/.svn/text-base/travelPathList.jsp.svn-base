<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="travelPathList" title="出差路径" actionUrl="travelPathController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="省" field="province" ></t:dgCol>
   <t:dgCol title="市" field="city" ></t:dgCol>
   <t:dgCol title="县" field="county" ></t:dgCol>
   <t:dgCol title="开始时间" field="beginDate" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="结束时间" field="endDate" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="交通工具" field="vehicle" ></t:dgCol>
   <t:dgCol title="报销标准" field="criterion" ></t:dgCol>
   <t:dgCol title="出差id" field="travelId" ></t:dgCol>
   <t:dgCol title="出差类型" field="travelType" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="travelPathController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="travelPathController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="travelPathController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="travelPathController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>