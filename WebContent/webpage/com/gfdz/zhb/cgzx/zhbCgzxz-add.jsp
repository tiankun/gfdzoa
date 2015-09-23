<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>采购执行主表</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="zhbCgzxzController.do?doAdd">
					<input id="id" name="id" type="hidden" value="${zhbCgzxzPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zhbCgzxzPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zhbCgzxzPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zhbCgzxzPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${zhbCgzxzPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zhbCgzxzPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zhbCgzxzPage.updateDate }">
					<input id="cgqdId" name="cgqdId" type="hidden" value="${zhbCgzxzPage.cgqdId }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">创建时间:</label>
			</td>
			<td class="value">
					  <input id="inputTime" name="inputTime" type="text" style="width: 150px" 
		      						class="Wdate" onClick="WdatePicker()"
					                
					               >    
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">创建时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">创建人:</label>
			</td>
			<td class="value">
		     	 <input id="inputUser" name="inputUser" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">创建人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
		     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
			<td align="right">
				<label class="Validform_label">状态:</label>
			</td>
			<td class="value">
		     	 <input id="falg" name="falg" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">状态</label>
			</td>
		</tr>
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="zhbCgzxzController.do?zhbCgzxList&id=${zhbCgzxzPage.id}" icon="icon-search" title="执行材料明细" id="zhbCgzx"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_zhbCgzx_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="zhbCgzxList[#index#].cgsqId" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">采购申请单主键</label>
				  </td>
				  <td align="left">
					  	<input name="zhbCgzxList[#index#].buyAmount" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">采购数量</label>
				  </td>
				  <td align="left">
					  	<input name="zhbCgzxList[#index#].buyPrice" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">采购单价</label>
				  </td>
				  <td align="left">
					  	<input name="zhbCgzxList[#index#].merchant" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">付款商家</label>
				  </td>
				  <td align="left">
					  	<input name="zhbCgzxList[#index#].payAmount" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">付款金额</label>
				  </td>
				  <td align="left">
					  	<input name="zhbCgzxList[#index#].payType" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">付款方式</label>
				  </td>
				  <td align="left">
					  	<input name="zhbCgzxList[#index#].payTime" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">付款时间</label>
				  </td>
				  <td align="left">
					  	<input name="zhbCgzxList[#index#].payExplain" maxlength="4000" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">付款说明</label>
				  </td>
				  <td align="left">
					  	<input name="zhbCgzxList[#index#].remark" maxlength="4000" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left">
					  	<input name="zhbCgzxList[#index#].flag" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">状态</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/gfdz/zhb/zhbCgzxz.js"></script>	