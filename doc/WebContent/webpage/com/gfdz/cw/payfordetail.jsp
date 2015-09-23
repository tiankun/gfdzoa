<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>款项支付子表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="payfordetailController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${payfordetailPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							材料:
						</label>
					</td>
					<td class="value">
					     	 <input id="cp" name="cp" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">材料</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							采购执行子表:
						</label>
					</td>
					<td class="value">
					     	 <input id="cgzx" name="cgzx" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">采购执行子表</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							材料数量 :
						</label>
					</td>
					<td class="value">
					     	 <input id="num" name="num" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">材料数量 </label>
						</td>
					<td align="right">
						<label class="Validform_label">
							材料单价:
						</label>
					</td>
					<td class="value">
					     	 <input id="price" name="price" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">材料单价</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							付款金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="money" name="money" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款金额</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							付款申请人:
						</label>
					</td>
					<td class="value">
					     	 <input id="userId" name="userId" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款申请人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							付款时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="odate" name="odate" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							供应商:
						</label>
					</td>
					<td class="value">
					     	 <input id="gysml" name="gysml" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供应商</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							款项支付主表:
						</label>
					</td>
					<td class="value">
					     	 <input id="payfor" name="payfor" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">款项支付主表</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							申请事由:
						</label>
					</td>
					<td class="value">
					     	 <input id="applyreason" name="applyreason" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请事由</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							附件数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="fujnum" name="fujnum" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">附件数量</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							项目:
						</label>
					</td>
					<td class="value">
					     	 <input id="project" name="project" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/gfdz/cw/payfordetail.js"></script>		