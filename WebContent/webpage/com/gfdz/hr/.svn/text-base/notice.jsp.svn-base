<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>通知公告</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
<style type="text/css">
  html,body,form{
   height: 100%;
   padding: 0px;
   margin: 0px;
  }
</style>
  <script type="text/javascript">
  $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".jeecgDetail").hide();
	}
   });
  
  $(window).resize(function(){
  	$('#layout').layout('resize',{width: '100%',height:($(window).height()-35)});  
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
 <body style="overflow-y: hidden;" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" callback="uploadFile" layout="table" action="noticeController.do?save">
		<div id="layout" class="easyui-layout" fit="true">
		<c:if test="${noticeFileId!=null}">
	        <div data-options="region:'east',split:true,collapsible:false" style="overflow: hidden;width:700px;" >
	           <iframe scrolling="yes" frameborder="0" name="showNoticeFile" src="commonController.do?openViewFile&fileid=${noticeFileId}&subclassname=com.gfdz.entity.hr.NoticeFilesEntity" style="width:100%;height:100%;"></iframe>
	        </div>
        </c:if>
        <div data-options="region:'center'" >
	       <table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
	        		<tr>
		   			<input type="hidden" id="id" name="id" value="${noticePage.id}" >
		        		<td align="right">
				     	 <label class="Validform_label">标题:</label>
		        		</td>
		        		<td class="value" colspan="3">
				      		<input class="inputxt" id="noticeTitle" name="noticeTitle" ignore="ignore"
							   value="${noticePage.noticeTitle}" >
							   	<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
				     	 <label class="Validform_label">类型:</label>
		        		</td>
		        		<td class="value" colspan="3">
				      			<t:dictSelect field="noticeType" typeGroupCode="noteType" hasLabel="false" defaultVal="${noticePage.noticeType}"></t:dictSelect>
				     		 <span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
				     	 <label class="Validform_label">备注:</label>
		        		</td>
		        		<td class="value" colspan="3">
				      	 <input class="inputxt" id="noticeRemarks" name="noticeRemarks" ignore="ignore"
							   value="${noticePage.noticeRemarks}">
						</td>
			  		 </tr>
			  		 <tr>
				  		 <td align="right">
					     	 <label class="Validform_label">附件:</label>
			        		</td>
			        		<td class="value" colspan="2">
					      	<input type="hidden" value="${noticePage.id}" id="noticeId" name="noticeId" />
				<table  cellpadding="0" cellspacing="1" class="formtable">
					<c:forEach items="${noticePage.noticeFiles}" var="noticeFile">
						<tr style="height: 34px;">
							<td>${noticeFile.attachmenttitle}</td>
							<td><a href="commonController.do?viewFile&fileid=${noticeFile.id}&subclassname=com.gfdz.entity.hr.NoticeFilesEntity" title="下载">下载</a></td>
							<td><a target="showNoticeFile" href="commonController.do?openViewFile&fileid=${noticeFile.id}&subclassname=com.gfdz.entity.hr.NoticeFilesEntity">预览</a></td>
							<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('noticeController.do?delFile&id=${noticeFile.id}',this)">删除</a></td>
						</tr>
					</c:forEach>
				</table>
			      <span class="Validform_checktip"></span>
							</td>
							<td>
						<div class="form" id="filediv"></div>
							<div class="form jeecgDetail">
							<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="noticeId" uploader="noticeController.do?saveFiles">
							</t:upload>
							</div>
						</td>
			  		 </tr>
			   </table>
        </div>
    </div>
  </t:formvalid>
 </body>