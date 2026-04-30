create database database_unefa;

use database_unefa;
create table User
(
IDUser int primary key not null,
Name varchar(50) not null,
LastName varchar(50),
UserName varchar(50),
Email varchar(50),
Password varchar(50),
Post varchar(50)
);

create table Subject
(
IDSubject int primary key not null,
Name varchar(50),
Unit_credit varchar(50),
Semester varchar(50)
);

create table Student
(
IDStudent int primary key not null,
Name varchar(50),
Lastname varchar(50),
Career varchar(50),
Tuition varchar(50)
);

use database_unefa;
insert into user(IDUser,Name,Lastname,Username,Email,Password,Post)
values("32066670","Jose Miguel","Betancourt Castro","Jose M","Gmail.con","1234","Hotmail");

insert into Subject(IDSubject,Name,Unit_credit,Semester)
values("2613 N","Lenguaje III","9999999","6to");

insert into Student(IDStudent,Name,Lastname,Career,Tuition)
values("12345678","Marco","Perez","politica","N1");

