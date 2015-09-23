<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>商品名称</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="goodsController.do?doUpdate" tiptype="3">
					<input id="id" name="id" type="hidden" value="${baseGoodsPage.id }">
					<input id="createName" name="createName" type="hidden" value="${baseGoodsPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${baseGoodsPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${baseGoodsPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${baseGoodsPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${baseGoodsPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${baseGoodsPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								商品名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="goodsName" name="goodsName" type="text" style="width: 150px" class="inputxt" value='${baseGoodsPage.goodsName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								商品型号:
							</label>
						</td>
						<td class="value">
						     	 <input id="goodsModel" name="goodsModel" type="text" style="width: 150px" class="inputxt" value='${baseGoodsPage.goodsModel}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品型号</label>
						</td>
					</tr>
					<tr>
					<td align="right">
							<label class="Validform_label">
								商品品牌:
							</label>
						</td>
					<td class="value">
					     	  <t:dictSelect field="goodsband" typeGroupCode="goodsBrand" hasLabel="false" defaultVal="${baseGoodsPage.goodsband}"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品品牌</label>
					</td>
				</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								商品单价:
							</label>
						</td>
						<td class="value">
						     	 <input id="goodsPrice" name="goodsPrice" type="text" style="width: 150px" class="inputxt" value='${baseGoodsPage.goodsPrice}' datatype="d">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品单价</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/goods/baseGoods.js"></script>		