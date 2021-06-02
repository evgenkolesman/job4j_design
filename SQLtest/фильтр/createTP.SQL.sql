create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    epired_date DATE,
    price int,
    type_id int references type.id
);