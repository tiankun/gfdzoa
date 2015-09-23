<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用车申请</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ycsqController.do?doUpdate" tiptype="1">
			<input id="id" name="id" type="hidden" value="${ycsqPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型编号:
						</label>
					</td>
					<td class="value">
					     	<input id="lxbh" name="lxbh" type="text" style="width: 150px" class="inputxt" datatype="*" value="${ycsqPage.lxbh}">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类型编号</label>
					</td>
					
					<td align="right">
						
					</td>
					<td class="value">
					     	
					</td>
					
						</tr>
						<tr>
						<td align="right">
						<label class="Validform_label">
							申请人:
						</label>
					</td>
					<td class="value">
					     	<input id="sqr" name="sqr" type="text" style="width: 150px" class="inputxt" value="${ycsqPage.sqr}" readonly="readonly">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人</label>
					</td>
						
					<td align="right">
						<label class="Validform_label">
							申请时间:
						</label>
					</td>
					<td class="value">
							<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="sqsj" name="sqsj" ignore="ignore" value="${ycsqPage.sqsj}">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请时间</label>
					</td>
				
					
				     
			</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							计划开始时间:
						</label>
					</td>
					<td class="value">					     
					        <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="jhkssj" name="jhkssj" datatype="*" ignore="ignore" value="${ycsqPage.jhkssj}">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计划开始时间</label>
					</td>
					<!-- </tr>
				    <tr> -->
					<td align="right">
						<label class="Validform_label">
							计划结束时间:
						</label>
					</td>
					<td class="value">
							<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="jhjssj" name="jhjssj" datatype="*" ignore="ignore" value="${ycsqPage.jhjssj}">	               
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计划结束时间</label>
					</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							用车原因:
						</label>
					</td>
					<td class="value" colspan="3">
					     	<!-- <input id="ycyy" name="ycyy" type="text" style="width: 150px" class="inputxt"> -->
							<textarea id="ycyy" name="ycyy" rows="5" cols="15" style="width: 500px" class="inputxt" value="${ycsqPage.ycyy}" datatype="*" errormsg="用车原因不为空">${ycsqPage.ycyy}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用车原因</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							行车路线:
						</label>
					</td>
					<td class="value" colspan="3">
					     <!-- 	<input id="xclx" name="xclx" type="text" style="width: 150px" class="inputxt"> -->
							<textarea id="xclx" name="xclx" rows="5" cols="15" style="width: 500px" class="inputxt" value="${ycsqPage.xclx}" datatype="*" errormsg="用车线路不为空">${ycsqPage.xclx}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">行车路线</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" colspan="3">
					     	<!-- <input id="bz" name="bz" type="text" style="width: 150px" class="inputxt"> -->
					     	<textarea id="bz" name="bz" rows="5" cols="15" style="width: 500px" class="inputxt" value="${ycsqPage.bz}">${ycsqPage.bz}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
				<tr>
					
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/gfdz/zhb/ycsq.js"></script>		