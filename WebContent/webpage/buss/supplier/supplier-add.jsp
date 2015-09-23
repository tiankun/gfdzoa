<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>供货商</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="supplierController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${supplierPage.id }">
					<input id="createName" name="createName" type="hidden" value="${supplierPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${supplierPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${supplierPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${supplierPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${supplierPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${supplierPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							供货商名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="supplierName" name="supplierName" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供货商名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							供货商类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="supplierModel" name="supplierModel" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供货商类型</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联系方式:
						</label>
					</td>
					<td class="value">
					     	 <input id="supplierContact" name="supplierContact" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系方式</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/supplier/supplier.js"></script>		