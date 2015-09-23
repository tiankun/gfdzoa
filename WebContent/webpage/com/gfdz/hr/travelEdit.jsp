<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>出差记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(function() {
	  var iszz='${travel.iszanzhi}';
	  if(iszz=='1'){
		  $("#zzmoney").show();
	  }else{
		  $("#zzmoney").hide();
	  }
	  
		$('#addTravelBtn').linkbutton({   
		    iconCls: 'icon-add'  
		});  
		$('#delTravelBtn').linkbutton({   
		    iconCls: 'icon-remove'  
		}); 
		$('#addTravelBtn').bind('click', function(){
			var len=$("#add_Travel_table tr").length;
			 var m=1;
			  if(len>0){
				  m= $("#add_Travel_table tr:eq("+(len-1)+")").attr("id")*1+1;
			  }
			  var n= m*1-1;
			  var tr ='<tr id="'+m+'"><td align="center"><div style="width: 25px;" name="xh">'+n+'</div></td>'+
			     '<td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>'+
				 '<td align="center">'+
			     '<select class="inputxt" name="travelPaths['+n+'].province" maxlength="50" style="width:120px;" datatype="*">'+
			     '<option value="">==请选择==</option>'+
					'<c:forEach items="${listArea}" var="db" varStatus="index">'+
					'<option value="${db.id}">${db.territoryName}</option>'+
					'</c:forEach>'+
			     '</select></td>'+
				 '<td align="center">'+
				 '<select class="inputxt" name="travelPaths['+n+'].city.id" maxlength="50" style="width:120px;" datatype="*">'+
			     '<option value="">==请选择==</option>'+
			     '</select></td>'+
			     '<td align="center">'+
				 '<select class="inputxt" name="travelPaths['+n+'].county.id" maxlength="50" style="width:120px;" datatype="*">'+
			     '<option value="">==请选择==</option>'+
			     '</select></td>'+
				 '<td align="center"><t:dictSelect hasLabel="false" field="travelPaths['+n+'].vehicle" id="vehicle" typeGroupCode="vehicle" defaultVal=""></t:dictSelect></td>'+
				 '<td align="center"><input style="margin-bottom:2px;margin-top:2px;width: 80px;" name="travelPaths['+n+'].beginDate" class="Wdate" onClick=" WdatePicker({ dateFmt: \'yyyy-MM-dd\', isShowToday: false, isShowClear: false,minDate:\'%y-%M-{%d}\'});" type="text" style="width:80px;" ></td>'+
				 '<td align="center"><input style="margin-bottom:2px;margin-top:2px;width: 80px;" name="travelPaths['+n+'].endDate" class="Wdate" onClick=" WdatePicker({ dateFmt: \'yyyy-MM-dd\', isShowToday: false, isShowClear: false,minDate:\'%y-%M-{%d}\' });" type="text" style="width:80px;" ></td>'+
				 '<td align="center"><input class="inputxt" name="travelPaths['+n+'].criterion" readonly="readonly" maxlength="20" type="text" style="width:100px;" ></td>'+
				 '</tr>'
		 	 $("#add_Travel_table").append(tr);
		  	$("#add_Travel_table tr").each(function(i){
		      	  $(this).children().eq(0).html(i+1);
		      	});
		  	cos();
		 	 resetTrNum('add_Travel_table');
	    }); 
		
		  $("#add_Travel_table select[name$=province]").live("change",function(){
			  getCity($(this).parent("td").parent("tr"));
		  });
		  
		  $("#add_Travel_table select[name*=city]").live("change",function(){
			  getCounty($(this).parent("td").parent("tr"));
		  });
		  
		  $("#add_Travel_table input[name$=endDate]").live("focus",function(){
			  getCriterion($(this).parent("td").parent("tr"));
		  });
		
		$('#delTravelBtn').bind('click', function(){   
	      	$("#add_Travel_table").find("input:checked").parent().parent().remove(); 
	      	$("#add_Travel_table tr").each(function(i){
	      	  $(this).children().eq(0).html(i+1);
	      	});
	        cos();
	        resetTrNum('add_Travel_table'); 
	    }); 
		$(".datagrid-toolbar").parent().css("width","auto");
		
		$("#iszanzhi").live("change",function(){
			  if(this.value=='1'){
				  $("#zzmoney").show();
			  }else{
				  $("#zzmoney").hide();
			  }
			});
	});
	
	function resetTrNum(tableId) {
		$tbody = $("#" + tableId + "");
		$tbody.find('>tr').each(function(i){
			$(':input, select', this).each(function() {
				var $this = $(this), name = $this.attr('name'), val = $this.val();
				if (name != null) {
					if (name.indexOf("#index#") >= 0) {
						$this.attr("name",name.replace('#index#',i));
					} else {
						var s = name.indexOf("[");
						var e = name.indexOf("]");
						var new_name = name.substring(s + 1,e);
						$this.attr("name",name.replace(new_name,i));
					}
				}
			});
		});
	}
	
	//获取的市级
	function getCity(tr){
		$.getJSON("travelController.do?getAddr",{"parentId":tr.children().eq(2).children().eq(0).val()},function(data){
			tr.children().eq(3).children().eq(0).html("");
			  var o='<option value="">==请选择==</option>';
			  if(data && data.length>0){
				  for(var i=0;i<data.length;i++){
					 o+='<option value="'+data[i].id+'">'+data[i].territoryName+'</option>'; 
				  }
			  }
			  tr.children().eq(3).children().eq(0).html(o);
		  });
		}
	//获取的县级
	function getCounty(tr){
		$.getJSON("travelController.do?getAddr",{"parentId":tr.children().eq(3).children().eq(0).val()},function(data){
			tr.children().eq(4).children().eq(0).html("");
			  var o='<option value="">==请选择==</option>';
			  if(data && data.length>0){
				  for(var i=0;i<data.length;i++){
					 o+='<option value="'+data[i].id+'">'+data[i].territoryName+'</option>'; 
				  }
			  }
			  tr.children().eq(4).children().eq(0).html(o);
		  });
	}
	function getCriterion(tr){
		var traveluser = $("#traveluser").val();
		var persons = $("#travelOtheruser").val();
		var stayType = $("#stayType").val();
		if(persons!="" && persons!="undefined"){
			persons=persons+","+traveluser;
		}else{
			persons=traveluser;
		}
		var city = tr.children().eq(4).children().eq(0).val();
		var vehicle = tr.children().eq(5).children().eq(0).val()
		var beginDate= tr.children().eq(6).children().eq(0).val()
		var endDate = tr.children().eq(7).children().eq(0).val();
		if(!endDate || !persons || !city || !beginDate || !vehicle){
			return false;
		}else{
			$.post("travelController.do?getCriterion",
					{"persons":persons,"city":city,"beginDate":beginDate,"endDate":endDate,"vehicle":vehicle,"stayType":stayType},
					function(data){
				 	 tr.children().eq(8).children().eq(0).val(data);
				 	 tr.children().eq(8).children().eq(0).focus();
					 cos();
			  	},"json");
		}
	}
	  function cos(){
	  	  var summoney=0;
	  	  $("#add_Travel_table tr").each(function(){
	  		summoney+=$(this).children().eq(8).children().eq(0).val()*1;
	  	  });
	  	  $("#sumMoney").val(summoney.toFixed(2));
	  }
</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="travelController.do?completeTask">
		  	<div class="formtitle" title="基本信息">基本信息</div>
			<input id="id" name="id" type="hidden" value="${travel.id }">
			<input id="taskId" name="taskId" type="hidden" value="${taskId}">
			<input id="taskKey" name="taskKey" type="hidden" value="${taskKey}">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							出差申请人:
						</label>
					</td>
					<td class="value">
						<input type="hidden" id="traveluser" name="travelUser.id" value="${travel.travelUser.id!=null ?travel.travelUser.id:user.id }">
						<input class="inputxt" id="username" name="username" readonly="readonly"
							   value="${travel.travelUser.realName!=null ? travel.travelUser.realName : user.realName}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							部门:
						</label>
					</td>
					<td class="value">
						<input type="hidden" id="depart" name="depart.id" value="${travel.depart.id!=null ?travel.depart.id:user.currentDepart.id}">
						<input class="inputxt" id="departname" name="departname" readonly="readonly"
							   value="${travel.depart.departname!=null ?travel.depart.departname:user.currentDepart.departname }">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							随行人员:
						</label>
					</td>
					<td class="value" colspan="3">
						<input type="hidden" id="travelOtheruser" name="travelOtheruser" ignore="ignore"
							   value="${travel.travelOtheruser}">
							   
						<textarea class="textarea" id="travelOtherusers" name="travelOtherusers">${travelOtherusers}</textarea>
				<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
               	<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll();">清空</a>
				<script type="text/javascript">
					var windowapi = frameElement.api, W = windowapi.opener;
					function choose() {
						if (typeof (windowapi) == 'undefined') {
							$
									.dialog({
										content : 'url:userController.do?departManager',
										zIndex : 2100,
										title : '人员列表',
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
						if ($('#travelOtherusers').length >= 1) {
							$('#travelOtherusers').val('');
							$('#travelOtherusers').blur();
						}
						$('#travelOtheruser').val("");
					}
					function clickcallback() {
						iframe = this.iframe.contentWindow;
						var travelOtheruser = iframe.getuserListSelections('realName');
						if ($('#travelOtherusers').length >= 1) {
							travelOtheruser=travelOtheruser+","+$('#travelOtherusers').val();
							$('#travelOtherusers').val(travelOtheruser);
							$('#travelOtherusers').blur();
						}
						var id = iframe.getuserListSelections('id');
						if (id !== undefined && id != "") {
							if($('#travelOtheruser').val()!="" &&$('#travelOtheruser').val()!=undefined){
								id=id+","+$('#travelOtheruser').val();
								
							}
							$('#travelOtheruser').val(id);
						}
					}
				</script>
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
							     value="<fmt:formatDate value='${travel.beginDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							结束时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="endDate" name="endDate" ignore="ignore"
							     value="<fmt:formatDate value='${travel.endDate}' type="date" pattern="yyyy-MM-dd"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否暂支:
						</label>
					</td>
					<td class="value">
						<t:dictSelect hasLabel="false" field="iszanzhi" id="iszanzhi" typeGroupCode="yesorno" defaultVal="${travel.iszanzhi !=null ? travel.iszanzhi : 0 }"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							暂支金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zzmoney" name="zzmoney"  maxlength="10"  style="display: none"
						onchange="convert(this.value)" 
						onkeyup="if(isNaN(value))execCommand(&quot;undo&quot;)"
						onafterpaste="if(isNaN(value))execCommand(&quot;undo&quot;)"
						value="${travel.zzmoney}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							住宿类别:
						</label>
					</td>
					<td class="value" colspan="3">
						<t:dictSelect hasLabel="false" field="stayType" id="stayType" typeGroupCode="stayType" defaultVal="${travel.stayType!=null ? travel.stayType:4 }"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出差事由:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="travelReason" name="travelReason" ignore="ignore" style="width:98%"
							   value="${travel.travelReason}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		<div class="formtitle" title="出差路线">出差路线</div>
				<div style="padding: 3px; height: 25px; width: auto;" class="datagrid-toolbar">
					<a id="addTravelBtn" href="###">添加</a> <a id="delTravelBtn" href="###">删除</a>
				</div>
				<div style="width: auto; height: auto; ">
					<table cellpadding="0" cellspacing="1" class="formtable" id="travelpath"
						 class="formtable">
						<tr bgcolor="#E6E6E6" style="line-height:25px">
							<td align="center" bgcolor="#EEEEEE">序号</td>
							<td align="center" bgcolor="#EEEEEE">选择</td>
							<td align="center" bgcolor="#EEEEEE">省</td>	
							<td align="center" bgcolor="#EEEEEE">市</td>
							<td align="center" bgcolor="#EEEEEE">县</td>
							<td align="center" bgcolor="#EEEEEE">交通工具</td>
							<td align="center" bgcolor="#EEEEEE">到达时间</td>
							<td align="center" bgcolor="#EEEEEE">离开时间</td>
							<td align="center" bgcolor="#EEEEEE">报销标准</td>
						</tr>
						<tbody id="add_Travel_table">
							<c:if test="${fn:length(travel.travelPaths)  > 0 }">
								<c:forEach items="${travel.travelPaths}" var="poVal" varStatus="stuts">
									<tr id="${stuts.index+1}">
										<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
										<td align="center"><input style="width: 20px;" type="checkbox" name="ck" />
											<input name="travelPaths[${stuts.index}].id" value="${poVal.id }" type="hidden"></td>
										<td align="center">
										<select class="inputxt" name="travelPaths[${stuts.index }].province" maxlength="50" style="width:120px;" datatype="*">
											<c:forEach items="${listArea}" var="db" varStatus="index"> 
												<option value="${db.id}" ${db.id==poVal.province ? 'selected' :''}>${db.territoryName}</option> 
											</c:forEach> 
										</select>
										</td>
										<td align="center">
										<select class="inputxt" name="travelPaths[${stuts.index }].city.id" maxlength="50" style="width:120px;" datatype="*">
											<option value="${poVal.city.id}">${poVal.city.territoryName}</option> 
										</select>
										</td>
										<td align="center">
										<select class="inputxt" name="travelPaths[${stuts.index }].county.id" maxlength="50" style="width:120px;" datatype="*">
											<option value="${poVal.county.id}">${poVal.county.territoryName}</option> 
										</select>
										</td>
										<td align="center">
											<t:dictSelect hasLabel="false" field="travelPaths[${stuts.index }].vehicle" id="vehicle" typeGroupCode="vehicle" defaultVal="${poVal.vehicle }"></t:dictSelect>
										</td>
										<td align="center">
										<input style="margin-bottom:2px;margin-top:2px;width: 80px;" name="travelPaths[${stuts.index }].beginDate" value="<fmt:formatDate value='${poVal.beginDate}' type="date" pattern="yyyy-MM-dd"/>" class="Wdate" onClick=" WdatePicker({ dateFmt: 'yyyy-MM-dd', isShowToday: false, isShowClear: false,minDate:'%y-%M-{%d}'});" type="text" style="width:80px;" >
										</td>
										<td align="center">
										<input style="margin-bottom:2px;margin-top:2px;width: 80px;" name="travelPaths[${stuts.index }].endDate" value="<fmt:formatDate value='${poVal.endDate}' type="date" pattern="yyyy-MM-dd"/>" class="Wdate"  onClick=" WdatePicker({ dateFmt: 'yyyy-MM-dd', isShowToday: false, isShowClear: false,minDate:'%y-%M-{%d}'});" type="text" style="width:80px;" >
										</td>
										<td align="center">
										<input class="inputxt" name="travelPaths[${stuts.index }].criterion" value="${poVal.criterion }" readonly="readonly" maxlength="20" type="text" style="width:100px;" >										
										</td>
									</tr>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
						<tfoot>
						<tr bgcolor="#E6E6E6" style="line-height:25px">
							<td align="center" bgcolor="#EEEEEE" colspan="8">总额</td>
							<td align="center" bgcolor="#EEEEEE"><input  style="width:100px;" class="inputxt" readonly="readonly" type="text" id="sumMoney" name="sumMoney" ></td>
						</tr>
						</tfoot>
					</table>
				</div>
		</t:formvalid>
 </body>