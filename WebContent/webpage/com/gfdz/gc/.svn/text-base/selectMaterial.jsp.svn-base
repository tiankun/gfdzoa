<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>销售交底附件表</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<style type="text/css">
.del{
  text-decoration: underline;
  cursor: pointer;
}
.del:hover{
  text-decoration: underline;
  cursor: pointer;
}
</style>
</head>
<body>
 <div class="easyui-layout" fit="true">
     <div data-options="region:'north',split:true,border:false" style="height:250px">
       <t:datagrid name="projectInfoList" title="工程信息表" pageSize="10" onClick="getMaterial" actionUrl="projectInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
	     <div class="datagrid-toolbar" id=projectInfoListtb style="height:24px;padding:5px" >
	      <div style="padding-left:10px;">
	                  项目名称：<input type="text" name="projectName"/>
	                  合同编号：<input type="text" name="agreementNumber"/>
		   <a class="easyui-linkbutton l-btn" style="float: right;margin-right:5px;" onclick="projectInfoListsearch()" href="#" iconcls="icon-search">查询</a>
		  </div>
		 </div>
			<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
			<t:dgCol title="项目名称" field="projectName" ></t:dgCol>
			<t:dgCol title="客户名称" field="customer"></t:dgCol>
			<t:dgCol title="联系人" field="contacts"></t:dgCol>
			<t:dgCol title="联系电话" field="contactPhone"></t:dgCol>
			<t:dgCol title="合同编号" field="agreementNumber" ></t:dgCol>
			<t:dgCol title="合同金额" field="moneyAmount"></t:dgCol>
			<t:dgCol title="项目经理" field="projectManager" ></t:dgCol>
			<t:dgCol title="销售经理" field="salesManager" ></t:dgCol>
			<t:dgCol title="项目状态" field="projectStatus" ></t:dgCol>
		</t:datagrid>
     </div>
     <div data-options="region:'center',title:'材料明细(<font color=red>点击选择材料</font>)'">
        <table id="material" class="easyui-datagrid" data-options="onSelect:onSelect,border:false,rownumbers:true,fit:true,
           fitColumns:true,pagination:true,singleSelect:true,toolbar: '#materialtb'">
			<thead>
				<tr>
				    <th data-options="field:'id',hidden:true">设备名称</th>
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
		<div class="datagrid-toolbar" id=materialtb style="height:24px;padding:5px" >
	      <div style="padding-left:10px;">
	                  设备名称：<input type="text" name="cp.cpmc"/>
	                  规格型号：<input type="text" name="cp.standard"/>
	                  技术参数：<input type="text" name="parameter"/>
		   <a class="easyui-linkbutton l-btn" style="float: right;margin-right:5px;" onclick="searchMaterial()" href="#" iconcls="icon-search">查询</a>
		  </div>
		 </div>
	 </div>
	 <div data-options="region:'east',split:true" title="已选材料" style="width:${param.width}px;">
	    <table id="selectedMaterial" class="easyui-datagrid" data-options="border:false,rownumbers:true,fit:true,fitColumns:true,singleSelect:true">
			<thead>
		       <tr>
			    <th data-options="field:'id',hidden:true">设备名称</th>
				<th data-options="field:'cp.cpmc'">设备名称</th>
				<th data-options="field:'cp.brand'">品牌</th>
				<th data-options="field:'cp.standard',align:'right'">规格型号</th>
				<th data-options="field:'parameter',align:'right'">技术参数</th>
				<th data-options="field:'unit'">单位</th>
				<th data-options="field:'designAmount',align:'center'">设计数量</th>
				<th data-options="field:'designPrice',align:'center'">设计单价</th>
				<th data-options="field:'opt',align:'center',formatter:formatter">操作</th>
			  </tr>
			</thead>
		</table>
     </div>
 </div>
</body>
<script type="text/javascript">

    $(function(){
    	$("#projectInfoListtb input").live('keydown',function(event){
    		if(event.keyCode==13){
    			projectInfoListsearch();
    		}
    	});
    	
    	$('#materialtb input').live('keydown',function(event) {
    		if(event.keyCode==13){
    			searchMaterial();
    		}
	  	});
    	
    	
    });
	function getMaterial(rowIndex, rowData) {
		$("#material").datagrid({
			url : 'purchasePlanController.do?materialGrid&projectId='+ rowData.id
		});
	}

	function retMaterial() {
		var obj = new Object();
		obj.pro = $("#projectInfoList").datagrid('getSelected');
		obj.row = $('#selectedMaterial').datagrid('getData').rows;
		return obj;
	}
	
	var array=new Array();
	function onSelect(index,row){
		if(!array.contains(row.id)){
			array.push(row);
			$('#selectedMaterial').datagrid({
				data:array
			});
		}
	}
	
	function formatter(value,row,index){
		return '<a class="del" herf="#" id="'+row.id+'" index="'+index+'" onclick="delMaterial(this)">[删除]</a>';
	}
	
	function delMaterial(obj){
	   array.remove($(obj).attr("index")*1);
	   $('#selectedMaterial').datagrid({
			data:array
	   });
	}
	
	function searchMaterial(){
	    var queryParams = $('#material').datagrid('options').queryParams;
		$('#materialtb').find('input,select').each(function() {
			queryParams[$(this).attr('name')] = $(this).val();
	  	});
		$('#material').datagrid('reload');
	}

	Array.prototype.contains = function(obj) {
		var i = this.length;
		while (i--) {
			if (this[i].id === obj) {
				return true;
			}
		}
		return false;
	};
</script>
</html>