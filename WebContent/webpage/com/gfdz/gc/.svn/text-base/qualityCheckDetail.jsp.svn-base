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
						<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${qualityCheck.project.projectName }">
	      			<span class="Validform_checktip"></span>
					</td>
					</tr>
					<tr>
					<td align="right">
						<label class="Validform_label">
							项目经理:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="projectManager" name="projectManager" ignore="ignore"
							   value="${qualityCheck.projectManager}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							质检员:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="qualityPerson" name="qualityPerson" ignore="ignore"
							   value="${qualityCheck.qualityPerson}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							操作组:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="constructionTeam" name="constructionTeam" ignore="ignore"
							   value="${qualityCheck.constructionTeam}">
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							检查地点:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="inspectionPlace" name="inspectionPlace" ignore="ignore"
							   value="${qualityCheck.inspectionPlace}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							巡检日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="qualityDate" name="qualityDate" ignore="ignore"
							   value="<fmt:formatDate value='${qualityCheck.qualityDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							问题描述:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="question" name="question" ignore="ignore">${qualityCheck.question}</textarea>
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
						<c:forEach items="${qualityCheck.qualityCheckFiles}" var="qualityCheckFile">
								<tr style="height: 25px;">
									<td>${qualityCheckFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${qualityCheckFile.id}&subclassname=com.gfdz.entity.gc.QualityCheckFilesEntity" title="下载">下载</a></td>
								<td><a target="showqualityCheckFile" href="commonController.do?openViewFile&fileid=${qualityCheckFile.id}&subclassname=com.gfdz.entity.gc.QualityCheckFilesEntity">预览</a></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
			</div>
        <div data-options="region:'center'" style="overflow: hidden;">
         	<iframe scrolling="yes" frameborder="0" name="showqualityCheckFile" src="commonController.do?openViewFile&fileid=${qualityCheckFileId}&subclassname=com.gfdz.entity.gc.QualityCheckFilesEntity" style="width:100%;height:100%;"></iframe>
        </div>
    </div>
 </body>
 </html>