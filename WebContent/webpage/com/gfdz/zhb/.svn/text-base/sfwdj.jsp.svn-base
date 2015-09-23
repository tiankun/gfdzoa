<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>收发文登记表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="sfwdjController.do?save">
			<input id="id" name="id" type="hidden" value="${sfwdjPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lxbh" name="lxbh" ignore="ignore"
							   value="${sfwdjPage.lxbh}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							文件名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wjmc" name="wjmc" 
							   value="${sfwdjPage.wjmc}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							文件编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wjbh" name="wjbh" 
							   value="${sfwdjPage.wjbh}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
					          收发文类型
						(1:收文;2:发文):
						</label>
					</td>
			<td class="value"><t:dictSelect field="sfwlx" typeGroupCode="sfwlx" hasLabel="false" defaultVal="${sfwdjPage.sfwlx}"></t:dictSelect> <span class="Validform_checktip"></span></td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							文件份数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wjfs" name="wjfs" 
							   value="${sfwdjPage.wjfs}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							收/发件人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fjr" name="fjr" 
							   value="${sfwdjPage.fjr}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							签收人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="qsr" name="qsr" 
							   value="${sfwdjPage.qsr}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							签收日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="qsrq" name="qsrq" 
							   value="<fmt:formatDate value='${sfwdjPage.qsrq}' type="date" pattern="yyyy-MM-dd"/>" datatype="*">
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
						<%-- <input  style="width: 150px" class="inputxt" id="bz" name="bz" ignore="ignore"
							   value="${sfwdjPage.bz}"> --%>
				<textarea rows="5" cols="" class="inputxt" id="bz" name="bz" style="width: 500px" value="${sfwdjPage.bz}">${sfwdjPage.bz}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>