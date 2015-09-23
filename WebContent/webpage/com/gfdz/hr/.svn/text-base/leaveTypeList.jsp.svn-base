<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
		<script type="text/javascript">
			$(function() {
				$('#leaveTypeList')
						.treegrid(
								{
									idField : 'id',
									treeField : 'text',
									title : ' 请假类型',
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
												width : 100
											},
											{
												field : 'null',
												title : ' 操作',
												width : 100,
												formatter : function(value,
														rec, index) {
													if (!rec.id) {
														return '';
													}
													var href = '';
													href += "[<a href='#' onclick=delObj('leaveTypeController.do?del&id="
															+ rec.id
															+ "','leaveTypeList')>";
													href += " 删除</a>]";
													return href;
												}
											} ] ],
									onLoadSuccess : function(data) {
										$("#leaveTypeList").treegrid("clearSelections");
			                            var roots = $("#leaveTypeList").treegrid("getRoots");
			                            if (roots.length > 0) {
			                                $.each(roots, function (i, item) {
			                                    $("#leaveTypeList").treegrid("expandAll", item.id);
			                                });
				                            }
									},
									onClickRow : function(rowData) {
										  alert();
										rowid = rowData.id;
										gridname = 'leaveTypeList';
									}
								});
				$('#leaveTypeList').treegrid('getPager').pagination({
					beforePageText : '',
					afterPageText : '/{pages}',
					displayMsg : '{from}-{to}共 {total}条',
					showPageList : true,
					showRefresh : true
				});
				$('#leaveTypeList').treegrid('getPager').pagination({
					onBeforeRefresh : function(pageNumber, pageSize) {
						$(this).pagination('loading');
						$(this).pagination('loaded');
					}
				});
			});
			function reloadTable() {
				try {
					$('#' + gridname).datagrid('reload');
					$('#' + gridname).treegrid('reload');
				} catch (ex) {
				}
			}
			function reloadleaveTypeList() {
				$('#leaveTypeList').treegrid('reload');
			}
			function getleaveTypeListSelected(field) {
				return getSelected(field);
			}
			function getSelected(field) {
				var row = $('#' + gridname).treegrid('getSelected');
				if (row != null) {
					value = row[field];
				} else {
					value = '';
				}
				return value;
			}
			function getleaveTypeListSelections(field) {
				var ids = [];
				var rows = $('#leaveTypeList').treegrid('getSelections');
				for (var i = 0; i < rows.length; i++) {
					ids.push(rows[i][field]);
				}
				ids.join(',');
				return ids
			};
			function getSelectRows() {
				return $('#leaveTypeList').datagrid('getChecked');
			}
			function leaveTypeListsearch() {
				var queryParams = $('#leaveTypeList').datagrid('options').queryParams;
				$('#leaveTypeListtb').find('*').each(function() {
					queryParams[$(this).attr('name')] = $(this).val();
				});
				$('#leaveTypeList')
						.treegrid(
								{
									url : 'leaveTypeController.do?datagrid&field=id,typeName,leaveDays,',
									pageNumber : 1
								});
			}
			function dosearch(params) {
				var jsonparams = $.parseJSON(params);
				$('#leaveTypeList')
						.treegrid(
								{
									url : 'leaveTypeController.do?datagrid&field=id,typeName,leaveDays,',
									queryParams : jsonparams
								});
			}
			function leaveTypeListsearchbox(value, name) {
				var queryParams = $('#leaveTypeList').datagrid('options').queryParams;
				queryParams[name] = value;
				queryParams.searchfield = name;
				$('#leaveTypeList').treegrid('reload');
			}
			$('#leaveTypeListsearchbox').searchbox({
				searcher : function(value, name) {
					leaveTypeListsearchbox(value, name);
				},
				menu : '#leaveTypeListmm',
				prompt : '请输入查询关键字'
			});
			function EnterPress(e) {
				var e = e || window.event;
				if (e.keyCode == 13) {
					leaveTypeListsearch();
				}
			}
			function searchReset(name) {
				$("#" + name + "tb").find(":input").val("");
				leaveTypeListsearch();
			}
		</script>
		<table width="100%" id="leaveTypeList" toolbar="#leaveTypeListtb"></table>
		<div id="leaveTypeListtb" style="padding: 3px; height: auto">
			<div style="height: 30px;" class="datagrid-toolbar">
				<span style="float: left;"><a href="#"
					class="easyui-linkbutton" plain="true" icon="icon-add"
					onclick="add(' 录入','leaveTypeController.do?addorupdate','leaveTypeList',null,null)">
						录入</a><a href="#" class="easyui-linkbutton" plain="true"
					icon="icon-edit"
					onclick="update(' 编辑','leaveTypeController.do?addorupdate','leaveTypeList',null,null)">
						编辑</a><a href="#" class="easyui-linkbutton" plain="true"
					icon="icon-search"
					onclick="detail(' 查看','leaveTypeController.do?addorupdate','leaveTypeList',null,null)">
						查看</a></span>
			</div>
		</div>

	</div>
 </div>