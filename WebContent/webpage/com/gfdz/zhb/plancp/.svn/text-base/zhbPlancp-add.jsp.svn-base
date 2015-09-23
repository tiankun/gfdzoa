<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>采购计划申请</title>
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
//travelOtheruser=travelOtheruser+","+$('#projiectId').val();
$('#projectName').val(travelOtheruser);
$('#projectName').blur();
}
}
						
  
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zhbPlancpController.do?doAdd">
					<input id="id" name="id" type="hidden" value="${zhbPlancpPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zhbPlancpPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zhbPlancpPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zhbPlancpPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${zhbPlancpPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zhbPlancpPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zhbPlancpPage.updateDate }">
					<input id="projectId" name="projectId" type="hidden" value="${zhbPlancpPage.projectId }">
					<input id="flag" name="flag" type="hidden" value="${zhbPlancpPage.flag }">
	<table cellpadding="0" cellspacing="1" class="formtable" width="900px">
		<tr>
			<td align="right">
				<label class="Validform_label">计划填写人:</label>
			</td>
			<td class="value">
		     	 <input id="applyPerson" name="applyPerson" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">计划填写人</label>
			</td>
			<td align="right">
				<label class="Validform_label">计划时间:</label>
			</td>
			<td class="value">
					  <input id="planTime" name="planTime" type="text" style="width: 150px" 
		      						class="Wdate" onClick="WdatePicker()"
					                
					               >    
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">计划时间</label>
			</td>
		</tr>
		<tr>
		  <td align="right">
				<label class="Validform_label">项目名称:</label>
			</td>
			<td colspan="3" class="value">
		      		<input id="projectName" name="projectName" type="text" style="width: 150px"   
					                onclick="choose();" class="searchbox-inputtext15"
					               >
				                                   
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
	  </tr>
		<tr>
			<td align="right">
				<label class="Validform_label">申请说明:</label>
			</td>
			<td colspan="3" class="value">
				 <textarea id="planExplain" style="width:500px;" class="inputxt" rows="6" name="planExplain"></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">申请说明</label>
			</td>
	    </tr>
	</table>
			<div style="width: 900px;height: 900px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
			  <div style="width:900px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="zhbPlancpController.do?zhbPlanlistList&id=${zhbPlancpPage.id}" icon="icon-search" title="采购申请材料详细" id="zhbPlanlist"></t:tab>
				</t:tabs>
	</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_zhbPlanlist_table_template">
		<tr >
			 <td align="center" width="30"><div width="25" name="xh"></div></td>
			 <td align="center" width="30"><input width="20" type="checkbox" name="ck"/></td>
				  <td align="left" width="120">
					       	<input id="zhbPlanlistListcpmc_index" readonly="true" name="" maxlength="36"  
						  		type="text" class="inputxt"  style="width:100%;" >
					        <input id="zhbPlanlistListcp_index" name="zhbPlanlistList[#index#].cp.id" maxlength="36" 
						  		type="hidden" class="inputxt"  style="width:110px;" >       
					  <label class="Validform_label" style="display: none;">产品名称</label>
				  </td>
				   <!-- <td align="left" style="width:120px;">
					       	<input id="zhbPlanlistListlxbh_index" name="" maxlength="36" 
						  		type="text" class="inputxt"  style="width:110px;">
					  <label class="Validform_label" style="display: none;">类型</label>
				  </td> -->
				   <td align="left" width="120">
					       	<input id="zhbPlanlistListbrand_index" readonly="true" name="" maxlength="36" 
						  		type="text" class="inputxt"  style="width:95%">
					  <label class="Validform_label" style="display: none;">品牌</label>
				  </td>
				  <td align="left" width="120">
					  	<input name="zhbPlanlistList[#index#].planNumber" maxlength="32" 
					  		type="text" class="inputxt"  style="width:110px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">计划数量</label>
				  </td>
				  <td align="left" width="120">
					  	<input  name="zhbPlanlistList[#index#].planPrice" maxlength="32" 
					  		type="text" class="inputxt"  style="width:110px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">计划单价</label>
				  </td>
				  <td align="left" width="120">
					       	<input name="zhbPlanlistList[#index#].remark" maxlength="300" 
						  		type="text" class="inputxt"  style="width:110px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				<!--   <td align="left">
					  	<input name="zhbPlanlistList[#index#].examinNumber" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">审核数量</label>
				  </td>
				  <td align="left">
					  	<input name="zhbPlanlistList[#index#].examinPrice" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">审核单价</label>
				  </td> -->
			</tr>
		 </tbody>
		 
		</table>
 </body>
 <script src = "webpage/com/gfdz/zhb/zhbPlancp.js"></script>	