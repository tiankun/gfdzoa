<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>费用开支计划明细</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="expensesPlanDetailController.do?save">
			<input id="id" name="id" type="hidden" value="${expensesPlanDetailPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							费用开支计划主键:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="expensesPlanId" name="expensesPlanId" ignore="ignore"
							   value="${expensesPlanDetailPage.expensesPlanId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开支项:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="item" name="item" 
							   value="${expensesPlanDetailPage.item}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开支金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planMoney" name="planMoney" 
							   value="${expensesPlanDetailPage.planMoney}" datatype="d">
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
						<input class="inputxt" id="remark" name="remark" ignore="ignore"
							   value="${expensesPlanDetailPage.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>