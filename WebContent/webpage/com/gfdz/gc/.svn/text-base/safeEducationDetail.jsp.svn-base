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
						<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${safeEducation.project.projectName }">
	      			<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							主讲人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lecturer" name="lecturer" ignore="ignore"
							   value="${safeEducation.lecturer}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							培训类别:
						</label>
					</td>
					<td class="value">
					<t:dictSelect field="educationType" typeGroupCode="safeEducationType" hasLabel="false" defaultVal="${safeEducation.educationType}"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							受教育人:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="trainee" name="trainee" ignore="ignore"
							   >${safeEducation.trainee}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="right" >
						<label class="Validform_label">
							教育内容:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="educationContent" name="educationContent" ignore="ignore"
							   >${safeEducation.educationContent}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							培训日期:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="educationDate" name="educationDate" ignore="ignore"
							     value="<fmt:formatDate value='${safeEducation.educationDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
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
						<c:forEach items="${safeEducation.safeEducationFiles}" var="safeEducationFile">
								<tr style="height: 25px;">
									<td>${safeEducationFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${safeEducationFile.id}&subclassname=com.gfdz.entity.gc.SafeEducationFilesEntity" title="下载">下载</a></td>
								<td><a target="showSafeEducationFile" href="commonController.do?openViewFile&fileid=${safeEducationFile.id}&subclassname=com.gfdz.entity.gc.SafeEducationFilesEntity">预览</a></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
			</div>
        <div data-options="region:'center'" style="overflow: hidden;">
         	<iframe scrolling="yes" frameborder="0" name="showSafeEducationFile" src="commonController.do?openViewFile&fileid=${safeEducationFileId}&subclassname=com.gfdz.entity.gc.SafeEducationFilesEntity" style="width:100%;height:100%;"></iframe>
        </div>
    </div>
 </body>
 </html>