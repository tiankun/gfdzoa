<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>工程计划表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  
   <script type="text/javascript">
  $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".jeecgDetail").hide();
	}
   });

  	function uploadFile(data){
  		
  		$("#projectTaskId").val(data.obj.id);
  		if($(".uploadify-queue-item").length>0){
  			upload();
  		}else{
  			frameElement.api.opener.reloadTable();
  			frameElement.api.close();
  		}
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
  	function close(){
  		frameElement.api.close();
  	}
  	</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" callback="uploadFile" action="projectTaskController.do?save">
			<input id="id" name="id" type="hidden" value="${projectTask.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value" colspan="3">
					<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${projectTask.project.projectName }">
					<input style="width: 230px" id="projectId" name="project.id" value="${projectTask.project.id }" type="hidden">
					<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
            		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
	      			<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							费用总额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="totalCost" name="totalCost" ignore="ignore"
							   value="${projectTask.totalCost}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							填报日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="createDate" name="createDate" ignore="ignore"
						   value="<fmt:formatDate value='${projectTask.createDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							责任人:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="responsible" name="responsible" ignore="ignore"
							   value="${projectTask.responsible}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							附件:
						</label>
					</td>
					<td class="value" colspan="2">
						<input type="hidden" value="${projectTask.id}" id="projectTaskId" name="projectTaskId" />
						<table>
							<c:forEach items="${projectTask.projectTaskFiles}" var="projectTaskFile">
								<tr style="height: 34px;">
									<td>${projectTaskFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${projectTaskFile.id}&subclassname=com.gfdz.entity.gc.ProjectTaskFilesEntity" title="下载">下载</a></td>
									<td><a href="javascript:void(0);"
										onclick="openwindow('预览','commonController.do?openViewFile&fileid=${projectTaskFile.id}&subclassname=com.gfdz.entity.gc.ProjectTaskFilesEntity','fList',1000,700)">预览</a></td>
									<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('projectTaskController.do?delFile&id=${projectTaskFile.id}',this)">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td class="value">
				    <div class="form" id="filediv"></div>
					<div class="form jeecgDetail">
					<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="projectTaskId" uploader="projectTaskController.do?saveFiles">
					</t:upload>
					</div>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
			</table>
		</t:formvalid>
 </body>
 </html>