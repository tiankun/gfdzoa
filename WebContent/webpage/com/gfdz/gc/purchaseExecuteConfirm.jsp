<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目材料采购到货记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="purchaseExecuteConfirmController.do?save">
			<input id="id" name="id" type="hidden" value="${purchaseExecuteConfirmPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							detailedId:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="detailedId" name="detailedId" ignore="ignore"
							   value="${purchaseExecuteConfirmPage.detailedId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							confirmNumber:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="confirmNumber" name="confirmNumber" ignore="ignore"
							   value="${purchaseExecuteConfirmPage.confirmNumber}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							confirmTime:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="confirmTime" name="confirmTime" ignore="ignore"
							   value="<fmt:formatDate value='${purchaseExecuteConfirmPage.confirmTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sjSuppliers:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sjSuppliers" name="sjSuppliers" ignore="ignore"
							   value="${purchaseExecuteConfirmPage.sjSuppliers}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							confirmUser:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="confirmUser" name="confirmUser" ignore="ignore"
							   value="${purchaseExecuteConfirmPage.confirmUser}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							remark:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="remark" name="remark" ignore="ignore"
							   value="${purchaseExecuteConfirmPage.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>