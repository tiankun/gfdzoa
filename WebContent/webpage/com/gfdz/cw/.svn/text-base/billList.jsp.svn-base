<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="billList" title="发票开具记录" actionUrl="billController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="用户主键" field="userId.realName" ></t:dgCol>
   <t:dgCol title="发票类型" field="ftype" dictionary="ftype"></t:dgCol>
   <t:dgCol title="开具发票类型" dictionary="stype" field="stype" ></t:dgCol>
   <t:dgCol title="客户单位名称" field="unit" ></t:dgCol>
   <t:dgCol title="开具金额" field="money" ></t:dgCol>
   <t:dgCol title="计划收款时间" field="planDate" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="申请时间" field="inputDate" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <t:dgCol title="开具发票内容" field="content" ></t:dgCol>
   <t:dgCol title="附件路径（针对增值税）" field="path" ></t:dgCol>
   <t:dgCol title="付款单位" field="payUnit" ></t:dgCol>
   <t:dgCol title="发票号" field="num" ></t:dgCol>
   <t:dgCol title="地税国税号" field="disgsh" ></t:dgCol>
   <t:dgCol title="纳税人识别号(针对增值税)" field="shibh" ></t:dgCol>
   <t:dgCol title="地址(针对增值税)" field="addr" ></t:dgCol>
   <t:dgCol title="电话(针对增值税)" field="phone" ></t:dgCol>
   <t:dgCol title="开户行(针对增值税)" field="kaihh" ></t:dgCol>
   <t:dgCol title="账号(针对增值税)" field="account" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="状态" field="state" ></t:dgCol>
   <t:dgCol title="作废原因" field="reason" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="billController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="billController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="billController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="billController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>