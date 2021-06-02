create table departments(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    dep_id int references departments(id)
);