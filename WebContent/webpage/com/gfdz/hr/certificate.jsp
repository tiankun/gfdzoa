<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>证书管理</title>
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

  	function uploadFile(data){
  		$("#certificateId").val(data.obj.id);
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
  <t:formvalid formid="certificateform" dialog="true" usePlugin="password" layout="table" callback="uploadFile"  action="certificateController.do?save">
		<div id="layout" class="easyui-layout" fit="true">
		<c:if test="${certificateFileId!=null}">
	        <div data-options="region:'east',split:true,collapsible:false" style="overflow: hidden;width:700px;" >
	           <iframe scrolling="yes" frameborder="0" name="showCertificateFile" src="commonController.do?openViewFile&fileid=${certificateFileId}&subclassname=com.gfdz.entity.hr.CertificateFilesEntity" style="width:100%;height:100%;"></iframe>
	        </div>
	       </c:if>
	       <div data-options="region:'center'" >
		<input id="id" name="id" type="hidden" value="${certificate.id }">
		<input type="hidden" id="personId" name="personId" value="${param.personId}">
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
				<td align="right">
					<label class="Validform_label">
						证书名称:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="mingCheng" name="mingCheng" ignore="ignore"
						   value="${certificate.mingCheng}">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						证书分类:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="certType" name="certType" ignore="ignore"
						   value="${certificate.certType}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						发证部门:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="faZheng" name="faZheng" ignore="ignore"
						   value="${certificate.faZheng}">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						证书级别:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="certLevel" name="certLevel" ignore="ignore"
						   value="${certificate.certLevel}">
					<span class="Validform_checktip"></span>
				</td>
				
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						证书专业:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="zhuangYe" name="zhuangYe" ignore="ignore"
						   value="${certificate.zhuangYe}">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						证书类型:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="majorType" name="majorType" ignore="ignore"
						   value="${certificate.majorType}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						证书保管部门:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="baoGuan" name="baoGuan" ignore="ignore"
						   value="${certificate.baoGuan}">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						是否主页显示:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="diaplay" name="diaplay" ignore="ignore"
						   value="${certificate.diaplay}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						证书编号:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="bianHao" name="bianHao" ignore="ignore"
						   value="${certificate.bianHao}">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						认定时间:
					</label>
				</td>
				<td class="value">
					<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="rdTime" name="rdTime" ignore="ignore"
						   value="<fmt:formatDate value='${certificate.rdTime}' type="date" pattern="yyyy-MM-dd"/>">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						是否到期提醒:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="tiXing" name="tiXing" ignore="ignore"
						   value="${certificate.tiXing}">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						是否年检提醒:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="nianJian" name="nianJian" ignore="ignore"
						   value="${certificate.nianJian}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						有效期开始:
					</label>
				</td>
				<td class="value">
					<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="xqSTime" name="xqSTime" ignore="ignore"
						   value="<fmt:formatDate value='${certificate.xqSTime}' type="date" pattern="yyyy-MM-dd"/>">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						有效期结束:
					</label>
				</td>
				<td class="value">
					<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="xqETime" name="xqETime" ignore="ignore"
						   value="<fmt:formatDate value='${certificate.xqETime}' type="date" pattern="yyyy-MM-dd"/>">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						证件扫描件:
					</label>
				</td>
				<td class="value" colspan="2">
				<input type="hidden" value="${certificate.id}" id="certificateId" name="certificateId" />
					<table>
						<c:forEach items="${certificate.certificateFiles}" var="certificateFile">
							<tr style="height: 34px;">
								<td>${certificateFile.attachmenttitle}</td>
								<td><a href="commonController.do?viewFile&fileid=${certificateFile.id}&subclassname=com.gfdz.entity.hr.CertificateFilesEntity" title="下载">下载</a></td>
								<td><a target="showCertificateFile" href="commonController.do?openViewFile&fileid=${certificateFile.id}&subclassname=com.gfdz.entity.hr.CertificateFilesEntity">预览</a></td>
								<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('certificateController.do?delFile&id=${certificateFile.id}',this)">删除</a></td>
							</tr>
						</c:forEach>
					</table>
				</td>
				<td class="value">
			    <div class="form" id="filediv"></div>
				<div class="form jeecgDetail">
				<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="certificateId" uploader="certificateController.do?saveFiles">
				</t:upload>
				</div>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						备注:
					</label>
				</td>
				<td class="value" colspan="3">
					<textarea class="textarea" id="remark" name="remark" ignore="ignore"
						   value="${certificate.remark}"></textarea>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
		</table>
		</div>
		</div>
	</t:formvalid>
 </body>