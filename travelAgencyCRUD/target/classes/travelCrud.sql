create database foodItem;
use foodItem;

create table food(
      id int not null,
      name varchar(50) not null,
      price int not null,
      available boolean not null,
      type varchar(50) not null
);

create table user(
	id int not null auto_increment primary key,
	name varchar(50) not null,
    phone varchar(50) not null,
    password varchar(50) not null
);

create table cart(
	slno int auto_increment unique key,
   	id int not null,
    itemid int not null
);

drop table cart;

CREATE TABLE `food` (
  `id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` int NOT NULL,
  `available` tinyint(1) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

select id, itemid from cart;
insert into user values(1,'Avik','9876543210','pass');

select itemid from cart where id = 1;

delete c1 from cart c1 inner join cart c2 where c1.id=1 and c1.itemid=2;

delete from food where (id=1);

insert into food values(1,'Sandwich',99.00,true,'Main Course');
insert into food values(2,'Burger',129.00,true,'Main Course');
insert into food values(3,'Pizza',149.00,true,'Main Course');
insert into food values(4,'French Fries',57.00,false,'Starters');
insert into food values(5,'Choclate Brownie',32.00,true,'Desert');

drop table food;

select * from food;
select * from user;
delete from user where id = 4;

SELECT * FROM MenuItem WHERE itemid in (select itemid from user where userid = 2);
select u.name, u.phone, u.password from user u where phone=9876543210;
drop table user;
drop table MenuItem;

truncate table cart;

select * from users_role;
select * from users;

delete from users_role where users_username = "client";
delete from users where id = 1;

drop database foodItem;

select * from food;
select * from user;
select * from users;
select * from users_role;
select * from cart;
