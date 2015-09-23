<%@ page language="java" import="java.util.*,java.sql.*,java.text.*,java.util.Date" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>暂支表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="advanceController.do?save">
  			<div class="formtitle" title="暂支申请单">暂支申请单</div>
			<input id="id" name="id" type="hidden" value="${advancePage.id }">
			<input id="applyTime" name="applyTime" type="hidden" value="">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							部门:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="departname" name="depart.departname" 
							   value="${advancePage.depart.departname!=null ?advancePage.depart.departname:user.currentDepart.departname}" datatype="*">
					    <input class="inputxt" id="depart.id" name="depart.id" type="hidden"
							   value="${advancePage.depart.id!=null ?advancePage.depart.id:user.currentDepart.id}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							申请人:
						</label>
					</td>
					<td class="value">
						<input id="userId.id" name="userId.id" type="hidden"
							   value="${advancePage.userId.id!=null ?advancePage.userId.id:user.id}" datatype="*">
						<input class="inputxt" id="userId.realName" name="userId.realName" readonly="readonly"
							   value="${advancePage.userId.realName!=null ?advancePage.userId.realName : user.realName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							收款单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="payeename" name="payeename" 
							   value="${advancePage.payeename}">
						<input class="inputxt" id="payeeid" name="payeeid" ignore="ignore" type="hidden"
							   value="">	   
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
							        <script type="text/javascript">
					var windowapi = frameElement.api, W = windowapi.opener;
					function choose() {
						if (typeof (windowapi) == 'undefined') {
							$
									.dialog({
										content : 'url:gysmlController.do?gysList',
										zIndex : 2100,
										title : '收款单位列表',
										lock : true,
										width : 400,
										height : 350,
										left : '85%',
										top : '65%',
										opacity : 0.4,
										button : [
												{
													name : '确定',
													callback : clickcallback,
													focus : true
												}, {
													name : '取消',
													callback : function() {
													}
												} ]
									});
						} else {
							$
									.dialog({
										content : 'url:gysmlController.do?gysList',
										zIndex : 2100,
										title : '收款单位列表',
										lock : true,
										parent : windowapi,
										width : 400,
										height : 350,
										left : '85%',
										top : '65%',
										opacity : 0.4,
										button : [
												{
													name : '确定',
													callback : clickcallback,
													focus : true
												}, {
													name : '取消',
													callback : function() {
													}
												} ]
									});
						}
					}
					function clearAll() {
						if ($('#payeename').length >= 1) {
							$('#payeename').val('');
							$('#payeename').blur();
						}
						$('#payeename').val("");
					}
					function clickcallback() {
						iframe = this.iframe.contentWindow;
						var payeename = iframe.getgysmlListSelections('gsmc');
						
						if ($('#payeename').length >= 1) {
							$('#payeename').val(payeename);
							$('#payeename').blur();
						}
						 var payeeid = iframe.getgysmlListSelections('id');
						
						if (payeeid !== undefined && payeeid != "") {
							$('#payeeid').val(payeeid);
						}
					}
				</script>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							收款单位(收款人):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fukuanUnit" name="fukuanUnit" ignore="ignore"
							   value="${advancePage.fukuanUnit}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
					<tr>
					<td align="right">
						<label class="Validform_label">
							暂支金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="applyMoney" name="applyMoney" datatype="d"
							   value="${advancePage.applyMoney}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							申请原因:
						</label>
					</td>
					<td class="value" >
				        <t:dictSelect field="applyReason" typeGroupCode="applyReason" hasLabel="false" defaultVal="${advancePage.applyReason}" extendJson="{\"datatype\":\"*\"}"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				
					
					<td align="right">
						<label class="Validform_label">
							借支类型:
						</label>
					</td>
					<td class="value">
						<t:dictSelect field="advanceType" typeGroupCode="advanceType" hasLabel="false" defaultVal="${advancePage.advanceType}" extendJson="{\"datatype\":\"*\"}"></t:dictSelect>	   
						<span class="Validform_checktip"></span>
					</td>
				
				<td align="right">
						<label class="Validform_label">
							
						</label>
					</td>
					<td class="value">
						
						<span class="Validform_checktip"></span>
					</td>
			 </tr>
			</table>
		</t:formvalid>
 </body>