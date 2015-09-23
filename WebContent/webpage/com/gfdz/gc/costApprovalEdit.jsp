<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>证章申请信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="costApprovalController.do?completeTask">
			<div class="formtitle" title="成本核定申请">成本核定申请</div>
			<input id="processKey" name="processKey" type="hidden" value="${processKey }">
			<input id="taskKey" name="taskKey" type="hidden" value="${taskKey }">
			<input id="taskId" name="taskId" type="hidden" value="${taskId }">
			<input id="id" name="id" type="hidden" value="${costApproval.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${costApproval.project.projectName }">
						<input style="width: 230px" id="projectId" name="project.id" value="${costApproval.project.id }" type="hidden">
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
		             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审定施工费:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sdsgf" name="sdsgf" ignore="ignore"
							   value="${costApproval.sdsgf}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							增减变更金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="bgje" name="bgje" ignore="ignore"
							   value="${costApproval.bgje}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							管网进度:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gwjd" name="gwjd" ignore="ignore"
							   value="${costApproval.gwjd}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							线缆进度:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="xljd" name="xljd" ignore="ignore"
							   value="${costApproval.xljd}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备进度:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sbjd" name="sbjd" ignore="ignore"
							   value="${costApproval.sbjd}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							总体进度:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ztjd" name="ztjd" ignore="ignore"
							   value="${costApproval.ztjd}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>