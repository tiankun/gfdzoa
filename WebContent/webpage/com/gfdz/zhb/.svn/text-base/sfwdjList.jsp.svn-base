<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="sfwdjList" title="收发文登记表" actionUrl="sfwdjController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="类型编号" field="lxbh" ></t:dgCol>
   <t:dgCol title="文件名称" field="wjmc" ></t:dgCol>
   <t:dgCol title="文件编号" field="wjbh" ></t:dgCol>
   <t:dgCol title="收发文类型(1：收文；2：发文)" sortable="true" field="sfwlx" dictionary="sfwlx" query="true"></t:dgCol>
   <t:dgCol title="文件份数" field="wjfs" ></t:dgCol>
   <t:dgCol title="收/发件人" field="fjr" ></t:dgCol>
   <t:dgCol title="签收人" field="qsr" ></t:dgCol>
   <t:dgCol title="签收日期" field="qsrq" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="备注" field="bz" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="sfwdjController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="sfwdjController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="sfwdjController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="sfwdjController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>