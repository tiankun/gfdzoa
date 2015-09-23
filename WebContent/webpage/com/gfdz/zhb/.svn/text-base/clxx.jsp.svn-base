<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>车辆信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="clxxController.do?save">
			<input id="id" name="id" type="hidden" value="${clxxPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							车辆名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="clmc" name="clmc" 
							   value="${clxxPage.clmc}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							车牌号码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cphm" name="cphm" 
							   value="${clxxPage.cphm}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							品牌:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pp" name="pp" 
							   value="${clxxPage.pp}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							车型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cx" name="cx" 
							   value="${clxxPage.cx}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发动机号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fdjh" name="fdjh" 
							   value="${clxxPage.fdjh}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							购买时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="gmsj" name="gmsj" ignore="ignore"
							   value="<fmt:formatDate value='${clxxPage.gmsj}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							购买价格（元）:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gmjg" name="gmjg" ignore="ignore"
							   value="${clxxPage.gmjg}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							年检时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="njsj" name="njsj" 
							   value="<fmt:formatDate value='${clxxPage.njsj}' type="date" pattern="yyyy-MM-dd"/>" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							保险购买时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="bxgmsj" name="bxgmsj" ignore="ignore"
							   value="<fmt:formatDate value='${clxxPage.bxgmsj}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							
						</label>
					</td>
					<td class="value">	   
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
						<%-- <input class="inputxt" id="bz" name="bz" ignore="ignore"
							   value="${clxxPage.bz}"> --%>
					   <textarea rows="5" cols="" class="inputxt" id="bz" name="bz" style="width: 500px" value="${clxxPage.bz}">${clxxPage.bz}</textarea>		   
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>