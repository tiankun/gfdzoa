<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="workFlowSetList" title="流程设置" actionUrl="workFlowSetController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="部署id" field="deploymentId" ></t:dgCol>
   <t:dgCol title="流程key" field="processKey" ></t:dgCol>
   <t:dgCol title="流程定义id" field="processDefinitionId" ></t:dgCol>
   <t:dgCol title="开始请求" field="beginUrl" ></t:dgCol>
   <t:dgCol title="处理请求" field="handleUrl" ></t:dgCol>
   <t:dgCol title="查看请求" field="detailUrl" ></t:dgCol>
   <t:dgCol title="流程分类" field="processType" ></t:dgCol>
   <t:dgCol title="流程说明" field="processExplain" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="workFlowSetController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="workFlowSetController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="workFlowSetController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="workFlowSetController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>