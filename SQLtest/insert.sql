insert into role(id,name) values (1, 'builder');
insert into users(name, id_role) values ('Alex', 1);
insert into state(id, name) values (10, 'Germany');
insert into rules(id, name) values (100, 'norm');
insert into category(id, name) values (7,'class');
insert into role_rules(name, id_role, id_rules) values('1', 1, 100);
insert into item(id, name, id_state, id_category) values (1000, 'shovel', 10,7);
insert into comments(name, id_item) values ('allright',1000);
insert into attaches(name, id_item) values('Shovel 1', 1000);