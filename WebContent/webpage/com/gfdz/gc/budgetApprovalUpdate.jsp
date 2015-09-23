<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>预算审批表附件</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
    $(window).resize(function(){
    	$('#tabs').tabs('resize',{width: '100%',height:($(window).height()-35)});  
     });
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
  <style type="text/css">
  html,body,form{
     height: 100%;
     padding: 0px;
     margin: 0px;
  }
  </style>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" tiptype="3" layout="table" callback="uploadFile" action="budgetApprovalController.do?completeTask">
	<input id="id" name="id" type="hidden" value="${page.id}">
	<input name="auditType" value="1" type="hidden"/>
	<input name="taskKey" type="hidden" value="${param.taskKey}">			
	<input name="taskId" type="hidden" value="${param.taskId}">	
	<div id="tabs" class="easyui-tabs" fit="true">
    <div title="采购申请">
        <div class="easyui-layout" border="false" fit="true">
         <div data-options="region:'east',split:true" style="width:500px;padding: 5px;">
			  <table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right" style="width: 90px">
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
					<input class="inputxt" id="compilin" name="compilin" datatype="*" value="${page.compilin}">
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
								<td><a href="javascript:void(0)" class="jeecgDetail" onclick="delFile('budgetApprovalController.do?delFile&id=${budgetApprovalFile.id}',this)">删除</a></td>
							</tr>
						</c:forEach>
					</table>
				  </td>
				  <td class="value">
			    <div class="form" id="filediv"></div>
				<div class="form jeecgDetail">
				<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formData="budgetApprovalId" uploader="budgetApprovalController.do?saveFiles"/>
				</div>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
		</table>
        </div>
        <div data-options="region:'center'" style="overflow: hidden;">
         <iframe scrolling="yes" frameborder="0"  src="commonController.do?openViewFile&fileid=${fileId}&subclassname=com.gfdz.entity.gc.BudgetApprovalFilesEntity" style="width:100%;height:100%;"></iframe>
        </div>
    </div>
	</div>
	<div id="bz" title="审批记录" data-options="closable:true" style="overflow:hidden;">
           <iframe scrolling="yes" frameborder="0"  src="activitiController.do?myViewProcessHistory&processInstanceId=${param.processInstanceId}" style="width:100%;height:100%;"></iframe>
	   </div>
       <div id="png" title="审批图" data-options="closable:true" style="">
          	<img src="activitiController.do?traceImage&processInstanceId=${param.processInstanceId}"> 
       </div>
	</div>
   </t:formvalid>
 </body>
 </html>