<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>不合格产品登记</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="bhgpdjController.do?save">
			<input id="id" name="id" type="hidden" value="${bhgpdjPage.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							产品名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cpmc" name="cpmc" 
							   value="${bhgpdjPage.cpmc}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							供方名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gfmc" name="gfmc" readonly="readonly"
							   value="${bhgpdjPage.gfmc}" datatype="*">
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
               	        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
               	        				<script type="text/javascript">
					var windowapi = frameElement.api, W = windowapi.opener;
					function choose() {
						if (typeof (windowapi) == 'undefined') {
							$
									.dialog({
										content : 'url:gysmlController.do?gysList',
										zIndex : 2100,
										title : '供应商列表',
										lock : true,
										width : 400,
										height : 350,
										left : '85%',
										top : '65%',
										opacity : 0.4,
										button : [
												{
													name : '确定',
													callback : clickcallback,
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
										content : 'url:gysmlController.do?gysList',
										zIndex : 2100,
										title : '供应商列表',
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
													callback : clickcallback,
													focus : true
												}, {
													name : '取消',
													callback : function() {
													}
												} ]
									});
						}
					}
					function clearAll() {
						if ($('#gfmc').length >= 1) {
							$('#gfmc').val('');
							$('#gfmc').blur();
						}
						$('#travelOtheruser').val("");
					}
					function clickcallback() {
						iframe = this.iframe.contentWindow;
						var gfmc = iframe.getgysmlListSelections('gsmc');
						if ($('#gfmc').length >= 1) {
							/* gfmc=gfmc+","+$('#gfmc').val(); */
						    /* gfmc=gfmc+$('#gfmc').val(); */
							$('#gfmc').val(gfmc);
							$('#gfmc').blur();
						}
						/* var id = iframe.getgysmlListSelections('id');
						if (id !== undefined && id != "") {
							if($('#gfmc').val()!="" &&$('#gfmc').val()!=undefined){
								id=id+","+$('#gfmc').val();
								
							}
							$('#gfmc').val(id);
						} */
					}
				</script>
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
				<tr><td align="right">
						<label class="Validform_label">
							规格型号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ggxh" name="ggxh" 
							   value="${bhgpdjPage.ggxh}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="right">
						<label class="Validform_label">
							不合格原因:
						</label>
					</td>
					<td class="value" colspan="3" >
						<input class="inputxt" id="bhgyy" name="bhgyy"
							   value="${bhgpdjPage.bhgyy}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							不合格数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="bhgsl" name="bhgsl" 
							   value="${bhgpdjPage.bhgsl}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							不合格品处置:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="bhgpcz" name="bhgpcz" ignore="ignore"
							   value="${bhgpdjPage.bhgpcz}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							经办人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jbr" name="jbr" 
							   value="${bhgpdjPage.jbr}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							经办时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="jbsj" name="jbsj" ignore="ignore"
							   value="<fmt:formatDate value='${bhgpdjPage.jbsj}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							批准人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pzr" name="pzr" ignore="ignore"
							   value="${bhgpdjPage.pzr}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							批准时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="pzsj" name="pzsj" ignore="ignore"
							   value="<fmt:formatDate value='${bhgpdjPage.pzsj}' type="date" pattern="yyyy-MM-dd"/>">
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
						<textarea class="textarea" id="bz" name="bz" ignore="ignore"  
							   value="${bhgpdjPage.bz}"></textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>