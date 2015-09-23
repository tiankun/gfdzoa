<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>工程信息表</title>
  <t:base type="jquery,easyui,tools,DatePicker,validate"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <form id="form_id" action="xsxmController.do?saveXsmx">
			<div class="formtitle" title="项目基本信息">项目基本信息</div>
			<input id="id" name="project.id" type="hidden" value="${projectInfo.id }">
			<input id="id" name="id" type="hidden" value="">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right" width="95px">
						<label class="Validform_label">
							项目名称:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt validate[required]" id="projectName"  style= "width:83%"
							   value="${projectInfo.projectName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目状态:
						</label>
					</td>
					<td class="value" colspan="3">
					<t:dictSelect hasLabel="false"  field="projectStatus" id="projectStatus" typeGroupCode="projectstate" defaultVal="${projectInfo.projectStatus }" extendJson="{\"class\":\"validate[required]\"}"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
			<div class="formtitle" title="销售记录">销售记录</div>
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right" width="95px">
						<label class="Validform_label">
							日期:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="Wdate validate[required]" id="logDate" name="logDate" onClick="WdatePicker()"  style="width: 150px"
							   value="">
						<span class="Validform_checktip"></span>
					</td>
					</tr>
					<tr>
					<td align="right">
						<label class="Validform_label">
							日志描述:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt validate[required]" id="description" style= "width:83%"  name="description" value="">
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
						<input class="inputxt validate[required]" id="remark"  style= "width:83%" name="remark" value="">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</form>
 </body>
 </html>