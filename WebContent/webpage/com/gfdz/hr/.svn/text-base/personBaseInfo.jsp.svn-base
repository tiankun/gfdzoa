<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>人员信息表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>

 </head>
 <body style="overflow-y: hidden" scroll="no">
 <t:formvalid formid="formobj" layout="table" dialog="false" action="personInfoController.do?save" btnsub="btn" callback="callbackFun">
			<div class="formtitle" title="基本信息">人员基本信息</div>
			<input id="id" name="id" type="hidden" value="${personInfo.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right" width="135px">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="realName" name="realName" ignore="ignore"
							   value="${personInfo.realName}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right" width="135px">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
				<t:dictSelect hasLabel="false" field="sex" id="sex" typeGroupCode="sex" defaultVal="${personInfo.sex }"></t:dictSelect>
<!-- 						<input class="inputxt" id="sex" name="sex" ignore="ignore" -->
<%-- 							   value="${personInfo.sex}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出生日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="birthday" name="birthday" ignore="ignore"
							     value="<fmt:formatDate value='${personInfo.birthday}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							民族:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nation" name="nation" ignore="ignore"
							   value="${personInfo.nation}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							身份证号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="idCard" name="idCard" ignore="ignore"
							   value="${personInfo.idCard}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							婚否:
						</label>
					</td>
					<td class="value">
						<t:dictSelect hasLabel="false" field="ismarried" id="ismarried" typeGroupCode="yesorno" defaultVal="${personInfo.ismarried }"></t:dictSelect>
<!-- 						<input class="inputxt" id="ismarried" name="ismarried" ignore="ignore" -->
<%-- 							   value="${personInfo.ismarried}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							政治面貌:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="politics" name="politics" ignore="ignore"
							   value="${personInfo.politics}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							健康状况:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="health" name="health" ignore="ignore"
							   value="${personInfo.health}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							籍贯:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="nativePlace" name="nativePlace" ignore="ignore"
							   value="${personInfo.nativePlace}">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="right">
						<label class="Validform_label">
							家庭住址:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="homeAddr" name="homeAddr" ignore="ignore"
							   value="${personInfo.homeAddr}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					
					<td align="right">
						<label class="Validform_label">
							紧急联系人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="contact" name="contact" ignore="ignore"
							   value="${personInfo.contact}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							联系电话:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="homePhone" name="homePhone" ignore="ignore"
							   value="${personInfo.homePhone}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				</table>
				<div class="formtitle" title="基本信息">学历及工作基本信息</div>
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right" width="135px">
						<label class="Validform_label">
							毕业学校:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shcool" name="shcool" ignore="ignore"
							   value="${personInfo.shcool}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right" width="135px">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="education" name="education" ignore="ignore"
							   value="${personInfo.education}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							专业:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="major" name="major" ignore="ignore"
							   value="${personInfo.major}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							第二学历/专业:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="secondMajor" name="secondMajor" ignore="ignore"
							   value="${personInfo.secondMajor}">
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
						<input class="inputxt" id="nowUnit" name="nowUnit" ignore="ignore"
							   value="${personInfo.nowUnit}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							现职业状况:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="workState" name="workState" ignore="ignore"
							   value="${personInfo.workState}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				</tr>
					<td align="right">
						<label class="Validform_label">
							希望待遇:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="expectSalary" name="expectSalary" ignore="ignore"
							   value="${personInfo.expectSalary}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							最低试用期工资:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="minSalary" name="minSalary" ignore="ignore"
							   value="${personInfo.minSalary}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							可到岗日期:
						</label>
					</td>
					<td class="value">
					<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="arrivalDate" name="arrivalDate" ignore="ignore"
							     value="<fmt:formatDate value='${personInfo.arrivalDate}' type="date" pattern="yyyy-MM-dd"/>">
<!-- 						<input class="inputxt" id="arrivalDate" name="arrivalDate" ignore="ignore" -->
<%-- 							   value="${personInfo.arrivalDate}"> --%>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							人员状态:
						</label>
					</td>
					<td class="value">
					<t:dictSelect hasLabel="false" field="personState" id="personState" typeGroupCode="persontype" defaultVal="${personInfo.personState }"></t:dictSelect>
<!-- 						<input class="inputxt" id="personState" name="personState" ignore="ignore" -->
<%-- 							   value="${personInfo.personState}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
				<td align="right">
						<label class="Validform_label">
							离职原因:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="leaveReason" name="leaveReason" ignore="ignore"
							   value="${personInfo.leaveReason}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td class="upload" colspan="4" align="center"><a href="#" class="easyui-linkbutton" id="btn" iconCls="icon-ok">提交</a> <a href="#" class="easyui-linkbutton" id="btn_reset" iconCls="icon-back">重置</a></td>
				</tr>
			</table>
	<script type="text/javascript">
	  function callbackFun(data) {
		  top.tip(data.msg);
		  window.location.href="personInfoController.do?addorupdate&personId="+data.attributes.personid;
		}
	 </script>
		</t:formvalid>
 </body>