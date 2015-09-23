<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>安全教育</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
   <script type="text/javascript">
   $(function(){
	    //查看模式情况下,删除和上传附件功能禁止使用
		if(location.href.indexOf("load=detail")!=-1){
			$(".jeecgDetail").hide();
		}
	   });

	function uploadFile(data){
		$("#safeEducationId").val(data.obj.id);
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
  function choose() {
  		$.dialog({
  			content : "url:transferController.do?selectProject",
  			zIndex : 2100,
  			title : "工程列表",
  			lock : true,
  			width : 1000,
  			height : 550,
  			left : '50%',
  			top : '50%',
  			opacity : 0.4,
  			button : [ {
  				name : '确认',
  				callback :function(){
  					clearAll();
  					var iframe = this.iframe.contentWindow;
  					var data=iframe.getProjectInfo();
  					$("#projectId").val(data.id);
  					$("#projectName").val(data.projectName);
  				},
  				focus : true
  			}, {
  				name : '取消',
  				callback : function() {
  				}
  			} ]
  		});
  	}

  	function clearAll(){
  		$("#projectName").val("");
  		$("#projectId").val("");
  	}
    </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" callback="uploadFile" action="safeEducationController.do?save">
			<div class="formtitle" title="基本信息">安全教育基本信息</div>
			<input id="id" name="id" type="hidden" value="${safeEducation.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							工程名称:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${safeEducation.project.projectName }">
				<input style="width: 230px" id="projectId" name="project.id" value="${safeEducation.project.id }" type="hidden">
				<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							主讲人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lecturer" name="lecturer" ignore="ignore"
							   value="${safeEducation.lecturer}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							培训类别:
						</label>
					</td>
					<td class="value">
					<t:dictSelect field="educationType" typeGroupCode="safeEducationType" hasLabel="false" defaultVal="${safeEducation.educationType}"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							受教育人:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="trainee" name="trainee" ignore="ignore"
							   >${safeEducation.trainee}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="right" >
						<label class="Validform_label">
							教育内容:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="educationContent" name="educationContent" ignore="ignore"
							   >${safeEducation.educationContent}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							培训日期:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="educationDate" name="educationDate" ignore="ignore"
							     value="<fmt:formatDate value='${safeEducation.educationDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							相关附件:
						</label>
					</td>
					<td class="value" colspan="2">
					<input type="hidden" value="${safeEducation.id}" id="safeEducationId" name="safeEducationId" />
						<table>
							<c:forEach items="${safeEducation.safeEducationFiles}" var="safeEducationFile">
								<tr style="height: 34px;">
									<td>${safeEducationFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${safeEducationFile.id}&subclassname=com.gfdz.entity.gc.SafeEducationFilesEntity" title="下载">下载</a></td>
									<td><a href="javascript:void(0);"
										onclick="openwindow('预览','commonController.do?openViewFile&fileid=${safeEducationFile.id}&subclassname=com.gfdz.entity.gc.SafeEducationFilesEntity','fList',1000,700)">预览</a></td>
									<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('safeEducationController.do?delFile&id=${safeEducationFile.id}',this)">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td class="value">
				    <div class="form" id="filediv"></div>
					<div class="form jeecgDetail">
					<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="safeEducationId" uploader="safeEducationController.do?saveFiles">
					</t:upload>
					</div>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
 </html>