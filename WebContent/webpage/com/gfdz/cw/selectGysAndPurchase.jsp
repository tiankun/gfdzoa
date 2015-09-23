<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>销售交底附件表</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div data-options="region:'south',split:true,title:'采购执行单'"
			style="height:250px;">
			<table id="material" class="easyui-datagrid"
				data-options="border:false,rownumbers:true,fit:true,fitColumns:true">
				<thead>
					<tr>
					    <th data-options="field:'id',hidden:true">设备名称</th>
						<th data-options="field:'billCode'">单号</th>
						<th data-options="field:'project.projectName'">所属项目</th>
						<th data-options="field:'gys.gsmc'">供应商</th>
						<th data-options="field:'advance',align:'right'">预付款</th>
						<th data-options="field:'yfMoney',align:'right'">应付金额</th>
						<th data-options="field:'payMoney',align:'right'">实付金额</th>
						<th data-options="field:'qkMoney',align:'right'">欠款金额</th>
					</tr>
				</thead>
			</table>
		</div>
		<div data-options="region:'center',border:false">
		  <t:datagrid name="gysmlList" fitColumns="true" onClick="getPurchase" title="供应商名录" actionUrl="gysmlController.do?datagrid" idField="id" fit="true">
		    <div class="datagrid-toolbar" id=gysmlListtb style="height:24px;padding:5px" >
		     <div style="padding-left:10px;">
		               供应商编号：<input type="text" name="gysbh"/>
		               公司名称：<input type="text" name="gsmc"/>
		               负责人：<input type="text" name="fzr"/>
		      <a class="easyui-linkbutton l-btn" style="float: right;" onclick="searchReset('gysmlList')" href="#" iconcls="icon-reload">重置</a>
			  <a class="easyui-linkbutton l-btn" style="float: right;margin-right:5px;" onclick="gysmlListsearch()" href="#" iconcls="icon-search">查询</a>
			</div>
			</div>
		   <t:dgCol title="主键" field="id"  hidden="true"  width="120"></t:dgCol>
		   <t:dgCol title="类型编号" field="lxbh" width="120"></t:dgCol>
		   <t:dgCol title="供应商编号" field="gysbh" width="120"></t:dgCol>
		   <t:dgCol title="公司名称" field="gsmc" width="120"></t:dgCol>
		   <t:dgCol title="公司电话" field="gsdh" width="120"></t:dgCol>
		   <t:dgCol title="公司传真" field="gscz" width="120"></t:dgCol>
		   <t:dgCol title="公司地址" field="gsdz" width="120"></t:dgCol>
		   <t:dgCol title="负责人" field="fzr" width="120"></t:dgCol>
		   <t:dgCol title="负责人电话" field="fzrdh" width="120"></t:dgCol>
		   <t:dgCol title="联系人" field="lxr" width="120"></t:dgCol>
		   <t:dgCol title="联系人电话" field="lxrdh" width="120"></t:dgCol>
		   <t:dgCol title="备注" field="bz" width="120"></t:dgCol>
		  </t:datagrid>
		</div>
	</div>
</body>
<script type="text/javascript">
	function getPurchase(rowIndex, rowData) {
		$("#material").datagrid({
			url : 'payforController.do?purchaseGrid&gys.id='+ rowData.id
		});
	}

	function retMaterial() {
		var obj = new Object();
		obj.pro = $("#gysmlList").datagrid('getSelected');
		obj.row = $('#material').datagrid('getSelections');
		return obj;
	}
</script>
</html>