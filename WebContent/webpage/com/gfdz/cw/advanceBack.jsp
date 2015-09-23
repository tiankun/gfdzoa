<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>暂支还款表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="advanceBackController.do?save">
			<input id="id" name="id" type="hidden" value="${advanceBackPage.id }">
			<table style="width: 100%" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							暂支单主键:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="advanceId" name="advanceId" 
							   value="${advanceBackPage.advanceId}" datatype="*">
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>	   
					    <script type="text/javascript">
					var windowapi = frameElement.api, W = windowapi.opener;
					function choose() {
						if (typeof (windowapi) == 'undefined') {
							$
									.dialog({
										content : 'url:advanceController.do?advanceLists',
										zIndex : 2100,
										title : '暂支列表',
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
										content : 'url:advanceController.do?advanceLists',
										zIndex : 2100,
										title : '暂支列表',
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
						if ($('#advanceId').length >= 1) {
							$('#advanceId').val('');
							$('#advanceId').blur();
						}
						$('#advanceId').val("");
					}
					function clickcallback() {
						iframe = this.iframe.contentWindow;
						var advanceId = iframe.getadvanceListSelections('id');
						if ($('#advanceId').length >= 1) {
							$('#advanceId').val(advanceId);
							$('#advanceId').blur();
						}
						 var id = iframe.getadvanceListSelections('id');
						if (id !== undefined && id != "") {
							$('#projectId').val(id);
						}
					}
				</script>	   
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="right">
						<label class="Validform_label">
							归还金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="backedMoney" name="backedMoney" 
							   value="${advanceBackPage.backedMoney}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							归还时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="backDate" name="backDate" 
							   value="<fmt:formatDate value='${advanceBackPage.backDate}' type="date" pattern="yyyy-MM-dd"/>" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="remark" name="remark" ignore="ignore"
							   value="${advanceBackPage.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>