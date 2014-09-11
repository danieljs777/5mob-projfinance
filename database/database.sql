
create table user
(
 user_id integer auto_increment primary key,
 user_name varchar(20) not null,
 login varchar(20) not null, 
 password varchar(40) not null, 
 enable bool default 1
);


create table transaction
(
 tran_id integer auto_increment primary key, 
 description varchar(50) not null,
 type smallint not null, 
 amount decimal(9,2) not null,
 tran_date date not null,
 tran_time time,
 gps_coordinations varchar(100),
 store varchar(50)

);

create table category
(
 cat_id integer auto_increment primary key, 
 description varchar(20) not null
);

create table transaction_category
(
 tran_id integer,
 cat_id integer,
 primary key(tran_id, cat_id)
);
