create table devices(
	id serial primary key,
	name varchar(255),
	price float unique
);
create table people(
	id serial primary key,
	name varchar(255)
);
create table devices_people(
	id serial primary key,
	people_id int references people(id),
	price_id int references devices(price),
	device_id int references devices(id)
);

insert into devices(name, price) values ('Printer', 50000);
insert into devices(name, price) values ('Mouse', 1000);
insert into devices(name, price) values ('Keyboard', 5000);

insert into people(name) values ('Alex');
insert into people(name) values ('Vicktor');
insert into people(name) values ('Fedor');

insert into devices_people(people_id, device_id) values (1, 1);
insert into devices_people(people_id, device_id) values (1, 2);
insert into devices_people(people_id, device_id) values (1, 3);
insert into devices_people(people_id, device_id) values (2, 2);
insert into devices_people(people_id, device_id) values (2, 3);
insert into devices_people(people_id, device_id) values (3, 3);
insert into devices_people(people_id, device_id) values (3, 3);
insert into devices_people(people_id, device_id) values (3, 3);

select avg(dev.price) from devices as dev;

select p.name, avg(dev.price) from people as p inner join devices_people dp on p.id= dp.people_id 
inner join devices as dev on dp.device_id = dev.id group by p.name;

select p.name, avg(dev.price) from people as p inner join devices_people dp on p.id= dp.people_id 
inner join devices as dev on dp.device_id = dev.id group by p.name having avg(dev.price) > 5000;