<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>证章申请信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  	   $(function(){
 	       $("#wagesDeclare tr td").each(function(){
 	           $(this).find("input").attr("disabled",true);
 	           $(this).find("textarea").attr("disabled",true);
 	           $(this).find("checkbox").attr("disabled",true);
 	           $(this).find("select").attr("disabled",true);
 	       });
 	   });
  </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wagesDeclareController.do?completeTask">
		<div class="formtitle" title="工资申请信息">工资申请信息</div>
		<input id="id" name="id" type="hidden" value="${wagesDeclare.id }">
			<table id="wagesDeclare" style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
					<td align="right">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${wagesDeclare.project.projectName }">
						<input style="width: 230px" id="projectId" name="project.id" value="${wagesDeclare.project.id }" type="hidden">
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
		             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申报人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="declare" name="declare" ignore="ignore"
							   value="${wagesDeclare.declare}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							申报日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="declareDate" name="declareDate" ignore="ignore"
							   value="<fmt:formatDate value='${wagesDeclare.declareDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							月份:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="month" name="month" ignore="ignore"
							   value="${wagesDeclare.month}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							本次申报金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="amount" name="amount" ignore="ignore"
							   value="${wagesDeclare.amount}">
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
						<input class="inputxt" id="guaranteeMoney" name="guaranteeMoney" ignore="ignore"
							   value="${wagesDeclare.guaranteeMoney}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							安全互助金:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="mutualMoney" name="mutualMoney" ignore="ignore"
							   value="${wagesDeclare.mutualMoney}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							施工队:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="constructionTeam" name="constructionTeam" ignore="ignore"
							   value="${wagesDeclare.constructionTeam}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="remarks" name="remarks" ignore="ignore"
							   value="${wagesDeclare.remarks}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
			<div class="formtitle" title="审批信息">审批信息</div>
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<input id="taskKey" name="taskKey" type="hidden" value="${taskKey}">			
				<input id="taskId" name="taskId" type="hidden" value="${taskId}">
				<input id="applyUserId" name="applyUserId" type="hidden" value="${zzsq.sqr}">
				<input id="isout" name="isout" type="hidden" value="${zzsq.isout}">		
				<c:if test="${taskKey=='deptLeaderAudit' || taskKey=='accountantId' || taskKey=='leaderManagerAudit' }">
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