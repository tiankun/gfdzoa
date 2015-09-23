<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>成本合算</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(function() {
	  $("#sdsgf,#bgje").live("change keyup",function(){
		  $("#hj").val($("#sdsgf").val()*1+$("#bgje").val()*1);
		  $("#zbj").val(($("#sdsgf").val()*0.05).toFixed(2));
		  $("#bgzbj").val(($("#bgje").val()*0.05).toFixed(2));
		  $("#bzjhj").val(($("#sdsgf").val()*0.05+$("#bgje").val()*0.05).toFixed(2));
	  });
	  
  });
  
  function choose() {
  		$.dialog({
  			content : "url:transferController.do?selectProject",
  			zIndex : 2100,
  			title : "工程列表",
  			lock : true,
  			width : 1000,
  			height : 550,
  			left : '50%',
  			top : '50%',
  			opacity : 0.4,
  			button : [ {
  				name : '确认',
  				callback :function(){
  					clearAll();
  					var iframe = this.iframe.contentWindow;
  					var data=iframe.getProjectInfo();
  					$("#projectId").val(data.id);
  					$("#projectName").val(data.projectName);
  					getCostApproval(data.id);
  				},
  				focus : true
  			}, {
  				name : '取消',
  				callback : function() {
  				}
  			} ]
  		});
  	}

  	function clearAll(){
  		$("#projectName").val("");
  		$("#projectId").val("");
  		$("#jd input[id]").val("");
  	}
  	
  	function getCostApproval(val){
  		$.post("costApprovalController.do?getCostApproval",{"pId":val},function(data){
  			if(data.msg){
  				$("#jd input").each(function(){
  					this.value=data[this.id];
  				});

  			}else{
  				alert("请先设置工程建设内容！");
  			}
  		},"json");
  	}
    </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="costApprovalController.do?save">
			<input id="id" name="id" type="hidden" value="${costApproval.id }">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value" colspan="4">
						<input class="inputxt" style="width: 230px" readonly="readonly" id="projectName" value="${costApproval.project.projectName }">
						<input style="width: 230px" id="projectId" name="project.id" value="${costApproval.project.id }" type="hidden">
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
		             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<label class="Validform_label">
							审定内容
						</label>
					</td>
					<td align="center" >
						<label class="Validform_label">
							增减变更金额
						</label>
					</td>
					<td align="center">
						<label class="Validform_label">
							合计金额
						</label>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							审定施工费:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sdsgf" name="sdsgf" ignore="ignore"
							   value="${costApproval.sdsgf}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						<input class="inputxt" id="bgje" name="bgje" ignore="ignore"
							   value="${costApproval.bgje}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						<input class="inputxt"  id="hj" readonly="readonly"
							   value="${costApproval.sdsgf+costApproval.bgje}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								质保金:
							</label>
						</td>
						<td class="value">
							<input class="inputxt" id="zbj"  readonly="readonly"
								   value="${costApproval.sdsgf*0.05}">
							<span class="Validform_checktip"></span>
						</td>
						<td class="value">
						<input class="inputxt" id="bgzbj"  readonly="readonly"
							   value="${costApproval.bgje*0.05}">
						<span class="Validform_checktip"></span>
					</td>
						<td class="value">
							<input class="inputxt" id="bzjhj"   readonly="readonly"
								   value="${(costApproval.sdsgf+costApproval.bgje)*0.05}">
							<span class="Validform_checktip"></span>
						</td>
					</tr>
				</table>
				<div class="formtitle"></div>
				<table id="jd" style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right" rowspan="2">
							<label class="Validform_label">
								工程进度(%)
							</label>
						</td>
						<td align="center">
							<label class="Validform_label">
								管网进度
							</label>
						</td>
						<td align="center">
							<label class="Validform_label">
								线缆进度
							</label>
						</td>
						<td align="center">
							<label class="Validform_label">
								设备进度
							</label>
						</td>
						<td align="center">
							<label class="Validform_label">
								总体进度
							</label>
						</td>
					</tr>
					<tr>
						<td class="value">
							<input class="inputxt" id="gwjd" name="gwjd" ignore="ignore"
								   value="${costApproval.gwjd}">
							<span class="Validform_checktip"></span>
						</td>
						<td class="value">
							<input class="inputxt" id="xljd" name="xljd" ignore="ignore"
								   value="${costApproval.xljd}">
							<span class="Validform_checktip"></span>
						</td>
						<td class="value">
							<input class="inputxt" id="sbjd" name="sbjd" ignore="ignore"
								   value="${costApproval.sbjd}">
							<span class="Validform_checktip"></span>
						</td>
						
						<td class="value">
							<input class="inputxt" id="ztjd" name="ztjd" ignore="ignore"
								   value="${costApproval.ztjd}">
							<span class="Validform_checktip"></span>
						</td>
					</tr>
				</table>
<!-- 				<div class="formtitle"></div> -->
<!-- 				<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable"> -->
<!-- 					<tr> -->
<!-- 						<td align="center"> -->
<!-- 							<label class="Validform_label"> -->
<!-- 								截至上月累计申报金额: -->
<!-- 							</label> -->
<!-- 						</td> -->
<!-- 						<td class="value"> -->
<!-- 								<input class="inputxt" id="ztjd" name="ztjd" ignore="ignore" -->
<%-- 									   value="${costApproval.ztjd}"> --%>
<!-- 								<span class="Validform_checktip"></span> -->
<!-- 							</td> -->
<!-- 						<td align="center"> -->
<!-- 							<label class="Validform_label"> -->
<!-- 								占审定费用比例(%): -->
<!-- 							</label> -->
<!-- 						</td> -->
<!-- 						<td class="value"> -->
<!-- 								<input class="inputxt" id="ztjd" name="ztjd" ignore="ignore" -->
<%-- 									   value="${costApproval.ztjd}"> --%>
<!-- 								<span class="Validform_checktip"></span> -->
<!-- 							</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td align="center"> -->
<!-- 						<label class="Validform_label"> -->
<!-- 							截至上月累计申报金额截至本月累计申报金额: -->
<!-- 						</label> -->
<!-- 						</td> -->
<!-- 						<td class="value"> -->
<!-- 								<input class="inputxt" id="ztjd" name="ztjd" ignore="ignore" -->
<%-- 									   value="${costApproval.ztjd}"> --%>
<!-- 								<span class="Validform_checktip"></span> -->
<!-- 							</td> -->
<!-- 						<td align="center"> -->
<!-- 							<label class="Validform_label"> -->
<!-- 								截至本月累计申报金额占审定施工费用比例(%): -->
<!-- 							</label> -->
<!-- 						</td> -->
<!-- 						<td class="value"> -->
<!-- 								<input class="inputxt" id="ztjd" name="ztjd" ignore="ignore" -->
<%-- 									   value="${costApproval.ztjd}"> --%>
<!-- 							<span class="Validform_checktip"></span> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 			</table> -->
		</t:formvalid>
 </body>
 </html>