<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>个人离职表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="leaveOfficeController.do?save">
			<input id="id" name="id" type="hidden" value="${leaveOffice.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							人员id:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="personId" name="personId" ignore="ignore"
							   value="${leaveOffice.personId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部门id:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="departId" name="departId" ignore="ignore"
							   value="${leaveOffice.departId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申请时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="applyType" name="applyType" ignore="ignore"
							   value="<fmt:formatDate value='${leaveOffice.applyType}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核状态:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="state" name="state" ignore="ignore"
							   value="${leaveOffice.state}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							离职原因:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="leaveReason" name="leaveReason" ignore="ignore"
							   value="${leaveOffice.leaveReason}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							流程id:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="processId" name="processId" ignore="ignore"
							   value="${leaveOffice.processId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>