<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目材料采购计划 </title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="purchasePlanDetailController.do?save">
			<input id="id" name="id" type="hidden" value="${purchasePlanDetailPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							采购计划主键:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="projectPlanId" name="projectPlanId" 
							   value="${purchasePlanDetailPage.projectPlanId}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							材料主键:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="projectMaterialId" name="projectMaterialId" 
							   value="${purchasePlanDetailPage.projectMaterialId}" datatype="*">
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
						<input class="inputxt" id="planNumber" name="planNumber" 
							   value="${purchasePlanDetailPage.planNumber}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							计划单价:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planPrice" name="planPrice" 
							   value="${purchasePlanDetailPage.planPrice}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申请说明:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="palanExplain" name="palanExplain" ignore="ignore"
							   value="${purchasePlanDetailPage.palanExplain}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="examineNumber" name="examineNumber" ignore="ignore"
							   value="${purchasePlanDetailPage.examineNumber}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核单价:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="examinePrice" name="examinePrice" ignore="ignore"
							   value="${purchasePlanDetailPage.examinePrice}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审批说明:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="examineExplain" name="examineExplain" ignore="ignore"
							   value="${purchasePlanDetailPage.examineExplain}">
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
							   value="${purchasePlanDetailPage.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>