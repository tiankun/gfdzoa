<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目材料采购计划 </title>
  <t:base type="jquery,easyui,tools,DatePicker,validate"></t:base>
  <style type="text/css">
    #material a{
      text-decoration: underline;
      color: blue;
      letter-spacing:1px;
    }
    #material a:hover{
      text-decoration: underline;
      color: red;
      letter-spacing:1px;
    }
  </style>
  </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" tiptype="3" usePlugin="password" layout="table" action="payforController.do?save">
  <div id="agent" class="easyui-panel" title="支付信息" style="width:auto;height:auto;margin-bottom:5px;padding: 5px;"data-options="doSize:false">
	<input id="id" name="id" type="hidden" value="${purchasePlanPage.id }">
	<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" style="width: 90px">
				<label class="Validform_label">
					收款单位：
				</label>
			</td>
			<td class="value"  colspan="5">
				<input class="inputxt" style="width: 50%" readonly="readonly" id="projectName" datatype="*" >
				<input style="width: 230px" id="projectId" name="skId.id" value="" type="hidden">
				<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
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
				<input class="inputxt" readonly="readonly" value="${userName}">
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
			<td align="center" bgcolor="#EEEEEE">预付款</td>
			<td align="center" bgcolor="#EEEEEE">应付金额</td>
			<td align="center" bgcolor="#EEEEEE">实付金额</td>
			<td align="center" bgcolor="#EEEEEE">欠款金额</td>
			<td align="center" bgcolor="#EEEEEE">本次付款金额</td>
			<td align="center" style="width: 35%" bgcolor="#EEEEEE">备注</td>
			<td align="center" style="width: 40px" bgcolor="#EEEEEE">操作</td>
		</tr>
	    <tbody id="material" style="text-align: center;">
	    </tbody>
	    <tr style="color: red;">
	      <td colspan="4" align="right">合  计：</td>
	      <td align="right"><span id="advance">0.00</span></td>
	      <td align="right"><span id="yfMoney">0.00</span></td>
	      <td align="right"><span id="payMoney">0.00</span></td>
	      <td align="right"><span id="qkMoney">0.00</span></td>
	      <td align="right"><span id="money">0.00</span></td>
	      <td colspan="2"></td>
	    </tr>
	  </table>
   </div>
 </t:formvalid>
</body>
<script type="text/javascript">
function choose() {
	$.dialog({
		content : "url:payforController.do?selectGysAndPurchase",
		zIndex : 2100,
		title : "商品列表",
		lock : true,
		width : 1000,
		height : 550,
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
				$("#projectName").val(data.pro.gsmc);
				if(data.row && data.row.length>0){
					for ( var i = 0; i < data.row.length; i++) {
						setMaterial(data.row[i]);
					}
				}
				$("#material input[name='money']").live("keyup change",cos);
				cos();
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
	         '<td>'+obj.billCode+'<input type="hidden" name="pId" value="'+obj.id+'"></td>'+
	         '<td>'+obj["project.projectName"]+'</td>'+
	         '<td>'+obj["gys.gsmc"]+'</td>'+
	         '<td align="right">'+obj.advance+'</td>'+
	         '<td align="right">'+obj.yfMoney+'</td>'+
	         '<td align="right">'+obj.payMoney+'</td>'+
	         '<td align="right">'+obj.qkMoney+'</td>'+
	         '<td><input name="money" style="width:90%" datatype="d" nullmsg="请填写金额" type="text"><span class="Validform_checktip"></span></td>'+
	         '<td><input name="note" style="width:95%" value="" type="text"></td>'+
	         '<td><a href="#" onclick="del(this.parentNode.parentNode)">删除</a></td></tr>';
	$("#material").append(tr);
	$("#material tr").each(function(i) {
		$(this).children().eq(0).html(i + 1);
	});
}

function del(obj){
	$(obj).remove();
	cos();
	$("#material tr").each(function(i) {
		$(this).children().eq(0).html(i + 1);
	});
}

function cos(){
	var advance=0;
	var yfMoney=0;
	var payMoney=0;
	var qkMoney=0;
	var money=0;
	$("#material tr").each(function(){
		advance+=$(this).find("td").eq(4).html()*1;
		yfMoney+=$(this).find("td").eq(5).html()*1;
		payMoney+=$(this).find("td").eq(6).html()*1;
		money+=$(this).find("td").eq(8).children().val()*1;
		$(this).find("td").eq(7).html(($(this).find("td").eq(5).html()*1-$(this).find("td").eq(8).children().val()*1-$(this).find("td").eq(6).html()*1).toFixed(2));
		qkMoney+=$(this).find("td").eq(7).html()*1;
	});
	$("#advance").html(advance.toFixed(2));
	$("#yfMoney").html(yfMoney.toFixed(2));
	$("#payMoney").html(payMoney.toFixed(2));
	$("#qkMoney").html(qkMoney.toFixed(2));
	$("#money").html(money.toFixed(2));
}
</script>
</html>