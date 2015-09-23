<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>计划采购申请审核</title>
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
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zhbPlanaditController.do?doUpdate">
					<input id="id" name="id" type="hidden" value="${zhbPlanaditPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zhbPlanaditPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zhbPlanaditPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zhbPlanaditPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${zhbPlanaditPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zhbPlanaditPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zhbPlanaditPage.updateDate }">
					<input id="plancpId" name="plancpId" type="hidden" value="${zhbPlancpPage.id}">
					<input id="flag" name="flag" type="hidden" value="${zhbPlanaditPage.flag }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
		 <td align="right">
				<label class="Validform_label">审核人:</label>
			</td>
			<td class="value">
		     	 <input id="examinPerson" name="examinPerson" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${zhbPlanaditPage.examinPerson}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核人</label>
			</td>
		  <td align="right">
				<label class="Validform_label">审核时间:</label>
			</td>
			<td class="value">
		     	 <input id="examinTime" name="examinTime" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${zhbPlanaditPage.examinTime}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核时间</label>
			</td>
	  </tr>
		<tr>
			<td align="right">
				<label class="Validform_label">审核说明:</label>
			</td>
			<td colspan="3" class="value">
				 <textarea id="examinExplain" style="width:500px;" class="inputxt" rows="6" name="examinExplain">${zhbPlanaditPage.examinExplain}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核说明</label>
			</td>
		</tr>
		
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
			  <div style="width:960px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="zhbPlanaditController.do?zhbPlanlistList&id=${zhbPlancpPage.id}" icon="icon-search" title="计划采购材料清单" id="zhbPlanlist"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_zhbPlanlist_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					       	<input name="zhbPlanlistList[#index#].matenalId" maxlength="36" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">材料编号</label>
				  </td>
				  <td align="left">
					  	<input name="zhbPlanlistList[#index#].planNumber" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">计划数量</label>
				  </td>
				  <td align="left">
					  	<input name="zhbPlanlistList[#index#].planPrice" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">计划单价</label>
				  </td>
				  <td align="left">
					       	<input name="zhbPlanlistList[#index#].remark" maxlength="300" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left">
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
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/gfdz/zhb/zhbPlanadit.js"></script>	