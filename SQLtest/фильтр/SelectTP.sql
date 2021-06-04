select product.name from product join type on   type_id=type.id where type.name = 'Сыр';
select name from product where name like '%Мороженное%';
select name from product where  expired_date < current_date;
--select name from product group by name order by max(price);
select * from products as p where p.price = (select max(price) from products);
select name from product where (select max(price) price from product) > price limit(1);
select type.name, count(type_id) from type join product on  type_id=type.id group by type.name;
select product.name from product join type on   type_id=type.id 
where type.name = 'Молоко' OR type.name = 'Сыр';
select type.name, count(type_id) from type join product on  type_id=type.id 
group by type.name having count(type_id) < 10;
select product.name, type.name from product left join type on type_id=type.id 
group by product.name, type.name order by type.name;
--select*from type;
