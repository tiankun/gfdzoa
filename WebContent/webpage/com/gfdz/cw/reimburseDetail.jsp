<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>财务报账明细</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="reimburseDetailController.do?save">
			<input id="id" name="id" type="hidden" value="${reimburseDetailPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							报账主表id:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="reimburseId" name="reimburseId" 
							   value="${reimburseDetailPage.reimburseId}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="paytype" name="paytype" 
							   value="${reimburseDetailPage.paytype}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							其他类型说明:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="other" name="other" ignore="ignore"
							   value="${reimburseDetailPage.other}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							支付金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="paymoney" name="paymoney" 
							   value="${reimburseDetailPage.paymoney}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							单据数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="documentsnum" name="documentsnum" 
							   value="${reimburseDetailPage.documentsnum}" datatype="*">
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
							   value="${reimburseDetailPage.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>