<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>质量管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
   <script type="text/javascript">
   $(function(){
	    //查看模式情况下,删除和上传附件功能禁止使用
		if(location.href.indexOf("load=detail")!=-1){
			$(".jeecgDetail").hide();
		}
	   });

	function uploadFile(data){
		$("#qualityCheckId").val(data.obj.id);
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
  					$("#projectManager").val(data.projectManager);
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
  		$("#projectManager").val("");
  	}
    </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" callback="uploadFile"  action="qualityCheckController.do?save">
			<div class="formtitle" title="基本信息">施工质量检查基本信息</div>
			<input id="id" name="id" type="hidden" value="${qualityCheck.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							工程名称:
						</label>
					</td>
					<td class="value">
				<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${qualityCheck.project.projectName }">
				<input style="width: 230px" id="projectId" name="project.id" value="${qualityCheck.project.id }" type="hidden">
				<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							项目经理:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="projectManager" name="projectManager" ignore="ignore"
							   value="${qualityCheck.projectManager}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							质检员:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="qualityPerson" name="qualityPerson" ignore="ignore"
							   value="${qualityCheck.qualityPerson}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							操作组:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="constructionTeam" name="constructionTeam" ignore="ignore"
							   value="${qualityCheck.constructionTeam}">
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							检查地点:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="inspectionPlace" name="inspectionPlace" ignore="ignore"
							   value="${qualityCheck.inspectionPlace}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							巡检日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="qualityDate" name="qualityDate" ignore="ignore"
							   value="<fmt:formatDate value='${qualityCheck.qualityDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							问题描述:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="question" name="question" ignore="ignore">${qualityCheck.question}</textarea>
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
					<input type="hidden" value="${qualityCheck.id}" id="qualityCheckId" name="qualityCheckId" />
						<table>
							<c:forEach items="${qualityCheck.qualityCheckFiles}" var="qualityCheckFile">
								<tr style="height: 25px;">
									<td>${qualityCheckFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${qualityCheckFile.id}&subclassname=com.gfdz.entity.gc.QualityCheckFilesEntity" title="下载">下载</a></td>
									<td><a href="javascript:void(0);"
										onclick="openwindow('预览','commonController.do?openViewFile&fileid=${qualityCheckFile.id}&subclassname=com.gfdz.entity.gc.QualityCheckFilesEntity','fList',1000,700)">预览</a></td>
									<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('qualityCheckController.do?delFile&id=${qualityCheckFile.id}',this)">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td class="value">
				    <div class="form" id="filediv"></div>
					<div class="form jeecgDetail">
					<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="qualityCheckId" uploader="qualityCheckController.do?saveFiles">
					</t:upload>
					</div>
						<span class="Validform_checktip"></span>
					</td>
					
		
				</tr>
			</table>
		</t:formvalid>
 </body>
 </html>