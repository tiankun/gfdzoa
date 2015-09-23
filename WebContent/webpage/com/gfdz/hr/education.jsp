<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>个人学历信息</title>
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
  		$("#educationId").val(data.obj.id);
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" callback="uploadFile" action="educationController.do?save">
			<div id="layout" class="easyui-layout" fit="true">
			<c:if test="${educationFilesId!=null}">
		        <div data-options="region:'east',split:true,collapsible:false" style="overflow: hidden;width:700px;" >
		           <iframe scrolling="yes" frameborder="0" name="showEduFile" src="commonController.do?openViewFile&fileid=${educationFilesId}&subclassname=com.gfdz.entity.hr.EducationFilesEntity" style="width:100%;height:100%;"></iframe>
		        </div>
	        </c:if>
	        <div data-options="region:'center'" >
			<input id="id" name="id" type="hidden" value="${education.id }">
			<input type="hidden" id="personId" name="personId" value="${param.personId}">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开始时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="beginDate" name="beginDate" ignore="ignore"
							   value="<fmt:formatDate value='${education.beginDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							结束时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="endDate" name="endDate" ignore="ignore"
							   value="<fmt:formatDate value='${education.endDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<td align="right">
						<label class="Validform_label">
							学校:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shcool" name="shcool" ignore="ignore"
							   value="${education.shcool}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							专业:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="major" name="major" ignore="ignore"
							   value="${education.major}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
				<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="education" name="education" ignore="ignore"
							   value="${education.education}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							学历类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="eduType" name="eduType" ignore="ignore"
							   value="${education.eduType}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							学位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="degree" name="degree" ignore="ignore"
							   value="${education.degree}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							证书编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="certificateNo" name="certificateNo" ignore="ignore"
							   value="${education.certificateNo}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							毕业/结业:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="isgradua" name="isgradua" ignore="ignore"
							   value="${education.isgradua}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							证件照:
						</label>
					</td>
					<td class="value" colspan="2">
					<input type="hidden" value="${education.id}" id="educationId" name="educationId" />
						<table>
							<c:forEach items="${education.educationFiles}" var="educationFile">
								<tr style="height: 34px;">
									<td>${educationFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${educationFile.id}&subclassname=com.gfdz.entity.hr.EducationFilesEntity" title="下载">下载</a></td>
									<td><a target="showEduFile" href="commonController.do?openViewFile&fileid=${educationFile.id}&subclassname=com.gfdz.entity.hr.EducationFilesEntity">预览</a></td>
									<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('educationController.do?delFile&id=${educationFile.id}',this)">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td class="value">
				    <div class="form" id="filediv"></div>
					<div class="form jeecgDetail">
					<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="educationId" uploader="educationController.do?saveFiles">
					</t:upload>
					</div>
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
						<textarea class="textarea" id="remark" name="remark" ignore="ignore"
							   value="${education.remark}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		 </div>
    </div>
		</t:formvalid>
 </body>