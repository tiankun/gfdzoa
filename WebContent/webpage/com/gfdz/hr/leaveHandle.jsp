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
            var editor;
            KindEditor.ready(function(K) {
            	editor = K.create('#leaveReasons', {
            		resizeType : 2,
            		minWidth:630,
            		width:'550px',
            		height:'150px',
            		filePostName:'file',
            		themeType : 'simple',
            		readonlyMode : true,
            		uploadJson:'uploadFileController.do?uploadImg',
            		afterBlur : function(url) {
                        $("#leaveReason").val(editor.html());
					},
            		items : [
            			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
            			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            			'insertunorderedlist', '|', 'emoticons', 'image','multiimage','link','fullscreen']
            	});
            });
        });
 	   $(function(){
 	       $("#leaveinfo tr td").each(function(){
 	           $(this).find("input").attr("disabled",true);
 	           $(this).find("textarea").attr("disabled",true);
 	       });
 	   });
    </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
 <div class="formtitle">请假信息</div>	
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="leaveController.do?completeTask">
			<input id="id" name="id" type="hidden" value="${leave.id }">
			<table id="leaveinfo" style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假类型:
						</label>
					</td>
					<td class="value" colspan="3">
							<input class="inputxt" id="leaveUser" name="leaveUser" value="${leave.leaveType.typeName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="leaveUser" name="leaveUser" ignore="ignore"
							   value="${leave.leaveUser.realName}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							请假天数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="leaveDay" name="leaveDay" ignore="ignore"
							   value="${leave.leaveDays}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开始时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="beginDate" name="beginDate" ignore="ignore"
							     value="<fmt:formatDate value='${leave.beginDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							开始区间:
						</label>
					</td>
					<td class="value">
						上午<input type="radio"  name="beginScope" checked="${leave.beginScope ==0 ?'checked':''}" value="0">
						下午<input type="radio"   name="beginScope" checked="${leave.beginScope ==1 ?'checked':''}"  value="1">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							结束时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="endDate" name="endDate" ignore="ignore"
							     value="<fmt:formatDate value='${leave.endDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							结束区间:
						</label>
					</td>
					<td class="value">
						上午<input  type="radio"  name="endScope" checked="${leave.endScope ==0 ?'checked':''}"  value="0">
						下午<input  type="radio"  name="endScope" checked="${leave.endScope ==1 ?'checked':''}" value="1">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假原因:
						</label>
					</td>
					<td class="value" colspan="3">
					<textarea id="leaveReasons" name="leaveReasons" class="textarea1">${leave.leaveReason }</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
			<div class="formtitle">审批信息</div>	
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right" width="60px">
						<label class="Validform_label">
							审批结果:
						</label>
					</td>
					<td class="value">
					<input id="taskKey" name="taskKey" type="hidden" value="${taskKey}">			
					<input id="taskId" name="taskId" type="hidden" value="${taskId}">			
					<input type="hidden" id="leaveDays" name="leaveDays" value="${leave.leaveDays }"/>
					
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
			</table>
		</t:formvalid>
 </body>