<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>安全检查</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(function(){
	    //查看模式情况下,删除和上传附件功能禁止使用
		if(location.href.indexOf("load=detail")!=-1){
			$(".jeecgDetail").hide();
		}
	   });

	function uploadFile(data){
		$("#safetyCheckId").val(data.obj.id);
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
 <body style="overflow-y:auto;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table"  callback="uploadFile" action="safetyCheckController.do?save">
  		<div class="formtitle" title="基本信息">施工安全检查基本信息</div>
			<input id="id" name="id" type="hidden" value="${safetyCheck.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							工程名称:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${safetyCheck.project.projectName }">
						<input style="width: 230px" id="projectId" name="project.id" value="${safetyCheck.project.id }" type="hidden">
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
		             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							参检人员:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="projectManager" name="projectManager" ignore="ignore"
							   value="${safetyCheck.projectManager}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							检查类别:
						</label>
					</td>
					<td class="value" colspan="3">
					<t:dictSelect field="constructionTeam" typeGroupCode="safeTycheckType" hasLabel="false" defaultVal="${safetyCheck.constructionTeam}"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							检查内容:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="qualityMan" name="qualityMan" ignore="ignore"
							   >${safetyCheck.qualityMan}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							存在隐患:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="inspectionPlace" name="inspectionPlace" ignore="ignore">${safetyCheck.inspectionPlace}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							整改措施:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="question" name="question" ignore="ignore"
							    >${safetyCheck.question}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							检查结论:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="conclusion" name="conclusion" ignore="ignore"
							   >${safetyCheck.conclusion}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							落实人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="implementPerson" name="implementPerson" ignore="ignore"
							   value="${safetyCheck.implementPerson}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							检查日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="qualityDate" name="qualityDate" ignore="ignore"
							   value="<fmt:formatDate value='${safetyCheck.qualityDate}' type="date" pattern="yyyy-MM-dd"/>">
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
					<input type="hidden" value="${safetyCheck.id}" id="safetyCheckId" name="safetyCheckId" />
						<table>
							<c:forEach items="${safetyCheck.safetyCheckFiles}" var="safetyCheckFile">
								<tr style="height: 34px;">
									<td>${safetyCheckFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${safetyCheckFile.id}&subclassname=com.gfdz.entity.gc.SafetyCheckFilesEntity" title="下载">下载</a></td>
									<td><a href="javascript:void(0);"
										onclick="openwindow('预览','commonController.do?openViewFile&fileid=${safetyCheckFile.id}&subclassname=com.gfdz.entity.gc.SafetyCheckFilesEntity','fList',1000,700)">预览</a></td>
									<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('safetyCheckController.do?delFile&id=${safetyCheckFile.id}',this)">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td class="value">
				    <div class="form" id="filediv"></div>
					<div class="form jeecgDetail">
					<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="safetyCheckId" uploader="safetyCheckController.do?saveFiles">
					</t:upload>
					</div>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
 </html>