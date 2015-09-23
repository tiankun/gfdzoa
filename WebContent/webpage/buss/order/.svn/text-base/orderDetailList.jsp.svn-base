<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="orderDetailList" checkbox="false" fitColumns="false" title=""
  		actionUrl="orderController.do?orderDetailData&orderId=${param.orderId }"  idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true" width="120"></t:dgCol>
   <t:dgCol title="商品名称"  field="goods.goodsName"     width="120"></t:dgCol>
   <t:dgCol title="品牌"  field="goods.goodsband" dictionary="goodsBrand"  width="120"></t:dgCol>
   <t:dgCol title="商品型号"  field="goods.goodsModel"   width="120"></t:dgCol>
   <t:dgCol title="商品单价"  field="goods.goodsPrice"  width="120"></t:dgCol>
   <t:dgCol title="商品数量"  field="goodsNum"  width="120"></t:dgCol>
   <t:dgCol title="商品金额"  field="goodsMoney"  width="120"></t:dgCol>
   <t:dgCol title="日期"  field="createDate" formatter="yyyy-MM-dd"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="cnote" ></t:dgCol>
  </t:datagrid>
  </div>
 </div>
