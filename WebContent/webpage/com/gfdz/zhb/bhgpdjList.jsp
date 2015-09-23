<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="bhgpdjList" title="不合格产品登记" actionUrl="bhgpdjController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="产品名称" field="cpmc" ></t:dgCol>
   <t:dgCol title="规格型号" field="ggxh" ></t:dgCol>
   <t:dgCol title="供方名称" field="gfmc" ></t:dgCol>
   <t:dgCol title="不合格原因" field="bhgyy" ></t:dgCol>
   <t:dgCol title="不合格数量" field="bhgsl" ></t:dgCol>
   <t:dgCol title="经办人" field="jbr" ></t:dgCol>
   <t:dgCol title="经办时间" field="jbsj" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="不合格品处置" field="bhgpcz" ></t:dgCol>
   <t:dgCol title="批准人" field="pzr" ></t:dgCol>
   <t:dgCol title="批准时间" field="pzsj" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="备注" field="bz" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="bhgpdjController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="bhgpdjController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="bhgpdjController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="bhgpdjController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>