<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>面试信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="interviewController.do?save">
			<input id="id" name="id" type="hidden" value="${interview.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							人员编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pId" name="pId" 
							   value="${interview.pId}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							希望待遇:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wantPay" name="wantPay" ignore="ignore"
							   value="${interview.wantPay}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							待遇底线:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="payUnderline" name="payUnderline" ignore="ignore"
							   value="${interview.payUnderline}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							应聘岗位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="position" name="position" ignore="ignore"
							   value="${interview.position}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							对岗位的认识:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="aboutPst" name="aboutPst" ignore="ignore"
							   value="${interview.aboutPst}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							优势特点:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="superiority" name="superiority" ignore="ignore"
							   value="${interview.superiority}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现工作单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="unitNow" name="unitNow" ignore="ignore"
							   value="${interview.unitNow}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							现职业状况:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="uStatus" name="uStatus" ignore="ignore"
							   value="${interview.uStatus}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							离职原因:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="reasonL" name="reasonL" ignore="ignore"
							   value="${interview.reasonL}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							到岗时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="posTime" name="posTime" ignore="ignore"
							   value="${interview.posTime}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							性格:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="character" name="character" ignore="ignore"
							   value="${interview.character}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							形象气质:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="form" name="form" ignore="ignore"
							   value="${interview.form}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							态度举止:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="manner" name="manner" ignore="ignore"
							   value="${interview.manner}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							表达方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="expression" name="expression" ignore="ignore"
							   value="${interview.expression}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							问题解决能力:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="dealAb" name="dealAb" ignore="ignore"
							   value="${interview.dealAb}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							表达能力:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="expAb" name="expAb" ignore="ignore"
							   value="${interview.expAb}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司比重:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="uScale" name="uScale" ignore="ignore"
							   value="${interview.uScale}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							个人比重:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pScale" name="pScale" ignore="ignore"
							   value="${interview.pScale}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							薪酬比重:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="mScale" name="mScale" ignore="ignore"
							   value="${interview.mScale}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							人际比重:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="rScale" name="rScale" ignore="ignore"
							   value="${interview.rScale}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							其他:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="other" name="other" ignore="ignore"
							   value="${interview.other}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							其他比重:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="oScale" name="oScale" ignore="ignore"
							   value="${interview.oScale}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							抗压能力:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="antiPres" name="antiPres" ignore="ignore"
							   value="${interview.antiPres}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							解压方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="extractWay" name="extractWay" ignore="ignore"
							   value="${interview.extractWay}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							吃苦能力:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="willpower" name="willpower" ignore="ignore"
							   value="${interview.willpower}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							其他描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="back" name="back" ignore="ignore"
							   value="${interview.back}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							考题方案评价:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="examine" name="examine" ignore="ignore"
							   value="${interview.examine}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							结果:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="result" name="result" ignore="ignore"
							   value="${interview.result}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							语言:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="language" name="language" ignore="ignore"
							   value="${interview.language}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							声音:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="voice" name="voice" ignore="ignore"
							   value="${interview.voice}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							行为:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="behavior" name="behavior" ignore="ignore"
							   value="${interview.behavior}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							倾听能力:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="listen" name="listen" ignore="ignore"
							   value="${interview.listen}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							思维能力:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="thinking" name="thinking" ignore="ignore"
							   value="${interview.thinking}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							性格补充:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="oCharacter" name="oCharacter" ignore="ignore"
							   value="${interview.oCharacter}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							语言补充:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="oLanguage" name="oLanguage" ignore="ignore"
							   value="${interview.oLanguage}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							形象气质补充:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="oForm" name="oForm" ignore="ignore"
							   value="${interview.oForm}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							态度举止补充:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="oManner" name="oManner" ignore="ignore"
							   value="${interview.oManner}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							行为补充:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="oBehavior" name="oBehavior" ignore="ignore"
							   value="${interview.oBehavior}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							表达方式补充:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="oExpression" name="oExpression" ignore="ignore"
							   value="${interview.oExpression}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							解决能力补充:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="oDealAb" name="oDealAb" ignore="ignore"
							   value="${interview.oDealAb}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							倾听补充:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="oListen" name="oListen" ignore="ignore"
							   value="${interview.oListen}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							思维补充:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="oThinking" name="oThinking" ignore="ignore"
							   value="${interview.oThinking}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							试用工资:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="entryPay" name="entryPay" ignore="ignore"
							   value="${interview.entryPay}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							试用期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="entryDate" name="entryDate" ignore="ignore"
							   value="<fmt:formatDate value='${interview.entryDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>