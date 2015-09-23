<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="noticeList" title="通知公告"  fitColumns="true"
  actionUrl="noticeController.do?datagrid" idField="id" fit="true" onClick="getDetail">
   <t:dgCol title="编号" field="id" hidden="true" width="10"></t:dgCol>
   <t:dgCol title="标题" field="noticeTitle" width="50"></t:dgCol>
   <t:dgCol title="类型" field="noticeType"  dictionary="noteType" width="10"></t:dgCol>
   <t:dgCol title="备注" field="noticeRemarks" width="50"></t:dgCol>
<%--    <t:dgToolBar title="查看" width="1200" height="600" icon="icon-search" url="noticeController.do?addorupdate" funname="detail"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
  <script type="text/javascript">
  function getDetail(index,rowData){
	  var url="noticeController.do?addorupdate&load=detail&id="+rowData.id;
	  $.dialog({
          content : 'url:'+url,
          lock : true,
          title :'详细信息',
          opacity : 0.3,
          width : 1200,
          height : 600,
          cache : false,
          cancelVal : '关闭',
          cancel : true
      });
  }
  </script>
 </div>