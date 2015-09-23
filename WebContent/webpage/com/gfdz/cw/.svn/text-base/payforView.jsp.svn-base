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
    <div title="支付申请信息" style="padding:5px;">
    <div id="agent" class="easyui-panel" title="支付信息" style="width:auto;height:auto;margin-bottom:5px;padding: 5px;"data-options="doSize:false">
	<input id="id" name="id" type="hidden" value="${page.id}">
	<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" style="width: 90px">
				<label class="Validform_label">
					收款单位：
				</label>
			</td>
			<td class="value"  colspan="5">
				<input class="inputxt" style="width: 50%" readonly="readonly" value="${page.skId.gsmc}">
			</td>
		</tr>
		<tr>
			<td align="right" style="width: 90px">
				<label class="Validform_label">
					支付方式：
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="payType" typeGroupCode="pay" defaultVal="${page.payType}" hasLabel="false" extendJson="{datatype:'*'}"/>
				<span class="Validform_checktip"></span>
			</td>
			<td align="right" style="width: 90px">
				<label class="Validform_label">
					申请人：
				</label>
			</td>
			<td class="value">
				<input class="inputxt" readonly="readonly" value="${page.user.realName}">
			</td>
			<td align="right" style="width: 90px">
				<label class="Validform_label">
					申请时间：
				</label>
			</td>
			<td class="value">
				<input class="Wdate" datatype="*" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width: 150px" id="applyTime" name="odate" 
				value="<fmt:formatDate value='${page.odate}' type="date" pattern="yyyy-MM-dd"/>">
				<span class="Validform_checktip"></span>
			</td>
		 </tr>
		 <tr>
			<td align="right">
				<label class="Validform_label">
					备注：
				</label>
			</td>
			<td class="value" colspan="5">
				<input class="inputxt" id="remark" style="width: 90%" name="note" value="${page.remark}">
			</td>
		</tr>
	</table>
	</div>
	<div class="easyui-panel" title="支付明细" style="width:auto;height:auto;margin-bottom:1px;padding: 5px;"data-options="doSize:false">
       <table cellpadding="0" cellspacing="1" id="" class="formtable">
		<tr bgcolor="#E6E6E6" style="line-height:25px">
			<td align="center" style="width: 30px" bgcolor="#EEEEEE">序号</td>
			<td align="center" bgcolor="#EEEEEE">采购单号</td>
			<td align="center" bgcolor="#EEEEEE">所属项目</td>	
			<td align="center" bgcolor="#EEEEEE">供应商</td>
			<td align="center" bgcolor="#EEEEEE">应付金额</td>
			<td align="center" bgcolor="#EEEEEE">已付金额</td>
<%--			<td align="center" bgcolor="#EEEEEE">欠款金额</td>--%>
			<td align="center" bgcolor="#EEEEEE">本次付款金额</td>
			<td align="center" style="width: 35%" bgcolor="#EEEEEE">备注</td>
		</tr>
	    <tbody style="text-align: center;">
	    <c:set value="0" var="yfMoney"/>
	    <c:set value="0" var="payMoney"/>
	    <c:set value="0" var="money"/>
	      <c:forEach items="${page.payforDetail}" var="p" varStatus="index">
	         <tr>
	           <td>${index.index+1}</td>
	           <td>${p.purchase.billCode}</td>
	           <td>${p.project.projectName}</td>
	           <td>${p.gysml.gsmc}</td>
	           <td><fmt:formatNumber pattern="#0.00" value="${p.purchase.yfMoney}"/></td>
	           <td><fmt:formatNumber pattern="#0.00" value="${p.purchase.payMoney}"/></td>
<%--	           <td><fmt:formatNumber pattern="#0.00" value="${p.purchase.qkMoney}"/></td>--%>
	           <td><fmt:formatNumber pattern="#0.00" value="${p.money}"/></td>
	           <td>${p.applyreason}</td>
	           <c:set value="${p.purchase.yfMoney+yfMoney}" var="yfMoney"/>
	           <c:set value="${p.purchase.payMoney+payMoney}" var="payMoney"/>
	           <c:set value="${p.money+money}" var="money"/>
	         </tr>
	      </c:forEach>
	    </tbody>
	    <tr style="color: red;">
	      <td colspan="4" align="right">合  计：</td>
	      <td align="right"><fmt:formatNumber pattern="#0.00" value="${yfMoney}"/></td>
	      <td align="right"><fmt:formatNumber pattern="#0.00" value="${payMoney}"/></td>
	      <td align="right"><fmt:formatNumber pattern="#0.00" value="${money}"/></td>
	      <td colspan="2"></td>
	    </tr>
	  </table>
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
});
</script>
</html>