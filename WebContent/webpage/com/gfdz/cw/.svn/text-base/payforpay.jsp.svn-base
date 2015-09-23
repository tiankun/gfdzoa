<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>款项支付</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  $(function() {
		$('#addPayforBtn').linkbutton({   
		    iconCls: 'icon-add'  
		});  
		$('#delPayforBtn').linkbutton({   
		    iconCls: 'icon-remove'  
		}); 
		 cos();
		$('#addPayforBtn').bind('click', function(){
			var len=$("#add_PayforDetail_table tr").length;
			 var m=1;
			  if(len>0){
				  m= $("#add_PayforDetail_table tr:eq("+(len-1)+")").attr("id")*1+1;
			  }
			  var n= m*1-1;
			  var tr ='<tr id="'+m+'"><td align="center"><div style="width: 25px;" name="xh">'+n+'</div></td>'+
			     '<td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>'+
				 '<td align="center">'+
			     '<input class="inputxt" name="payforDetail['+n+'].applyreason"  style="width:90%" datatype="*">'+
			     '</td>'+
				 '<td align="center">'+
				 '<input class="inputxt" name="payforDetail['+n+'].money" onchange="cos();"  style="width:120px;" datatype="d">'+
			     '</td>'+
			     '<td align="center">'+
				 '<input class="inputxt" name="payforDetail['+n+'].fujnum"  style="width:120px;" datatype="d">'+
			     '</td>'+
				 '</tr>'
		 	 $("#add_PayforDetail_table").append(tr);
		  	$("#add_PayforDetail_table tr").each(function(i){
		      	  $(this).children().eq(0).html(i+1);
		      	});
		  	cos();
		 	 resetTrNum('add_PayforDetail_table');
	    }); 
		
		  /* $("#add_PayforDetail_table select[name$=province]").live("change",function(){
			  getCity($(this).parent("td").parent("tr"));
		  });
		  
		  $("#add_PayforDetail_table select[name*=city]").live("change",function(){
			  getCounty($(this).parent("td").parent("tr"));
		  });
		  
		  $("#add_PayforDetail_table input[name$=endDate]").live("focus",function(){
			  getCriterion($(this).parent("td").parent("tr"));
		  }); */
		
		$('#delPayforBtn').bind('click', function(){   
	      	$("#add_PayforDetail_table").find("input:checked").parent().parent().remove(); 
	      	$("#add_PayforDetail_table tr").each(function(i){
	      	  $(this).children().eq(0).html(i+1);
	      	});
	        cos();
	        resetTrNum('add_PayforDetail_table'); 
	    }); 
		$(".datagrid-toolbar").parent().css("width","auto");
		
		$("input[name$=iszanzhi]").live("click",function(){
			var checks = $("input[name$=iszanzhi]");
			 for(var i=0;i<checks.length;i++){
				  if(checks[i].checked==true){
				  if(checks[i].value=='1'){
					  $("#zzmoney").show();
				  }else{
					  $("#zzmoney").hide();
				  }
				  }
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
	
	/* //获取的市级
	function getCity(tr){
		$.getJSON("payforController.do?getAddr",{"parentId":tr.children().eq(2).children().eq(0).val()},function(data){
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
		$.getJSON("payforController.do?getAddr",{"parentId":tr.children().eq(3).children().eq(0).val()},function(data){
			 tr.children().eq(4).children().eq(0).html("");
			  var o='<option value="">==请选择==</option>';
			  if(data && data.length>0){
				  for(var i=0;i<data.length;i++){
					 o+='<option value="'+data[i].id+'">'+data[i].territoryName+'</option>'; 
				  }
			  }
			  tr.children().eq(4).children().eq(0).html(o);
		  });
	} */
	/* function getCriterion(tr){
		var payforuser = $("#payforuser").val();
		var persons = $("#payforOtheruser").val();
		if(persons!="" && persons!="undefined"){
			persons=persons+","+payforuser;
		}else{
			persons=payforuser;
		}
		var city = tr.children().eq(4).children().eq(0).val();
		var beginDate= tr.children().eq(6).children().eq(0).val()
		var endDate = tr.children().eq(7).children().eq(0).val();
		if(!endDate || !persons || !city || !beginDate){
			return false;
		}else{
			$.post("payforController.do?getCriterion",
					{"persons":persons,"city":city,"beginDate":beginDate,"endDate":endDate},
					function(data){
				 	 tr.children().eq(8).children().eq(0).val(data);
				 	 tr.children().eq(8).children().eq(0).focus();
					 cos();
			  	},"json");
		}
	} */
	  function cos(){
	  	  var summoney=0;
	  	  $("#add_PayforDetail_table tr").each(function(){
	  		summoney+=$(this).children().eq(7).children().eq(0).val()*1;
	  	  });
	  	  $("#sumMoney").val(summoney.toFixed(2));
	  	   $("#money").val(summoney.toFixed(2));
	  }
</script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="payforController.do?savePay" tiptype="1">
					<input id="id" name="id" type="hidden" value="${payforPage.id }">
		<table style="width: 100%" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
				<td align="right">
						<label class="Validform_label">
							付款方式:
						</label>
					</td>
					<td class="value">
					     	<t:dictSelect field="paytype" typeGroupCode="pay" hasLabel="false" defaultVal="${payforPage.paytype}" extendJson="{\"datatype\":\"*\"}"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款方式</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							付款金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="money" name="money" type="text" style="width: 80%" class="inputxt"  readonly="readonly"								               
								               value="${payforPage.money}" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款金额</label>
						</td>
					</tr>
				<tr>
					 <tr>
					
					<td align="right">
						<label class="Validform_label">
							收款单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="skId" name="skId" type="text" style="width: 80%" class="inputxt"  readonly="readonly"								               
								               value="${payforPage.skId}">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款单位</label>
						</td>
					
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="note" name="note" type="text" style="width: 80%" class="inputxt"  								               
								              value="${payforPage.note} ">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
			<div class="formtitle" title="支付明细">支付明细</div>
				<!-- <div style="padding: 3px; height: 25px; width: auto;" class="datagrid-toolbar">
					<a id="addPayforBtn" href="###">添加</a> <a id="delPayforBtn" href="###">删除</a>
				</div> -->
				<div style="width: auto; height: auto; ">
					<table cellpadding="0" cellspacing="1" class="formtable" id="payforDetail" class="formtable">
						<tr bgcolor="#E6E6E6" style="line-height:25px">
							<td align="center" bgcolor="#EEEEEE">序号</td>
							<td align="center" bgcolor="#EEEEEE">选择</td>
							<td align="center" bgcolor="#EEEEEE">配给单</td>
							<td align="center" bgcolor="#EEEEEE">材料</td>	
							<td align="center" bgcolor="#EEEEEE">采购数量</td>
							<td align="center" bgcolor="#EEEEEE">入库数量 </td>
							<td align="center" bgcolor="#EEEEEE">入库单价 </td>
							<td align="center" bgcolor="#EEEEEE">金额 </td>
							<td align="center" bgcolor="#EEEEEE">供应商 </td>
							<td align="center" bgcolor="#EEEEEE">项目</td>
							<td align="center" bgcolor="#EEEEEE">单据数</td>
						</tr>
						<tbody id="add_PayforDetail_table">
							<c:if test="${fn:length(payforpayList)> 0 }">
								<c:forEach items="${payforpayList}" var="poVal" varStatus="stuts">
									<tr id="${stuts.index+1}">
										<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
										<td align="center"><input style="width: 20px;" type="checkbox" name="ck" checked="checked"/>
											<input name="payforDetail[${stuts.index}].id" value="${poVal.id }" type="hidden"></td>
										<td align="center">
										<input style="margin-bottom:2px;margin-top:2px;width: 90%" name="payforDetail[${stuts.index }].applyreason" value="${poVal.buyAmount }"  type="text"  >
										</td>
										<td align="center">
										<input style="margin-bottom:2px;margin-top:2px;width: 60%" name="payforDetail[${stuts.index }].cp" value="${poVal.buyAmount }"   type="text"  >
										</td>
										<td align="center">
										<input class="inputxt" name="payforDetail[${stuts.index }].fujnum" value="${poVal.buyAmount }"   type="text" style="width:60%" >										
										</td>
										<td align="center">
										<input class="inputxt" name="payforDetail[${stuts.index }].fujnum" value="${poVal.buyAmount }"   type="text" style="width:60%" >										
										</td>
										<td align="center">
										<input class="inputxt" name="payforDetail[${stuts.index }].fujnum" value="${poVal.buyPrice }"   type="text" style="width:60%" >										
										</td>
										<td align="center">
										<input class="inputxt" name="payforDetail[${stuts.index }].fujnum" value="${poVal.merchant }"   type="text" style="width:60%" >										
										</td>
										<td align="center">
										<input class="inputxt" name="payforDetail[${stuts.index }].fujnum" value="${poVal.buyAmount }"   type="text" style="width:60%" >										
										</td>
										<td align="center">
										<input class="inputxt" name="payforDetail[${stuts.index }].fujnum" value="${poVal.buyAmount }"   type="text" style="width:60%" >										
										</td>
										<td align="center">
										<input class="inputxt" name="payforDetail[${stuts.index }].fujnum"    type="text" style="width:60%" >										
										</td>
									</tr>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
						<!-- <tfoot>
						<tr bgcolor="#E6E6E6" style="line-height:25px">
							<td align="center" bgcolor="#EEEEEE" colspan="4">总额</td>
							<td align="center" bgcolor="#EEEEEE"><input  style="width:100px;" class="inputxt" readonly="readonly" type="text" id="sumMoney" name="sumMoney" ></td>
						</tr>
						</tfoot> -->
					</table>
				</div>
		</t:formvalid>
 </body>		