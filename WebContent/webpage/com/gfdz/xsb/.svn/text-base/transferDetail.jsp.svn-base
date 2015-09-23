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
					<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${transfer.project.projectName }">
	      			<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
					<label class="Validform_label">
						合同编号:
					</label>
				</td>
				<td class="value">
					 <input class="inputxt" id="agreementNumber" name="agreementNumber" ignore="ignore"
					   value="${transfer.project.agreementNumber}">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						项目金额:
					</label>
				</td>
				<td class="value">
					  <input class="inputxt" id="moneyAmount" name="project.moneyAmount" ignore="ignore"
					   value="${transfer.project.moneyAmount}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			   <tr>
				<td align="right">
					<label class="Validform_label">
						项目类型:
					</label>
				</td>
				<td class="value">
					<t:dictSelect hasLabel="false"  field="project.projectType" id="projectType" typeGroupCode="projectType" defaultVal="${transfer.project.projectType }" extendJson="{\"class\":\"validate[required]\"}"></t:dictSelect>
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						建设内容:
					</label>
				</td>
				<td class="value">
					<t:dictSelect hasLabel="false"  field="project.buildType" id="buildType" typeGroupCode="buildType" defaultVal="${transfer.project.buildType }" extendJson="{\"class\":\"validate[required]\"}"></t:dictSelect>
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
					<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="transferDate" name="transferDate" ignore="ignore"
						   value="<fmt:formatDate value='${transfer.transferDate}' type="date" pattern="yyyy-MM-dd"/>">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						交底人:
					</label>
				</td>
				<td class="value">
					  <input class="inputxt" id="operator" name="operator" ignore="ignore"
					   value="${transfer.operator}">
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
						<input type="hidden" value="${transfer.id}" id="transferId" name="transferId" />
					<table  cellpadding="0" cellspacing="1" class="formtable">
						<c:forEach items="${transfer.transferFiles}" var="transferFile">
							<tr style="height: 25px;">
								<td>${transferFile.attachmenttitle}</td>
								<td><a href="commonController.do?viewFile&fileid=${transferFile.id}&subclassname=com.gfdz.entity.gc.TransferFilesEntity" title="下载">下载</a></td>
								<td><a target="showTransferFile" href="commonController.do?openViewFile&fileid=${transferFile.id}&subclassname=com.gfdz.entity.gc.TransferFilesEntity">预览</a></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
			</div>
        <div data-options="region:'center'" style="overflow: hidden;">
         	<iframe scrolling="yes" frameborder="0" name="showTransferFile" src="commonController.do?openViewFile&fileid=${transferFileId}&subclassname=com.gfdz.entity.gc.TransferFilesEntity" style="width:100%;height:100%;"></iframe>
        </div>
    </div>
 </body>
 </html>