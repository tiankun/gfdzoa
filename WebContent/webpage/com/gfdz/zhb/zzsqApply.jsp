<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>证章申请信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zzsqController.do?save">
			<div class="formtitle" title="证章借用申请">证章借用详情</div>
			<input id="id" name="id" type="hidden" value="${zzsqPage.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							借用项目:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jyxm" name="jyxm" ignore="ignore"
							   value="${zzsqPage.jyxm}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							使用时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="sysj" name="sysj" 
							   value="<fmt:formatDate value='${zzsqPage.sysj}' type="date" pattern="yyyy-MM-dd"/>" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							借用用途:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="jyyt" name="jyyt" 
							   value="${zzsqPage.jyyt}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							借用类型:
						</label>
					</td>
					<td class="value">
						<input type="checkbox" id="jylx" name="jylx" value="${zzsqPage.jylx}">原件
						<input type="checkbox" id="jylx" name="jylx" value="${zzsqPage.jylx}">复印及加盖公章
						<input type="checkbox" id="jylx" name="jylx" value="${zzsqPage.jylx}">盖章
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							使用份数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="syfs" name="syfs" ignore="ignore"
							   value="${zzsqPage.syfs}">
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
						<textarea class="textarea" id="bz" name="bz" ignore="ignore"
							   value="${zzsqPage.bz}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		<div class="formtitle" title="证章借用申请">证章借用审批批注信息</div>
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right" width="70px">
						<label class="Validform_label">
							批注:
						</label>
					</td>
					<td class="value">
						<textarea class="textarea" id="bz" name="bz" ignore="ignore"
							   value="${zzsqPage.bz}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>