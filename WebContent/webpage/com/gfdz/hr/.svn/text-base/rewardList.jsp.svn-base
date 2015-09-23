<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="rewardList" title="人员奖惩信息" actionUrl="rewardController.do?datagrid&personId=${param.personId}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="人员id" field="personId" hidden="true"></t:dgCol>
   <t:dgCol title="类型" field="rewardType" width="100"></t:dgCol>
   <t:dgCol title="名称" field="name" width="100" ></t:dgCol>
   <t:dgCol title="日期" field="rewardDate" formatter="yyyy-MM-dd" width="100"></t:dgCol>
   <t:dgCol title="备注" field="remark" width="200"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="rewardController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="rewardController.do?addorupdate&personId=${param.personId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="rewardController.do?addorupdate&personId=${param.personId}" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="rewardController.do?addorupdate&personId=${param.personId}" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>