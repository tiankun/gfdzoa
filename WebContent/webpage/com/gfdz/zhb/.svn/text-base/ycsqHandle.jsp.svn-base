<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用车申请</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  	   $(function(){
 	       $("#ycsqinfo tr td").each(function(){
 	           $(this).find("input").attr("disabled",true);
 	           $(this).find("textarea").attr("disabled",true);
 	           $(this).find("checkbox").attr("disabled",true);
 	           $(this).find("select").attr("disabled",true);
 	       });
 	      getStaff();
 	   });
  	   
  	 function getStaff(){
 		  $.getJSON("zzsqController.do?getStaff",function(data){
 			  $("#staff").html("");
 			  var o='<option value="">==请选择==</option>';
 			  if(data && data.length>0){
 				  for(var i=0;i<data.length;i++){
 					 o+='<option value="'+data[i].id+'">'+data[i].realName+'</option>'; 
 				  }
 			  }
 			  $(o).appendTo("#staff");
 		  });
 	  }	
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ycsqController.do?completeTask" tiptype="1">
					
		<input id="id" name="id" type="hidden" value="${ycsq.id }">
		<table id="ycsqinfo" style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用车类型:
						</label>
					</td>
					<td class="value">
					<t:dictSelect hasLabel="false" field="lxbh" id="lxbh" typeGroupCode="usecartype" extendJson="{\"datatype\":\"*\"}" defaultVal="${ycsq.lxbh }"></t:dictSelect>
<!-- 					     	<input id="lxbh" name="lxbh" type="text" style="width: 150px" class="inputxt" datatype="*" errormsg="类型编号不为空"> -->
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类型编号</label>
					</td>
					
					<td align="right">
						
					</td>
					<td class="value">
					     	
					</td>					
						</tr>
						<tr>
						
						<td align="right">
						<label class="Validform_label">
							申请人:
						</label>
					</td>
					    <td class="value">
					    	<input id="sqr" name="sqr" type="hidden" style="width: 150px" class="inputxt" value="${user.id}" readonly="readonly">
					     	<input id="sqr" name="sqrName" type="text" style="width: 150px" class="inputxt" value="${user.realName}" readonly="readonly">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人</label>														
						</td>
					<td align="right">
						<label class="Validform_label">
							申请时间:
						</label>
					</td>
					<td class="value">
							<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="sqsj" name="sqsj" 
							ignore="ignore" value="<fmt:formatDate value='${date!=null ? date : ycsq.sqsj}' type="date" pattern="yyyy-MM-dd HH:mm:ss"/>">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请时间</label>
					</td>
					
					
				     
			</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							计划开始时间:
						</label>
					</td>
					<td class="value">					     
					        <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="jhkssj" name="jhkssj" datatype="*"  ignore="ignore" value="<fmt:formatDate value='${ycsq.jhkssj }' type="date" pattern="yyyy-MM-dd"/>">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计划开始时间</label>
					</td>
					<!-- </tr>
				    <tr> -->
					<td align="right">
						<label class="Validform_label">
							计划结束时间:
						</label>
					</td>
					<td class="value">
							<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="jhjssj" name="jhjssj" ignore="ignore" value="<fmt:formatDate value='${ycsq.jhjssj }' type="date" pattern="yyyy-MM-dd"/>" datatype="*">	               
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计划结束时间</label>
					</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							用车原因:
						</label>
					</td>
					<td class="value" colspan="3">
					     	<!-- <input id="ycyy" name="ycyy" type="text" style="width: 150px" class="inputxt"> -->
							<textarea class="textarea" id="ycyy" name="ycyy" rows="5" cols="15" datatype="*" errormsg="用车原因不为空">${ycsq.ycyy }</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用车原因</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							行车路线:
						</label>
					</td>
					<td class="value" colspan="3">
					     <!-- 	<input id="xclx" name="xclx" type="text" style="width: 150px" class="inputxt"> -->
							<textarea class="textarea"  id="xclx" name="xclx" rows="5" cols="15"  datatype="*" errormsg="用车线路不为空">${ycsq.xclx }</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">行车路线</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" colspan="3">
					     	<!-- <input id="bz" name="bz" type="text" style="width: 150px" class="inputxt"> -->
					     	<textarea class="textarea"  id="bz" name="bz" rows="5" cols="15">${ycsq.bz }</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
				</tr>
			</table>
			<div class="formtitle" title="审批信息">审批信息</div>
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<input id="taskKey" name="taskKey" type="hidden" value="${taskKey}">			
				<input id="taskId" name="taskId" type="hidden" value="${taskId}">
				<input id="applyUserId" name="applyUserId" type="hidden" value="${ycsq.sqr}">
				<c:if test="${taskKey=='deptLeaderAudit'}">
						<tr>
							<td align="right" width="105px">
								<label class="Validform_label">
									审批结果:
								</label>
							</td>
							<td class="value">
							<t:dictSelect hasLabel="false" field="auditType" id="auditType" typeGroupCode="auditType" defaultVal=""></t:dictSelect>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label class="Validform_label">
									审批意见:
								</label>
							</td>
							<td class="value">
							<textarea class="textarea" id="postil" name="postil"></textarea>
							</td>
						</tr>
				</c:if>	
					<c:if test="${taskKey=='officeLeaderAudit'}">
						<tr>
							<td align="right" width="105px">
								<label class="Validform_label">
									审批结果:
								</label>
							</td>
							<td class="value">
							<t:dictSelect hasLabel="false" field="auditType" id="auditType" typeGroupCode="auditType" defaultVal=""></t:dictSelect>
							</td>
						</tr>
						<tr>
							<td align="right">
								<label class="Validform_label">
									审批意见:
								</label>
							</td>
							<td class="value">
							<textarea class="textarea" id="postil" name="postil"></textarea>
							</td>
						</tr>
						<tr>
						<td align="right" width="105px">
							<label class="Validform_label">
								派车人:
							</label>
						</td>
						<td class="value">
							<select id="staff" name="staff">
							
							</select>
						</td>
					</tr>
				</c:if>	
				<c:if test="${taskKey=='sendCar'}">
					
					<tr>
						<td align="right" width="105px">
							<label class="Validform_label">
								确认领用:
							</label>
						</td>
						<td class="value">
						<t:dictSelect hasLabel="false" field="auditType" id="auditType" typeGroupCode="yesorno" defaultVal=""></t:dictSelect>
						</td>
					</tr>
				</c:if>
				</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/gfdz/zhb/ycsq.js"></script>		