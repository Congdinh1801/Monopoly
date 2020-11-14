--if your user table is referenced by other tables, drop them first
drop table user; 

create table user(
username varchar(30),
password binary(16));


alter table user
	add constraint users_username_pk primary key(username);
