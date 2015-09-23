select t1.id id , t1.goods_name goodsname ,t1.goods_band goodsband ,t1.goods_model goodsmodel ,p.ddnum ddnum, p.cgnum cgnum, (p.cgnum-p.ddnum) kcnum from 
(SELECT t.goods_id goodsid, sum(case when t.inorout='1'  then t.goods_num else 0 end) ddnum,
sum(case when t.inorout='0'  then  t.goods_num else 0 end) cgnum
FROM t_base_goodsinout t where t.goods_state='1' group by t.goods_id) p
inner join t_base_goods t1 on p.goodsid = t1.id
where 1=1 @replace

