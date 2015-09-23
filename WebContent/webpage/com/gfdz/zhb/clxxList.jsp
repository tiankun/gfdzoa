<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="clxxList" title="车辆信息" actionUrl="clxxController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="车辆名称" field="clmc" query="true"></t:dgCol>
   <t:dgCol title="车牌号码" field="cphm" query="true"></t:dgCol>
   <t:dgCol title="品牌" field="pp" query="true"></t:dgCol>
   <t:dgCol title="车型" field="cx" query="true"></t:dgCol>
   <t:dgCol title="发动机号" field="fdjh" ></t:dgCol>
   <t:dgCol title="购买时间" field="gmsj" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="购买价格（元）" field="gmjg" ></t:dgCol>
   <t:dgCol title="年检时间" field="njsj" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="保险购买时间" field="bxgmsj" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="备注" field="bz" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="clxxController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="clxxController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="clxxController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="clxxController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>