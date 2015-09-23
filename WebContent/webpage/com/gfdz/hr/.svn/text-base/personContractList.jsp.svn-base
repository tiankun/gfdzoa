<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="personContractList" title="个人合同信息" actionUrl="personContractController.do?datagrid&personId=${param.personId}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="人员id" field="personId" hidden="true"></t:dgCol>
   <t:dgCol title="合同编号" field="contractNo" ></t:dgCol>
   <t:dgCol title="合同类型" field="contractType" ></t:dgCol>
   <t:dgCol title="签订方式" field="signedType" ></t:dgCol>
   <t:dgCol title="签订日期" field="signedDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="开始时间" field="beginDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="结束时间" field="endDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="试用期开始时间" field="syBedinDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="试用期结束时间" field="syEndDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="合同解除/终止时间" field="overContractDate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="补偿金额" field="compensation" ></t:dgCol>
   <t:dgCol title="违约金额" field="breach" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="personContractController.do?del&id={id}" />
   <t:dgToolBar title="录入" width="1200" height="600" icon="icon-add" url="personContractController.do?addorupdate&personId=${param.personId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" width="1200" height="600" icon="icon-edit" url="personContractController.do?addorupdate&personId=${param.personId}" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" width="1200" height="600" icon="icon-search" url="personContractController.do?addorupdate&personId=${param.personId}" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>