<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="certificateList" title="证书管理" actionUrl="certificateController.do?datagrid&personId=${param.personId}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="员工编号" field="pId" hidden="true"></t:dgCol>
   <t:dgCol title="证书名称" field="mingCheng" ></t:dgCol>
   <t:dgCol title="证书级别" field="certLevel" ></t:dgCol>
   <t:dgCol title="证书专业" field="zhuangYe" ></t:dgCol>
   <t:dgCol title="证书分类" field="certType" ></t:dgCol>
   <t:dgCol title="证书类型" field="majorType" ></t:dgCol>
   <t:dgCol title="发证部门" field="faZheng" ></t:dgCol>
   <t:dgCol title="证书编号" field="bianHao" ></t:dgCol>
   <t:dgCol title="认定时间" field="rdTime" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="有效期开始" field="xqSTime" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="有效期结束" field="xqETime" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="证书保管部门" field="baoGuan" ></t:dgCol>
   <t:dgCol title="是否到期提醒" field="tiXing" ></t:dgCol>
   <t:dgCol title="是否年检提醒" field="nianJian" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="certificateController.do?del&id={id}" />
   <t:dgToolBar title="录入" width="1200" height="600" icon="icon-add" url="certificateController.do?addorupdate&personId=${param.personId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" width="1200" height="600" icon="icon-edit" url="certificateController.do?addorupdate&personId=${param.personId}" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" width="1200" height="600" icon="icon-search" url="certificateController.do?addorupdate&personId=${param.personId}" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>