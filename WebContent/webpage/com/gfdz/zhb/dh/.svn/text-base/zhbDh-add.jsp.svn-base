<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>采购到货记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zhbDhController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${zhbDhPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zhbDhPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zhbDhPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zhbDhPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${zhbDhPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zhbDhPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zhbDhPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							采购执行单主键:
						</label>
					</td>
					<td class="value">
					     	 <input id="cgzxId" name="cgzxId" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">采购执行单主键</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							到货数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="aogNumber" name="aogNumber" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">到货数量</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							到货日期:
						</label>
					</td>
					<td class="value">
							   <input id="aogDate" name="aogDate" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								                
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">到货日期</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							实际供应商:
						</label>
					</td>
					<td class="value">
					     	 <input id="trueSupplier" name="trueSupplier" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际供应商</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							到货确认人:
						</label>
					</td>
					<td class="value">
					     	 <input id="identifier" name="identifier" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">到货确认人</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="flag" name="flag" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/gfdz/zhb/zhbDh.js"></script>		