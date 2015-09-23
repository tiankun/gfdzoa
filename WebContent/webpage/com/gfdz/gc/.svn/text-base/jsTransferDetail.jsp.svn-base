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
					<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${jsTransfer.project.projectName }">
	      			<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							交底时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="transferTiem" name="transferTiem" ignore="ignore"
							   value="<fmt:formatDate value='${jsTransfer.transferTiem}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							交底人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lecturer" name="lecturer" ignore="ignore"
							   value="${jsTransfer.lecturer}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注说明:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="remarks" name="remarks" ignore="ignore"
							   >${jsTransfer.remarks}</textarea>
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
						<input type="hidden" value="${jsTransfer.id}" id="transferId" name="transferId" />
						<table  cellpadding="0" cellspacing="1" class="formtable">
							<c:forEach items="${jsTransfer.jsTransferFiles}" var="jsTransferFile">
								<tr style="height: 25px;">
									<td>${jsTransferFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${jsTransferFile.id}&subclassname=com.gfdz.entity.gc.JsTransferFilesEntity" title="下载">下载</a></td>
								<td><a target="showJsTransferFile" href="commonController.do?openViewFile&fileid=${jsTransferFile.id}&subclassname=com.gfdz.entity.gc.JsTransferFilesEntity">预览</a></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
			</div>
        <div data-options="region:'center'" style="overflow: hidden;">
         	<iframe scrolling="yes" frameborder="0" name="showJsTransferFile" src="commonController.do?openViewFile&fileid=${jsTransferFileId}&subclassname=com.gfdz.entity.gc.JsTransferFilesEntity" style="width:100%;height:100%;"></iframe>
        </div>
    </div>
 </body>
 </html>