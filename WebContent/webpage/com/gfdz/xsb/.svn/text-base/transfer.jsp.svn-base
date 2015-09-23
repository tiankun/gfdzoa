<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>销售交底</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".jeecgDetail").hide();
	}
   });

  	function uploadFile(data){
  		
  		$("#transferId").val(data.obj.id);
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" callback="uploadFile" layout="table" action="transferController.do?save">
		<div class="formtitle" title="基本信息">销售交底基本信息</div>
		<input id="id" name="id" type="hidden" value="${transfer.id }">
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right">
					<label class="Validform_label">
						项目名称:
					</label>
				</td>
				<td class="value" colspan="3">
					<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${transfer.project.projectName }">
					<input style="width: 230px" id="projectId" name="project.id" value="${transfer.project.id }" type="hidden">
					<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
            		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
	      			<span class="Validform_checktip"></span>
		   	</td>
		   </tr>	
		   <tr>
				<td align="right">
					<label class="Validform_label">
						合同编号:
					</label>
				</td>
				<td class="value">
					 <input class="inputxt" id="agreementNumber" name="agreementNumber" ignore="ignore"
					   value="${transfer.project.agreementNumber}">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						项目金额:
					</label>
				</td>
				<td class="value">
					  <input class="inputxt" id="moneyAmount" name="project.moneyAmount" ignore="ignore"
					   value="${transfer.project.moneyAmount}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			   <tr>
				<td align="right">
					<label class="Validform_label">
						项目类型:
					</label>
				</td>
				<td class="value">
					<t:dictSelect hasLabel="false"  field="project.projectType" id="projectType" typeGroupCode="projectType" defaultVal="${transfer.project.projectType }" extendJson="{\"class\":\"validate[required]\"}"></t:dictSelect>
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						建设内容:
					</label>
				</td>
				<td class="value">
					<t:dictSelect hasLabel="false"  field="project.buildType" id="buildType" typeGroupCode="buildType" defaultVal="${transfer.project.buildType }" extendJson="{\"class\":\"validate[required]\"}"></t:dictSelect>
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
					<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="transferDate" name="transferDate" ignore="ignore"
						   value="<fmt:formatDate value='${transfer.transferDate}' type="date" pattern="yyyy-MM-dd"/>">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						交底人:
					</label>
				</td>
				<td class="value">
					  <input class="inputxt" id="operator" name="operator" ignore="ignore"
					   value="${transfer.operator}">
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
			</table>
			<div class="formtitle" title="基本信息">附件信息</div>
			<table  style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right" width="85px">
					<label class="Validform_label">
						相关附件:
					</label>
				</td>
				<td class="value" colspan="2">
						<input type="hidden" value="${transfer.id}" id="transferId" name="transferId" />
					<table>
						<c:forEach items="${transfer.transferFiles}" var="transferFile">
							<tr style="height: 34px;">
								<td>${transferFile.attachmenttitle}</td>
								<td><a href="commonController.do?viewFile&fileid=${transferFile.id}&subclassname=com.gfdz.entity.gc.TransferFilesEntity" title="下载">下载</a></td>
								<td><a href="javascript:void(0);"
									onclick="openwindow('预览','commonController.do?openViewFile&fileid=${transferFile.id}&subclassname=com.gfdz.entity.gc.TransferFilesEntity','fList',1000,700)">预览</a></td>
								<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('transferController.do?delFile&id=${transferIdFile.id}',this)">删除</a></td>
							</tr>
						</c:forEach>
					</table>
				</td>
				<td class="value" width="150px">
			    <div class="form" id="filediv"></div>
				<div class="form jeecgDetail">
					<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="transferId" uploader="transferController.do?saveFiles">
				</t:upload>
				</div>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
		</table>
  </t:formvalid>
 </body>