<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>工程信息表</title>
   <t:base type="jquery,easyui,tools,DatePicker,validate"></t:base>
   <script type="text/javascript">
	var windowapi = frameElement.api, W = windowapi.opener;
	function choose() {
		$.dialog({
				content : 'url:userController.do?departManager',
				zIndex : 2100,
				title : '角色列表',
				lock : true,
				parent : windowapi,
				width : 400,
				height : 350,
				left : '50%',
				top : '40%',
				opacity : 0.4,
				button : [
						{
							name : '确定',
							callback : function () {
								iframe = this.iframe.contentWindow;
								var salesManagerName = iframe.getuserListSelections('realName');
									$('#salesManagerName').val(salesManagerName);
									$('#salesManagerName').blur();
								var id = iframe.getuserListSelections('id');
									$('#salesManagerid').val(id);
							},
							focus : true
						}, {
							name : '取消',
							callback : function() {
							}
						} ]
			});
	}
	function clearAll() {
		if ($('#salesManagerName').length >= 1) {
			$('#salesManagerName').val('');
			$('#salesManagerName').blur();
		}
		$('#salesManagerid').val("");
	}
</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <form id="form_id" action="xsxmController.do?save">
			<div class="formtitle" title="项目基本信息">项目基本信息</div>
			<input id="id" name="id" type="hidden" value="${projectInfo.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right" width="95px">
						<label class="Validform_label">
							项目名称:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt validate[required]" id="projectName" name="projectName" style= "width:83%"
							   value="${projectInfo.projectName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							销售经理:
						</label>
					</td>
					<td class="value">
						<input class="inputxt validate[required]" id="salesManagerName" name="salesManager.realName"  value="${projectInfo.salesManager.realName !=null ? projectInfo.salesManager.realName : username }">
						<input type="hidden" id="salesManagerid" name="salesManager.id" value="${projectInfo.salesManager.id }">
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
		               	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							项目状态:
						</label>
					</td>
					<td class="value">
					<t:dictSelect hasLabel="false"  field="projectStatus" id="projectStatus" typeGroupCode="projectstate" defaultVal="${projectInfo.projectStatus }" extendJson="{\"class\":\"validate[required]\"}"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
			<div class="formtitle" title="客户信息">客户信息</div>
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							客户名称:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt validate[required]" id="customer" name="customer"  style= "width:83%" value="${projectInfo.customer}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联系人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt validate[required]" id="contacts" name="contacts" value="${projectInfo.contacts}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							联系电话:
						</label>
					</td>
					<td class="value">
						<input class="inputxt validate[required]" id="contactPhone" name="contactPhone" value="${projectInfo.contactPhone}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</form>
 </body>
 </html>