create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    epired_date DATE,
    price int,
<<<<<<< HEAD
    type_id int references type.id
=======
    type_id int references type(id)
>>>>>>> 974bfbc... Подготовил решение. Поиск файлов по критерию [#449811]
);