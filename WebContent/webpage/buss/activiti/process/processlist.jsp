<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>流程列表</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <t:base type="jquery,easyui,tools"></t:base>
</head>
<body>
<div class="easyui-layout" fit="true">
		
		  <div data-options="region:'north',title:''" style="height:55px">
		<div class="datagrid-toolbar"  id="headshow">
			<div style="margin-top: 3px">
				<span style="display: inline-block;">
					<span style="margin-left: 25px" title="流程名称" >
					    流程名称：</span><input id="agentJm" name="agentJm" style="width: 100px;" type="text">
				</span>
				<a href="#" style="float:right;margin-right: 25px" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="customerQuery();">查询</a>
			</div>
				<span>
				<a href="#" class="easyui-linkbutton" plain="true" icon="icon-add"
				onclick="add('部署流程','activitiController.do?addProcess','processList')" >部署流程</a> 
			</span>
			<span>
				<a href="#" class="easyui-linkbutton" plain="true" icon="icon-add"
				onclick="updateProcess('流程设置','workFlowSetController.do?addorupdate','processList')" >流程设置</a> 
			</span>
		</div>
	</div>
	<div region="center" style="padding: 1px;">
				<table id="processList">
					<thead>
						<tr>
							<th field="id" hidden="hidden">编号</th>
							<th field="processDefinitionId" fitColumns="true">流程定义ID</th>
							<th field="deploymentId" fitColumns="true">部署ID</th>
							<th field="name" fitColumns="true">流程名称</th>
							<th field="key" fitColumns="true">流程KEY</th>
							<th field="version" fitColumns="true">版本</th>
							<th field="xml" fitColumns="true">流程文件</th>
							<th field="image" fitColumns="true">流程图</th>
							<th field="deploymentDate" fitColumns="true">部署日期</th>
							<th field="isSuspended" fitColumns="true">是否挂起</th>
							<th field="opt" fitColumns="true">操作</th>
						</tr>
					</thead>
				</table>

				<script type="text/javascript">
		//查看流程xml或流程图片
		function readProcessResouce(processDefinitionId,resourceType) {
			var url = "";
			var title = "";
			if(resourceType == "xml"){
				title = "查看流程文件";
				url = "activitiController.do?resourceRead&processDefinitionId="+processDefinitionId+"&resourceType=xml&isIframe"
			}

			if(resourceType == "image"){
				title = "查看流程图片";
				url = "activitiController.do?resourceRead&processDefinitionId="+processDefinitionId+"&resourceType=image&isIframe"
			}
			addOneTab(title, url);
		}
		
	    // 编辑初始化数据
		function getData(data){
			var rows = [];			
			var total = data.total;
			for(var i=0; i<data.rows.length; i++){
				rows.push({
					id: data.rows[i].id,
					processDefinitionId: data.rows[i].processDefinitionId,
					deploymentId: data.rows[i].deploymentId,
					name: data.rows[i].name,
					key: data.rows[i].key,
					version: data.rows[i].version,
					deploymentDate: data.rows[i].deploymentDate,
					xml: "[<a href=\"#\" onclick=\"readProcessResouce('"+data.rows[i].processDefinitionId+"','xml')\">查看流程xml</a>]",
					image: "[<a href=\"#\" onclick=\"readProcessResouce('"+data.rows[i].processDefinitionId+"','image')\">查看流程图片</a>]",
					isSuspended: data.rows[i].isSuspended=='false'?'否':'是',
					opt: "[<a href=\"#\" onclick=\"delObj('activitiController.do?setvalid&id="+data.rows[i].processDefinitionId+"','processList')\">"+(data.rows[i].isSuspended=='false'?'挂起':'启动')+"</a>]"+
					"[<a href=\"#\" onclick=\"delObj('activitiController.do?del&deploymentId="+data.rows[i].deploymentId+"','processList')\">删除流程</a>]"
				});
			}
			var newData={"total":total,"rows":rows};
			return newData;
		}
	    // 筛选
		function jeecgEasyUIListsearchbox(value,name){
    		var queryParams=$('#processList').datagrid('options').queryParams;
    		queryParams[name]=value;
    		queryParams.searchfield=name;
    		$('#processList').datagrid('load');
    	}
	    // 刷新
	    function reloadTable(){
	    	$('#processList').datagrid('reload');
	    }
	    
		// 设置datagrid属性
		$('#processList').datagrid({
			title: '流程定义及部署管理',
	        idField: 'id',
	        fit:true,
	        loadMsg: '数据加载中...',
	        pageSize: 10,
	        pagination:true,
	        sortOrder:'asc',
	        rownumbers:true,
	        singleSelect:true,
	        fitColumns:true,
	        showFooter:true,
	        url:'activitiController.do?datagrid',  
	        loadFilter: function(data){
	        	return getData(data);
	    	}
	        
	    }); 
	    //设置分页控件  
	    $('#processList').datagrid('getPager').pagination({  
	        pageSize: 10,  
	        pageList: [10,20,30],  
	        beforePageText: '',  
	        afterPageText: '/{pages}',
	        displayMsg: '{from}-{to}共{total}条',
	        showPageList:true,
	        showRefresh:true,
	        onBeforeRefresh:function(pageNumber, pageSize){
	            $(this).pagination('loading');
	            $(this).pagination('loaded');
	        }
	    });
	    // 设置筛选
    	$('#jeecgEasyUIListsearchbox').searchbox({
    		searcher:function(value,name){
    			jeecgEasyUIListsearchbox(value,name);
    		},
    		menu:'#jeecgEasyUIListmm',
    		prompt:'请输入查询关键字'
    	});
	    
    	function updateProcess(title,url, id,width,height) {
    		gridname=id;
    		var rowsData = $('#'+id).datagrid('getSelections');
    		if (!rowsData || rowsData.length==0) {
    			tip('请选择编辑项目');
    			return;
    		}
    		if (rowsData.length>1) {
    			tip('请选择一条记录再编辑');
    			return;
    		}
    		
    		url += '&deploymentId='+rowsData[0].deploymentId;
    		createwindow(title,url,width,height);
    	}
	</script>
			</div>
		</div></body>