<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>工程验收登记</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="projectAcceptController.do?save">
			<div class="formtitle">基本信息</div>
			<input id="id" name="id" type="hidden" value="${projectAccept.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="projectId" name="projectId" ignore="ignore"
							   value="${projectAccept.projectId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							建设单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="development" name="development" ignore="ignore"
							   value="${projectAccept.development}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							设计单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="designUnit" name="designUnit" ignore="ignore"
							   value="${projectAccept.designUnit}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							监理单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="supervisionUnit" name="supervisionUnit" ignore="ignore"
							   value="${projectAccept.supervisionUnit}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							施工单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="constructionUnit" name="constructionUnit" ignore="ignore"
							   value="${projectAccept.constructionUnit}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							质量监督机构:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="superviseUnit" name="superviseUnit" ignore="ignore"
							   value="${projectAccept.superviseUnit}">
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开工日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="begindate" name="begindate" ignore="ignore"
							   value="<fmt:formatDate value='${projectAccept.begindate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							竣工日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="enddate" name="enddate" ignore="ignore"
							   value="<fmt:formatDate value='${projectAccept.enddate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							验收日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="acceptDate" name="acceptDate" ignore="ignore"
							   value="<fmt:formatDate value='${projectAccept.acceptDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							质保期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="guarantee" name="guarantee" ignore="ignore"
							   value="<fmt:formatDate value='${projectAccept.guarantee}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							验收内容:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="acceptDetail" name="acceptDetail" ignore="ignore"
							   value="${projectAccept.acceptDetail}">
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
			</table>
		</t:formvalid>
 </body>
 </html>