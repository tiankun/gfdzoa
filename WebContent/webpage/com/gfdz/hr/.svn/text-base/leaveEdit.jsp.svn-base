<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>请假管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/kindeditor/kindeditor.js"></script>
  <script type="text/javascript" src="plug-in/kindeditor/lang/zh_CN.js"></script>
      <script type="text/javascript">
        $(function(){
            $('#cc').combo({
                editable:false
            });
            $('#sp').appendTo($('#cc').combo('panel'));
            
            var editor;
            KindEditor.ready(function(K) {
            	editor = K.create('#leaveReasons', {
            		resizeType : 2,
            		minWidth:630,
            		width:'550px',
            		height:'150px',
            		filePostName:'file',
            		themeType : 'simple',
            		uploadJson:'uploadFileController.do?uploadImg',
            		afterBlur : function(url) {
                        $("#leaveReason").val(editor.html());
					},
            		items : [
            			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
            			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            			'insertunorderedlist', '|', 'emoticons', 'image','multiimage','link','fullscreen']
            	});
            });
        });
       
    </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="leaveController.do?completeTask">
			<input id="id" name="id" type="hidden" value="${leave.id }">
			<input id="processKey" name="processKey" type="hidden" value="${processKey }">
			<input id="taskKey" name="taskKey" type="hidden" value="${taskKey }">
			<input id="taskId" name="taskId" type="hidden" value="${taskId }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假类型:
						</label>
					</td>
					<td class="value" colspan="3">
<!-- 						<input class="inputxt" id="leaveType" name="leaveType" ignore="ignore" -->
<%-- 							   value="${leave.leaveType}"> --%>
    <select id="cc" name="leaveType.id" style="width:500px"></select>
    <div id="sp" style="padding:1px;height:500px">
		<script type="text/javascript">
			$(function() {
				$('#leaveTypeList')
						.treegrid(
								{
									idField : 'id',
									treeField : 'text',
									url : 'leaveTypeController.do?datagrid&field=id,typeName,leaveDays,',
									fit : true,
									loadMsg : '数据加载中...',
									pageSize : 10,
									pagination : false,
									pageList : [ 10, 20, 30 ],
									sortOrder : 'asc',
									rownumbers : true,
									singleSelect : true,
									fitColumns : true,
									showFooter : true,
									frozenColumns : [ [] ],
									columns : [ [
											{
												field : 'id',
												title : ' 编号',
												hidden : true
											},
											{
												field : 'text',
												title : ' 请假类型',
												width : 100
											},
											{
												field : 'src',
												title : ' 允许天数',
												width : 20
											} ] ],
									onLoadSuccess : function(data) {
										$("#leaveTypeList").treegrid("clearSelections");
// 			                            var roots = $("#leaveTypeList").treegrid("getRoots");
// 			                            if (roots.length > 0) {
// 			                                $.each(roots, function (i, item) {
// 			                                    $("#leaveTypeList").treegrid("expandAll", item.id);
// 			                                });
// 				                            }
									},
									onDblClickRow : function(rowData) {
										$('#cc').combo('setValue', rowData.id).combo('setText', rowData.text).combo('hidePanel');
									}
								});
			});
		</script>
		<table width="100%" id="leaveTypeList" ></table>
		</div>
		
		<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							开始时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="beginDate" name="beginDate" ignore="ignore"
							     value="<fmt:formatDate value='${leave.beginDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							开始区间:
						</label>
					</td>
					<td class="value">
						上午<input type="radio"  name="beginScope" checked="checked" value="0">
						下午<input type="radio"  name="beginScope"  value="1">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							结束时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="endDate" name="endDate" ignore="ignore"
							     value="<fmt:formatDate value='${leave.endDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							结束区间:
						</label>
					</td>
					<td class="value">
						上午<input  type="radio"  name="endScope" value="0">
						下午<input  type="radio"  name="endScope" checked="checked"  value="1">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							请假原因:
						</label>
					</td>
					<td class="value" colspan="3">
					<input class="inputxt" type="hidden" id="leaveReason" name="leaveReason" ignore="ignore" value="">
					<textarea id="leaveReasons" name="leaveReasons" class="textarea1">${leave.leaveReason }</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>