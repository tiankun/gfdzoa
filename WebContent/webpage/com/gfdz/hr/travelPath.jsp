<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>出差路径</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="travelPathController.do?save">
			<input id="id" name="id" type="hidden" value="${travelPathPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							省:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="province" name="province" ignore="ignore"
							   value="${travelPathPage.province}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							市:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="city" name="city" ignore="ignore"
							   value="${travelPathPage.city}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							县:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="county" name="county" ignore="ignore"
							   value="${travelPathPage.county}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开始时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="beginDate" name="beginDate" ignore="ignore"
							     value="<fmt:formatDate value='${travelPathPage.beginDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							结束时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="endDate" name="endDate" ignore="ignore"
							     value="<fmt:formatDate value='${travelPathPage.endDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							交通工具:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="vehicle" name="vehicle" ignore="ignore"
							   value="${travelPathPage.vehicle}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							报销标准:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="criterion" name="criterion" ignore="ignore"
							   value="${travelPathPage.criterion}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出差id:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="travelId" name="travelId" ignore="ignore"
							   value="${travelPathPage.travelId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出差类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="travelType" name="travelType" ignore="ignore"
							   value="${travelPathPage.travelType}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>