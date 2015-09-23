<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="projectInfoList" title="工程信息表" actionUrl="transferController.do?projectData" 
  idField="id" fit="true" queryMode="group">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="项目名称" field="projectName" query="true"></t:dgCol>
   <t:dgCol title="客户名称" field="customer" ></t:dgCol>
   <t:dgCol title="联系人" field="contacts" ></t:dgCol>
   <t:dgCol title="联系电话" field="contactPhone" ></t:dgCol>
   <t:dgCol title="合同编号" field="agreementNumber" query="true"></t:dgCol>
   <t:dgCol title="合同金额" field="moneyAmount" ></t:dgCol>
   <t:dgCol title="项目经理" field="projectManager.realName" query="true"></t:dgCol>
   <t:dgCol title="销售经理" field="salesManager.realName" query="true"></t:dgCol>
   <t:dgCol title="项目状态" field="projectStatus" query="true"></t:dgCol>
   <t:dgToolBar title="查看" icon="icon-search" url="projectInfoController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
  <script type="text/javascript">
	function getProjectInfo() {
		var obj = new Object();
		obj = $("#projectInfoList").datagrid('getSelected');
		return obj;
	}
</script>
 </div>