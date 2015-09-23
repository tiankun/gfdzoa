<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZhbCgzxBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZhbCgzxBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addZhbCgzxBtn').bind('click', function(){   
 		 var tr =  $("#add_zhbCgzx_table_template tr").clone();
	 	 $("#add_zhbCgzx_table").append(tr);
	 	 resetTrNum('add_zhbCgzx_table');
	 	 return false;
    });  
	$('#delZhbCgzxBtn').bind('click', function(){   
      	$("#add_zhbCgzx_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zhbCgzx_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#zhbCgzx_table").createhftable({
	    	height:'300px',
			width:'auto',
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
				if (id.indexOf("#index#") >= 0){
					$this.attr("id",id.replace('#index#',i));
				}else{
					var s = id.indexOf("[");
					var e = id.indexOf("]");
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
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addZhbCgzxBtn" href="#">添加</a> <a id="delZhbCgzxBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zhbCgzx_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
				  <td align="left" bgcolor="#EEEEEE">
						采购申请单主键
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						采购数量
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						采购单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						付款商家
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						付款金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						付款方式
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						付款时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						付款说明
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						备注
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						状态
				  </td>
	</tr>
	<tbody id="add_zhbCgzx_table">	
	<c:if test="${fn:length(zhbCgzxList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="zhbCgzxList[0].id" type="hidden"/>
					<input name="zhbCgzxList[0].createName" type="hidden"/>
					<input name="zhbCgzxList[0].createBy" type="hidden"/>
					<input name="zhbCgzxList[0].createDate" type="hidden"/>
					<input name="zhbCgzxList[0].updateName" type="hidden"/>
					<input name="zhbCgzxList[0].updateBy" type="hidden"/>
					<input name="zhbCgzxList[0].updateDate" type="hidden"/>
				  <td align="left">
					  	<input name="zhbCgzxList[0].cgsqId" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">采购申请单主键</label>
					</td>
				  <td align="left">
					  	<input name="zhbCgzxList[0].buyAmount" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">采购数量</label>
					</td>
				  <td align="left">
					  	<input name="zhbCgzxList[0].buyPrice" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">采购单价</label>
					</td>
				  <td align="left">
					  	<input name="zhbCgzxList[0].merchant" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">付款商家</label>
					</td>
				  <td align="left">
					  	<input name="zhbCgzxList[0].payAmount" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">付款金额</label>
					</td>
				  <td align="left">
					  	<input name="zhbCgzxList[0].payType" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">付款方式</label>
					</td>
				  <td align="left">
					  	<input name="zhbCgzxList[0].payTime" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">付款时间</label>
					</td>
				  <td align="left">
					  	<input name="zhbCgzxList[0].payExplain" maxlength="4000" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">付款说明</label>
					</td>
				  <td align="left">
					  	<input name="zhbCgzxList[0].remark" maxlength="4000" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				  <td align="left">
					  	<input name="zhbCgzxList[0].flag" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">状态</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(zhbCgzxList)  > 0 }">
		<c:forEach items="${zhbCgzxList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="zhbCgzxList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="zhbCgzxList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
					<input name="zhbCgzxList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
					<input name="zhbCgzxList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
					<input name="zhbCgzxList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
					<input name="zhbCgzxList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
					<input name="zhbCgzxList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
				   <td align="left">
					  	<input name="zhbCgzxList[${stuts.index }].cgsqId" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.cgsqId }">
					  <label class="Validform_label" style="display: none;">采购申请单主键</label>
				   </td>
				   <td align="left">
					  	<input name="zhbCgzxList[${stuts.index }].buyAmount" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.buyAmount }">
					  <label class="Validform_label" style="display: none;">采购数量</label>
				   </td>
				   <td align="left">
					  	<input name="zhbCgzxList[${stuts.index }].buyPrice" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.buyPrice }">
					  <label class="Validform_label" style="display: none;">采购单价</label>
				   </td>
				   <td align="left">
					  	<input name="zhbCgzxList[${stuts.index }].merchant" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.merchant }">
					  <label class="Validform_label" style="display: none;">付款商家</label>
				   </td>
				   <td align="left">
					  	<input name="zhbCgzxList[${stuts.index }].payAmount" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.payAmount }">
					  <label class="Validform_label" style="display: none;">付款金额</label>
				   </td>
				   <td align="left">
					  	<input name="zhbCgzxList[${stuts.index }].payType" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.payType }">
					  <label class="Validform_label" style="display: none;">付款方式</label>
				   </td>
				   <td align="left">
					  	<input name="zhbCgzxList[${stuts.index }].payTime" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.payTime }">
					  <label class="Validform_label" style="display: none;">付款时间</label>
				   </td>
				   <td align="left">
					  	<input name="zhbCgzxList[${stuts.index }].payExplain" maxlength="4000" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.payExplain }">
					  <label class="Validform_label" style="display: none;">付款说明</label>
				   </td>
				   <td align="left">
					  	<input name="zhbCgzxList[${stuts.index }].remark" maxlength="4000" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
				   <td align="left">
					  	<input name="zhbCgzxList[${stuts.index }].flag" maxlength="32" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.flag }">
					  <label class="Validform_label" style="display: none;">状态</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
