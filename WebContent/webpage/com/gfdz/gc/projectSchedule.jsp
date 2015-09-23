<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>工程信息表</title>
  <t:base type="jquery,easyui,tools,DatePicker,validate"></t:base>
  <script type="text/javascript">
   function choose() {
  		$.dialog({
  			content : "url:projectScheduleController.do?selectSchedule",
  			zIndex : 2100,
  			title : "工程列表",
  			lock : true,
  			width : 1280,
  			height : 600,
  			left : '50%',
  			top : '50%',
  			opacity : 0.4,
  			button : [ {
  				name : '确认',
  				callback :function(){
  					clearAll();
  					var iframe = this.iframe.contentWindow;
  					var data=iframe.retMaterial();
  					$("#projectId").val(data.pro.id);
  					$("#projectName").val(data.pro.projectName);
  					var rows =  data.row.rows;
  					if(data.row && rows.length>0){
  						for ( var i = 0; i < rows.length; i++) {
  							var obj= rows[i];
  							var tr = '<tr><td align="center"></td>'+
  					        '<td align="center">'+obj["cp.cpmc"]+'<input type="hidden" name="projectScheduleDetail['+i+'].material.id" value="'+obj["cp.id"]+'"></td>'+
  					        '<td align="center">'+obj["cp.brand"]+'</td>'+
  					        '<td align="center">'+obj["cp.standard"]+'</td>'+
  					        '<td align="center">'+obj.unit+'</td>'+
  					        '<td align="center"><input name="projectScheduleDetail['+i+'].amount" id="amount'+i+'"  class="validate[required,custom[integer],min[1]]" type="text"/></td>'+
  					        '<td align="center"><input name="projectScheduleDetail['+i+'].position" id="position'+i+'"  style="width:95%" class="validate[required]" type="text"/></td>'+
  					        '<td align="center"><input name="projectScheduleDetail['+i+'].remarks" id="remarks'+i+'"  style="width:95%" value="" type="text"></td></tr>';
  							$("#scheduleMaterials_table").append(tr);
  							$("#scheduleMaterials_table tr").each(function(i) {
  								$(this).children().eq(0).html(i + 1);
  							});
  						}
  					}
  					$("#scheduleMaterials_table").find("input[name='num'],input[name='price']").live('change',function(){
  						$tr= $(this).parents("tr");
  						var desigNum=$tr.children("td").eq(6).html()*1;
  						var desigPrice=$tr.children("td").eq(7).html()*1;
  						var num=$tr.find("input[name='num']").val()*1;
  						var price=$tr.find("input[name='price']").val()*1;
  						if(num>desigNum || price>desigPrice){
  							$tr.find("input[name='note']").addClass("validate[required]");
  						}else{
  							$tr.find("input[name='note']").removeClass("validate[required]");
  						}
  					});
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
  		$("#scheduleMaterials_table").html("");
  	}
  	</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <form id="projectScheduleform" action="projectScheduleController.do?save">
		<div class="formtitle" title="项目基本信息">项目进度基本信息</div>
		<input id="id" name="id" type="hidden" value="${projectSchedule.id }">
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right">
					<label class="Validform_label">
						项目编号:
					</label>
				</td>
				<td class="value" colspan="3">
					<input class="inputxt" style="width: 60%" readonly="readonly" id="projectName" value="${projectSchedule.project.projectName }">
					<input style="width: 230px" id="projectId" name="project.id" value="${projectSchedule.project.id }" type="hidden">
					<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
	             	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						开始日期:
					</label>
				</td>
				<td class="value">
					<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="startDate" name="startDate" ignore="ignore"
						   value="<fmt:formatDate value='${projectSchedule.startDate}' type="date" pattern="yyyy-MM-dd"/>">
					<span class="Validform_checktip"></span>
				</td>
				<td align="right">
					<label class="Validform_label">
						截止日期:
					</label>
				</td>
				<td class="value">
					<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="endDate" name="endDate" ignore="ignore"
						   value="<fmt:formatDate value='${projectSchedule.endDate}' type="date" pattern="yyyy-MM-dd"/>">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
		</table>
	<div class="formtitle" title="项目进度明显">项目进度明细</div>
	<div style="width: auto; height: auto; ">
			<table cellpadding="0" cellspacing="1" class="formtable" id="scheduleMaterials" class="formtable">
				<tr bgcolor="#E6E6E6" style="line-height:25px">
					<td align="center" bgcolor="#EEEEEE">序号</td>
					<td align="center" bgcolor="#EEEEEE">设备名称</td>	
					<td align="center" bgcolor="#EEEEEE">品牌</td>
					<td align="center" bgcolor="#EEEEEE">规格型号</td>
					<td align="center" bgcolor="#EEEEEE">单位</td>
					<td align="center" bgcolor="#EEEEEE">使用数量</td>
					<td align="center" bgcolor="#EEEEEE">使用部位</td>
					<td align="center" bgcolor="#EEEEEE">备注</td>
				</tr>
				<tbody id="scheduleMaterials_table">
				<c:if test="${fn:length(projectSchedule.projectScheduleDetail)  > 0 }">
					<c:forEach items="${projectSchedule.projectScheduleDetail}" var="poVal" varStatus="stuts">
						<tr id="${stuts.index+1}">
							<td align="center">
							<div style="width: 25px;" name="xh">${stuts.index+1 }
							<input name="projectScheduleDetail[${stuts.index}].id" value="${poVal.id }" type="hidden">
							<input name="projectScheduleDetail[${stuts.index}].material.id" value="${poVal.material.id }" type="hidden">
							<td align="center">${poVal.material.cpmc}</td>
							<td align="center">${poVal.material.brand}</td>
							<td align="center">${poVal.material.standard} </td>
							<td align="center">${poVal.material.unit}</td>
							<td align="center"><input name="projectScheduleDetail[${stuts.index}].amount" value="${poVal.amount }" class="validate[required,custom[integer],min[1]]" type="text"/></td>
							<td align="center"><input name="projectScheduleDetail[${stuts.index}].position" value="${poVal.position }" class="validate[required]" type="text"/></td>
							<td align="center"><input name="projectScheduleDetail[${stuts.index}].remarks" value="${poVal.remarks }"  type="text"/></td>
						</tr>
					</c:forEach>
				</c:if>
				</tbody>
			</table>
		</div>
</form>
 </body>