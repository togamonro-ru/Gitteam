 

ユーザー
CREATE TABLE bookaccount(
 id serial,
 name VARCHAR (64) NOT NULL,
 mail varchar(256) not null unique,
 phon int not null,
 salt varchar(32) not null,
 password varchar(64) not null,
 primary key(id)
);


本
CREATE TABLE book(
 id serial,
 name VARCHAR (64) NOT NULL,
 isbn int not null
 
 primary key(id)
);



