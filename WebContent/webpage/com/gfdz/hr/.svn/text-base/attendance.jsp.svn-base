<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>考勤记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="attendanceController.do?save">
			<input id="id" name="id" type="hidden" value="${attendancePage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="username" name="username" ignore="ignore"
							   value="${attendancePage.username}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部门:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="depart" name="depart" ignore="ignore"
							     value="<fmt:formatDate value='${attendancePage.depart}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							考勤日期:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="attendanceDate" name="attendanceDate" ignore="ignore"
							   value="${attendancePage.attendanceDate}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							上午考勤:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="attendanceAm" name="attendanceAm" ignore="ignore"
							   value="${attendancePage.attendanceAm}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							下午考勤:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="attendancePm" name="attendancePm" ignore="ignore"
							   value="${attendancePage.attendancePm}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>