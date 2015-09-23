<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目材料采购计划 </title>
  <t:base type="jquery,easyui,tools,DatePicker,validate"></t:base>
  <style type="text/css">
   table tbody .selected{
     background-color: #FBEC88;
   }
  </style>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <form name="formobj" id="formobj" action="purchaseController.do?purchaseSave">
  <div id="agent" class="easyui-panel" title="采购申请单信息" style="width:auto;height:auto;margin-bottom:5px;padding: 5px;"data-options="doSize:false">
	<input id="id" name="plan.id" type="hidden" value="${page.id}">
	<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">
					项目：
				</label>
			</td>
			<td class="value">
				<input class="inputxt" style="width: 230px" readonly="readonly" value="${page.project.projectName}">
			</td>
			<td align="right">
				<label class="Validform_label">
					申请人：
				</label>
			</td>
			<td class="value">
				<input class="inputxt" readonly="readonly" value="${page.user.realName}">
			</td>
			<td align="right">
				<label class="Validform_label">
					申请时间：
				</label>
			</td>
			<td class="value">
				<input class="Wdate validate[required,custom[date]]" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width: 150px" id="applyTime" name="applyTime" 
				value="<fmt:formatDate value='${page.applyTime}' type="date" pattern="yyyy-MM-dd"/>">
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					备注：
				</label>
			</td>
			<td class="value" colspan="5">
				<input class="inputxt" id="remark" name="remark" ignore="ignore" value="${page.remark}">
			</td>
		</tr>
	</table>
  </div>
  <input id="projectId" name="project.id" value="${page.project.id}" type="hidden">
   <div class="easyui-panel" title="材料采购单明细" style="width:auto;height:auto;margin-bottom:1px;padding: 5px;"data-options="doSize:false">
       <table cellpadding="0" cellspacing="1" id="" class="formtable">
		<tr bgcolor="#E6E6E6" style="line-height:25px">
			<td align="center" style="width: 30px" bgcolor="#EEEEEE">序号</td>
			<td align="center" bgcolor="#EEEEEE">设备名称</td>
			<td align="center" bgcolor="#EEEEEE">品牌</td>	
			<td align="center" bgcolor="#EEEEEE">规格型号</td>
			<td align="center" bgcolor="#EEEEEE">技术参数</td>
			<td align="center" bgcolor="#EEEEEE">单位</td>
			<td align="center" bgcolor="#EEEEEE" style="width: 50px">设计数量</td>
			<td align="center" bgcolor="#EEEEEE">设计单价</td>
			<td align="center" bgcolor="#EEEEEE" style="width: 50px">采购数量</td>
			<td align="center" bgcolor="#EEEEEE" >采购单价</td>
			<td align="center" bgcolor="#EEEEEE" >总额</td>
			<td align="center" bgcolor="#EEEEEE" style="width: 80px">要求到货时间</td>
			<td align="center" style="width: 20%" bgcolor="#EEEEEE">备注</td>
		</tr>
	    <tbody id="material" style="text-align: center;">
	      <c:set value="0" var="total"/>
	      <c:forEach items="${list}" var="pd" varStatus="index">
	        <tr>
	          <td>${index.index+1}<input name="pdId" value="${pd.id}" type="hidden"/></td>
	          <td>${pd.cp.cpmc}</td>
	          <td>${pd.cp.brand}</td>
	          <td>${pd.cp.standard}</td>
	          <td>${pd.material.parameter}</td>
	          <td>${pd.material.unit}</td>
	          <td>${pd.material.designAmount}</td>
	          <td><fmt:formatNumber pattern="#0.00" value="${pd.material.designPrice}"/></td>
	          <td>${pd.material.purchaseAmount}</td>
	          <td><fmt:formatNumber pattern="#0.00" value="${pd.material.purchasePrice}"/></td>
	          <c:set value="${pd.material.purchasePrice*pd.material.purchaseAmount+total}" var="total"/>
	          <td align="right"><fmt:formatNumber pattern="#0.00" value="${pd.material.purchasePrice*pd.material.purchaseAmount}"/></td>
	          <td><fmt:formatDate pattern="yyyy-MM-dd" value="${pd.requireTime}"/></td>
	          <td>${pd.remark}</td>
	        </tr>
	      </c:forEach>
	      <tr>
           <td colspan="10" style="color: red;" align="right">合计：</td>
           <td style="color: red;" align="right">￥<fmt:formatNumber pattern="#0.00" value="${total}"/></td>
           <td colspan="3"></td>
         </tr>
         <tr>
           <td colspan="2" style="color: red;" align="right">预付款：</td>
           <td colspan="4" align="left">
            <input name="advance" class="validate[custom[number],min[0]]" style="width: 100px;color: red" type="text">
            <span id="qrfk" style="color: red;display: none;">付款后<input id="days" name="days" type="text" style="width: 20px;text-align: right;"/>天到货</span>
           </td>
           <td  colspan="2" align="right" style="padding-left: 10px">供应商：</td>
           <td colspan="5" align="left">
                <input style="width: 280px;" readonly="readonly" type="text" id="gsmc" class="validate[required]">
             	<input id="gsmcId" name="gys.id" value="" type="hidden" class="validate[required]">
				<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="selectGys()">选择</a>
             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
           </td>
         </tr>
         <tr>
           <td colspan="2" align="right">备注：</td>
           <td colspan="11" align="left"><input name="remark" type="text" style="width:92%"/></td>
         </tr>
	    </tbody>
	  </table>
   </div>
 </form>
</body>
<script type="text/javascript">
$(function(){
	$("#formobj").validationEngine();
	$("#agent table tr td").find("input,select").attr("disabled",true);
	
	$("input[name='advance']").live('change keyup',function(){
		var advance='${total}';
		if(this.value*1-advance*1==0){
			$("#qrfk").show();
			$("#days").addClass("validate[required,custom[integer],min[0]]");
		}else{
			$("#qrfk").hide();
			$("#days").val("");
			$("#days").removeClass("validate[required,custom[integer],min[0]]");
		}
	});
});

function addPD(){
	var rel = $("#formobj").validationEngine('validate');
	$.ajax({
		type : "POST",
		url : $("#formobj").attr("action"),
		data : $("#formobj").serialize(),
		dataType : "json",
		beforeSend : function(XMLHttpRequest) {
			var lock=$("#formobj").attr("lock");
			if(lock=="lock"){
				return false;
			}else{
				if (!rel) {
					$("#formobj").shake();
					return false;
				} else {
					$("#formobj").attr("lock","lock");
					$.messager.progress({
						title : '系统提示',
						msg : '数据提交中...'
					});
				}
			}
		},
		success : function(data) {
			$("#formobj").attr("lock","");
			$.messager.progress('close');
			if (!data.success) {
				error(data.msg);
			} else {
				 var frame=top.frames;
				 for(var i=0;i<frame.length;i++){
      				if(frame[i].document.getElementById("reloadId")){
      					frame[i].location.reload();
      				}
      			 }
				frameElement.api.close();
			}
		},
		error : function(req) {
			$("#formobj").attr("lock","");
			$.messager.progress('close');
			error("操作异常！" + req.status);
		}
	});
}
	
	
	function selectGys() {
		clearAll();
		$.dialog({
			title : '收款单位列表',
			opacity : 0.5,
			width : 900,
			height : 500,
			content : 'url:purchaseController.do?selectGysList',
			lock : true,
			cache : false,
			parent : api,
			ok:function(){
				var frame = this.iframe.contentWindow;
				var obj=frame.getGys();
				$("#gsmc").val(obj.gsmc);
				$("#gsmcId").val(obj.id);
				return true;
			},
			cancel : true,
			zIndex : 2005
		});
	}
	
	function clearAll() {
		$("#gsmc").val("");
		$("#gsmcId").val("");
	}
</script>
</html>