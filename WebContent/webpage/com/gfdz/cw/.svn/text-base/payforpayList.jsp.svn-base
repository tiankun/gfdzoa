<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
function payforpayAdd(title,url, id,width,height) {
        var ids=[];
		var gys=[];
		var flag=false;
		var rows =$('#payforList').datagrid('getSelections');
		if(rows.length<=0){
			tip('请选择至少一条信息');
			return;
		}else{
		
		for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i].id);
					gys.push(rows[i].merchant);
				}
		}
		  
	     if(gys.length>0){
	     for(var j = 0;j < gys.length; j++)
	       if(gys[0]!=gys[j]){
	       flag=true;
	       }
	     }
	     if(flag){
	     alert("只可选择同一家供应商的配给单！")
	     return;
	     }
	
	url += '&ids='+ids;
	createwindow(title,url,width,height);
}	
</script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="payforList" checkbox="true" fitColumns="false" title="款项支付" actionUrl="payforController.do?datagridPay" idField="id" fit="true" queryMode="group">
   <t:dgCol title="配给单"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="材料"  field="userId.realName"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="采购数量"  field="buyAmount"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入库数量"  field="money"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入库单价"  field="buyPrice"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="金额"  field="payAmount"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="供应商"  field="merchant"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目"  field="project.projectName"    queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="付款" icon="icon-add"  url="payforController.do?addorupdatePay" funname="payforpayAdd"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>