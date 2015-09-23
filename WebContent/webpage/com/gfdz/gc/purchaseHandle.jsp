<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目材料采购计划 </title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
.selectTab{
  border: 1px solid red; 
  background-color: red;
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
	          <c:if test="${param.taskKey=='buyerRecheck'}">
	          <td>${pd.state==1 ? '<font color="#0000FF">已生成采购单</font>' : '<font color="red">未生成采购单</font>'}</td>
	          <td><input value="${pd.id}" class="validate[required]" <c:if test="${pd.state==1}">disabled="disabled"</c:if> name="pdId" type="checkbox"></td>
			  </c:if>
	        </tr>
	      </c:forEach>
	    </tbody> 
	  </table>
	  <c:if test="${param.taskKey=='buyerRecheck'}">
	   <div id="createPD" style="padding: 10px;margin-left:auto;margin-left:auto;text-align: center;display: none;">
          <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="addPD()">生成采购单</a>
       </div>
      </c:if>
   </div>
   <div class="easyui-panel" title="采购执行单" style="width:auto;height:auto;margin-bottom:5px;padding: 5px;"data-options="doSize:false">
      <c:set value="0" var="yfk"/>
      <c:set value="0" var="money"/>
     <c:forEach items="${page.ps}" var="p">
       <table name="delTab" <c:if test="${param.taskKey=='buyerRecheck'}">title="点击鼠标右键选中后可以删除执行单"</c:if> lang="${p.id}" style="width: 100%;table-layout: fixed;margin-bottom: 3px" cellpadding="0" cellspacing="1" class="formtable" id="reloadId">
		<tr> 
		    <c:if test="${param.taskKey=='purchasingExecutive' || param.taskKey=='arrivalNotice'}">
		    <td align="left" style="width: 80px;padding: 2px;">
				<label class="Validform_label">
					<input type="checkbox" name="ids" value="${p.id}" <c:if test="${p.arriving==1}">checked="checked" disabled="disabled"</c:if> datatype="*"/>已到货
				</label>
			</td>
			</c:if>
			<td align="right" style="width: 80px;padding: 2px;">
			  <span class="datagrid-row-expand opt" title="点击展开查看明细" state="close"></span>
				<label class="Validform_label">
					单   号：
				</label>
			</td>
			<td class="value">${p.billCode}</td>
			<td align="right" style="width: 90px">
				<label class="Validform_label">
					供应商：
				</label>
			</td>
			<td class="value">${p.gys.gsmc}</td>
			<td align="right" style="width: 90px">
				<label class="Validform_label">
					创建时间：
				</label>
			</td>
			<td class="value"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${p.inputTime}"/></td>
			<td align="right" style="width: 90px">
				<label class="Validform_label">
					预付款：
				</label>
			</td>
			<td class="value">￥<fmt:formatNumber value="${p.advance}" pattern="#0.00"/></td>
			<c:set value="${p.advance+yfk}" var="yfk"/>
			<td align="right" style="width: 90px">
				<label class="Validform_label">
					已付款：
				</label>
			</td>
			<td class="value">￥<fmt:formatNumber value="${p.payMoney}" pattern="#0.00"/></td>
			<c:set value="${p.payMoney+money}" var="money"/>
		</tr>
		<tr style="display: none;">
		  <c:if test="${param.taskKey!='purchasingExecutive' && param.taskKey!='arrivalNotice'}">
		  <td colspan="10" style="background-color: white;">
		  </c:if>
		   <c:if test="${param.taskKey=='purchasingExecutive' || param.taskKey=='arrivalNotice'}">
		  <td colspan="11" style="background-color: white;">
		  </c:if>
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
	<table style="width: 100%;table-layout: fixed;margin-bottom: 3px" cellpadding="0" cellspacing="1" class="formtable">
	  <tr style="color: red">
	    <td colspan="6" align="right">预付款合计：</td>
	    <td>￥<fmt:formatNumber pattern="#0.00" value="${yfk}"/></td>
	    <td align="right" style="width: 90px">已付款合计：</td>
	    <td>￥<fmt:formatNumber pattern="#0.00" value="${money}"/></td>
	  </tr>
	</table>
   </div>
   <input id="taskKey" name="taskKey" type="hidden" value="${param.taskKey}">			
   <input id="taskId" name="taskId" type="hidden" value="${param.taskId}">	
   <c:if test="${param.taskKey!='cashierId' && param.taskKey!='purchasingExecutive' && param.taskKey!='arrivalNotice'}">
   <div class="easyui-panel" title="审批信息" style="width:auto;height:auto;margin-bottom:5px;padding: 5px;"data-options="doSize:false">
	<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="60px">
				<label class="Validform_label">
					审批结果:
				</label>
			</td>
			<td class="value">
			<t:dictSelect hasLabel="false" field="auditType" extendJson="{datatype:'*'}" id="auditType" typeGroupCode="auditType" defaultVal=""></t:dictSelect>
			<span class="Validform_checktip"></span>
			</td>
			<td align="right">
				<label class="Validform_label">
					审批意见 ：
				</label>
			</td>
			<td class="value" width="65%">
				<input class="inputxt" style="width: 95%" name="postil" value="" datatype="*">
				<span class="Validform_checktip"></span>
			</td>
		</tr>
	</table>
  </div>
  </c:if>  
  <c:if test="${param.taskKey=='cashierId'}">
    <div class="easyui-panel" title="支付信息" style="width:auto;height:auto;margin-bottom:5px;padding: 5px;"data-options="doSize:false">
	<table style="width: 100%;table-layout:auto;" cellpadding="0" cellspacing="1" class="formtable" >
		<tr>
			<td align="right" style="80px">
				<label class="Validform_label">
					付款金额:
				</label>
			</td>
			<td class="value">
			<input class="inputxt" readonly="readonly" style="color: red" value="<fmt:formatNumber pattern="#0.00" value="${yfk}"/>">
			<span class="Validform_checktip"></span>
			</td>
			<td align="right" style="80px">
				<label class="Validform_label">
					付款方式：
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="payType" typeGroupCode="pay" defaultVal="" hasLabel="false" extendJson="{datatype:'*'}"/>
				<span class="Validform_checktip"></span>
			</td>
			<td align="right" style="80px">
				<label class="Validform_label">
					付款时间：
				</label>
			</td>
			<td class="value">
				<input class="Wdate validate[required,custom[date]" name="payDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="" datatype="*">
				<span class="Validform_checktip"></span>
			</td>
			<td align="right" style="80px">
				<label class="Validform_label">
					操作人：
				</label>
			</td>
			<td class="value">
				<input class="inputxt" readonly="readonly" value="${userName}">
				<span class="Validform_checktip"></span>
			</td>
		</tr>
	</table>
  </div>
  </c:if>  
    </div>
       <div id="bz" title="审批记录" data-options="closable:true" style="overflow:hidden;">
           <iframe scrolling="yes" frameborder="0"  src="activitiController.do?myViewProcessHistory&processInstanceId=${param.processInstanceId}" style="width:100%;height:100%;"></iframe>
	   </div>
       <div id="png" title="审批图" data-options="closable:true" style="">
          	<img src="activitiController.do?traceImage&processInstanceId=${param.processInstanceId}"> 
       </div>
   </div>
  </t:formvalid>
      <div id="mm" class="easyui-menu" data-options="onClick:menuHandler" style="width:120px;">
        <div data-options="name:'del',iconCls:'icon-remove'">删除采购执行单</div>
      </div>
</body>
<script type="text/javascript">
$(function(){
	$(function(){
		$(window).resize(function(){
	    	$('#tabs').tabs('resize',{width: '100%',height:($(window).height()-35)});  
	     });
	});
	$("#agent table tr td").find("input,select").attr("disabled",true);
	$("#material tr").click(function(){
		var checkbox=$(this).find("input[name='pdId'][type='checkbox']");
		if(this.className!='selected' && $(checkbox).attr("disabled")!='disabled'){
			$(checkbox).attr("checked",true);
			$(this).addClass("selected");
		}else{
			$(checkbox).attr("checked",false);
			$(this).removeClass("selected");
		}
	});
	
	$("#material tr td").find("input[type='checkbox']").each(function(){
		if($(this).attr("disabled")!='disabled'){
			$("#createPD").show();
		}
	});
	
	
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
	$("table[name='delTab']").bind('contextmenu',function(e){
		$("table[name='delTab']").removeClass("selectTab");
		$(this).addClass("selectTab");
        e.preventDefault();
        $('#mm').menu('show', {
            left: e.pageX,
            top: e.pageY
        });
    });
});

function menuHandler(item){
	if(item.name=='del'){
	    $.messager.confirm('系统提示','您确定要删除你选中的采购单吗?', function(r){
            if (r){
            	var tab=$("table[name='delTab'][class*=selectTab]");
            	var id= $(tab).attr("lang");
            	$.post('purchaseController.do?del',{'id':id},function(data){
            		if(data.success){
            			toTip(data.msg);
            			window.location.reload();
            		}else{
            			error(data.msg);
            		}
            	},'json');
            }
        });
	}
}

function addPDOrder(){
	var rel = $("#formobj").validationEngine('validate');
	$.ajax({
		type : "POST",
		url : 'purchaseController.do?purchaseSave',
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
				window.location.reload();
				top.tip(data.msg);
			}
		},
		error : function(req) {
			$("#formobj").attr("lock","");
			$.messager.progress('close');
			error("操作异常！" + req.status);
		}
	});
}


function addPD(){
	var rel = $("#formobj").validationEngine('validate');
	if(rel){
		$.dialog({
			title : '生成采购执行单',
			opacity : 0.5,
			width : 1100,
			height : 500,
			content : 'url:purchaseController.do?createPurchase&'+$("#formobj").serialize(),
			lock : true,
			cache : false,
			parent : api,
			ok:function(){
				var frame = this.iframe.contentWindow;
				frame.addPD();
				return false;
			},
			cancel : true,
			zIndex : 2000
		});
	}
};
</script>
</html>