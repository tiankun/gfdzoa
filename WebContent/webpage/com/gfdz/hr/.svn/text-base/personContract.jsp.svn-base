<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>个人合同信息</title>
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
  		$("#personContractId").val(data.obj.id);
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
  <t:formvalid formid="personContractform" dialog="true" usePlugin="password" layout="table" callback="uploadFile"  action="personContractController.do?save">
			<div id="layout" class="easyui-layout" fit="true">
			<c:if test="${personContractFileId!=null}">
	        <div data-options="region:'east',split:true,collapsible:false" style="overflow: hidden;width:700px;" >
	           <iframe scrolling="yes" frameborder="0" name="showPersonContractFile" src="commonController.do?openViewFile&fileid=${personContractFileId}&subclassname=com.gfdz.entity.hr.PersonContractFilesEntity" style="width:100%;height:100%;"></iframe>
	        </div>
	       </c:if>
	       <div data-options="region:'center'" >
			<input id="id" name="id" type="hidden" value="${personContract.id }">
		 	<input id="personId" name="personId" type="hidden" value="${param.personId}">
			<table style="width:100%" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							合同编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="contractNo" name="contractNo" ignore="ignore"
							   value="${personContract.contractNo}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							合同类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="contractType" name="contractType" ignore="ignore"
							   value="${personContract.contractType}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							签订方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="signedType" name="signedType" ignore="ignore"
							   value="${personContract.signedType}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							签订日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="signedDate" name="signedDate" ignore="ignore"
							   value="<fmt:formatDate value='${personContract.signedDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开始时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="beginDate" name="beginDate" ignore="ignore"
							   value="<fmt:formatDate value='${personContract.beginDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							结束时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="endDate" name="endDate" ignore="ignore"
							   value="<fmt:formatDate value='${personContract.endDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							试用期开始时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="syBedinDate" name="syBedinDate" ignore="ignore"
							   value="<fmt:formatDate value='${personContract.syBedinDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							试用期结束时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="syEndDate" name="syEndDate" ignore="ignore"
							   value="<fmt:formatDate value='${personContract.syEndDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							合同解除/终止时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="overContractDate" name="overContractDate" ignore="ignore"
							   value="<fmt:formatDate value='${personContract.overContractDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							补偿金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="compensation" name="compensation" ignore="ignore"
							   value="${personContract.compensation}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							违约金额:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="breach" name="breach" ignore="ignore"
							   value="${personContract.breach}">
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
					<input type="hidden" value="${personContract.id}" id="personContractId" name="personContractId" />
						<table>
							<c:forEach items="${personContract.personContractFiles}" var="personContractFile">
								<tr style="height: 34px;">
									<td>${personContractFile.attachmenttitle}</td>
									<td><a href="commonController.do?viewFile&fileid=${personContractFile.id}&subclassname=com.gfdz.entity.hr.PersonContractFilesEntity" title="下载">下载</a></td>
									<td><a target="showPersonContractFile" href="commonController.do?openViewFile&fileid=${personContractFile.id}&subclassname=com.gfdz.entity.hr.PersonContractFilesEntity">预览</a></td>
									<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('personContractController.do?delFile&id=${personContractFile.id}',this)">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td class="value">
				    <div class="form" id="filediv"></div>
					<div class="form jeecgDetail">
					<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="personContractId" uploader="personContractController.do?saveFiles">
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
							   value="${personContract.remark}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
			</div>
			</div>
		</t:formvalid>
 </body>