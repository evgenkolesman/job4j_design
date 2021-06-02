create table teensM(
    id serial primary key,
    name varchar(255),
    gender varchar (2)
);
create table teensF(
    id serial primary key,
    name varchar(255),
    gender varchar (2)
);
create table teens(
    id serial primary key,
    F_id int references teensF(id),
    M_id int references teensM(id)
);