<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>人事变动信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="personChangeController.do?save">
			<input id="id" name="id" type="hidden" value="${personChange.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							人员id:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="personId" name="personId" ignore="ignore"
							   value="${personChange.personId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动前单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="beforeUnit" name="beforeUnit" ignore="ignore"
							   value="${personChange.beforeUnit}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动前部门:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="beforeDepart" name="beforeDepart" ignore="ignore"
							   value="${personChange.beforeDepart}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动前岗位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="beforeJob" name="beforeJob" ignore="ignore"
							   value="${personChange.beforeJob}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动前行政级别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="beforeLevel" name="beforeLevel" ignore="ignore"
							   value="${personChange.beforeLevel}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动后单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="afterUnir" name="afterUnir" ignore="ignore"
							   value="${personChange.afterUnir}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动后部门:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="afterDepart" name="afterDepart" ignore="ignore"
							   value="${personChange.afterDepart}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动后岗位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="afterJob" name="afterJob" ignore="ignore"
							   value="${personChange.afterJob}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动后行政级别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="afterLevel" name="afterLevel" ignore="ignore"
							   value="${personChange.afterLevel}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="changeType" name="changeType" ignore="ignore"
							   value="${personChange.changeType}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="changeDate" name="changeDate" ignore="ignore"
							     value="<fmt:formatDate value='${personChange.changeDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							附件:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="changeFiles" name="changeFiles" ignore="ignore"
							   value="${personChange.changeFiles}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							说明:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="explain" name="explain" ignore="ignore"
							   value="${personChange.explain}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动前状态:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="beforeState" name="beforeState" ignore="ignore"
							   value="${personChange.beforeState}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							变动后状态:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="afterState" name="afterState" ignore="ignore"
							   value="${personChange.afterState}">
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
							   value="${personChange.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>