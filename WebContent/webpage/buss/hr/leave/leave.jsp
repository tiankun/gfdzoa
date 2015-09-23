<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>请假表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="leaveController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${leave.id }">
					<input id="createName" name="createName" type="hidden" value="${leave.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${leave.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${leave.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${leave.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${leave.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${leave.updateDate }">
				<input id="processKey" name="processKey" type="hidden" value="${processKey }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假原因:
						</label>
					</td>
					<td class="value">
					     	 <input id="leaveReason" name="leaveReason" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请假原因</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="leaveType" name="leaveType" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请假类型</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开始时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="leaveBeginDate" name="leaveBeginDate" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开始时间</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							结束时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="leaveEndDate" name="leaveEndDate" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结束时间</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/leave/leave.js"></script>		