<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>产品列表</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <t:base type="jquery,easyui"></t:base>
</head>
<body>
  <t:datagrid name="dg" checkbox="false" fitColumns="false" title=""
  		actionUrl="orderController.do?goodsListJson"  idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true" width="120"></t:dgCol>
   <t:dgCol title="商品名称" field="goodsName" query="true"  width="120" ></t:dgCol>
   <t:dgCol title="品牌"   field="goodsband"   dictionary="goodsBrand" width="120" ></t:dgCol>
   <t:dgCol title="商品型号"  field="goodsModel" query="true"  width="120"></t:dgCol>
   <t:dgCol title="商品单价"  field="goodsPrice"  width="120"></t:dgCol>
  </t:datagrid>
</body>
<script type="text/javascript">
        function getGoodsData() {
        	var obj=$("#dg").datagrid("getSelections");
        	return obj;
        }
</script>
</html>