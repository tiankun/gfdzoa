<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="educationList" title="个人学历信息" actionUrl="educationController.do?datagrid&personId=${param.personId}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="人员id" field="personId" hidden="true"></t:dgCol>
   <t:dgCol title="开始时间" field="beginDate" formatter="yyyy-MM" width="10"></t:dgCol>
   <t:dgCol title="结束时间" field="endDate" formatter="yyyy-MM"  width="10"></t:dgCol>
   <t:dgCol title="学校" field="shcool"  width="20"></t:dgCol>
   <t:dgCol title="专业" field="major"  width="20"></t:dgCol>
   <t:dgCol title="学历" field="education"  width="10"></t:dgCol>
   <t:dgCol title="学历类型" field="eduType"  width="10"></t:dgCol>
   <t:dgCol title="毕业/结业" field="isgradua"  width="10"></t:dgCol>
   <t:dgCol title="学位" field="degree"  width="10"></t:dgCol>
   <t:dgCol title="证书编号" field="certificateNo"  width="10"></t:dgCol>
   <t:dgCol title="备注" field="remark"  width="20"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="10"></t:dgCol>
   <t:dgDelOpt title="删除" url="educationController.do?del&id={id}" />
   <t:dgToolBar title="录入" width="1200" height="600" icon="icon-add" url="educationController.do?addorupdate&personId=${param.personId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" width="1200" height="600" icon="icon-edit" url="educationController.do?addorupdate&personId=${param.personId}" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" width="1200" height="600" icon="icon-search" url="educationController.do?addorupdate&personId=${param.personId}" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>