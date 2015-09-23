<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>文件列表</title>
<script type="text/javascript" src="plug-in/mutiLang/zh-cn.js"></script>
<script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="plug-in/tools/dataformat.js"></script>
<link rel="stylesheet" href="plug-in/tools/css/common.css" type="text/css"></link>
<script type="text/javascript" src="plug-in/tools/easyuiextend.js"></script>
</head>
<body style="overflow-y: hidden" scroll="no">
	<div id="content">
		<div id="wrapper">
			<div id="steps">
				<form id="formobj" action="null" name="formobj" method="post">
					<input type="hidden" id="btn_sub" class="btn_sub" />
					<fieldset class="step">
						<div class="form">
							<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css"
								type="text/css"></link>
							<script type="text/javascript"
								src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
							<script type="text/javascript" src="plug-in/tools/Map.js"></script>
							<script type="text/javascript">
								var flag = false;
								var fileitem = "";
								var fileKey = "";
								var serverMsg = "";
								var m = new Map();
								$(function() {
									$('#file_upload').uploadify(
													{
														buttonText : '上传文件',
														auto : false,
														progressData : 'speed',
														multi : true,
														height : 25,
														overrideEvents : [ 'onDialogClose' ],
														fileTypeDesc : '文件格式:',
														queueID : 'filediv',
														fileObjName: 'file',
														fileTypeExts : '*.zip;*.bar;*.png;*.bpmn;*.bpmn20.xml',
														fileSizeLimit : '15MB',
														swf : 'plug-in/uploadify/uploadify.swf',
														uploader : 'activitiController.do?deployProcess&sessionId='+'${sessionId}',
														onUploadStart : function(file) {
															var documentTitle = $('#documentTitle').val();
															$('#file_upload').uploadify("settings","formData",
																			{
																				'documentTitle' : documentTitle
																			});
														},
														onQueueComplete : function(queueData) {
															var win = frameElement.api.opener;
															win.reloadTable();
															win.tip(serverMsg);
															frameElement.api.close();
														},
														onUploadSuccess : function(file, data,response) {
															var d = $.parseJSON(data);
															if (d.success) {
																var win = frameElement.api.opener;
																serverMsg = d.msg;
															}
														},
														onFallback : function() {
															tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
														},
														onSelectError : function( file, errorCode, errorMsg) {
															switch (errorCode) {
															case -100:
																tip("上传的文件数量已经超出系统限制的" + $('#file_upload').uploadify('settings','queueSizeLimit') + "个文件！");
																break;
															case -110:
																tip("文件 [" + file.name + "] 大小超出系统限制的" + $('#file_upload').uploadify('settings','fileSizeLimit')+ "大小！");
																break;
															case -120:
																tip("文件 [" + file.name + "] 大小异常！");
																break;
															case -130:
																tip("文件 [" + file.name + "] 类型不正确！");
																break;
															}
														},
														onUploadProgress : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
														}
													});
								});
								function upload() {
									$('#file_upload').uploadify('upload', '*');
									return flag;
								}
								function cancel() {
									$('#file_upload').uploadify('cancel', '*');
								}
							</script>
							<span id="file_uploadspan">
							<input type="file"  id="file_upload" />
							</span>
						</div>
						<div class="form" id="filediv" name="file" style="height: 50px"></div>
					</fieldset>
					<link rel="stylesheet" href="plug-in/Validform/css/divfrom.css" type="text/css" />
					<link rel="stylesheet" href="plug-in/Validform/css/style.css" type="text/css" />
					<link rel="stylesheet" href="plug-in/Validform/css/tablefrom.css" type="text/css" />
					<script type="text/javascript" src="plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
					<script type="text/javascript" src="plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
					<script type="text/javascript" src="plug-in/Validform/js/datatype_zh-cn.js"></script>
					<script type="text/javascript">
						$(function() {
							$("#formobj").Validform(
											{
												tiptype : 4,
												btnSubmit : "#btn_sub",
												btnReset : "#btn_reset",
												ajaxPost : true,
												beforeSubmit : function(curform) {
													var tag = false;
													return upload(curform);
												},
												callback : function(data) {
													var win = frameElement.api.opener;
													if (data.success == true) {
														frameElement.api.close();
														win.tip(data.msg);
													} else {
														if (data.responseText == ''|| data.responseText == undefined) {
															$.messager.alert('错误',data.msg);
															$.Hidemsg();
														} else {
															try {
																var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'),
																				data.responseText.indexOf('错误信息'));
																$.messager.alert('错误',emsg);
																$.Hidemsg();
															} catch (ex) {
																$.messager.alert('错误',data.responseText+ "");
																$.Hidemsg();
															}
														}
														return false;
													}
													win.reloadTable();
												}
											});
						});
					</script>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

