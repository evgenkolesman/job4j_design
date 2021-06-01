select name from product where type_id = 2;
select name from product where name like '%Мороженное%';
select name from product where expired_date <= '2020-01-01';
select name from product group by name order by max(price) limit(1);
select type.name, count(type_id) from type join product on  type_id=type.id group by type.name;
select name from product where type_id = 1 OR type_id = 2;
select type.name, count(type_id) from type join product on  type_id=type.id 
group by type.name having count(type_id) < 10;
select product.name, type.name from product left join type on type_id=type.id 
group by product.name, type.name order by type.name;
