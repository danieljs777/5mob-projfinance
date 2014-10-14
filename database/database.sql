
create table user
(
 id integer auto_increment primary key,
 user_name varchar(20) not null,
 login varchar(20) not null, 
 password varchar(40) not null, 
 enable bool default 1
);


create table transaction
(
 id integer auto_increment primary key, 
 category integer,
 description varchar(50) not null,
 type smallint not null, 
 amount decimal(9,2) not null,
 tran_date date not null,
 tran_time time,
 gps_coordinations varchar(100),
 payment_method smallint,
 store varchar(50)

);

create table category
(
 id integer auto_increment primary key, 
 description varchar(20) not null
);

create table transaction_category
(
 id integer,
 cat_id integer,
 primary key(tran_id, cat_id)
);

create table transaction_type
(
 id integer primary key not null auto_increment,
 description varchar(20) not null
);

create table payment_method
(
 id integer primary key not null auto_increment,
 description varchar(20) not null
);