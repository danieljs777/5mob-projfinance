

CREATE TABLE category
(
cat_id integer auto_increment primary key,
description varchar(20) not null
);

CREATE TABLE payment_method
(
id integer auto_increment primary key,
description varchar(20) not null
);

CREATE TABLE transaction_category
(
tran_id integer,
cat_id integer,
primary key(tran_id, cat_id)
);


CREATE TABLE `transaction`
(
id integer auto_increment primary key,
category integer,
description varchar(50) not null,
type smallint not null,
amount decimal(9,2) not null,
tran_date date not null,
tran_time time,
gps_coordinations varchar(100),
payment_method integer,
store varchar(50)
);

CREATE TABLE transaction_type
(
id integer auto_increment primary key,
description varchar(20) not null
);

CREATE TABLE user
(
id integer auto_increment primary key,
user_name varchar(20) not null,
login varchar(20) not null,
password varchar(40) not null,
enable bool default 1
);