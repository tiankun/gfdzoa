<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>工程计划表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <link href="plug-in/Validform/css/tablefrom.css" rel="stylesheet" type="text/css"><link>
 </head>
 <body style="overflow-y: hidden" scroll="no">
			<div class="easyui-layout" border="false" fit="true">
        	 <div data-options="region:'west',split:true" style="width:520px;padding: 5px;">
			<table style="width: 500px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value" colspan="3">
					<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${projectTask.project.projectName }">
	      			<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							费用总额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="totalCost" name="totalCost" ignore="ignore"
							   value="${projectTask.totalCost}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							填报日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="createDate" name="createDate" ignore="ignore"
						   value="<fmt:formatDate value='${projectTask.createDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							责任人:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="responsible" name="responsible" ignore="ignore"
							   value="${projectTask.responsible}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							附件:
						</label>
					</td>
					<td class="value" colspan="3">
						<input type="hidden" value="${projectTask.id}" id="projectTaskId" name="projectTaskId" />
						<table  cellpadding="0" cellspacing="1" class="formtable">
							<c:forEach items="${projectTask.projectTaskFiles}" var="projectTaskFile">
								<tr style="height: 25px;">
									<td>${projectTaskFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${projectTaskFile.id}&subclassname=com.gfdz.entity.gc.ProjectTaskFilesEntity" title="下载">下载</a></td>
									<td><a target="showFile" href="commonController.do?openViewFile&fileid=${projectTaskFile.id}&subclassname=com.gfdz.entity.gc.ProjectTaskFilesEntity">预览</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</table>
			</div>
        <div data-options="region:'center'" style="overflow: hidden;">
         	<iframe scrolling="yes" frameborder="0" name="showFile" src="commonController.do?openViewFile&fileid=${projectTaskFile}&subclassname=com.gfdz.entity.gc.ProjectTaskFilesEntity" style="width:100%;height:100%;"></iframe>
        </div>
    </div>
 </body>
 </html>