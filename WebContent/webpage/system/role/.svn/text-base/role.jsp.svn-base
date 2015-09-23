<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><t:mutiLang langKey="common.role.info"/></title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" layout="div" dialog="true" action="roleController.do?saveRole">
	<input name="id" type="hidden" value="${role.id}">
	<fieldset class="step">
	<div class="form"><label class="Validform_label"><t:mutiLang langKey="common.role.name"/>:</label> <input name="roleName" class="inputxt" value="${role.roleName }" datatype="s2-8"> <span class="Validform_checktip"></span>
	</div>
	<div class="form"><label class="Validform_label"> <t:mutiLang langKey="common.role.code"/>: </label> <input name="roleCode" id="roleCode" ajaxurl="roleController.do?checkRole&code=${role.roleCode }" class="inputxt"
		value="${role.roleCode }" datatype="s2-15"> <span class="Validform_checktip"></span></div>
		
		<div class="form"><label class="Validform_label"> 角色级别: </label> 
		<t:dictSelect hasLabel="false" field="roleLevel" id="roleLevel" typeGroupCode="rolelevel" extendJson="{\"datatype\":\"*\"}" defaultVal="${role.roleLevel }"></t:dictSelect>
 <span class="Validform_checktip"></span></div>
	</fieldset>
</t:formvalid>
</body>
</html>
