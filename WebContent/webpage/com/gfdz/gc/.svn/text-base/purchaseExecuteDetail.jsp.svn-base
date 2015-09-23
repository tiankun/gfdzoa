<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目材料采购执行详细</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="purchaseExecuteDetailController.do?save">
			<input id="id" name="id" type="hidden" value="${purchaseExecuteDetailPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							采购单主键:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="projectPlanId" name="projectPlanId" 
							   value="${purchaseExecuteDetailPage.projectPlanId}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							采购申请物品主键:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="projectMaterialId" name="projectMaterialId" 
							   value="${purchaseExecuteDetailPage.projectMaterialId}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							计划数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="amount" name="amount" 
							   value="${purchaseExecuteDetailPage.amount}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							采购单价:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="price" name="price" ignore="ignore"
							   value="${purchaseExecuteDetailPage.price}">
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
							   value="${purchaseExecuteDetailPage.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>