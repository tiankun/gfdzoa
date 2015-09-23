<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>销售交底附件表</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div data-options="region:'south',split:true,title:'材料明细'"
			style="height:200px;">
			<table id="material" class="easyui-datagrid"
				data-options="border:false,rownumbers:true,fit:true,fitColumns:true,singleSelect:true">
				<thead>
					<tr>
					    <th data-options="field:'id',hidden:true">设备名称</th>
					     <th data-options="field:'cp.id',hidden:true">设备名称</th>
						<th data-options="field:'cp.cpmc'">设备名称</th>
						<th data-options="field:'cp.brand'">品牌</th>
						<th data-options="field:'cp.standard',align:'right'">规格型号</th>
						<th data-options="field:'parameter',align:'right'">技术参数</th>
						<th data-options="field:'unit'">单位</th>
						<th data-options="field:'designAmount',align:'center'">设计数量</th>
						<th data-options="field:'designPrice',align:'center'">设计单价</th>
					</tr>
				</thead>
			</table>
		</div>
		<div data-options="region:'center',border:false">
			<t:datagrid name="projectInfoList" title="工程信息表"
				onClick="getMaterial" actionUrl="projectInfoController.do?datagrid"
				idField="id" fit="true" queryMode="group">
				<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
				<t:dgCol title="项目名称" field="projectName" query="true"></t:dgCol>
				<t:dgCol title="客户名称" field="customer"></t:dgCol>
				<t:dgCol title="联系人" field="contacts"></t:dgCol>
				<t:dgCol title="联系电话" field="contactPhone"></t:dgCol>
				<t:dgCol title="合同编号" field="agreementNumber" query="true"></t:dgCol>
				<t:dgCol title="合同金额" field="moneyAmount"></t:dgCol>
				<t:dgCol title="项目经理" field="projectManager" query="true"></t:dgCol>
				<t:dgCol title="销售经理" field="salesManager" query="true"></t:dgCol>
				<t:dgCol title="项目状态" field="projectStatus" query="true"></t:dgCol>
				<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
			</t:datagrid>
		</div>
	</div>
</body>
<script type="text/javascript">
	function getMaterial(rowIndex, rowData) {
		$("#material").datagrid({
			url : 'purchasePlanController.do?materialGrid&projectId='+ rowData.id
		});
	}

	function retMaterial() {
		var obj = new Object();
		obj.pro = $("#projectInfoList").datagrid('getSelected');
		obj.row = $('#material').datagrid('getData');
		return obj;
	}
</script>
</html>