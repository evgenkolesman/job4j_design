create table role(
	id serial primary key,
	name varchar(255)
);
create table category(
	id serial primary key,
	name varchar(255)
);
create table state(
	id serial primary key,
	name varchar(255)
);
	
create table users(
	id serial primary key,
	name varchar(255),
	id_role int references role(id)
);
create table rules(
	id serial primary key,
	name varchar(255)
);
create table role_rules(
	id serial primary key,
	name varchar(255),
	id_role int references role(id),
	id_rules int references rules(id)
);
create table item(
	id serial primary key,
	name varchar(255),
	id_state int references state(id),
	id_category int references category(id)
);
create table comments(
	id serial primary key,
	name varchar(255),
	id_item int references item(id)
);
create table attaches(
	id serial primary key,
	name varchar(255),
	id_item int references item(id)
);