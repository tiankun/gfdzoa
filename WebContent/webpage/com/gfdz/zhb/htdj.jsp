<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>合同登记</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <link rel="stylesheet" href="plug-in/Validform/css/divfrom.css" type="text/css"/>
  <script type="text/javascript">
	 $(function(){
	    //查看模式情况下,删除和上传附件功能禁止使用
		if(location.href.indexOf("load=detail")!=-1){
			$(".jeecgDetail").hide();
		}
	   });

  	function uploadFile(data){
  		$("#noticeId").val(data.obj.id);
  		if($(".uploadify-queue-item").length>0){
  			upload();
  		}else{
  			frameElement.api.opener.reloadTable();
  			frameElement.api.close();
  		}
  	}
  	
  	function close(){
  		frameElement.api.close();
  	}
  	</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="htdjController.do?save">
  		  	<div class="formtitle" title="基本信息">基本信息</div>
			<input id="id" name="id" type="hidden" value="${htdjPage.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lxbh" name="lxbh" ignore="ignore"
							   value="${htdjPage.lxbh}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							合同编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="htbh" name="htbh" 
							   value="${htdjPage.htbh}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							合同名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="htmc" name="htmc" 
							   value="${htdjPage.htmc}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							合同单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="htdw" name="htdw" 
							   value="${htdjPage.htdw}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							合同日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="htrq" name="htrq" 
							   value="<fmt:formatDate value='${htdjPage.htrq}' type="date" pattern="yyyy-MM-dd"/>" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							合同金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="htje" name="htje" 
							   value="${htdjPage.htje}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							存档份数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cdfs" name="cdfs" 
							   value="${htdjPage.cdfs}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
						<td align="right">
						<label class="Validform_label">
							存放位置:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cfwz" name="cfwz" ignore="ignore"
							   value="${htdjPage.cfwz}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							经办人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jbr" name="jbr" 
							   value="${htdjPage.jbr}" datatype="*">
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
						<input class="inputxt" id="bz" name="bz" ignore="ignore"
							   value="${htdjPage.bz}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
  		  	<div class="formtitle">附件信息</div>
			<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">附件:</label>
<%-- 		      <input class="inputxt" id="noticeFiles" name="noticeFiles" ignore="ignore" value="${noticePage.noticeFiles}"> --%>
			<input type="hidden" value="${noticePage.id}" id="noticeId" name="noticeId" />
			<table>
				<c:forEach items="${noticePage.noticeFiles}" var="noticeFile">
					<tr style="height: 34px;">
						<td>${noticeFile.attachmenttitle}</td>
						<td><a href="commonController.do?viewFile&fileid=${noticeFile.id}&subclassname=com.gfdz.entity.hr.NoticeFilesEntity" title="下载">下载</a></td>
						<td><a href="javascript:void(0);"
							onclick="openwindow('预览','commonController.do?openViewFile&fileid=${noticeFile.id}&subclassname=com.gfdz.entity.hr.NoticeFilesEntity','fList',1000,700)">预览</a></td>
						<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('noticeController.do?delFile&id=${noticeFile.id}',this)">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form" id="filediv"></div>
			<div class="form jeecgDetail">
			<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="noticeId" uploader="noticeController.do?saveFiles">
			</t:upload>
			</div>
			</fieldset>
		</t:formvalid>
 </body>