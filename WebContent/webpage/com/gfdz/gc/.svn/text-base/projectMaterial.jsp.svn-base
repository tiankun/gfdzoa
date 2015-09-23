<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>材料设计</title>
  <t:base type="jquery,easyui,tools,DatePicker,validate"></t:base>
  <script type="text/javascript">
  $(function() {
		$('#addMaterialBtn').linkbutton({   
		    iconCls: 'icon-add'  
		});  
		$('#delMaterialBtn').linkbutton({   
		    iconCls: 'icon-remove'  
		}); 
		$('#addMaterialBtn').bind('click', addGoods);
		
		$('#delMaterialBtn').bind('click', function(){   
	      	$("#add_Material_table").find("input:checked").parent().parent().remove(); 
	      	$("#add_Material_table tr").each(function(i){
	      	  $(this).children().eq(0).html(i+1);
	      	});
	       	cos();
	        resetTrNum('add_Material_table'); 
	    }); 
		$(".datagrid-toolbar").parent().css("width","auto");
		
	});
	
	
	function addGoods(){
		 $.dialog({
				content : "url:projectInfoController.do?selectCp",
				zIndex : 2100,
				title : "产品选择列表",
				lock : false,
				width : 800,
				height : 500,
				parent : windowapi,
				left : '50%',
				top : '50%',
				opacity : 0.4,
				button : [ {
					name : '确认',
					callback : function() {
						var iframe = this.iframe.contentWindow;
						var list = iframe.retCp();
						  var len=$("#add_Material_table tr").length;
						  var m=0;
						  if(len>0){
							  m= $("#add_Material_table tr:eq("+(len-1)+")").attr("id")*1+1;
						  }
						var o="";
						for(var i=0;i<list.length;i++){
							var obj= list[i];
								o+='<tr id="'+m+'"><td align="center" width="35px">'+(m+1)+'</td>'+
							     '<td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>'+
								 '<td align="center">'+obj.cpmc+'<input type="hidden" name="materials['+m+'].cp.id" value="'+obj.id+'"></td>'+
						         '<td align="center">'+obj.brand+'</td>'+
						         '<td align="center">'+obj.standard+'</td>'+
						         '<td align="center">'+obj.unit+'</td>'+
						         '<td align="center"><t:dictSelect hasLabel="false" field="materials['+m+'].ctype" id="ctype" typeGroupCode="ctype" defaultVal="1"></t:dictSelect></td>'+
						         '<td align="center"><input name="materials['+m+'].parameter" class="validate[required]" type="text"/></td>'+
						         '<td align="center"><input name="materials['+m+'].designPrice" class="validate[required,custom[number]]" type="text"/></td>'+
						         '<td align="center"><input name="materials['+m+'].designAmount" class="validate[required,custom[integer],min[1]]" type="text"/></td>';
						}
						$(o).appendTo("#add_Material_table");
					},
					focus : true
				}, {
					name : '取消',
					callback : function() {
					}
				} ]
			});
	}
	
	
	//重计算数组下标
	function resetTrNum(tableId) {
		$tbody = $("#"+ tableId +" tr");
		$tbody.each(function(i){
			$(this).find("input[name*='[']").each(function() {
				var name = $(this).attr('name');
				if (name != null) {
					var s = name.indexOf("[");
					var e = name.indexOf("]");
					var new_name = name.substring(s + 1,e);
					$(this).attr("name",name.replace(new_name,i));
				}
			});
		});
	}
</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="projectInfoController.do?saveMaterial">
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
						<input class="inputxt validate[required]" id="projectName"  style= "width:83%"
							   value="${projectInfo.projectName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目状态:
						</label>
					</td>
					<td class="value" colspan="3">
					<t:dictSelect hasLabel="false"  field="projectStatus" id="projectStatus" typeGroupCode="projectstate" defaultVal="${projectInfo.projectStatus }" extendJson="{\"class\":\"validate[required]\"}"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		<div class="formtitle" title="设计材料">设计材料</div>
				<div style="padding: 3px; height: 25px; width: auto;" class="datagrid-toolbar">
					<a id="addMaterialBtn" href="###">添加</a> <a id="delMaterialBtn" href="###">删除</a>
				</div>
				<div style="width: auto; height: auto; ">
					<table cellpadding="0" cellspacing="1" class="formtable" id="materials" class="formtable">
						<tr bgcolor="#E6E6E6" style="line-height:25px">
							<td align="center" bgcolor="#EEEEEE">序号</td>
							<td align="center" bgcolor="#EEEEEE">选择</td>
							<td align="center" bgcolor="#EEEEEE">设备名称</td>	
							<td align="center" bgcolor="#EEEEEE">品牌</td>
							<td align="center" bgcolor="#EEEEEE">规格型号</td>
							<td align="center" bgcolor="#EEEEEE">材料用途</td>
							<td align="center" bgcolor="#EEEEEE">单位</td>
							<td align="center" bgcolor="#EEEEEE">技术参数</td>
							<td align="center" bgcolor="#EEEEEE">设计单价</td>
							<td align="center" bgcolor="#EEEEEE">设计数量</td>
						</tr>
						<tbody id="add_Material_table">
							<c:if test="${fn:length(projectInfo.materials)  > 0 }">
								<c:forEach items="${projectInfo.materials}" var="poVal" varStatus="stuts">
									<tr id="${stuts.index+1}">
										<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
										<td align="center"><input style="width: 20px;" type="checkbox" name="ck" />
											<input name="materials[${stuts.index}].cp.id" value="${poVal.cp.id }" type="hidden">
											<input name="materials[${stuts.index}].id" value="${poVal.id }" type="hidden"></td>
										<td align="center">${poVal.cp.cpmc}</td>
										<td align="center">${poVal.cp.brand}</td>
										<td align="center">${poVal.cp.standard} </td>
										<td align="center">${poVal.cp.unit}</td>
										<td align="center"><t:dictSelect hasLabel="false" field="materials[${stuts.index}].ctype" id="ctype" typeGroupCode="ctype" defaultVal="${poVal.ctype }"></t:dictSelect></td>
										<td align="center"><input name="materials[${stuts.index}].parameter" value="${poVal.parameter }" class="validate[required]" type="text"/></td>
										<td align="center"><input name="materials[${stuts.index}].designPrice" value="${poVal.designPrice }" class="validate[required,custom[number]]" type="text"/></td>
										<td align="center"><input name="materials[${stuts.index}].designAmount" value="${poVal.designAmount }" class="validate[required,custom[integer],min[1]]" type="text"/></td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
		</t:formvalid>
 </body>