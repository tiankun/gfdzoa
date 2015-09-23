<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
 <script type="text/javascript">
//   $("input[name='date_begin']").val(myformatter(new Date()));
//   $("input[name='date_end']").val(myformatter(new Date()));
  
  function queryWorkFlow(val,row){
	  if(row.key){
	 	 return "<a style='color:blue;text-decoration: underline;' onclick=queryDetail('"+row.action+"','"+row.id+"') title='查看明细' class='href' href='#'>"+val+"</a>";
	  }else{
	 	 return val;
	  }
	 }	

	 function queryDetail(val,val2){
	 	var url= val +"&pid="+val2;
	 	createdetailwindow("明细信息", url,1000,600);
	 }
  
  function createdetailwindow(title,url,width,height){
	  $.dialog({
          content : 'url:'+url,
          lock : true,
          title :title,
          opacity : 0.3,
          width : width,
          height : height,
          cache : false,
          cancelVal : '关闭',
          cancel : true
      }).max();
  }
  
  function getDetail(index,rowData){
	  var url=rowData.action +"&pid="+rowData.id;
	  $.dialog({
          content : 'url:'+url,
          lock : true,
          title :'明细信息',
          opacity : 0.3,
          width : 1100,
          height : 600,
          cache : false,
          cancelVal : '关闭',
          cancel : true
      }).max();
  }
</script>
<div class="easyui-layout" fit="true" border="false">
  <div region="center" style="padding:1px;">
  <t:datagrid name="myWorkTaskList" title="我的工作" pageSize="10" onDblClick="getDetail"
  actionUrl="dailyWorkController.do?myWorkTaskData" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="流水号" field="taskId" width="10"></t:dgCol>
   <t:dgCol title="工作名称/文号 " field="key" width="20"  extendParams="formatter:queryWorkFlow," ></t:dgCol>
   <t:dgCol title="发起人" field="username" width="10"></t:dgCol>
   <t:dgCol title="流程开始时间" field="beginDate" width="12"></t:dgCol>
   <t:dgCol title="流程结束时间" field="endDate" width="12"></t:dgCol>
   <t:dgCol title="流程状态" field="stateType" width="10"></t:dgCol>
  </t:datagrid>
  </div>
 </div>