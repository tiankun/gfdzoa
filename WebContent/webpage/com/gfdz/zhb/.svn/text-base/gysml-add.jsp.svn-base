<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>供应商名录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="gysmlController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${gysmlPage.id }">
					<input id="createName" name="createName" type="hidden" value="${gysmlPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${gysmlPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${gysmlPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${gysmlPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${gysmlPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${gysmlPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="lxbh" name="lxbh" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类型编号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							供应商编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="gysbh" name="gysbh" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供应商编号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="gsmc" name="gsmc" type="text" style="width: 150px" class="inputxt" datatype="*"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							公司电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="gsdh" name="gsdh" type="text" style="width: 150px" class="inputxt" datatype="*" 
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司电话</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司传真:
						</label>
					</td>
					<td class="value">
					     	 <input id="gscz" name="gscz" type="text" style="width: 150px" class="inputxt" datatype="*" 
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司传真</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							公司地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="gsdz" name="gsdz" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司地址</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司网站:
						</label>
					</td>
					<td class="value">
					     	 <input id="gswz" name="gswz" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司网站</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							注册资本:
						</label>
					</td>
					<td class="value">
					     	 <input id="zczb" name="zczb" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">注册资本</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司法人:
						</label>
					</td>
					<td class="value">
					     	 <input id="gsfr" name="gsfr" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司法人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							成立时间:
						</label>
					</td>
					<td class="value">
						    <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width: 150px" id="clsj" name="clsj" ignore="ignore" value="">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">成立时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							负责人:
						</label>
					</td>
					<td class="value">
					     	 <input id="fzr" name="fzr" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">负责人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							负责人电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="fzrdh" name="fzrdh" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">负责人电话</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联系人:
						</label>
					</td>
					<td class="value">
					     	 <input id="lxr" name="lxr" type="text" style="width: 150px" class="inputxt" datatype="*" 
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							联系人电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="lxrdh" name="lxrdh" type="text" style="width: 150px" class="inputxt" datatype="*" 
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系人电话</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							付款条件:
						</label>
					</td>
					<td class="value">
					     	 <input id="fktj" name="fktj" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款条件</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							供货期:
						</label>
					</td>
					<td class="value">
					     	 <input id="ghq" name="ghq" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供货期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							配送方式:
						</label>
					</td>
					<td class="value">
					     	 <input id="psfs" name="psfs" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">配送方式</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							是否技术支持:
						</label>
					</td>
					<td class="value">
					     	 <input id="sfjszc" name="sfjszc" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否技术支持</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否一般纳税人:
						</label>
					</td>
					<td class="value">
					     	 <input id="sfybnsr" name="sfybnsr" type="text" style="width: 150px" class="inputxt" datatype="*" 
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否一般纳税人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							调查及评价报告编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="pjbgbh" name="pjbgbh" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">调查及评价报告编号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							首次列入日期:
						</label>
					</td>
					<td class="value">					   
					        <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width: 150px" id="sclrrq" name="sclrrq" ignore="ignore" value="">			               
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">首次列入日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							年度复评结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="ndfpjg" name="ndfpjg" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年度复评结果</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							复评时间:
						</label>
					</td>
					<td class="value">
							<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="fpsj" name="fpsj" ignore="ignore" value="">	               
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">复评时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							评定结论:
						</label>
					</td>
					<td class="value">
					     	 <input id="pdjl" name="pdjl" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">评定结论</label>
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
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/gfdz/gys/gysml.js"></script>		