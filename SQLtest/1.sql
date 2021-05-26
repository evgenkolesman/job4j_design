create table cars(
	id serial primary key,
	name varchar(255),
	country text,
	number int2
);
insert into cars(name, country, number) values('Gealy', 'China', '030');
insert into cars(name, country, number) values('Jeep', 'USA', '020');
insert into cars(name, country, number) values('Vesta', 'Russia', '010');
update cars
	set name = 'Cherry'
	WHERE id = 1;
select*from cars;
delete from cars;
