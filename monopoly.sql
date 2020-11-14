drop table hascontact;
drop table messageSent;
drop table user;


CREATE TABLE user
        (username            varchar (25),
        password            varbinary (16)
        );
        
CREATE TABLE hascontact
        (username           VARCHAR(25),
        contact_username    VARCHAR(25))
        ;

CREATE TABLE messageSent
        (fromusername         varchar (25),
        tousername         varchar (25) ,
        message          varchar (50),
        date_sent          date)
        ;


alter table user
 add constraint user_username_pk primary key(username);

alter table hascontact
 add constraint hascontact_username_contactusername_pk primary key(username,contact_username);

alter table messageSent 
 add constraint messageSent_fromusername_tousername__datesent_pk primary key(fromusername,tousername,date_sent);

alter table hascontact
 add constraint hascontact_username_fk foreign key(username)
 references user(username);

 alter table hascontact
 add constraint hascontact_contactusername_fk foreign key(contact_username)
 references user(username);

alter table messageSent
 add constraint message_fromuser_fk foreign key(fromusername)
 references user(username);

 alter table messageSent
 add constraint message_touser_fk foreign key(tousername)
 references user(username);


--  alter table user
--   modify password not null;
--  add constraint password_nn not null;(tousername)
--  references user(username);

-- alter table worker
--       modify age numeric(3) not null;
	  

desc user;
desc hascontact;
desc messageSent;
