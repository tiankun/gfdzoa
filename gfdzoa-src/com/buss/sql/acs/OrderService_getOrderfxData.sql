select t.id id,
t.order_Number orderNumber,
t.sales sales,
t.cost cost,
(t.sales-t.cost-t.sales*3/100-t.sales*3/100*12/100-(t.sales-ifnull(t.fuwumoney,0))*5/100+50*ifnull(t.fuwunum,0)) profit
 from t_base_profit t 