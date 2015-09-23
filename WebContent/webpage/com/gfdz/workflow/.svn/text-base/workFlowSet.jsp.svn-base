<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>流程设置</title>
  <t:base type="jquery,easyui,tools"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="workFlowSetController.do?save">
			<input id="id" name="id" type="hidden" value="${workFlowSet.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr style="display: none">
					<td align="right" >
						<label class="Validform_label">
							部署id:
						</label>
					</td>
					<td class="value">
						<input readonly="readonly"  class="inputxt" id="deploymentId" name="deploymentId" ignore="ignore"
							   value="${workFlowSet.deploymentId !=null ? workFlowSet.deploymentId :deploymentId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr style="display: none">
					<td align="right">
						<label class="Validform_label">
							流程key:
						</label>
					</td>
					<td class="value">
						<input readonly="readonly"  class="inputxt" id="processKey" name="processKey" ignore="ignore"
							   value="${workFlowSet.processKey !=null ? workFlowSet.processKey : processKey}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr style="display: none">
					<td align="right">
						<label class="Validform_label">
							流程定义id:
						</label>
					</td>
					<td class="value">
						<input readonly="readonly" class="inputxt" id="processDefinitionId" name="processDefinitionId" ignore="ignore"
							   value="${workFlowSet.processDefinitionId !=null ?workFlowSet.processDefinitionId : processDefinitionId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right"  style="width: 120px">
						<label class="Validform_label">
							流程分类:
						</label>
					</td>
					<td class="value">
					<t:dictSelect hasLabel="false" field="processType" id="processType" typeGroupCode="flowType" defaultVal="${workFlowSet.processType}"></t:dictSelect>
<%-- 						<input class="inputxt" id="processType" name="processType" ignore="ignore" value="${workFlowSet.processType}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							流程名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" style="width:90%" id="processName" name="processName" ignore="ignore"
							   value="${workFlowSet.processName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开始请求:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" style="width:90%" id="beginUrl" name="beginUrl" ignore="ignore"
							   value="${workFlowSet.beginUrl}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							处理请求:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" style="width:90%" id="handleUrl" name="handleUrl" ignore="ignore"
							   value="${workFlowSet.handleUrl}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							查看请求:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" style="width:90%" id="detailUrl" name="detailUrl" ignore="ignore"
							   value="${workFlowSet.detailUrl}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
		<tr>
					<td align="right">
						<label class="Validform_label">
							开始路径:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" style="width:90%" id="beginPath" name="beginPath" ignore="ignore"
							   value="${workFlowSet.beginPath}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							处理路径:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" style="width:90%" id="handlePath" name="handlePath" ignore="ignore"
							   value="${workFlowSet.handlePath}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							查看路径:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" style="width:90%" id="detailPath" name="detailPath" ignore="ignore"
							   value="${workFlowSet.detailPath}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							对应实体:
						</label>
					</td>
					<td class="value">
					<input class="inputxt" style="width:90%" id="entityName" name="entityName" ignore="ignore"
							   value="${workFlowSet.entityName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							流程说明:
						</label>
					</td>
					<td class="value">
						<textarea class="textarea" id="processExplain" name="processExplain" ignore="ignore"
						style="width:90%" value="${workFlowSet.processExplain}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>