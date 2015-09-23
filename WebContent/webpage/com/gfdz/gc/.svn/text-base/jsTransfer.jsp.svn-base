<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>技术移交记录表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(function(){
	    //查看模式情况下,删除和上传附件功能禁止使用
		if(location.href.indexOf("load=detail")!=-1){
			$(".jeecgDetail").hide();
		}
	   });

	function uploadFile(data){
		if(data.success){
			$("#jsTransferId").val(data.obj.id);
			if($(".uploadify-queue-item").length>0){
				upload();
			}else{
				frameElement.api.opener.reloadTable();
				frameElement.api.close();
			}
		}else{
			
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" callback="uploadFile" action="jsTransferController.do?save">
		  	<div class="formtitle" title="基本信息">技术交底基本信息</div>
			<input id="id" name="id" type="hidden" value="${jsTransfer.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目名称:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${jsTransfer.project.projectName }">
						<input style="width: 230px" id="projectId" name="project.id" value="${jsTransfer.project.id }" type="hidden">
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
		             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							交底时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="transferTiem" name="transferTiem" ignore="ignore"
							   value="<fmt:formatDate value='${jsTransfer.transferTiem}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							交底人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lecturer" name="lecturer" ignore="ignore"
							   value="${jsTransfer.lecturer}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注说明:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea class="textarea" id="remarks" name="remarks" ignore="ignore"
							   >${jsTransfer.remarks}</textarea>
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
					<input type="hidden" value="${jsTransfer.id}" id="jsTransferId" name="jsTransferId" />
						<table>
							<c:forEach items="${jsTransfer.jsTransferFiles}" var="jsTransferFile">
								<tr style="height: 34px;">
									<td>${jsTransferFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${jsTransferFile.id}&subclassname=com.gfdz.entity.gc.JsTransferFilesEntity" title="下载">下载</a></td>
									<td><a href="javascript:void(0);"
										onclick="openwindow('预览','commonController.do?openViewFile&fileid=${jsTransferFile.id}&subclassname=com.gfdz.entity.gc.JsTransferFilesEntity','fList',1000,700)">预览</a></td>
									<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('jsTransferController.do?delFile&id=${jsTransferFile.id}',this)">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td class="value">
				    <div class="form" id="filediv"></div>
					<div class="form jeecgDetail">
					<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="jsTransferId" uploader="jsTransferController.do?saveFiles">
					</t:upload>
					</div>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>