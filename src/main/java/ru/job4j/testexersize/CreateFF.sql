create table Customer(
    id serial primary key,
	name text,
	adress text
);

create table if not exists  Account(
    id serial primary key,
	Acc_number int,
	description text,
	customer_id  int references customer.id
);

create table if not exists Fin_Transaction(
    id serial primary key,
    TransactDate date,
    Ammount long,
    Account_id int references  Account.id,
    description text
)