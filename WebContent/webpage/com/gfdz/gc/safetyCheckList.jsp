<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="safetyCheckList" title="安全检查" actionUrl="safetyCheckController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目名称" field="project.projectName" width="100"></t:dgCol>
   <t:dgCol title="参检人员" field="projectManager" width="100"></t:dgCol>
   <t:dgCol title="检查类别" field="constructionTeam" width="100"></t:dgCol>
   <t:dgCol title="检查内容" field="qualityMan" width="100"></t:dgCol>
   <t:dgCol title="存在隐患" field="inspectionPlace" width="100"></t:dgCol>
   <t:dgCol title="整改措施" field="question" width="100"></t:dgCol>
   <t:dgCol title="落实人" field="implementPerson" width="100"></t:dgCol>
   <t:dgCol title="检查结论" field="conclusion" width="100"></t:dgCol>
   <t:dgCol title="检查日期" field="qualityDate" formatter="yyyy-MM-dd" width="100"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="safetyCheckController.do?del&id={id}" />
   <t:dgToolBar title="录入" width="900" height="550" icon="icon-add" url="safetyCheckController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" width="900" height="550" icon="icon-edit" url="safetyCheckController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看"  width="1200" height="600" icon="icon-search" url="safetyCheckController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>