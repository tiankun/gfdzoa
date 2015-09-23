<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>合同信息登记</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="htdjController.do?doAdd" tiptype="1">
		<input id="id" name="id" type="hidden" value="${htdjPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							类别编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="lxbh" name="lxbh" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类别编号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							合同编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="htbh" name="htbh" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同编号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							合同名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="htmc" name="htmc" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同名称</label>
						</td>
					<td align="right">
						
					</td>
					<td class="value">
					     
				    </td>
					</tr>
					<tr>
					<td align="right">
						<label class="Validform_label">
							合同内容:
						</label>
					</td>
					<td class="value" colspan="3">
					     	<!--  <input id="htnr" name="htnr" type="text" style="width: 150px" class="inputxt"  
								               
								               > -->
						<textarea id="htnr" name="htnr" type="text" style="width: 500px" class="inputxt"  rows="7"
								               
								               ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同内容</label>
						</td>
					
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							合同单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="htdw" name="htdw" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同单位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							合同日期:
						</label>
					</td>
					<td class="value">
					     	 <!-- <input id="htrq" name="htrq" type="text" style="width: 150px" class="inputxt"  
								               
								               > -->
				            <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width: 150px" id="htrq" name="htrq" ignore="ignore" value="">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							合同金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="htje" name="htje" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同金额</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							存档份数:
						</label>
					</td>
					<td class="value">
					     	 <input id="cdfs" name="cdfs" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">存档份数</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							经办人:
						</label>
					</td>
					<td class="value">
					     	 <input id="jbr" name="jbr" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经办人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							存放位置:
						</label>
					</td>
					<td class="value">
					     	 <input id="cfwz" name="cfwz" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">存放位置</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="bz" name="bz" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建日期:
						</label>
					</td>
					<td class="value">
					     	 <!-- <input id="createDate" name="createDate" type="text" style="width: 150px" class="inputxt"  
								               
								               > -->
						    <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width: 150px" id="createDate" name="createDate" ignore="ignore" value="">		               
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建人:
						</label>
					</td>
					<td class="value">
					     	 <input id="createName" name="createName" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							编辑时间:
						</label>
					</td>
					<td class="value">
					     	 <!-- <input id="updateDate" name="updateDate" type="text" style="width: 150px" class="inputxt"  
								               
								               > -->
						    <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="updateDate" name="updateDate" ignore="ignore" value="">		               
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">编辑时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							编辑人:
						</label>
					</td>
					<td class="value">
					     	 <input id="updateName" name="updateName" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">编辑人</label>
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
  <script src = "webpage/com/gfdz/zhb/htdj.js"></script>		