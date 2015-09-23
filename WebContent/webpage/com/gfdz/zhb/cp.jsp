<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>产品表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
var windowapi = frameElement.api, W = windowapi.opener;
function choose() {
	if (typeof (windowapi) == 'undefined') {
		$
			.dialog({
				content : 'url:cplxController.do?cplxList',
				zIndex : 2100,
				title : '项目列表',
				lock : true,
				width : 600,
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
				content : 'url:cplxController.do?cplxList',
				zIndex : 2100,
				title : '项目列表',
				lock : true,
				parent : windowapi,
				width : 600,
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
					
function clickcallback() {
	var iframe = this.iframe.contentWindow;
	var lxbh = iframe.getcplxListSelections('id');
	var lxname = iframe.getcplxListSelections('text');
	alert(lxname);
	//alert(lxbh);
	$('#lxbhname').val(lxname);
	$('#lxbh').val(lxbh);
	/* var payeeid = iframe.getcplxListListSelections('id');
	if (payeeid !== undefined && payeeid != "") {
	$('#payeeid').val(payeeid);
	} */
}
						

function unitchoose() {
	if (typeof (windowapi) == 'undefined') {
		$
			.dialog({
				content : 'url:gysmlController.do?gysList',
				zIndex : 2100,
				title : '项目列表',
				lock : true,
				width : 600,
				height : 350,
				left : '85%',
				top : '65%',
				opacity : 0.4,
				button : [
				{
					name : '确定',
					callback : unitclickcallback,
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
				title : '项目列表',
				lock : true,
				parent : windowapi,
				width : 600,
				height : 350,
				left : '85%',
				top : '65%',
				opacity : 0.4,
				button : [
				{
					name : '确定',
					callback : unitclickcallback,
					focus : true
				}, {
					name : '取消',
					callback : function() {
					}
						} ]
				});
						}
}
					
function unitclickcallback() {
	var iframe = this.iframe.contentWindow;
	var unitid = iframe.getgysmlListSelections('id');
	var unitname = iframe.getgysmlListSelections('gsmc');
	alert(unitname);
	//alert(lxbh);
	$('#unitname').val(unitname);
	$('#unitid').val(unitid);
	/* var payeeid = iframe.getcplxListListSelections('id');
	if (payeeid !== undefined && payeeid != "") {
	$('#payeeid').val(payeeid);
	} */
}

</script>   
 </head>
 
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="cpController.do?save">
			<input id="id" name="id" type="hidden" value="${cpPage.id }">
			<input id="lxbh" name="lxbh.id" type="hidden" value="${cpPage.lxbh.id }"> 
			<input id="unitid" name="unit.id" type="hidden" value="${cpPage.lxbh.id }"> 
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
				<td align="right">
						<label class="Validform_label">
							产品名称:
						</label>
						
					</td>
					<td class="value">
						<input class="inputxt" id="cpmc" name="cpmc" 
							   value="${cpPage.cpmc}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="right">
						<label class="Validform_label">
							类型:
						</label>
					</td>
					<td class="value">
						<input  id="lxbhname" name="lxbhname"  ignore="ignore"
							   value="${cpPage.lxbh.lxmc}" onclick="choose();" class="searchbox-inputtext15">
							  
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							品牌:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="brand" name="brand" ignore="ignore"
							   value="${cpPage.brand}">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="right">
						<label class="Validform_label">
							规格:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="standard" name="standard" ignore="ignore"
							   value="${cpPage.standard}">
						<span class="Validform_checktip"></span>
					</td>
				
				</tr>
				<tr>
				
				<td align="right">
						<label class="Validform_label">
							单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="unit" name="unit" ignore="ignore"
							   value="${cpPage.unit}">
						<span class="Validform_checktip"></span>
					</td>
					
					
					<td align="right">
						<label class="Validform_label">
							供应商:
						</label>
					</td>
					<td class="value">
						<input id="unitname" name="unitname" ignore="ignore"
							   value="${cpPage.unit.gsmc}" onclick="unitchoose();" class="searchbox-inputtext15">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" style="width: 430px" id="bz" name="bz" ignore="ignore"
							   value="${cpPage.bz}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>