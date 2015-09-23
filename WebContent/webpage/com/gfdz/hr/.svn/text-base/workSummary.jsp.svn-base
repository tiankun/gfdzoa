<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>工作总结</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript" src="plug-in/kindeditor/kindeditor.js"></script>
<script type="text/javascript" src="plug-in/kindeditor/lang/zh_CN.js"></script>
      <script type="text/javascript">
        $(function(){
            var editor;
            KindEditor.ready(function(K) {
            	editor = K.create('#summaryNote', {
            		resizeType : 2,
            		minWidth:630,
            		width:'550px',
            		height:'150px',
            		filePostName:'file',
            		themeType : 'simple',
            		uploadJson:'uploadFileController.do?uploadImg',
            		items : [
            			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
            			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            			'insertunorderedlist', '|', 'emoticons', 'image','multiimage','link','fullscreen']
            	});
            });
        });
       
    </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="workSummaryController.do?save">
			<input id="id" name="id" type="hidden" value="${workSummaryPage.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							提交日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="summaryDate" name="summaryDate" ignore="ignore"value="<fmt:formatDate value='${workSummaryPage.summaryDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							周数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="summaryWeeks" name="summaryWeeks" ignore="ignore"
							   value="${workSummaryPage.summaryWeeks}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							总结内容:
						</label>
					</td>
					<td class="value">
<!-- 						<input class="inputxt" id="summaryNote" name="summaryNote" ignore="ignore" -->
<%-- 							   value="${workSummaryPage.summaryNote}"> --%>
							   <textarea id="summaryNote" name="summaryNote" class="textarea1"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>