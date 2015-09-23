<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>证章信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zzxxController.do?save">
  		  	<div class="formtitle" title="基本信息">基本信息</div>
			<input id="id" name="id" type="hidden" value="${zzxxPage.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lxbh" name="lxbh" 
							   value="${zzxxPage.lxbh}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							证章名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zzmc" name="zzmc" 
							   value="${zzxxPage.zzmc}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							责任部门:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zrbm" name="zrbm" ignore="ignore"
							   value="${zzxxPage.zrbm}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							责任人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zrr" name="zrr" ignore="ignore"
							   value="${zzxxPage.zrr}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							存放位置:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cfwz" name="cfwz" ignore="ignore"
							   value="${zzxxPage.cfwz}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							
						</label>
					</td>
					<td class="value">	
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
						<%-- <input class="inputxt" id="bz" name="bz" ignore="ignore"
							   value="${zzxxPage.bz}"> --%>
							   <textarea rows="5" cols="5" id="bz" name="bz" class="textarea" value="${zzxxPage.bz}" >${zzxxPage.bz}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>