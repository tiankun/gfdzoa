<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>请假管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/kindeditor/kindeditor.js"></script>
  <script type="text/javascript" src="plug-in/kindeditor/lang/zh_CN.js"></script>
      <script type="text/javascript">
 	   $(function(){
 	       $("#qualityRetention tr td").each(function(){
 	           $(this).find("input").attr("disabled",true);
 	           $(this).find("textarea").attr("disabled",true);
 	       });
 	   });
    </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
 <div class="formtitle">工资申请信息</div>	
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="qualityRetentionHandle.do?completeTask">
		<div class="formtitle">基本信息</div>
		<input id="id" name="id" type="hidden" value="${qualityRetention.id }">
		<table id="qualityRetention" style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right">
					<label class="Validform_label">
						项目名称:
					</label>
				</td>
				<td class="value" colspan="3">
					<input class="inputxt" id="projectId" name="projectId" ignore="ignore"
						   value="${qualityRetention.projectId}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						质保金:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="retentionMoney" name="retentionMoney" ignore="ignore"
						   value="${qualityRetention.retentionMoney}" datatype="d">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						申请金额:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="applyMoney" name="applyMoney" ignore="ignore"
						   value="${qualityRetention.applyMoney}" datatype="d">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						批准金额:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="approvalMoney" name="approvalMoney" ignore="ignore"
						   value="${qualityRetention.approvalMoney}" datatype="d">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						核对金额:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="checkMoney" name="checkMoney" ignore="ignore"
						   value="${qualityRetention.checkMoney}" datatype="d">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						申请人:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="applyPerson" name="applyPerson" ignore="ignore"
						   value="${qualityRetention.applyPerson}">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						申请日期:
					</label>
				</td>
				<td class="value">
					<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="applyDate" name="applyDate" ignore="ignore"
						   value="<fmt:formatDate value='${qualityRetention.applyDate}' type="date" pattern="yyyy-MM-dd"/>">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label class="Validform_label">
						操作组:
					</label>
				</td>
				<td class="value" colspan="3">
					<input class="inputxt" id="actionGroup" name="actionGroup" ignore="ignore"
						   value="${qualityRetention.actionGroup}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						备注:
					</label>
				</td>
				<td class="value" colspan="3">
					<input class="inputxt" id="remark" name="remark" ignore="ignore"
						   value="${qualityRetention.remark}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
		</table>
		<div class="formtitle">审批流程</div>	
	<div class="easyui-tabs" style="width:auto;height:480px">
      		<div title="审批步骤" data-options="closable:true" style="overflow:hidden;">
	            <iframe scrolling="yes" frameborder="0"  src="activitiController.do?myViewProcessHistory&processInstanceId=${pid }" style="width:100%;height:100%;"></iframe>
		</div>
        <div title="审批图" data-options="closable:true" style="overflow:hidden">
           	<img src="activitiController.do?traceImage&processInstanceId=${pid }&isIframe"> 
        </div>
  	 	</div>
	</t:formvalid>
 </body>