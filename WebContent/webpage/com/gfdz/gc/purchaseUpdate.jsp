<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目材料采购计划 </title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <style type="text/css">
  html,body,form{
     height: 100%;
     padding: 0px;
     margin: 0px;
  }
table tbody .selected {
	background-color: #FBEC88;
}

a {
	text-decoration: underline;
	color: #1C1CFF;
}

a:hover {
	text-decoration: underline;
	color: red;
}

.opt {
	display: inline-block;
	width: 15px;
	height: 15px;
	vertical-align: sub;
	float:left;
	cursor: pointer;
	padding: 0px;
	margin: 0px 3px;
}
</style>
</head>
 <body style="overflow-y: hidden">
  <t:formvalid formid="formobj" dialog="true" tiptype="3" layout="table" action="purchasePlanController.do?update">
  <div id="tabs" class="easyui-tabs" fit="true">
    <div title="采购申请" style="padding:5px;">
    <input id="taskKey" name="taskKey" type="hidden" value="${param.taskKey}">			
    <input id="taskId" name="taskId" type="hidden" value="${param.taskId}">
    <input id="id" name="id" type="hidden" value="${page.id }">
    <div id="agent" class="easyui-panel" title="采购信息" style="width:auto;height:auto;margin-bottom:5px;padding: 5px;"data-options="doSize:false">
	<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">
					项目：
				</label>
			</td>
			<td class="value">
				<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${page.project.projectName}">
				<input style="width: 230px" id="projectId" name="project.id" type="hidden" value="${page.project.id}">
				<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
			</td>
			<td align="right">
				<label class="Validform_label">
					申请人：
				</label>
			</td>
			<td class="value">
				<input class="inputxt" readonly="readonly" value="${userName}">
			</td>
			<td align="right">
				<label class="Validform_label">
					申请时间：
				</label>
			</td>
			<td class="value">
				<input class="Wdate" datatype="*" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width: 150px" id="applyTime" name="applyTime" 
				value="<fmt:formatDate value='${page.applyTime}' type="date" pattern="yyyy-MM-dd"/>">
				 <span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					备注：
				</label>
			</td>
			<td class="value"  colspan="5">
				<input class="inputxt" id="remark" name="remark" ignore="ignore" value="${page.remark}">
			</td>
		</tr>
	</table>
  </div>
   <div class="easyui-panel" title="材料采购明细" style="width:auto;height:auto;margin-bottom:1px;padding: 5px;"data-options="doSize:false">
       <table cellpadding="0" cellspacing="1" id="" class="formtable">
		<tr bgcolor="#E6E6E6" style="line-height:25px">
			<td align="center" style="width: 50px" bgcolor="#EEEEEE">序号</td>
			<td align="center" bgcolor="#EEEEEE">设备名称</td>
			<td align="center" bgcolor="#EEEEEE">品牌</td>	
			<td align="center" bgcolor="#EEEEEE">规格型号</td>
			<td align="center" bgcolor="#EEEEEE">技术参数</td>
			<td align="center" bgcolor="#EEEEEE">单位</td>
			<td align="center" bgcolor="#EEEEEE">设计数量</td>
			<td align="center" bgcolor="#EEEEEE">设计单价</td>
			<td align="center" bgcolor="#EEEEEE">采购数量</td>
			<td align="center" bgcolor="#EEEEEE">采购单价</td>
			<td align="center" bgcolor="#EEEEEE">要求到货时间</td>
			<td align="center" style="width: 40%" bgcolor="#EEEEEE">备注</td>
			<td align="center" style="width: 60px" bgcolor="#EEEEEE">操作</td>
		</tr>
		<tbody id="materialOld" style="text-align: center;">
		 <c:forEach items="${page.pds}" var="pd" varStatus="index">
	        <tr>
	          <td align="center">${index.index+1}<input type="hidden" name="mId" value="${pd.material.id}"></td>
	          <td align="center">${pd.cp.cpmc}</td>
	          <td align="center">${pd.cp.brand}</td>
	          <td align="center">${pd.cp.standard}</td>
	          <td align="center">${pd.material.parameter}</td>
	          <td align="center">${pd.material.unit}</td>
	          <td align="center">${pd.material.designAmount}</td>
	          <td align="center">${pd.material.designPrice}</td>
	          <td align="center">
	             <input type="text" name="num" datatype="n" nullmsg="请填写采购数量" class="validate[required,custom[integer],min[1]]" value="${pd.material.purchaseAmount}">
	             <span class="Validform_checktip"></span>
	          </td>
	          <td align="center">
	           <input type="text" name="price" datatype="d" nullmsg="请填写采购单价" class="validate[required,custom[number],min[0]]" value="${pd.material.purchasePrice}">
	           <span class="Validform_checktip"></span>
	          </td>
	          <td align="center">
	            <input class="Wdate" datatype="*" nullmsg="请填写要求到货时间" name="otd" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${pd.requireTime}"/>">
	            <span class="Validform_checktip"></span>
	          </td>
	          <td align="center">
	            <input name="note" style="width:95%" ignore="ignore" datatype="*" value="${pd.remark}" type="text">
	            <span class="Validform_checktip"></span>
	          </td>
	          <td align="center"><a href="#" onclick="$(this.parentNode.parentNode).remove()">删除</a></td>
	        </tr>
	      </c:forEach>
	     </tbody>
	    <tbody id="material" style="text-align: center;">
	    </tbody>
	  </table>
   </div>
    </div>
       <div id="bz" title="审批记录" data-options="closable:true" style="overflow:hidden;">
           <iframe scrolling="yes" frameborder="0"  src="activitiController.do?myViewProcessHistory&processInstanceId=${param.processInstanceId}" style="width:100%;height:100%;"></iframe>
	   </div>
       <div id="png" title="审批图" data-options="closable:true" style="">
          	<img src="activitiController.do?traceImage&processInstanceId=${param.processInstanceId}"> 
       </div>
   </div>
  </t:formvalid>
</body>
<script type="text/javascript">
$(window).resize(function(){
	$('#tabs').tabs('resize',{width: '100%',height:($(window).height()-35)});  
 });
$("#materialOld").find("input[name='otd']").live('click',function(){
	WdatePicker({dateFmt:'yyyy-MM-dd'});
});

$("#material,#materialOld").find("input[name='num'],input[name='price']").live('change',function(){
	$tr= $(this).parents("tr");
	var desigNum=$tr.children("td").eq(6).html()*1;
	var desigPrice=$tr.children("td").eq(7).html()*1;
	var num=$tr.find("input[name='num']").val()*1;
	var price=$tr.find("input[name='price']").val()*1;
	if(num>desigNum || price>desigPrice){
		$tr.find("input[name='note']").attr("ignore","");
	}else{
		$tr.find("input[name='note']").attr("ignore","ignore");
	}
});
function choose() {
	$.dialog({
		content : "url:purchasePlanController.do?selectMaterial&width="+$(window).width()/2,
		zIndex : 2100,
		title : "商品列表",
		lock : true,
		width : $(window).width()-100,
		height : $(window).height()-80,
		left : '50%',
		top : '50%',
		opacity : 0.4,
		button : [ {
			name : '确认',
			callback :function(){
				clearAll();
				var iframe = this.iframe.contentWindow;
				var data=iframe.retMaterial();
				$("#projectId").val(data.pro.id);
				$("#projectName").val(data.pro.projectName);
				if(data.row && data.row.length>0){
					for ( var i = 0; i < data.row.length; i++) {
						setMaterial(data.row[i]);
					}
				}
				
				$("#material").find("input[name='otd']").live('click',function(){
					WdatePicker({dateFmt:'yyyy-MM-dd'});
				});
			},
			focus : true
		}, {
			name : '取消',
			callback : function() {
			}
		} ]
	});
}

function clearAll(){
	$("#projectId").val("");
	$("#projectName").val("");
	$("#material").html("");
}
function setMaterial(obj) {
	var tr = '<tr><td></td>'+
	         '<td>'+obj["cp.cpmc"]+'<input type="hidden" name="mId" value="'+obj.id+'"></td>'+
	         '<td>'+obj["cp.brand"]+'</td>'+
	         '<td>'+obj["cp.standard"]+'</td>'+
	         '<td>'+obj.parameter+'</td>'+
	         '<td>'+obj.unit+'</td>'+
	         '<td>'+obj.designAmount+'</td>'+
	         '<td>'+obj.designPrice+'</td>'+
	         '<td><input name="num" datatype="n" nullmsg="请填写采购数量" type="text"/><span class="Validform_checktip"></span></td>'+
	         '<td><input name="price" datatype="n" nullmsg="请填写采购单价" type="text"/><span class="Validform_checktip"></span></td>'+
	         '<td><input class="Wdate" datatype="*" nullmsg="请填写要求到货时间" name="otd"><span class="Validform_checktip"></span></td>'+
	         '<td><input name="note" style="width:95%" value="" ignore="ignore" datatype="*" type="text"><span class="Validform_checktip"></span></td>'+
	         '<td align="center"><a href="#" onclick="$(this.parentNode.parentNode).remove()">删除</a></td>'+
	         '</tr>';
	$("#material").append(tr);
	$("#material tr").each(function(i) {
		$(this).children().eq(0).html(i + 1);
	});
}
</script>
</html>