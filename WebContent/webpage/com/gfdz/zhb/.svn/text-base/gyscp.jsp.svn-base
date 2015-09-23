<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>供应商产品表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="gyscpController.do?save">
			<input id="id" name="id" type="hidden" value="${gyscpPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							产品编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cpbh" name="cpbh" 
							   value="${gyscpPage.cpbh}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							供应商编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gysbh" name="gysbh" 
							   value="${gyscpPage.gysbh}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>