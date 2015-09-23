<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>配给采购申请单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
  var windowapi = frameElement.api, W = windowapi.opener;
		function choose() {
				if (typeof (windowapi) == 'undefined') {
					$
						.dialog({
							content : 'url:projectInfoController.do?projectList',
							zIndex : 2100,
							title : '项目列表',
							lock : true,
							width : 600,
							height : 350,
							left : '85%',
							top : '65%',
							opacity : 0.4,
							button : [
									{
										name : '确定',
										callback : clickcallback,
										focus : true
									}, {
										name : '取消',
										callback : function() {
										}
										} ]
									});
			} else {
					$
						.dialog({
							content : 'url:projectInfoController.do?projectList',
							zIndex : 2100,
							title : '项目列表',
							lock : true,
							parent : windowapi,
							width : 600,
							height : 350,
							left : '85%',
							top : '65%',
							opacity : 0.4,
							button : [
								{
									name : '确定',
									callback : clickcallback,
									focus : true
								}, {
													name : '取消',
													callback : function() {
											}
									} ]
						});
				}
}
					
function clickcallback() {
var iframe = this.iframe.contentWindow;
var travelOtheruser = iframe.getprojectInfoListSelections('projectName');
var getprjectid = iframe.getprojectInfoListSelections('id');
$('#projectId').val(getprjectid);
if ($('#projectName').length >= 1) {
//travelOtheruser=travelOtheruser+","+$('#projectId').val();
$('#projectName').val(travelOtheruser);
$('#projectName').blur();
}
}	    
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zhbCgqdController.do?doUpdate">
					<input id="id" name="id" type="hidden" value="${zhbCgqdPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zhbCgqdPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zhbCgqdPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zhbCgqdPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${zhbCgqdPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zhbCgqdPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zhbCgqdPage.updateDate }">
					<input id="projectId" name="project.id" type="hidden" value="${zhbCgqdPage.project.id}">
					<input id="flag" name="flag" type="hidden" value="${zhbCgqdPage.flag }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
		  <td align="right">
				<label class="Validform_label">用户主键:</label>
			</td>
			<td class="value">
		     	 <input id="userId" name="userId" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${zhbCgqdPage.userId}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">用户主键</label>
			</td>
		  <td align="right">
				<label class="Validform_label">申请时间:</label>
			</td>
			<td class="value">
		     	 <input id="inputTime" name="inputTime" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${zhbCgqdPage.inputTime}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">申请时间</label>
			</td>
	  </tr>
		<tr>
		  <td align="right">
				<label class="Validform_label">到货联系人:</label>
			</td>
			<td class="value">
		      		<input id="linkman" name="linkman" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${zhbCgqdPage.linkman}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">到货联系人</label>
			</td>
		 <td align="right">
				<label class="Validform_label">到货联系人电话:</label>
			</td>
			<td class="value">
		     	 <input id="contactNumber" name="contactNumber" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${zhbCgqdPage.contactNumber}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">到货联系人电话</label>
			</td>
	  </tr>
		<tr>
			<td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td colspan="3" class="value">
		      		<input id="projectId" name="" type="text" style="width: 150px" 
					                 onclick="choose();" class="searchbox-inputtext15"
					                value='${zhbCgqdPage.project.projectName}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
                
			</td>
		</tr>
		<tr>
			
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td colspan="3" class="value">
				 <textarea id="applyRemark" style="width:500px;" class="inputxt" rows="6" name="applyRemark">${zhbCgqdPage.applyRemark}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
        </tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
			  <div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="zhbCgqdController.do?zhbCgclList&id=${zhbCgqdPage.id}" icon="icon-search" title="申请材料详细" id="zhbCgcl"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_zhbCgcl_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					       	<input name="zhbCgclList[#index#].materailId" maxlength="36" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">材料编号</label>
				  </td>
				  <td align="left">
					  	<input name="zhbCgclList[#index#].appplyNumber" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">申请数量</label>
				  </td>
				  <td align="left">
					  	<input name="zhbCgclList[#index#].materailRemark" maxlength="4000" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/gfdz/zhb/zhbCgqd.js"></script>	