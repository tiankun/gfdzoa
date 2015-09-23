<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>法定节假日</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vacationArrangementController.do?save">
			<input id="id" name="id" type="hidden" value="${vacationArrangement.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							节假日:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="vacationDate" name="vacationDate" ignore="ignore"
							   value="<fmt:formatDate value='${vacationArrangement.vacationDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<!--  -->
				<tr>
					<td align="right">
						<label class="Validform_label">
							说明:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="note" name="note" ignore="ignore"
							   value="${vacationArrangement.note}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>