<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>证章申请信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript">
  	   $(function(){
 	       $("#zzsqinfo tr td").each(function(){
 	           $(this).find("input").attr("disabled",true);
 	           $(this).find("textarea").attr("disabled",true);
 	           $(this).find("checkbox").attr("disabled",true);
  	           $(this).find("select").attr("disabled",true);
 	       });
 	   });
  </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zzsqController.do?save">
			<div class="formtitle" title="证章借用申请">证章借用申请</div>
			<input id="id" name="id" type="hidden" value="${zzsq.id }">
			<table id="zzsqinfo" style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							借用项目:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jyxm" name="jyxm"  datatype="*"
							   value="${zzsq.jyxm}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							使用时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="sysj" name="sysj" 
							   value="<fmt:formatDate value='${zzsq.sysj}' type="date" pattern="yyyy-MM-dd"/>" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							借用用途:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jyyt" name="jyyt" 
							   value="${zzsq.jyyt}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							是否外借:
						</label>
					</td>
					<td class="value">
					<t:dictSelect hasLabel="false" field="isout" id="isout" typeGroupCode="yesorno" defaultVal="${zzsq.isout }"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							借用类型:
						</label>
					</td>
					<td class="value">
						<input type="checkbox" id="jylx" name="jylx" value="${zzsq.jylx}">原件
						<input type="checkbox" id="jylx" name="jylx" value="${zzsq.jylx}">复印及加盖公章
						<input type="checkbox" id="jylx" name="jylx" value="${zzsq.jylx}">盖章
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							使用份数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="syfs" name="syfs" ignore="ignore"
							   value="${zzsq.syfs}">
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
						<textarea class="textarea" id="bz" name="bz" ignore="ignore"
							   value="${zzsq.bz}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
			<div class="formtitle" title="证章借用申请">证章借用申请审批流程</div>
			<div class="easyui-tabs" style="width:auto;height:480px;">
		        <div title="审批步骤" data-options="closable:true" style="overflow:hidden;">
		            <iframe scrolling="yes" frameborder="0"  src="activitiController.do?myViewProcessHistory&processInstanceId=${pid }" style="width:100%;height:100%;"></iframe>
				</div>
		        <div title="审批图" data-options="closable:true" style="overflow:hidden">
		           	<img src="activitiController.do?traceImage&processInstanceId=${pid }&isIframe"> 
		        </div>
	   	 	</div>
		</t:formvalid>
 </body>