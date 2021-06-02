select employees.name from employees left join departments d on dep_id=d.id;
select e.name, d.name from employees e right join departments d on dep_id=d.id;
select e.name, d.name from employees e full join departments d on dep_id=d.id;
select e.name, d.name from employees e cross join departments d ;
select d.name from departments d left join employees e on dep_id=d.id where e.name is null;
select e.name, d.name from employees e right join departments d on dep_id=d.id;
select e.name, d.name from  departments d left join employees e on dep_id=d.id;
