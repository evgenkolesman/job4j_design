create table bodywork(
    id serial primary key,
    name varchar(255)
);
create table engine(
    id serial primary key,
    name varchar(255)
);
create table transmission(
    id serial primary key,
    name varchar(255)
);
create table auto(
    id serial primary key,
    name varchar(255),
    b_id int references bodywork(id),
    e_id int references engine(id),
    t_id int references transmission(id)
);