<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目材料采购计划 </title>
<t:base type="jquery,easyui"></t:base>
<style type="text/css">
html,body,form {
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
	float: left;
	cursor: pointer;
	padding: 0px;
	margin: 0px 3px;
}
</style>
</head>
 <body style="overflow-y: hidden">
  <t:formvalid formid="formobj" dialog="true" tiptype="3" layout="table" action="purchaseController.do?completeTask">
  <div id="tabs" class="easyui-tabs" fit="true">
    <div title="采购申请" style="padding:5px;">
    <div id="agent" class="easyui-panel" title="采购申请信息" style="width:auto;height:auto;margin-bottom:5px;padding: 5px;"data-options="doSize:false">
	<input id="id" name="plan.id" type="hidden" value="${page.id}">
	<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable" id="reloadId">
		<tr>
		    <td align="right">
				<label class="Validform_label">
					单号：
				</label>
			</td>
			<td class="value">
			  <input class="inputxt" readonly="readonly" value="${page.billCode}">
			</td>
			<td align="right">
				<label class="Validform_label">
					申请项目：
				</label>
			</td>
			<td class="value">
				<input class="inputxt" style="width: 230px" readonly="readonly" value="${page.project.projectName}">
				<input style="width: 230px" id="projectId" name="project.id" value="${page.project.id}" type="hidden">
			</td>
			<td align="right">
				<label class="Validform_label">
					申请人：
				</label>
			</td>
			<td class="value">
				<input class="inputxt" readonly="readonly" value="${page.user.realName}">
			</td>
	      </tr>
		  <tr>
			<td align="right">
				<label class="Validform_label">
					申请时间：
				</label>
			</td>
			<td class="value">
				<input class="Wdate validate[required,custom[date]" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width: 150px" id="applyTime" name="applyTime" 
				value="<fmt:formatDate value='${page.applyTime}' type="date" pattern="yyyy-MM-dd"/>">
			</td>
			<td align="right">
				<label class="Validform_label">
					备注：
				</label>
			</td>
			<td class="value" colspan="5">
				<input class="inputxt" id="remark" name="remark" style="width: 90%" value="${page.remark}">
			</td>
		</tr>
	</table>
  </div>
   <div class="easyui-panel" title="采购申请材料明细" style="width:auto;height:auto;margin-bottom:5px;padding: 5px;"data-options="doSize:false">
       <table cellpadding="0" cellspacing="1" id="" class="formtable">
		<tr bgcolor="#E6E6E6" style="line-height:25px">
			<td align="center" style="width: 30px" bgcolor="#EEEEEE">序号</td>
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
			<td align="center" style="width: 20%" bgcolor="#EEEEEE">备注</td>
			<c:if test="${param.taskKey=='buyerRecheck'}">
			<td align="center" bgcolor="#EEEEEE">状态</td>
			<td align="center" style="width: 30px" bgcolor="#EEEEEE">操作</td>
			</c:if>
		</tr>
	    <tbody id="material" style="text-align: center;">
	      <c:forEach items="${page.pds}" var="pd" varStatus="index">
	        <tr>
	          <td>${index.index+1}</td>
	          <td>${pd.cp.cpmc}</td>
	          <td>${pd.cp.brand}</td>
	          <td>${pd.cp.standard}</td>
	          <td>${pd.material.parameter}</td>
	          <td>${pd.material.unit}</td>
	          <td>${pd.material.designAmount}</td>
	          <td>${pd.material.designPrice}</td>
	          <td>${pd.material.purchaseAmount}</td>
	          <td>${pd.material.purchasePrice}</td>
	          <td><fmt:formatDate pattern="yyyy-MM-dd" value="${pd.requireTime}"/></td>
	          <td>${pd.remark}</td>
	        </tr>
	      </c:forEach>
	    </tbody> 
	  </table>
   </div>
   
   <div class="easyui-panel" title="采购执行单" style="width:auto;height:auto;margin-bottom:5px;padding: 5px;"data-options="doSize:false">
     <c:forEach items="${page.ps}" var="p">
       <table style="width: 100%;table-layout: fixed;margin-bottom: 3px" cellpadding="0" cellspacing="1" class="formtable" id="reloadId">
		<tr>
			<td align="right" style="width: 120px;padding: 2px;">
			  <span class="datagrid-row-collapse opt" title="点击展开查看明细" state="open"></span>
				<label class="Validform_label">
					单   号：
				</label>
			</td>
			<td class="value">${p.billCode}</td>
			<td align="right">
				<label class="Validform_label">
					供应商：
				</label>
			</td>
			<td class="value">${p.gys.gsmc}</td>
			<td align="right" style="width: 120px">
				<label class="Validform_label">
					创建时间：
				</label>
			</td>
			<td class="value"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${p.inputTime}"/></td>
			<td align="right" style="width: 120px">
				<label class="Validform_label">
					预付款：
				</label>
			</td>
			<td class="value">￥${p.advance}</td>
			<td align="right" style="width: 120px">
				<label class="Validform_label">
					已付款：
				</label>
			</td>
			<td class="value">￥<fmt:formatNumber value="${p.payMoney}" pattern="#0.00"/></td>
		</tr>
		<tr>
		  <td colspan="10" style="background-color: white;">
		    <table cellpadding="0" cellspacing="1" id="" class="formtable">
		<tr bgcolor="#E6E6E6" style="line-height:20px">
			<td align="center" style="width: 45px" bgcolor="#EEEEEE">序号</td>
			<td align="center" bgcolor="#EEEEEE">设备名称</td>
			<td align="center" bgcolor="#EEEEEE">品牌</td>	
			<td align="center" bgcolor="#EEEEEE">规格型号</td>
			<td align="center" bgcolor="#EEEEEE">技术参数</td>
			<td align="center" bgcolor="#EEEEEE">单位</td>
			<td align="center" bgcolor="#EEEEEE">采购数量</td>
			<td align="center" bgcolor="#EEEEEE">采购单价</td>
			<td align="center" bgcolor="#EEEEEE">金额</td>
			<td align="center" style="width: 30%" bgcolor="#EEEEEE">备注</td>
		</tr>
	    <tbody id="material" style="text-align: center;">
	      <c:set value="0" var="total"/>
	      <c:forEach items="${p.pd}" var="pd" varStatus="index">
	        <tr>
	          <td>${index.index+1}</td>
	          <td>${pd.cp.cpmc}</td>
	          <td>${pd.cp.brand}</td>
	          <td>${pd.cp.standard}</td>
	          <td>${pd.material.parameter}</td>
	          <td>${pd.material.unit}</td>
	          <td>${pd.material.purchaseAmount}</td>
	          <td><fmt:formatNumber pattern="#0.00" value="${pd.material.purchasePrice}"/></td>
	          <td><fmt:formatNumber pattern="#0.00" value="${pd.material.purchasePrice*pd.material.purchaseAmount}"/></td>
	          <td>${remark}</td>
	           <c:set value="${pd.material.purchasePrice*pd.material.purchaseAmount+total}" var="total"/>
	        </tr>
	      </c:forEach>
	      <tr style="color: red">
	        <td colspan="8" align="right">小计：</td>
	        <td><fmt:formatNumber pattern="#0.00" value="${total}"/></td>
	        <td></td>
	      </tr>
	    </tbody> 
	  </table>
		  </td>
		</tr>
	</table>
	</c:forEach>
   </div>
    </div>
       <div id="bz" title="审批记录" data-options="closable:true" style="overflow:hidden;">
           <iframe scrolling="yes" frameborder="0"  src="activitiController.do?myViewProcessHistory&processInstanceId=${param.pid}" style="width:100%;height:100%;"></iframe>
	   </div>
       <div id="png" title="审批图" data-options="closable:true" style="">
          	<img src="activitiController.do?traceImage&processInstanceId=${param.pid}"> 
       </div>
   </div>
  </t:formvalid>
</body>
<script type="text/javascript">
$(function(){
	$(window).resize(function(){
    	$('#tabs').tabs('resize',{width: '100%',height:($(window).height()-35)});  
    });
	
	$("#agent table tr td").find("input,select").attr("disabled",true);
	
	$("table tr td .opt").click(function(){
		var obj=this;
		if($(this).attr("state")=="close"){
			$(this).attr("state","open");
			$(this).parents("tr").next().slideDown(function(){
				$(obj).removeClass("datagrid-row-expand");
				$(obj).addClass("datagrid-row-collapse");
			});
		}else{
			$(this).attr("state","close");
			$(this).parents("tr").next().slideUp(function(){
				$(obj).addClass("datagrid-row-expand");
				$(obj).removeClass("datagrid-row-collapse");
			});
		}
	});
});
</script>
</html>