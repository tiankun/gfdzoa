<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目材料采购计划 </title>
  <t:base type="jquery,easyui,tools"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
 <div id="p" class="easyui-panel" fit="true">
<table id="taskHistoryList">
	<thead>
		<tr>
			<th field="name" width="50">名称</th>
			<th field="processInstanceId" width="50">流程实例ID</th>
			<th field="startTime" width="50">开始时间</th>
			<th field="endTime" width="50">结束时间</th>
			<th field="assignee" width="50">负责人</th>
			<th field="deleteReason" width="50">处理结果</th>
			<th field="msg" width="100">批注信息</th>
		</tr>
	</thead>
</table>
</div>
<script type="text/javascript">
    // 编辑初始化数据
	function getData(data){
		var rows = [];			
		var total = data.total;
		for(var i=0; i<data.rows.length; i++){
			rows.push({
				name: data.rows[i].name,
				processInstanceId: data.rows[i].processInstanceId,
				startTime: data.rows[i].startTime,
				endTime: data.rows[i].endTime,
				assignee: data.rows[i].assignee,
				deleteReason: data.rows[i].deleteReason,
				msg:data.rows[i].msg
			});
		}
		var newData={"total":total,"rows":rows};
		return newData;
	}
    
	// 设置datagrid属性
	$('#taskHistoryList').datagrid({
        idField: 'id',
        fit:true,
        border:false,
        loadMsg: '数据加载中...',
        pageSize: 10,
        pagination:true,
        sortOrder:'asc',
        rownumbers:true,
        singleSelect:true,
        fitColumns:true,
        showFooter:true,
        url:'activitiController.do?myTaskHistoryList&processInstanceId=${processInstanceId}',  
        loadFilter: function(data){
        	return getData(data);
    	}
        
    }); 
    //设置分页控件  
    $('#taskHistoryList').datagrid('getPager').pagination({  
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
</script>
</body>
</html>
