<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>部门信息</title>
<t:base type="jquery,easyui,tools"></t:base>
<script type="text/javascript">
	$(function() {
		$('#cc').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
            width: 155,
            onSelect : function(node) {
//                alert(node.text);
                changeOrgType();
            }
        });
        if(!$('#cc').val()) { // 第一级，只显示公司选择项
            var orgTypeSelect = $("#orgType");
            var companyOrgType = '<option value="1" <c:if test="${orgType=='1'}">selected="selected"</c:if>><t:mutiLang langKey="common.company"/></option>';
            orgTypeSelect.empty();
            orgTypeSelect.append(companyOrgType);
        } else { // 非第一级，不显示公司选择项
            $("#orgType option:first").remove();
        }
        if($("#id").val()) {
            $('#cc').combotree('disable');
        }
        if('${empty pid}' == 'false') { // 设置新增页面时的父级
            $('#cc').combotree('setValue', '${pid}');
        }
	});
    function changeOrgType() { // 处理组织类型，不显示公司选择项
        var orgTypeSelect = $("#orgType");
        var optionNum = orgTypeSelect.get(0).options.length;
        if(optionNum == 1) {
            $("#orgType option:first").remove();
            var bumen = '<option value="2" <c:if test="${orgType=='2'}">selected="selected"</c:if>><t:mutiLang langKey="common.department"/></option>';
            var gangwei = '<option value="3" <c:if test="${orgType=='3'}">selected="selected"</c:if>><t:mutiLang langKey="common.position"/></option>';
            orgTypeSelect.append(bumen).append(gangwei);
        }
    }
</script>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" layout="div" dialog="true" action="systemController.do?saveDepart">
	<input id="id" name="id" type="hidden" value="${depart.id }">
	<fieldset class="step">
        <div class="form">
            <label class="Validform_label"> <t:mutiLang langKey="common.department.name"/>: </label>
            <input name="departname" class="inputxt" value="${depart.departname }"  datatype="s1-20">
            <span class="Validform_checktip"><t:mutiLang langKey="departmentname.rang1to20"/></span>
        </div>
        <div class="form">
            <label class="Validform_label"> <t:mutiLang langKey="position.desc"/>: </label>
            <input name="description" class="inputxt" value="${depart.description }">
        </div>
        <div class="form">
            <label class="Validform_label"> <t:mutiLang langKey="parent.depart"/>: </label>
            <input id="cc" name="TSPDepart.id" value="${depart.TSPDepart.id}">
        </div>
        <div class="form">
            <input type="hidden" name="orgCode" value="${depart.orgCode }">
            <label class="Validform_label"> <t:mutiLang langKey="common.org.type"/>: </label>
            <select name="orgType" id="orgType">
                <option value="1" <c:if test="${orgType=='1'}">selected="selected"</c:if>><t:mutiLang langKey="common.company"/></option>
                <option value="2" <c:if test="${orgType=='2'}">selected="selected"</c:if>><t:mutiLang langKey="common.department"/></option>
                <option value="3" <c:if test="${orgType=='3'}">selected="selected"</c:if>><t:mutiLang langKey="common.position"/></option>
            </select>
        </div>
       <div class="form">
		<label class="Validform_label">部门领导: </label>
                <input id="departManager" name="departManager.id" type="hidden" value="${depart.departManager.id}" >
                <input name="realName" class="inputxt" value="${depart.departManager.realName }" id="realName" readonly="readonly" datatype="*" />
               	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose_402891f04d46f392014d46f45a490004()">选择</a>
               	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll_402891f04d46f392014d46f45a490004();">清空</a>
				<script type="text/javascript">
					var windowapi = frameElement.api, W = windowapi.opener;
					function choose_402891f04d46f392014d46f45a490004() {
						if (typeof (windowapi) == 'undefined') {
							$
									.dialog({
										content : 'url:userController.do?departManager',
										zIndex : 2100,
										title : '角色列表',
										lock : true,
										width : 400,
										height : 350,
										left : '85%',
										top : '65%',
										opacity : 0.4,
										button : [
												{
													name : '确定',
													callback : clickcallback_402891f04d46f392014d46f45a490004,
													focus : true
												}, {
													name : '取消',
													callback : function() {
													}
												} ]
									});
						} else {
							$
									.dialog({
										content : 'url:userController.do?departManager',
										zIndex : 2100,
										title : '角色列表',
										lock : true,
										parent : windowapi,
										width : 400,
										height : 350,
										left : '85%',
										top : '65%',
										opacity : 0.4,
										button : [
												{
													name : '确定',
													callback : clickcallback_402891f04d46f392014d46f45a490004,
													focus : true
												}, {
													name : '取消',
													callback : function() {
													}
												} ]
									});
						}
					}
					function clearAll_402891f04d46f392014d46f45a490004() {
						if ($('#realName').length >= 1) {
							$('#realName').val('');
							$('#realName').blur();
						}
						if ($("input[name='realName']").length >= 1) {
							$("input[name='realName']").val('');
							$("input[name='realName']").blur();
						}
						$('#departManager').val("");
					}
					function clickcallback_402891f04d46f392014d46f45a490004() {
						iframe = this.iframe.contentWindow;
						var realName = iframe.getuserListSelections('realName');
						if ($('#realName').length >= 1) {
							$('#realName').val(realName);
							$('#realName').blur();
						}
						if ($("input[name='realName']").length >= 1) {
							$("input[name='realName']").val(realName);
							$("input[name='realName']").blur();
						}
						var id = iframe.getuserListSelections('id');
						if (id !== undefined && id != "") {
							$('#departManager').val(id);
						}
					}
				</script>
				<span class="Validform_checktip"></span>
		</div>
		       <div class="form">
		<label class="Validform_label">分管领导: </label>
                <input id="managerLeader" name="managerLeader.id" type="hidden" value="${depart.managerLeader.id}" >
                <input name="realName1" class="inputxt" value="${depart.managerLeader.realName }" id="managerLeaderName" readonly="readonly" datatype="*" />
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose_402891f04d46f392014d46f65ec80006()">选择</a>
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll_402891f04d46f392014d46f65ec80006();">清空</a>
				<script type="text/javascript">
					var windowapi = frameElement.api, W = windowapi.opener;
					function choose_402891f04d46f392014d46f65ec80006() {
						if (typeof (windowapi) == 'undefined') {
							$
									.dialog({
										content : 'url:userController.do?managerLeader',
										zIndex : 2100,
										title : '角色列表',
										lock : true,
										width : 400,
										height : 350,
										left : '85%',
										top : '65%',
										opacity : 0.4,
										button : [
												{
													name : '确定',
													callback : clickcallback_402891f04d46f392014d46f65ec80006,
													focus : true
												}, {
													name : '取消',
													callback : function() {
													}
												} ]
									});
						} else {
							$
									.dialog({
										content : 'url:userController.do?managerLeader',
										zIndex : 2100,
										title : '角色列表',
										lock : true,
										parent : windowapi,
										width : 400,
										height : 350,
										left : '85%',
										top : '65%',
										opacity : 0.4,
										button : [
												{
													name : '确定',
													callback : clickcallback_402891f04d46f392014d46f65ec80006,
													focus : true
												}, {
													name : '取消',
													callback : function() {
													}
												} ]
									});
						}
					}
					function clearAll_402891f04d46f392014d46f65ec80006() {
						if ($('#realName1').length >= 1) {
							$('#realName1').val('');
							$('#realName1').blur();
						}
						if ($("input[name='realName1']").length >= 1) {
							$("input[name='realName1']").val('');
							$("input[name='realName1']").blur();
						}
						$('#managerLeader').val("");
					}
					function clickcallback_402891f04d46f392014d46f65ec80006() {
						iframe = this.iframe.contentWindow;
						var realName1 = iframe
								.getmanagerLeaderSelections('realName');
						if ($('#realName1').length >= 1) {
							$('#realName1').val(realName1);
							$('#realName1').blur();
						}
						if ($("input[name='realName1']").length >= 1) {
							$("input[name='realName1']").val(realName1);
							$("input[name='realName1']").blur();
						}
						var id = iframe.getmanagerLeaderSelections('id');
						if (id !== undefined && id != "") {
							$('#managerLeader').val(id);
						}
					}
				</script>

				<span class="Validform_checktip"></span>
		</div>
	</fieldset>
</t:formvalid>
</body>
</html>
