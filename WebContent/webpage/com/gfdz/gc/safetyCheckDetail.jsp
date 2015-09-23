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
						项目名称:
					</label>
				</td>
				<td class="value" colspan="3">
					<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${safetyCheck.project.projectName }">
      			<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						参检人员:
					</label>
				</td>
				<td class="value" colspan="3">
					<input class="inputxt" id="projectManager" name="projectManager" ignore="ignore"
						   value="${safetyCheck.projectManager}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						检查类别:
					</label>
				</td>
				<td class="value" colspan="3">
				<t:dictSelect field="constructionTeam" typeGroupCode="safeTycheckType" hasLabel="false" defaultVal="${safetyCheck.constructionTeam}"></t:dictSelect>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						检查内容:
					</label>
				</td>
				<td class="value" colspan="3">
					<textarea class="textarea" id="qualityMan" name="qualityMan" ignore="ignore"
						   >${safetyCheck.qualityMan}</textarea>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						存在隐患:
					</label>
				</td>
				<td class="value" colspan="3">
					<textarea class="textarea" id="inspectionPlace" name="inspectionPlace" ignore="ignore">${safetyCheck.inspectionPlace}</textarea>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						整改措施:
					</label>
				</td>
				<td class="value" colspan="3">
					<textarea class="textarea" id="question" name="question" ignore="ignore"
						    >${safetyCheck.question}</textarea>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						检查结论:
					</label>
				</td>
				<td class="value" colspan="3">
					<textarea class="textarea" id="conclusion" name="conclusion" ignore="ignore"
						   >${safetyCheck.conclusion}</textarea>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
			<td align="right">
					<label class="Validform_label">
						落实人:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="implementPerson" name="implementPerson" ignore="ignore"
						   value="${safetyCheck.implementPerson}">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						检查日期:
					</label>
				</td>
				<td class="value">
					<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="qualityDate" name="qualityDate" ignore="ignore"
						   value="<fmt:formatDate value='${safetyCheck.qualityDate}' type="date" pattern="yyyy-MM-dd"/>">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
		</table>
		<div class="formtitle" title="基本信息">附件信息</div>
		<table  style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="85px">
				<label class="Validform_label">
					相关附件:
				</label>
			</td>
			<td class="value" colspan="3">
			<table  style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
					<c:forEach items="${safetyCheck.safetyCheckFiles}" var="safetyCheckFile">
							<tr style="height: 25px;">
								<td>${safetyCheckFile.attachmenttitle}</td>
								<td><a href="commonController.do?viewFile&fileid=${safetyCheckFile.id}&subclassname=com.gfdz.entity.gc.SafetyCheckFilesEntity" title="下载">下载</a></td>
							<td><a target="showsafetyCheckFile" href="commonController.do?openViewFile&fileid=${safetyCheckFile.id}&subclassname=com.gfdz.entity.gc.SafetyCheckFilesEntity">预览</a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
		</div>
       <div data-options="region:'center'" style="overflow: hidden;">
        	<iframe scrolling="yes" frameborder="0" name="showsafetyCheckFile" src="commonController.do?openViewFile&fileid=${safetyCheckFileId}&subclassname=com.gfdz.entity.gc.SafetyCheckFilesEntity" style="width:100%;height:100%;"></iframe>
       </div>
   </div>
 </body>
 </html>