<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="wagesDeclareList" title="工资申报" actionUrl="wagesDeclareController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目名称" field="project.projectName" ></t:dgCol>
   <t:dgCol title="月份" field="month" ></t:dgCol>
   <t:dgCol title="本次申报金额" field="amount" ></t:dgCol>
   <t:dgCol title="质保金" field="guaranteeMoney" ></t:dgCol>
   <t:dgCol title="安全互助金" field="mutualMoney" ></t:dgCol>
   <t:dgCol title="申报人" field="declare" ></t:dgCol>
   <t:dgCol title="申报日期" field="declareDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="施工队" field="constructionTeam" ></t:dgCol>
   <t:dgCol title="备注" field="remarks" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wagesDeclareController.do?del&id={id}" />
   <t:dgToolBar title="录入" width="100%" height="100%" icon="icon-add" url="wagesDeclareController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" width="100%" height="100%" icon="icon-edit" url="wagesDeclareController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" width="100%" height="100%" icon="icon-search" url="wagesDeclareController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>