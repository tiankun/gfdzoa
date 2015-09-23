<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>证章申请信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  	   $(function(){
 	       $("#qualityRetention tr td").each(function(){
 	           $(this).find("input").attr("disabled",true);
 	           $(this).find("textarea").attr("disabled",true);
 	           $(this).find("checkbox").attr("disabled",true);
 	           $(this).find("select").attr("disabled",true);
 	       });
 	   });
  </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="qualityRetentionController.do?completeTask">
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
			<div class="formtitle" title="审批信息">审批信息</div>
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<input id="taskKey" name="taskKey" type="hidden" value="${taskKey}">			
				<input id="taskId" name="taskId" type="hidden" value="${taskId}">
				<c:if test="${taskKey=='deptLeaderAudit' || taskKey=='accountantId' || taskKey=='leaderManagerAudit'}">
						<tr>
							<td align="right" width="60px">
								<label class="Validform_label">
									审批结果:
								</label>
							</td>
							<td class="value">
							<t:dictSelect hasLabel="false" field="auditType" id="auditType" typeGroupCode="auditType" defaultVal=""></t:dictSelect>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label class="Validform_label">
									审批意见:
								</label>
							</td>
							<td class="value">
							<textarea class="textarea" id="postil" name="postil"></textarea>
							</td>
						</tr>
				</c:if>	
				</table>
		</t:formvalid>
 </body>