<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目材料审计</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="materialBaseController.do?save">
			<input id="id" name="id" type="hidden" value="${materialBasePage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="projectId" name="projectId" ignore="ignore"
							   value="${materialBasePage.projectId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="materialName" name="materialName" ignore="ignore"
							   value="${materialBasePage.materialName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							品牌:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="brand" name="brand" ignore="ignore"
							   value="${materialBasePage.brand}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							规格型号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="model" name="model" ignore="ignore"
							   value="${materialBasePage.model}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							技术参数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="parameter" name="parameter" ignore="ignore"
							   value="${materialBasePage.parameter}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="unit" name="unit" ignore="ignore"
							   value="${materialBasePage.unit}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设计数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="designAmount" name="designAmount" ignore="ignore"
							   value="${materialBasePage.designAmount}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							采购数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="purchaseAmount" name="purchaseAmount" ignore="ignore"
							   value="${materialBasePage.purchaseAmount}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							实到数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="receiveAmount" name="receiveAmount" ignore="ignore"
							   value="${materialBasePage.receiveAmount}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							安装数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="installAmount" name="installAmount" ignore="ignore"
							   value="${materialBasePage.installAmount}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							移交数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="transferAmount" name="transferAmount" ignore="ignore"
							   value="${materialBasePage.transferAmount}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>