create table client_baza(
	id serial primary key,
	number int
);
create table client(
	id serial primary key,
	name varchar(255),
	baza_id int references client_baza(id)
);

insert into client_baza(number) values (1);
insert into client_baza(number) values (2);
insert into client_baza(number) values (3);
insert into client_baza(number) values (4);
insert into client_baza(number) values (5);

insert into client(name, baza_id) values ('Vicktor', 1);
insert into client(name, baza_id) values ('Alex', 2);
insert into client(name, baza_id) values ('Valery', 3);
insert into client(name, baza_id) values ('Ilya', 4);
insert into client(name, baza_id) values ('Yury', 5);

insert into client(name) values('Pavel');

select * from client as c inner join client_baza cb on c.baza_id = cb.id;
select cb.number, c.name, c.baza_id from client as c join client_baza as cb on c.baza_id = cb.id;
select cb.number as Номер, c.baza_id as id from client as c join client_baza as cb on c.baza_id = cb.id;
select cb.number as Номер, c.baza_id as Id, c.name as Имя from client as c join client_baza as cb on c.baza_id = cb.id;

