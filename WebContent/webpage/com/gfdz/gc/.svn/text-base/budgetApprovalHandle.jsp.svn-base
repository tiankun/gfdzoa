<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>预算审批表附件</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
    $(function(){
    	$("#budgetTab tr td").find("input,select").attr("disabled","disabled");
    });
    
    $(window).resize(function(){
    	$('#tabs').tabs('resize',{width: '100%',height:($(window).height()-35)});  
     });
  </script>
  <style type="text/css">
  html,body,form{
     height: 100%;
     padding: 0px;
     margin: 0px;
  }
  </style>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" tiptype="3" layout="table" action="budgetApprovalController.do?completeTask">
	<input id="id" name="id" type="hidden" value="${page.id}">
	<div id="tabs" class="easyui-tabs" fit="true">
    <div title="采购申请">
        <div class="easyui-layout" border="false" fit="true">
         <div data-options="region:'east',split:true" style="width:440px;padding: 5px;">
			 <table style="width: 100%;margin-bottom: 5px" cellpadding="0" cellspacing="1" class="formtable" id="budgetTab" >
				<tr>
					<td align="right" style="width: 85px">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value" colspan="2">
						<input class="inputxt" id="projectId" name="projectId" value="${page.project.projectName}">
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							建设单位:
						</label>
					</td>
					<td class="value" colspan="2">
						<input class="inputxt" id="construction" name="construction" ignore="ignore"
							   value="${page.construction}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							编制说明:
						</label>
					</td>
					<td class="value" colspan="2">
						<input class="inputxt" id="remark" name="remark" ignore="ignore"
							   value="${page.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							编制人:
						</label>
					</td>
					<td class="value" colspan="2">
						<input class="inputxt" id="compilin" name="compilin" ignore="ignore"
							   value="${page.compilin}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							编制日期:
						</label>
					</td>
					<td class="value" colspan="2">
						<input class="inputxt" onClick="WdatePicker()"  style="width: 150px" id="compilingDate" name="compilingDate"
							   value="<fmt:formatDate value='${page.compilingDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		 <div class="easyui-panel" title="审批信息" style="width:auto;height:auto;overflow: hidden;" data-options="doSize:false">
	     <table style="width: 100%;margin: -1px" cellpadding="0" cellspacing="1" class="formtable">
		  <tr>
			<td align="right" style="width: 85px">
				<label class="Validform_label">
					审批结果:
				</label>
			</td>
			<td class="value">
			<input id="taskKey" name="taskKey" type="hidden" value="${param.taskKey}">			
			<input id="taskId" name="taskId" type="hidden" value="${param.taskId}">			
			<t:dictSelect hasLabel="false" field="auditType" extendJson="{datatype:'*'}" id="auditType" typeGroupCode="auditType" defaultVal=""></t:dictSelect>
			<span class="Validform_checktip"></span>
			</td>
			</tr>
			<tr>
			<td align="right">
				<label class="Validform_label">
					审批意见 ：
				</label>
			</td>
			<td class="value">
			   <textarea class="inputxt" name="postil" datatype="*" style="width: 80%"></textarea>
				<span class="Validform_checktip"></span>
			</td>
		</tr>
	</table>
  </div>  
        </div>
        <div data-options="region:'center'" style="overflow: hidden;">
         <iframe scrolling="yes" frameborder="0"  src="commonController.do?openViewFile&fileid=${fileId}&subclassname=com.gfdz.entity.gc.BudgetApprovalFilesEntity" style="width:100%;height:100%;"></iframe>
        </div>
    </div>
	</div>
	<div id="bz" title="审批记录" data-options="closable:true" style="overflow:hidden;">
           <iframe scrolling="yes" frameborder="0"  src="activitiController.do?myViewProcessHistory&processInstanceId=${param.processInstanceId}" style="width:100%;height:100%;"></iframe>
	   </div>
       <div id="png" title="审批图" data-options="closable:true" style="">
          	<img src="activitiController.do?traceImage&processInstanceId=${param.processInstanceId}"> 
       </div>
	</div>
   </t:formvalid>
 </body>
 </html>