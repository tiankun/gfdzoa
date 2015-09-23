<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>请假类型</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript">
		$(function() {
			$('#parentId').combotree({
				url : 'leaveTypeController.do?getChildren'
			});
		});
		</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="leaveTypeController.do?save">
			<input id="id" name="id" type="hidden" value="${leaveTypePage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="typeName" name="typeName" ignore="ignore"
							   value="${leaveTypePage.typeName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							上级目录:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="parentId" name="parent.id" ignore="ignore"
							   value="${leaveTypePage.parent.id}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							允许天数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="leaveDays" name="leaveDays" ignore="ignore"
							   value="${leaveTypePage.leaveDays}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="note" name="note" ignore="ignore"
							   value="${leaveTypePage.note}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>