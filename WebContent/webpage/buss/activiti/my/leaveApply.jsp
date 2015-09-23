<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>发起请假申请</title>
<t:base type="jquery,easyui"></t:base>
<script type="text/javascript" src="plug-in/My97DatePicker/WdatePicker.js"></script>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" dialog="true" layout="table" action="leaveController.do?leaveStart">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> 请假类型: </label></td>
			<td class="value" width="85%">
				<input id="reason" class="inputxt" name="reason" value="" datatype="s2-10" />
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> 开始时间: </label></td>
			<td class="value" width="85%">
				<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" 
				id="birthday" name="birthday" ignore="ignore" value=""> 
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> 结束时间: </label></td>
			<td class="value" width="85%">
				<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" 
				id="birthday" name="birthday" ignore="ignore" value=""> 
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> 请假原因: </label></td>
			<td class="value" width="85%">
				<input id="reason" class="inputxt" name="reason" value="" datatype="*" />
				<span class="Validform_checktip"></span>
			</td>
		</tr>
	</table>
</t:formvalid>
</body>