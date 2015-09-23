<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>费用开支计划</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
    $(function() {
		$('#addExpensesPlanBtn').linkbutton({   
		    iconCls: 'icon-add'  
		});  
		$('#delExpensesPlanBtn').linkbutton({   
		    iconCls: 'icon-remove'  
		}); 
		$('#addExpensesPlanBtn').bind('click', function(){
			var len=$("#add_ExpensesPlan_table tr").length;
			 var m=1;
			  if(len>0){
				  m= $("#add_ExpensesPlan_table tr:eq("+(len-1)+")").attr("id")*1+1;
			  }
			  var n= m*1-1;
			  var tr ='<tr id="'+m+'">'+
			     '<td align="center">'+
			     '<div style="width: 25px;" name="xh">'+n+'</div>'+
			     '</td>'+
			     '<td align="center">'+
			     '<input style="width:20px;" type="checkbox" name="ck"/>'+
			     '</td>'+
				 '<td align="center">'+
				 '<input class="inputxt" name="expensesPlanDetail['+n+'].item"  type="text" style="width:80%" datatype="*">'+
			     '</td>'+
			     '<td align="center">'+
				 '<input class="inputxt" name="expensesPlanDetail['+n+'].planMoney"  type="text" onchange="cos();" style="width:80%" datatype="*">'+
			     '</td>'+
				 '<td align="center">'+
				 '<input class="inputxt" name="expensesPlanDetail['+n+'].remark"   type="text" style="width:80%" >'+
				 '</td>'+
				 '</tr>'
		 	 $("#add_ExpensesPlan_table").append(tr);
		  	 $("#add_ExpensesPlan_table tr").each(function(i){
		      	  $(this).children().eq(0).html(i+1);
		      	});
		  	cos();
		 	 resetTrNum('add_ExpensesPlan_table');
	    }); 
		
		$('#delExpensesPlanBtn').bind('click', function(){   
	      	$("#add_ExpensesPlan_table").find("input:checked").parent().parent().remove(); 
	      	$("#add_ExpensesPlan_table tr").each(function(i){
	      	  $(this).children().eq(0).html(i+1);
	      	});
	        cos();
	        resetTrNum('add_ExpensesPlan_table'); 
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
		   //人民币大小写自动转换
 function convert(currencyDigits) { 
// Constants: 
    var MAXIMUM_NUMBER = 99999999999.99; 
    // Predefine the radix characters and currency symbols for output: 
    var CN_ZERO = "零"; 
    var CN_ONE = "壹"; 
    var CN_TWO = "贰"; 
    var CN_THREE = "叁"; 
    var CN_FOUR = "肆"; 
    var CN_FIVE = "伍"; 
    var CN_SIX = "陆"; 
    var CN_SEVEN = "柒"; 
    var CN_EIGHT = "捌"; 
    var CN_NINE = "玖"; 
    var CN_TEN = "拾"; 
    var CN_HUNDRED = "佰"; 
    var CN_THOUSAND = "仟"; 
    var CN_TEN_THOUSAND = "万"; 
    var CN_HUNDRED_MILLION = "亿"; 
    var CN_SYMBOL = "人民币"; 
    var CN_DOLLAR = "元"; 
    var CN_TEN_CENT = "角"; 
    var CN_CENT = "分"; 
    var CN_INTEGER = "整"; 
     
// Variables: 
    var integral;    // Represent integral part of digit number. 
    var decimal;    // Represent decimal part of digit number. 
    var outputCharacters;    // The output result. 
    var parts; 
    var digits, radices, bigRadices, decimals; 
    var zeroCount; 
    var i, p, d; 
    var quotient, modulus; 
     
// Validate input string: 
    currencyDigits = currencyDigits.toString(); 
    if (currencyDigits == "") { 
        alert("Empty input!"); 
        return ""; 
    } 
    if (currencyDigits.match(/[^,.\d]/) != null) { 
        alert("Invalid characters in the input string!"); 
        return ""; 
    } 
    if ((currencyDigits).match(/^((\d{1,3}(,\d{3})*(.((\d{3},)*\d{1,3}))?)|(\d+(.\d+)?))$/) == null) { 
        alert("Illegal format of digit number!"); 
        return ""; 
    } 
     
// Normalize the format of input digits: 
    currencyDigits = currencyDigits.replace(/,/g, "");    // Remove comma delimiters. 
    currencyDigits = currencyDigits.replace(/^0+/, "");    // Trim zeros at the beginning. 
    // Assert the number is not greater than the maximum number. 
    if (Number(currencyDigits) > MAXIMUM_NUMBER) { 
        alert("Too large a number to convert!"); 
        return ""; 
    } 
     
// Process the coversion from currency digits to characters: 
    // Separate integral and decimal parts before processing coversion: 
    parts = currencyDigits.split("."); 
    if (parts.length > 1) { 
        integral = parts[0]; 
        decimal = parts[1]; 
        // Cut down redundant decimal digits that are after the second. 
        decimal = decimal.substr(0, 2); 
    } 
    else { 
        integral = parts[0]; 
        decimal = ""; 
    } 
    // Prepare the characters corresponding to the digits: 
    digits = new Array(CN_ZERO, CN_ONE, CN_TWO, CN_THREE, CN_FOUR, CN_FIVE, CN_SIX, CN_SEVEN, CN_EIGHT, CN_NINE); 
    radices = new Array("", CN_TEN, CN_HUNDRED, CN_THOUSAND); 
    bigRadices = new Array("", CN_TEN_THOUSAND, CN_HUNDRED_MILLION); 
    decimals = new Array(CN_TEN_CENT, CN_CENT); 
    // Start processing: 
    outputCharacters = ""; 
    // Process integral part if it is larger than 0: 
    if (Number(integral) > 0) { 
        zeroCount = 0; 
        for (i = 0; i < integral.length; i++) { 
            p = integral.length - i - 1; 
            d = integral.substr(i, 1); 
            quotient = p / 4; 
            modulus = p % 4; 
            if (d == "0") { 
                zeroCount++; 
            } 
            else { 
                if (zeroCount > 0) 
                { 
                    outputCharacters += digits[0]; 
                } 
                zeroCount = 0; 
                outputCharacters += digits[Number(d)] + radices[modulus]; 
            } 
            if (modulus == 0 && zeroCount < 4) { 
                outputCharacters += bigRadices[quotient]; 
            } 
        } 
        outputCharacters += CN_DOLLAR; 
        
    } 
    // Process decimal part if there is: 
    if (decimal != "") { 
        for (i = 0; i < decimal.length; i++) { 
            d = decimal.substr(i, 1); 
            if (d != "0") { 
                outputCharacters += digits[Number(d)] + decimals[i]; 
            } 
        } 
    } 
    // Confirm and return the final output string: 
    if (outputCharacters == "") { 
        outputCharacters = CN_ZERO + CN_DOLLAR; 
    } 
    if (decimal == "") { 
        outputCharacters += CN_INTEGER; 
    }
    return outputCharacters;
   /*  $("#upper_chn").attr("value",outputCharacters); */
}
  function cos(){
	  	  var summoney=0;
	  	  $("#add_ExpensesPlan_table tr").each(function(){
	  		summoney+=$(this).children().eq(3).children().eq(0).val()*1;
	  	  });
	  	  $("#sumMoney").val(summoney.toFixed(2));
	  	  $("#totalSum").val(summoney.toFixed(2));
	  	  var upperChn=convert(summoney);
	  	   $("#upperChn").val(upperChn);
	  }

	  
  </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="expensesPlanController.do?save">
			<input id="id" name="id" type="hidden" value="${expensesPlanPage.id }">
			<input id="depart" name="depart.id" type="hidden" value="${expensesPlanPage.depart.id!=null ?expensesPlanPage.depart.id:user.currentDepart.id}">
			<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户主键:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="userId" name="userId.id" type="hidden"
							   value="${expensesPlanPage.userId.id!=null ?expensesPlanPage.userId.id:user.id}" datatype="*">
						<input class="inputxt" id="username" name="userId.username" readonly="readonly"
							   value="${expensesPlanPage.userId.realName!=null ?expensesPlanPage.userId.realName : user.realName}">		   
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							申请时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="applyTime" name="applyTime" 
							     value="<fmt:formatDate value='${expensesPlanPage.applyTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			
				
				
				<tr>
				    <td align="right">
						<label class="Validform_label">
							是否要综合办购买:
						</label>
					</td>
					<td class="value">
					<select name="buy" id="buy" style="width: 150px;"  datatype="*">
							<option value="">
								未选择
							</option>
							<option value="1" <c:if test="${expensesPlanPage.buy==1}">selected</c:if>>
								是
							</option>
							<option value="0" <c:if test="${expensesPlanPage.buy==0}">selected</c:if>>
								否
							</option>
							
				      </select>
					<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							暂支主键:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="advanceId" name="advanceId.id" ignore="ignore"
							   value="${expensesPlanPage.advanceId.id}">
							   <a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose()">选择</a>
							        <script type="text/javascript">
					var windowapi = frameElement.api, W = windowapi.opener;
					function choose() {
						if (typeof (windowapi) == 'undefined') {
							$
									.dialog({
										content : 'url:advanceController.do?advanceLists',
										zIndex : 2100,
										title : '暂支列表',
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
										content : 'url:advanceController.do?advanceLists',
										zIndex : 2100,
										title : '暂支列表',
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
													callback : clickcallback1,
													focus : true
												}, {
													name : '取消',
													callback : function() {
													}
												} ]
									});
						}
					}
					
					function clickcallback1() {
						iframe = this.iframe.contentWindow;
					    var advanceId = iframe.getadvanceListSelections('id');
						
						if ($('#advanceId').length >= 1) {
							$('#advanceId').val(advanceId);
							$('#advanceId').blur();
						}
						 /* var id = iframe.getgysmlListSelections('id');
						if (id !== undefined && id != "") {
							$('#advanceId').val(id);
						} */
					}
				</script>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
					<tr>
					<td align="right">
						<label class="Validform_label">
							预支时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker()"  style="width: 150px" id="advanceTime" name="advanceTime" 
							   value="<fmt:formatDate value='${expensesPlanPage.advanceTime}' type="date" pattern="yyyy-MM-dd"/>" ignore="ignore">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
						
						</label>
					</td>
					<td class="value">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							申请金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="totalSum" name="totalSum"  readonly="readonly" style="background:#EEEEEE;color:red"
							   value="${expensesPlanPage.totalSum}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				<td align="right">
						<label class="Validform_label">
							大写申请金额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="upperChn" name="upperChn"  readonly="readonly" style="background:#EEEEEE;color:red"
							   value="${expensesPlanPage.upperChn}">
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
						<input class="inputxt" id="remark" name="remark" ignore="ignore"
							   value="${expensesPlanPage.remark}"style="width: 75%">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
			<div class="formtitle" title="明细">明细 </div>
				<div style="padding: 3px; height: 25px; width: auto;" class="datagrid-toolbar">
					<a id="addExpensesPlanBtn" href="###">添加</a> 
					<a id="delExpensesPlanBtn" href="###">删除</a>
				</div>
				<div style="width: auto; height: auto; ">
					<table cellpadding="0" cellspacing="1" class="formtable" id="expensesPlanpath"
						id="ExpensesPlan_table" class="formtable">
						<tr bgcolor="#E6E6E6" style="line-height:25px">
							<td align="center" bgcolor="#EEEEEE">序号</td>
							<td align="center" bgcolor="#EEEEEE">选择</td>
							<td align="center" bgcolor="#EEEEEE">开支项</td>	
							<td align="center" bgcolor="#EEEEEE">开支金额</td>
							<td align="center" bgcolor="#EEEEEE">备注</td>
						</tr>
						<tbody id="add_ExpensesPlan_table">
						
							<c:if test="${fn:length(list)  > 0 }">
								<c:forEach items="${list}" var="poVal" varStatus="stuts">
								 	<tr id="${stuts.index+1}">
										<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
										<td align="center"><input style="width: 20px;" type="checkbox" name="ck" ></td>
										<td align="center">
										<input class="inputxt" maxlength="50" name="expensesPlanDetail[${stuts.index}].item" value="${poVal.item}" type="text" style="width: 80%" datatype="*">
										</td>
										<td align="center">
										<input class="inputxt" maxlength="50"  name="expensesPlanDetail[${stuts.index}].planMoney" value="${poVal.planMoney}" type="text" style="width: 80%" datatype="*">
										</td>
										<td align="center">
										<input class="inputxt" maxlength="50" name="expensesPlanDetail[${stuts.index}].remark"  value="${poVal.remark}" type="text" style="width: 80%" datatype="*">
										</td>
										<input name="expensesPlanDetail[${stuts.index}].expensesPlan.id" value="${poVal.expensesPlan.id }" type="hidden" >
										<input name="expensesPlanDetail[${stuts.index}].id" value="${poVal.id }" type="hidden">
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