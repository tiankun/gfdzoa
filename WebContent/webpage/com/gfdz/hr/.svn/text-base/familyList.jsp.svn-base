<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="familyList" title="人员家庭成员" actionUrl="familyController.do?datagrid&personId=${param.personId}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="人员id" field="personId" hidden="true"></t:dgCol>
   <t:dgCol title="姓名" field="name" width="100"></t:dgCol>
   <t:dgCol title="称谓" field="appellation"  width="100"></t:dgCol>
   <t:dgCol title="工作单位" field="workUnit"  width="200"></t:dgCol>
   <t:dgCol title="部门" field="depar"  width="100"></t:dgCol>
   <t:dgCol title="职务" field="position"  width="100"></t:dgCol>
   <t:dgCol title="联系方式" field="phone"  width="100"></t:dgCol>
   <t:dgCol title="住址" field="addr"  width="200"></t:dgCol>
   <t:dgCol title="备注" field="remark" width="200" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="familyController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="familyController.do?addorupdate&personId=${param.personId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="familyController.do?addorupdate&personId=${param.personId}" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="familyController.do?addorupdate&personId=${param.personId}" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>