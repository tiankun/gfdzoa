<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>工程验收登记</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="projectAcceptList" title="工程验收登记" actionUrl="projectAcceptController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目id" field="projectId" ></t:dgCol>
   <t:dgCol title="建设单位" field="development" ></t:dgCol>
   <t:dgCol title="设计单位" field="designUnit" ></t:dgCol>
   <t:dgCol title="监理单位" field="supervisionUnit" ></t:dgCol>
   <t:dgCol title="施工单位" field="constructionUnit" ></t:dgCol>
   <t:dgCol title="质量监督机构" field="superviseUnit" ></t:dgCol>
   <t:dgCol title="开工日期" field="begindate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="竣工日期" field="enddate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="质保期" field="guarantee" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="验收内容" field="acceptDetail" ></t:dgCol>
   <t:dgCol title="验收日期" field="acceptDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="projectAcceptController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="projectAcceptController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="projectAcceptController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="projectAcceptController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 </body>
 </html>