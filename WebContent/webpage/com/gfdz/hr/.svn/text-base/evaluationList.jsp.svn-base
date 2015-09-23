<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>转正考评</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body style="overflow-y: hidden;overflow-x:auto ">
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="evaluationList" title="转正考评" actionUrl="evaluationController.do?datagrid&personId=${param.personId}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="被考评人" field="pId"  hidden="true"></t:dgCol>
   <t:dgCol title="考评人" field="epId" ></t:dgCol>
   <t:dgCol title="部门" field="deptId" ></t:dgCol>
   <t:dgCol title="考评时间" field="evTime" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="工作质量得分" field="pQuality" ></t:dgCol>
   <t:dgCol title="工作数量得分" field="pQuantity" ></t:dgCol>
   <t:dgCol title="纪律性得分" field="pDiscipline" ></t:dgCol>
   <t:dgCol title="集体观念得分" field="pCollective" ></t:dgCol>
   <t:dgCol title="积极性得分" field="pPositivity" ></t:dgCol>
   <t:dgCol title="责任感得分" field="pResponsibility" ></t:dgCol>
   <t:dgCol title="知识得分" field="pKnowledge" ></t:dgCol>
   <t:dgCol title="判断得分" field="pJudge" ></t:dgCol>
   <t:dgCol title="计划得分" field="pPlan" ></t:dgCol>
   <t:dgCol title="人际得分" field="pRelationships" ></t:dgCol>
   <t:dgCol title="成绩得分" field="pPerformance" ></t:dgCol>
   <t:dgCol title="成绩比例" field="rPerformance" ></t:dgCol>
   <t:dgCol title="成绩评分" field="sPerformance" ></t:dgCol>
   <t:dgCol title="态度得分" field="pAttitude" ></t:dgCol>
   <t:dgCol title="态度比例" field="rAttitude" ></t:dgCol>
   <t:dgCol title="态度评分" field="sAttitude" ></t:dgCol>
   <t:dgCol title="能力得分" field="pCapability" ></t:dgCol>
   <t:dgCol title="能力比例" field="rCapability" ></t:dgCol>
   <t:dgCol title="能力评分" field="sCapability" ></t:dgCol>
   <t:dgCol title="个人评分" field="sPersonal" ></t:dgCol>
   <t:dgCol title="综合评分" field="sTotal" ></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="evaluationController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" width="1200" height="600" url="evaluationController.do?addorupdate&personId=${param.personId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" width="1200" height="600" url="evaluationController.do?addorupdate&personId=${param.personId}" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" width="1200" height="600" url="evaluationController.do?addorupdate&personId=${param.personId}" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 </body>
 </html>