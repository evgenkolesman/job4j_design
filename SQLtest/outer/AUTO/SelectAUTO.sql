select a.name АВТО, e.name Двигатель, t.name Коробка, b.name Кузов from auto a join engine e on e_id=e.id
join bodywork b on b.id = b_id join transmission t on t_id = t.id;
select e.name from engine e left join auto on e.id = e_id where e_id is null;
select b.name from bodywork b left join auto on b.id = e_id where b_id is null;
select t.name  from transmission t left join auto on t.id = t_id where t_id is null;