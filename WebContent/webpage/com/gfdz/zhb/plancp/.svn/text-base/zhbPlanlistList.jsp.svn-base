<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
  
	$('#addZhbPlanlistBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZhbPlanlistBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	/* $('#addZhbPlanlistBtn').bind('click', function(){   
 		 var tr =  $("#add_zhbPlanlist_table_template tr").clone();
	 	 $("#add_zhbPlanlist_table").append(tr);
	 	 resetTrNum('add_zhbPlanlist_table');
	 	 addGoods();
	 	 return false;
    });  */ 
	$('#delZhbPlanlistBtn').bind('click', function(){
	   
      	$("#add_zhbPlanlist_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zhbPlanlist_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#zhbPlanlist_table").createhftable({
	    	height:'300px',
			width:'900px',
			fixFooter:false
			});
    });
    //初始化下标
function resetTrNum(tableId) {
	$tbody = $("#"+tableId+"");
	$tbody.find('>tr').each(function(i){
		$(':input, select,button,a', this).each(function(){
			var $this = $(this), name = $this.attr('name'),id=$this.attr('id'),onclick_str=$this.attr('onclick'), val = $this.val();
			if(name!=null){
				if (name.indexOf("#index#") >= 0){
					$this.attr("name",name.replace('#index#',i));
				}else{
					var s = name.indexOf("[");
					var e = name.indexOf("]");
					var new_name = name.substring(s+1,e);
					$this.attr("name",name.replace(new_name,i));
				}
			}
			if(id!=null){
				if (id.indexOf("_index") >= 0){
					$this.attr("id",id.replace('_index',i));
				}else{
					
					var s = id.indexOf("_");
					var e = id.length;
					
					var new_id = id.substring(s+1,e);
					$this.attr("id",id.replace(new_id,i));
				}
			}
			if(onclick_str!=null){
				if (onclick_str.indexOf("#index#") >= 0){
					$this.attr("onclick",onclick_str.replace(/#index#/g,i));
				}else{
				}
			}
		});
		$(this).find('div[name=\'xh\']').html(i+1);
	});
}

//产品列表
function addGoods(){

	 $.dialog({
			content : "url:cpController.do?getcpList",
			zIndex : 2100,
			title : "产品列表",
			lock : false,
			width : 600,
			height : 350,
			parent : windowapi,
			left : '50%',
			top : '50%',
			opacity : 0.4,
			button : [ {
				name : '确认',
				callback : function() {
					
					var tr =  $("#add_zhbPlanlist_table_template tr").clone();
	 				$("#add_zhbPlanlist_table").append(tr);
	 	 			resetTrNum('add_zhbPlanlist_table');
					var data=$('#add_zhbPlanlist_table').children().length-1;
					//alert('总数据量:'+data); 
					var iframe = this.iframe.contentWindow;
					var getprjectid = iframe.getcpListSelections('id');
					//var getlxbh = iframe.getcpListSelections('lxbh.lxmc');
					var getcpmc = iframe.getcpListSelections('cpmc');
					var getbrand = iframe.getcpListSelections('brand');
					 // alert(getcpmc);
					
					 
					
					  $("#zhbPlanlistListcp"+data+"").val(getprjectid);
					 $("#zhbPlanlistListcpmc"+data+"").val(getcpmc);
					//$("#zhbPlanlistListlxbh"+data+"").val(getlxbh);
					$("#zhbPlanlistListbrand"+data+"").val(getbrand); 
					//var list = iframe.getGoodsData();
					//alert(getprjectid);
					//var list=iframe.getBackList();
					 /*  var len=$("#goodsList tr").length;
					  var m=0;
					  if(len>0){
						  m= $("#goodsList tr:eq("+(len-1)+")").attr("id")*1+1;
					  }
					var o="";
					for(var i=0;i<list.length;i++){
							o+='<tr id="'+(m+i)+'"><td width="35px">'+(i+1)+'</td>'
							  +'<td width="120px"><input type="hidden" name="orderDetail['+(m+i)+'].goods.id" value="'+list[i].id+'">'+list[i].goodsName+'</td>'
							  +'<td width="90px">'+(cbrand[list[i].goodsband] ? cbrand[list[i].goodsband] : "")+'</td>'
							  +'<td width="100px">'+list[i].goodsModel+'</td>'
							  +'<td width="60px"><input style="width:55px" name="orderDetail['+(m+i)+'].goodsPrice" value="'+list[i].goodsPrice+'"></td>'
							  +'<td width="60px"><input style="width:55px" name="orderDetail['+(m+i)+'].goodsNum"></td>'
							  +'<td width="60px"><input style="width:95%" name="orderDetail['+(m+i)+'].goodsMoney"></td>'
							+'<td><input style="width:95%" name="orderDetail['+(m+i)+'].cnote"></td></tr>';
					}
					$(o).appendTo("#goodsList");
					if($("#goodsDiv").height()<$("#blist").height()){
						  $("#goodsTab")[0].style.paddingRight="20px";
					  }else{
						  $("#goodsTab")[0].style.paddingRight="3px";
					  }
					serial(); */
				},
				focus : true
			}, {
				name : '取消',
				callback : function() {
       
				}
			} ]
		});
}


</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addZhbPlanlistBtn" onclick="addGoods()" href="#">添加</a> <a id="delZhbPlanlistBtn" href="#">删除</a> 
</div>
<table  cellpadding="0" cellspacing="1" class="formtable" id="zhbPlanlist_table">
	<tr bgcolor="#E6E6E6" align="center">
		<td align="center" width="30"  bgcolor="#EEEEEE">序号</td>
		<td align="center" width="30" bgcolor="#EEEEEE">操作</td>
		<td  width="120"  align="left" bgcolor="#EEEEEE">产品名称</td>
		<!-- <td  style="width:120px; " align="center" bgcolor="#EEEEEE">类型</td> -->
		<td width="120" align="left" bgcolor="#EEEEEE">品牌</td>
		<td  width="120" align="left" bgcolor="#EEEEEE">计划数量 </td>
	    <td  width="120" align="left" bgcolor="#EEEEEE">计划单价</td>
		<td  width="120" align="left" bgcolor="#EEEEEE">备注</td>
		<!-- <td align="left" bgcolor="#EEEEEE">审核数量 </td>
		<td align="left" bgcolor="#EEEEEE">审核单价</td> -->
	</tr>
	<tbody id="add_zhbPlanlist_table">	

	<c:if test="${fn:length(zhbPlanlistList)  > 0 }">
		<c:forEach items="${zhbPlanlistList}" var="poVal" varStatus="stuts">
			<tr >
				<td width="30" align="center"><div style="width: 25;" name="xh">${stuts.index+1 }</div></td>
				<td width="30" align="center"><input style="width:20;"  type="checkbox" name="ck" /></td>
					<input name="zhbPlanlistList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="zhbPlanlistList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
					<input name="zhbPlanlistList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
					<input name="zhbPlanlistList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
					<input name="zhbPlanlistList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
					<input name="zhbPlanlistList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
					<input name="zhbPlanlistList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
					<input name="zhbPlanlistList[${stuts.index }].plancpId" type="hidden" value="${poVal.plancpId }"/>
					<input name="zhbPlanlistList[${stuts.index }].cp.id" type="hidden" value="${poVal.cp.id }"/>
				   <td align="left" width="120" >
					       	<input id="zhbPlanlistListcpmc_${stuts.index }" name="zhbPlanlistList[${stuts.index }].cp.cpmc" maxlength="36" 
						  		type="text" class="inputxt"  style="width:100%;"
					               
					                value="${poVal.cp.cpmc }"> 
					  <label class="Validform_label" style="display: none;">产品名称</label>
				   </td>
				   <%-- <td align="left">
					        	<input id="zhbPlanlistListlxbh_${stuts.index }" name="zhbPlanlistList[${stuts.index }].cp.lxbh" maxlength="36" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.cp.lxbh.lxmc }"> 
					  <label class="Validform_label" style="display: none;">类型</label> 
				   </td> --%>
				   <td align="left" width="120">
					       	<input id="zhbPlanlistListbrand_${stuts.index }" name="zhbPlanlistList[${stuts.index }].cp.brand" maxlength="36" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.cp.brand }"> 
					  <label class="Validform_label" style="display: none;">品牌</label>
				   </td>
				   <td align="left" width="120">
					  	<input name="zhbPlanlistList[${stuts.index }].planNumber" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.planNumber }">
					  <label class="Validform_label" style="display: none;">计划数量</label>
				   </td>
				   <td align="left" width="120">
					  	<input name="zhbPlanlistList[${stuts.index }].planPrice" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.planPrice }">
					  <label class="Validform_label" style="display: none;">计划单价</label>
				   </td>
				   <td align="left" width="120">
					       	<input name="zhbPlanlistList[${stuts.index }].remark" maxlength="300" 
						  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;" style="width:120px;">备注</label>
				   </td>
				   <%-- <td align="left">
					  	<input name="zhbPlanlistList[${stuts.index }].examinNumber" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.examinNumber }">
					  <label class="Validform_label" style="display: none;">审核数量</label>
				   </td>
				   <td align="left">
					  	<input name="zhbPlanlistList[${stuts.index }].examinPrice" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.examinPrice }">
					  <label class="Validform_label" style="display: none;">审核单价</label>
				   </td> --%>
				   
   			</tr>
		</c:forEach>
	</c:if>					
	</tbody>
	 <tfoot>
		<tr bgcolor="#E6E6E6" >
		<td width="30" align="left" bgcolor="#EEEEEE" >&nbsp;</td>
		<td width="30" align="left" bgcolor="#EEEEEE" >&nbsp;</td>
		<td width="120" align="left" bgcolor="#EEEEEE" >&nbsp;</td>
		<td width="120" align="left" bgcolor="#EEEEEE" >&nbsp;</td>
		<td width="120" align="left" bgcolor="#EEEEEE" >&nbsp;</td>
		<td width="120" align="right" bgcolor="#EEEEEE" >&nbsp;总额：</td>
		<td  width="120"  align="left" bgcolor="#EEEEEE"><input  style="width:100px;" class="inputxt" readonly="readonly" type="text" id="sumMoney" name="sumMoney" ></td>
		</tr>
	</tfoot>
</table>
