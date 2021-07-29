drop table if exists student CASCADE;
create table student
(
   id bigint not null auto_increment,
   age integer not null,
   email varchar (255),
   first_name varchar (255),
   last_name varchar (255),
   primary key (id)
);
 