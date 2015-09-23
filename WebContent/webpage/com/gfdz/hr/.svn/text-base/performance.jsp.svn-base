<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>绩效考核</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
	$(function() {
		//信用额度初始化
		$('#addperformanceBtn').linkbutton({   
		    iconCls: 'icon-add'  
		});  
		$('#delperformanceBtn').linkbutton({   
		    iconCls: 'icon-remove'  
		}); 
		$('#addperformanceBtn').bind('click', function(){
			var len=$("#add_performance_table tr").length;
			 var m=1;
			  if(len>0){
				  m= $("#add_performance_table tr:eq("+(len-1)+")").attr("id")*1+1;
			  }
			  var n= m*1-1;
			  var tr ='<tr id="'+m+'"><td align="center"><div style="width: 25px;" name="xh">'+n+'</div></td>'+
			     '<td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>'+
				 '<td align="center"><input name="performances['+n+'].user.id" type="hidden">'+
			     '<input class="inputxt" maxlength="50" type="text" style="width:80px;" datatype="*"></td>'+
				 '<td align="center"><input name="performances['+n+'].depart.id" type="hidden">'+
				 '<input class="inputxt" maxlength="20" type="text" style="width:100px;" ></td>'+
				 '<td align="center"><input style="margin-bottom:2px;margin-top:2px;width: 80px;" name="performances['+n+'].performanceDate" class="Wdate" onClick=" WdatePicker({ dateFmt: \'yyyy-MM-dd\', isShowToday: false, isShowClear: false });" type="text" style="width:80px;" ></td>'+
				 '<td align="center"><input class="inputxt" name="performances['+n+'].results" maxlength="20" type="text" style="width:100px;" ></td>'+
				 '<td align="center"><input class="inputxt" name="performances['+n+'].note" maxlength="20" type="text" style="width:100px;" ></td>'+
				 '</tr>'
		 	 $("#add_performance_table").append(tr);
		  	$("#add_performance_table tr").each(function(i){
		      	  $(this).children().eq(0).html(i+1);
		      	});
		 	 resetTrNum('add_performance_table');
	    });  
		$('#delperformanceBtn').bind('click', function(){   
	      	$("#add_performance_table").find("input:checked").parent().parent().remove(); 
	      	$("#add_performance_table tr").each(function(i){
	      	  $(this).children().eq(0).html(i+1);
	      	});
	        resetTrNum('add_performance_table'); 
	    }); 
		$(".datagrid-toolbar").parent().css("width","auto");
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
</script>
 <style type="text/css">
 #performance_table select{
	padding:2px 2px !important;
	width:50px !important;
}

</style>
</head>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="performanceController.do?save">
			<div class="formtitle"  title="目标值">绩效考核结果</div>
				<div style="padding: 3px; height: 25px; width: auto;" class="datagrid-toolbar">
					<a id="addperformanceBtn" href="###">添加</a> <a id="delperformanceBtn" href="###">删除</a>
				</div>
				<div style="width: auto; height: auto; ">
					<table cellpadding="0" cellspacing="1" class="formtable"
						id="performance_table" class="formtable">
						<tr bgcolor="#E6E6E6" style="line-height:25px">
							<td align="center" bgcolor="#EEEEEE">序号</td>
							<td align="center" bgcolor="#EEEEEE">选择</td>
							<td align="center" bgcolor="#EEEEEE">用户名</td>	
							<td align="center" bgcolor="#EEEEEE">部门</td>
							<td align="center" bgcolor="#EEEEEE">考核日期</td>
							<td align="center" bgcolor="#EEEEEE">考核结果</td>
							<td align="center" bgcolor="#EEEEEE">备注</td>
						</tr>
						<tbody id="add_performance_table">
							<c:if test="${fn:length(list)  > 0 }">
								<c:forEach items="${list}" var="poVal" varStatus="stuts">
									<tr id="${stuts.index+1}">
										<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
										<td align="center"><input style="width: 20px;" type="checkbox" name="ck" />
										<input name="performances[${stuts.index}].id" value="${poVal.id }" type="hidden"></td>
										<td align="center">
										<input name="performances[${stuts.index}].user.id" value="${poVal.tsUser.id }" type="hidden">
										<input class="inputxt" maxlength="50" value="${poVal.tsUser.realName }" type="text" style="width: 80px;" datatype="*">
										</td>
										<td align="center">
										<input name="performances[${stuts.index }].depart.id" value="${poVal.tsDepart.id }" type="hidden">
										<input class="inputxt" maxlength="50" value="${poVal.tsDepart.departname}" type="text" style="width: 100px;" datatype="*">
										</td>
										<td align="center">
										<input  name="performances[${stuts.index }].performanceDate" maxlength="50" class="Wdate" onClick="WdatePicker({ dateFmt: 'yyyy-MM-dd', isShowToday: false, isShowClear: false });"
										value="<fmt:formatDate value='${date}' type="date" pattern="yyyy-MM-dd"/>" type="text" style="margin-bottom:2px;margin-top:2px;width: 80px;" >
										</td>
										<td align="center">
										<input class="inputxt" name="performances[${stuts.index }].results" maxlength="50" value="100" type="text" style="width: 100px;">
										</td>
										<td align="center">
										<input class="inputxt" name="performances[${stuts.index }].note" maxlength="50" value="" type="text" style="width: 100px;">
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			
		</t:formvalid>
 </body>