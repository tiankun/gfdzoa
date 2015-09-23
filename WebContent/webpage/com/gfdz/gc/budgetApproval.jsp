<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>预算审批表附件</title>
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
		  $("#budgetApprovalId").val(data.obj.id);
			if($(".uploadify-queue-item").length>0){
				upload();
			}else{
				frameElement.api.opener.reloadTable();
				frameElement.api.close();
			} 
	  }else{
		  error(data.msg);
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
  	</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" tiptype="3" usePlugin="password" layout="table" callback="uploadFile" action="budgetApprovalController.do?save">
		<input id="id" name="id" type="hidden" value="${page.id }">
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right" style="width: 110px">
					<label class="Validform_label">
						所属项目:
					</label>
				</td>
				<td class="value" colspan="2">
					    <input class="inputxt" datatype="*" style="width: 230px" readonly="readonly" id="projectName" value="${page.project.projectName }">
						<input style="width: 230px" id="projectId" name="project.id" value="${page.project.id }" type="hidden">
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
		             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
						<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						类型:
					</label>
				</td>
				<td class="value" colspan="2">
					<label><input name="type" value="0" datatype="*" <c:if test="${page.type==0}">checked="checked"</c:if> type="radio">预算</label>
					<label><input name="type" value="1" datatype="*" <c:if test="${page.type==1}">checked="checked"</c:if> type="radio">结算 </label>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						建设单位:
					</label>
				</td>
				<td class="value" colspan="2">
					<input class="inputxt" id="construction" name="construction" datatype="*" value="${page.construction}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						编制说明:
					</label>
				</td>
				<td class="value" colspan="2">
					<input class="inputxt" id="remark" name="remark" datatype="*" value="${page.remark}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						编制人:
					</label>
				</td>
				<td class="value" colspan="2">
					<input class="inputxt" id="compilin" name="compilin" datatype="*" value="${userName}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						编制日期:
					</label>
				</td>
				<td class="value" colspan="2">
					<input class="Wdate" onClick="WdatePicker()" datatype="*" style="width: 150px" id="compilingDate" name="compilingDate"
						   value="<fmt:formatDate value='${page.compilingDate}' type="date" pattern="yyyy-MM-dd"/>">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						附件:
					</label>
				</td>
				<td class="value">
					<input type="hidden" value="${page.id}" id="budgetApprovalId" name="budgetApprovalId" />
					<table>
						<c:forEach items="${page.budgetApprovalFiles}" var="budgetApprovalFile">
							<tr style="height: 34px;">
								<td>${budgetApprovalFile.attachmenttitle}</td>
								<td><a href="commonController.do?viewFile&fileid=${budgetApprovalFile.id}&subclassname=com.gfdz.entity.gc.BudgetApprovalFilesEntity" title="下载">下载</a></td>
								<td><a href="javascript:void(0);"
									onclick="openwindow('预览','commonController.do?openViewFile&fileid=${budgetApprovalFile.id}&subclassname=com.gfdz.entity.gc.BudgetApprovalFilesEntity','fList',1000,700)">预览</a></td>
								<c:if test="${page.isverify==0}"><td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('budgetApprovalController.do?delFile&id=${budgetApprovalFile.id}',this)">删除</a></td></c:if>
							</tr>
						</c:forEach>
					</table>
				  <c:if test="${page.budgetApprovalFiles!=null}">
				  </td>
				  <td class="value">
				  </c:if>
			    <div class="form" id="filediv"></div>
				<div class="form jeecgDetail">
				<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="budgetApprovalId" uploader="budgetApprovalController.do?saveFiles"/>
				</div>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			
		</table>
	</t:formvalid>
 </body>
 </html>