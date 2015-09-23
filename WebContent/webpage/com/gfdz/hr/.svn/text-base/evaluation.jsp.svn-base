<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>转正考评</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="evaluationController.do?save">
 		 <div class="formtitle" title="考核评分信息">考核评分信息<div>
			<input id="id" name="id" type="hidden" value="${evaluation.id }">
			<input type="hidden" id="pId" name="pId"  value="${param.personId}">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
				<td align="right">
						<label class="Validform_label">
							被考评人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pname" name="mane" ignore="ignore"
							   value="${username}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							考评人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="epId" name="epId" ignore="ignore"
							   value="${evaluation.epId}">
						<span class="Validform_checktip"></span>
					</td>
				<td align="right">
						<label class="Validform_label">
							部门:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="deptId" name="deptId" ignore="ignore"
							   value="${evaluation.deptId}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							考评时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="evTime" name="evTime" ignore="ignore"
							   value="<fmt:formatDate value='${evaluation.evTime}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				
					<td align="right">
						<label class="Validform_label">
							工作质量得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pQuality" name="pQuality" ignore="ignore"
							   value="${evaluation.pQuality}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							工作质量说明:
						</label>
					</td>
					<td class="value" >
						<textarea class="textarea" id="eQuality" name="eQuality" ignore="ignore"
							   value="${evaluation.eQuality}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							工作数量得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pQuantity" name="pQuantity" ignore="ignore"
							   value="${evaluation.pQuantity}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							工作数量说明:
						</label>
					</td>
					<td class="value">
						<textarea class="textarea" id="eQuantity" name="eQuantity" ignore="ignore"
							   value="${evaluation.eQuantity}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							纪律性得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pDiscipline" name="pDiscipline" ignore="ignore"
							   value="${evaluation.pDiscipline}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							纪律性说明:
						</label>
					</td>
					<td class="value">
						<textarea class="textarea" id="eDiscipline" name="eDiscipline" ignore="ignore"
							   value="${evaluation.eDiscipline}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							集体观念得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pCollective" name="pCollective" ignore="ignore"
							   value="${evaluation.pCollective}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							集体观念说明:
						</label>
					</td>
					<td class="value">
						<textarea class="textarea" id="eCollective" name="eCollective" ignore="ignore"
							   value="${evaluation.eCollective}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							积极性得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pPositivity" name="pPositivity" ignore="ignore"
							   value="${evaluation.pPositivity}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							积极性说明:
						</label>
					</td>
					<td class="value">
						<textarea class="textarea" id="ePositivity" name="ePositivity" ignore="ignore"
							   value="${evaluation.ePositivity}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							责任感得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pResponsibility" name="pResponsibility" ignore="ignore"
							   value="${evaluation.pResponsibility}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							责任感说明:
						</label>
					</td>
					<td class="value">
						<textarea class="textarea" id="eResponsibility" name="eResponsibility" ignore="ignore"
							   value="${evaluation.eResponsibility}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							知识得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pKnowledge" name="pKnowledge" ignore="ignore"
							   value="${evaluation.pKnowledge}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							知识说明:
						</label>
					</td>
					<td class="value">
						<textarea class="textarea" id="eKnowledge" name="eKnowledge" ignore="ignore"
							   value="${evaluation.eKnowledge}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							判断得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pJudge" name="pJudge" ignore="ignore"
							   value="${evaluation.pJudge}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							判断说明:
						</label>
					</td>
					<td class="value">
						<textarea class="textarea" id="eJudge" name="eJudge" ignore="ignore"
							   value="${evaluation.eJudge}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							计划得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pPlan" name="pPlan" ignore="ignore"
							   value="${evaluation.pPlan}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							计划说明:
						</label>
					</td>
					<td class="value">
						<textarea class="textarea" id="ePlan" name="ePlan" ignore="ignore"
							   value="${evaluation.ePlan}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							人际得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pRelationships" name="pRelationships" ignore="ignore"
							   value="${evaluation.pRelationships}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							人际说明:
						</label>
					</td>
					<td class="value">
						<textarea class="textarea" id="eRelationships" name="eRelationships" ignore="ignore"
							   value="${evaluation.eRelationships}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							成绩得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pPerformance" name="pPerformance" ignore="ignore"
							   value="${evaluation.pPerformance}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							成绩比例:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="rPerformance" name="rPerformance" ignore="ignore"
							   value="${evaluation.rPerformance}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							成绩评分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sPerformance" name="sPerformance" ignore="ignore"
							   value="${evaluation.sPerformance}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							态度得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pAttitude" name="pAttitude" ignore="ignore"
							   value="${evaluation.pAttitude}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							态度比例:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="rAttitude" name="rAttitude" ignore="ignore"
							   value="${evaluation.rAttitude}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							态度评分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sAttitude" name="sAttitude" ignore="ignore"
							   value="${evaluation.sAttitude}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							能力得分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pCapability" name="pCapability" ignore="ignore"
							   value="${evaluation.pCapability}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							能力比例:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="rCapability" name="rCapability" ignore="ignore"
							   value="${evaluation.rCapability}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							能力评分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sCapability" name="sCapability" ignore="ignore"
							   value="${evaluation.sCapability}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							个人评分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sPersonal" name="sPersonal" ignore="ignore"
							   value="${evaluation.sPersonal}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							综合评分:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sTotal" name="sTotal" ignore="ignore"
							   value="${evaluation.sTotal}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
<!-- 				<tr> -->
<!-- 				<td class="upload" colspan="8" align="center"><a href="#" class="easyui-linkbutton" id="btn" iconCls="icon-ok">提交</a> <a href="#" class="easyui-linkbutton" id="btn_reset" iconCls="icon-back">重置</a></td> -->
<!-- 				</tr> -->
			</table>
		</t:formvalid>
 </body>