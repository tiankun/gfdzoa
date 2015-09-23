<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>人员家庭成员</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="familyController.do?save">
			<input id="id" name="id" type="hidden" value="${family.id }">
			<input id="personId" name="personId" type="hidden" value="${param.personId}">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
				<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="name" name="name" ignore="ignore"
							   value="${family.name}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							称谓:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="appellation" name="appellation" ignore="ignore"
							   value="${family.appellation}">
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							工作单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="workUnit" name="workUnit" ignore="ignore"
							   value="${family.workUnit}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							部门:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="depar" name="depar" ignore="ignore"
							   value="${family.depar}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							职务:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="position" name="position" ignore="ignore"
							   value="${family.position}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							联系方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="phone" name="phone" ignore="ignore"
							   value="${family.phone}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							住址:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" style="width:98%" id="addr" name="addr" ignore="ignore"
							   value="${family.addr}">
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
						<textarea class="textarea" id="remark" name="remark" ignore="ignore"
							   value="${family.remark}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>