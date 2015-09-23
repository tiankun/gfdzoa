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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="gysmlController.do?doUpdate" tiptype="1">
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
						<input class="inputxt" id="lxbh" name="lxbh" ignore="ignore"
							   value="${gysmlPage.lxbh}">
						<span class="Validform_checktip"></span>
					</td>
			
					<td align="right">
						<label class="Validform_label">
							供应商编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gysbh" name="gysbh" 
							   value="${gysmlPage.gysbh}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gsmc" name="gsmc" 
							   value="${gysmlPage.gsmc}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							公司电话:
						</label>
   				</td>
					<td class="value">
						<input class="inputxt" id="gsdh" name="gsdh" 
							   value="${gysmlPage.gsdh}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司传真:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="gscz" style="width: 500px" name="gscz" 
							   value="${gysmlPage.gscz}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司地址:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="gsdz" name="gsdz" style="width: 500px" ignore="ignore"
							   value="${gysmlPage.gsdz}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司网址:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="gswz" style="width: 500px" name="gswz" ignore="ignore"
							   value="${gysmlPage.gswz}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司法人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gsfr" name="gsfr" ignore="ignore"
							   value="${gysmlPage.gsfr}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							注册资本:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zczb" name="zczb" ignore="ignore"
							   value="${gysmlPage.zczb}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							成立时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="clsj" name="clsj" ignore="ignore"
							   value="<fmt:formatDate value='${gysmlPage.clsj}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							负责人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fzr" name="fzr" ignore="ignore"
							   value="${gysmlPage.fzr}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							负责人电话:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fzrdh" name="fzrdh" ignore="ignore"
							   value="${gysmlPage.fzrdh}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							联系人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lxr" name="lxr" 
							   value="${gysmlPage.lxr}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联系人电话:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lxrdh" name="lxrdh" 
							   value="${gysmlPage.lxrdh}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							付款条件:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fktj" name="fktj" ignore="ignore"
							   value="${gysmlPage.fktj}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							供货期:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ghq" name="ghq" ignore="ignore"
							   value="${gysmlPage.ghq}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							配送方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="psfs" name="psfs" ignore="ignore"
							   value="${gysmlPage.psfs}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否技术支持:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sfjszc" name="sfjszc" ignore="ignore"
							   value="${gysmlPage.sfjszc}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							是否一般纳税人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sfybnsr" name="sfybnsr" 
							   value="${gysmlPage.sfybnsr}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							调查及评价报告编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pjbgbh" name="pjbgbh" ignore="ignore"
							   value="${gysmlPage.pjbgbh}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							首次列入日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="sclrrq" name="sclrrq" ignore="ignore"
							   value="<fmt:formatDate value='${gysmlPage.sclrrq}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							年度复评结果（0：不合格；1：合格）:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ndfpjg" name="ndfpjg" ignore="ignore"
							   value="${gysmlPage.ndfpjg}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							复评时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="fpsj" name="fpsj" ignore="ignore"
							   value="<fmt:formatDate value='${gysmlPage.fpsj}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							评定结论:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="pdjl" name="pdjl" style="width: 500px" ignore="ignore"
							   value="${gysmlPage.pdjl}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="bz" name="bz" style="width: 500px" ignore="ignore"
							   value="${gysmlPage.bz}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/gfdz/gys/gysml.js"></script>		