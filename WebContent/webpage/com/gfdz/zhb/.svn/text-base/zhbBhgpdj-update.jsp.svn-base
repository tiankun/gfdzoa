<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>不合格品登记</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zhbBhgpdjController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${zhbBhgpdjPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zhbBhgpdjPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zhbBhgpdjPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zhbBhgpdjPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${zhbBhgpdjPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zhbBhgpdjPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zhbBhgpdjPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								产品名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="cpmc" name="cpmc" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${zhbBhgpdjPage.cpmc}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">产品名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								规格型号:
							</label>
						</td>
						<td class="value">
						     	 <input id="ggxh" name="ggxh" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${zhbBhgpdjPage.ggxh}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">规格型号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								供方名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="gfmc" name="gfmc" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${zhbBhgpdjPage.gfmc}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">供方名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								不合格原因:
							</label>
						</td>
						<td class="value">
						     	 <input id="bhgyy" name="bhgyy" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${zhbBhgpdjPage.bhgyy}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">不合格原因</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								不合格数量:
							</label>
						</td>
						<td class="value">
						     	 <input id="bhgsl" name="bhgsl" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${zhbBhgpdjPage.bhgsl}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">不合格数量</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								经办人:
							</label>
						</td>
						<td class="value">
						     	 <input id="jbr" name="jbr" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${zhbBhgpdjPage.jbr}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经办人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								经办时间:
							</label>
						</td>
						<td class="value">
						     	 <input id="jbsj" name="jbsj" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${zhbBhgpdjPage.jbsj}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经办时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								不合格品处置:
							</label>
						</td>
						<td class="value">
						     	 <input id="bhgpcz" name="bhgpcz" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${zhbBhgpdjPage.bhgpcz}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">不合格品处置</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								批准人:
							</label>
						</td>
						<td class="value">
						     	 <input id="pzr" name="pzr" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${zhbBhgpdjPage.pzr}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">批准人</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								批准时间:
							</label>
						</td>
						<td class="value">
						     	 <input id="pzsj" name="pzsj" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${zhbBhgpdjPage.pzsj}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">批准时间</label>
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
									               
									                 value='${zhbBhgpdjPage.bz}'>
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
  <script src = "webpage/com/gfdz/bhg/zhbBhgpdj.js"></script>		