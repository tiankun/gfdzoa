<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
<t:base type="jquery,easyui,tools"></t:base>
<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css"></link>
<link rel="stylesheet" href="plug-in/Validform/css/style.css" type="text/css" />
<link rel="stylesheet" href="plug-in/Validform/css/tablefrom.css" type="text/css" />
<script src="/plug-in/lodop/LodopFuncs.js" type="text/javascript"></script>
<script type="text/javascript" src="plug-in/Validform/js/Validform_v5.3.1_min.js"></script>
<script type="text/javascript" src="plug-in/Validform/js/Validform_Datatype.js"></script>
<script type="text/javascript" src="plug-in/Validform/js/datatype.js"></script>
<script type="text/javascript" src="plug-in/My97DatePicker/WdatePicker.js"></script>
  <style type="text/css">
   #goodsList input[type='text']{
		margin: 0px;
		padding: 0px;
		height: 20px;
		line-height: 20px;
		width: 95%;
   }
   .formtable .value .inputxt{
     width: 120px;
   }
   .spanbut{
      display: inline-block;
      color: #000000;
      font-family: Tahoma,Verdana,微软雅黑,新宋体;
      font-size: 12px;
   }
  </style>
<script type="text/javascript">
document.write("<script type='text/javascript' src='plug-in/uploadify/jquery.uploadify-3.1.js?" + new Date()+ "'></s" + "cript>");
var filesQueued=0; 
//商品品牌
var cbrand=$.parseJSON('${cbrand}');
$(function() {
	 $("select[name='cbillType']").bind("change",function(){
		 $.post("orderController.do?goodsAccDta&code="+this.value,function(data){
		    $("#cbillCode").val(data.msg);
		 },'json');
	 });
	 
	 $("#goodsList tr").live("click",function(){
		  $("#goodsList .select").removeClass("select");
		  $(this).addClass("select");
	  });
	 
	$("input[name$='goodsPrice']").live("change keyup",cost);
	$("input[name$='goodsNum']").live("change keyup",cost);
	$("input[name$='goodsMoney']").live("change keyup",cost);
	$("#uploadfile").uploadify({
		auto            : false,
	    height          : 18,
	    swf             : 'plug-in/uploadify/uploadify.swf',
	    uploader        : 'orderController.do?upLoadFile',
	    width           : 80,
	    fileObjName     : 'file',
	    multi           : true,
	    queueSizeLimit  : 99,
	    fileTypeExts    : '*.*',
	    buttonText      : '<span class="spanbut"><a href="###" class="icon-add"></a>&nbsp;添加附件</span>',
	    debug           : false,
	    removeCompleted : false,
	    method          : 'post',
	    successTimeout  : 60,
	    queueID         : 'fileRet',
	    onUploadSuccess : function(data,ref){
	    	var obj=$.parseJSON(ref);
	    	if($("input[name='fileId']").length>0){
	    		$("input[name='fileId']").val($("input[name='fileId']").val()+","+obj.id);
	    	}else{
	    		$("<input type='hidden' name='fileId' value='"+obj.id+"'>").appendTo("#formobj");
	    	}
	    },
	    onUploadComplete:function(file){
	    	filesQueued=filesQueued-1;
	    	 $('#uploadfile').uploadify('upload');
	    	 if(filesQueued==0){
	    		 saveData();
	    	 }
	    },
	    onDialogClose:function(swfuploadifyQueue){
	    	filesQueued+=swfuploadifyQueue.filesQueued;
	    }
	 });
	$("#uploadfile-button").removeClass();
	
	$("#billType").change(function(){
		if(this.value=='CBFY'){
			$(".hidden").show();
			$("#NAME").attr("ignore","");
		}else{
			$("#NAME").attr("ignore","ignore");
			$(".hidden").hide();
		}
	});
});
//产品列表
function addGoods(){
	 $.dialog({
			content : "url:orderController.do?goodsList",
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
					var iframe = this.iframe.contentWindow;
					var list = iframe.getGoodsData();
					//var list=iframe.getBackList();
					  var len=$("#goodsList tr").length;
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
					serial();
				},
				focus : true
			}, {
				name : '取消',
				callback : function() {
				}
			} ]
		});
}

//删除
function delGoods(){
    $("#goodsList .select").remove();
    $("#goodsList tr").each(function(i){
  	  $(this).children().eq(0).html(i+1);
    });
    if($("#goodsDiv").height()<$("#blist").height()){
		  $("#goodsTab")[0].style.paddingRight="20px";
	 }else{
		  $("#goodsTab")[0].style.paddingRight="3px";
	 }
    serial();
}
//生成序号
function serial(){
  var total=0;
  $("#goodsList tr").each(function(i){
	  $(this).children().eq(0).html(i+1);
  });
  $("#total").val(total.toFixed(2));
  adjustScroll();
  cost();
}
//计算
function cost(){
	 var total=0;
	  $("#goodsList tr").each(function(){
		  var num = 0;
		  if($(this).children().eq(5).children().eq(0).val()!=""){
			  num = $(this).children().eq(5).children().eq(0).val();
		  }
		  $(this).children().eq(6).children().eq(0).val(($(this).children().eq(4).children().eq(0).val()*1)*(num*1));
		  total+=$(this).children().eq(6).children().eq(0).val()*1;
	  });
	  $("#orderMoney").val(total.toFixed(2));
	  $("#total").html(total.toFixed(2));
}

//调整滚动条
function adjustScroll(){
	  if($("#goodsDiv").height()<$("#goodsList").height()){
		  $("#cos")[0].style.paddingRight="20px";
		  $("#goodsTab")[0].style.paddingRight="20px";
	  }else{
		  $("#cos")[0].style.paddingRight="3px";
		  $("#goodsTab")[0].style.paddingRight="3px";
	  }
}
var data=[];
var n="";
function addCost(){
  var len=$("#retList tr").length;
  var m=0;
  if(len>0){
	  m= $("#retList tr:eq("+(len-1)+")").attr("id")*1+1;
  }
  var html='<tr id="'+m+'">'
	 	 +'<td width="35px"></td>'
	 	 +'<td width="200px"><input style="width:190px" class="inputxt" type="text" datatype="*" value=""nullmsg="请填科目类型！"  name="costIncomeSubject['+m+'].accSubject.id"><span class="Validform_checktip"></span></td>'
		 +'<td width="90px"><input style="width:80px" nullmsg="请填写金额！" type="text" class="inputxt" name="costIncomeSubject['+m+'].${code=="INTYPE" ? "ninMoney" : "noutMoney"}" value="" datatype="d"><span class="Validform_checktip"></span></td>'
		 +'<td>'
		 +'<input type="text" class="inputxt" name="costIncomeSubject['+m+'].csubjectNote" datatype="*" nullmsg="该项必填！" value="">'
		 +'<span class="Validform_checktip"></span>'
		 +'</td>'
		 +'</tr>';
   $(html).appendTo("#retList");
   adjustScroll();
   $("input[name='costIncomeSubject["+m+"].accSubject.id']").combotree({
	     data:data,
		 onSelect:function(obj){
			 if(n==""){
				 n=obj.text;
			 }
		 },
		 onBeforeSelect:function(node){
			 var n = $(this).tree('getData', node.target);
			 if(n.children.length>0){
				 return false;
			 }else{
				 $("input[comboname='costIncomeSubject["+m+"].accSubject.id']").val(node.id);
				 return true;
			 }
		 }
   });
   serial();
}

</script>
 </head>
 <body>
  <form name="formobj" id="formobj" action="orderController.do?doAdd">
  <input id="id" name="cinOrOut" type="hidden" value="">
  <div id="agent" class="easyui-panel" title="客户订单" style="width:auto;height:auto;margin-bottom:1px;" data-options="doSize:false">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
		    <td align="right"><label class="Validform_label">单号:</label></td>
			<td class="value">
			  <input type="text" readonly="readonly" id="orderNumber" class="inputxt" name="orderNumber" value="${orderNumber }">
			</td>
			<td align="right"><label class="Validform_label">预约日期:</label></td>
			<td class="value">
				<input class="inputxt" id="orderDate" name="orderDate"  class="Wdate" onClick="WdatePicker()" style="width: 150px">
				<span class="Validform_checktip"></span>
			</td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label">销售人:</label></td>
			<td class="value">
				<input class="inputxt" id="orderSaleser" name="orderSaleser" value="">
				<span class="Validform_checktip"></span>
			</td>
			<td align="right"><label class="Validform_label">联系方式:</label></td>
			<td class="value">
				<input class="inputxt" id="orderPhone" name="orderPhone" value="">
				<span class="Validform_checktip"></span>
			</td>
			
		</tr>
		<tr>
			<td align="right"><label class="Validform_label">联系地址:</label></td>
			<td class="value" colspan="3">
				<input style="width:583px" class="inputxt" id="orderAddress" name="orderAddress" value="">
				<span class="Validform_checktip"></span>
			</td>
			</tr>
		<tr>
			<td align="right"><label class="Validform_label">发票信息:</label></td>
			<td class="value" colspan="3">
				<input class="inputxt" id="orderNote" name="orderNote" value=""  style="width:583px">
				<span class="Validform_checktip"></span>
			</td>
		</tr>
	</table>
  </div>
     <div class="easyui-panel" title="商品明细" style="width:auto;height:350px;margin-bottom:1px;" data-options="tools:'#goods',doSize:false">
	 <div id="goodsTab" style="padding: 3px 3px 0px 3px;">
	  <table style="width:100%;table-layout:fixed;" cellpadding="0" cellspacing="1" class="formList">
	    <tr>
	 	 <th width="35px">序号</th>
	     <th width="120px">产品名称</th>
	     <th width="90px">品牌</th>
	     <th width="100px">产品型号</th>
	     <th width="60px">单价</th>
	     <th width="60px">数量</th>
	     <th width="60px">金额</th>
	 	 <th>备注</th>
	    </tr>
	  </table>
	</div>
	<div id="goodsDiv" style="width: auto;height:290px;padding:0px 3px 0px 3px;overflow: auto;">
	  <table id="blist" style="width:100%;table-layout:fixed;margin-top:-1px" cellpadding="0" cellspacing="1" class="formList">
	    <tbody id="goodsList" align="center">
	    </tbody>
	  </table>
	</div>
	 <div id="cos" style="padding: 0px 3px 3px 3px;margin-top:-1px">
	  <table style="width:100%;table-layout:fixed;" cellpadding="0" cellspacing="1" class="formList">
	    <tr>
	     <input type="hidden" id="orderMoney" class="inputxt" name="orderMoney">
	      <input type="hidden" id="orderType" class="inputxt" name="orderType" value="1">
	     <th class="red" align="right">总金额：<span id="total">0.00</span>元</th>
	    </tr>
	  </table>
	</div>
    </div>
    <div id="goods">
        <a href="javascript:void(0)" title="添加" class="icon-add" onclick="addGoods()" style="margin-right:5px"></a>
        <a href="javascript:void(0)" title="删除" class="icon-remove" onclick="delGoods()" style="margin-right:5px"></a>
    </div>
   
</form>
 </body>
 <script type="text/javascript">
var validform=$("#formobj").Validform({
	tiptype:3, 
	ajaxPost:true
});
function uploadFile(){
	if(validform.check()){
       waiting();
       if(filesQueued==0 || $("input[name='fileId']").length>0){
    	   saveData();
       }else{
    	  $('#uploadfile').uploadify('upload');
       }
	}
}

function saveData(){
	$.post('orderController.do?doAdd',$("#formobj").serialize(),function(data){
		$.messager.progress('close');
		if(data.success){
			window.parent.tip(data.msg);
			var frame=window.parent.frames;
         	for(var i=0;i<frame.length;i++){
   				if(frame[i].document.getElementById("main_order_list")){
   					frame[i].location.reload();
   				}
   			}
	     windowapi.close();
		}else{
			$.messager.alert('错误提示',data.msg,'error');
		}
	},'json');
}
function waiting(){
    var win = $.messager.progress({
      title:'系统提示',
        msg:'数据正在保存中...请稍等'
    });
}

</script>
</html>
