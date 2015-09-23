<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="purchaseList" title="项目材料采购申请" actionUrl="purchaseController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目主键" field="projectId" ></t:dgCol>
   <t:dgCol title="用户主键" field="userId" ></t:dgCol>
   <t:dgCol title="申请时间" field="inputTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="要求到货时间" field="requireTime" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="到货联系人" field="linkman" ></t:dgCol>
   <t:dgCol title="到货联系人电话" field="contactNumber" ></t:dgCol>
   <t:dgCol title="流程id" field="processinstanceid" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="purchaseController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="purchaseController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="purchaseController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="purchaseController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>