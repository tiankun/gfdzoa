<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="personChangeList" title="人事变动信息" actionUrl="personChangeController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="人员id" field="personId" ></t:dgCol>
   <t:dgCol title="变动前单位" field="beforeUnit" ></t:dgCol>
   <t:dgCol title="变动前部门" field="beforeDepart" ></t:dgCol>
   <t:dgCol title="变动前岗位" field="beforeJob" ></t:dgCol>
   <t:dgCol title="变动前行政级别" field="beforeLevel" ></t:dgCol>
   <t:dgCol title="变动后单位" field="afterUnir" ></t:dgCol>
   <t:dgCol title="变动后部门" field="afterDepart" ></t:dgCol>
   <t:dgCol title="变动后岗位" field="afterJob" ></t:dgCol>
   <t:dgCol title="变动后行政级别" field="afterLevel" ></t:dgCol>
   <t:dgCol title="变动类型" field="changeType" ></t:dgCol>
   <t:dgCol title="变动日期" field="changeDate" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="附件" field="changeFiles" ></t:dgCol>
   <t:dgCol title="说明" field="explain" ></t:dgCol>
   <t:dgCol title="变动前状态" field="beforeState" ></t:dgCol>
   <t:dgCol title="变动后状态" field="afterState" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="personChangeController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="personChangeController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="personChangeController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="personChangeController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>