create database if not exists database_unefa;

use database_unefa;

/* =================================== */
create table User
(
IDUser int primary key not null,
Name varchar(100),
LastName varchar(50),
UserName varchar(50),
Email varchar(50) not null unique,
Password varchar(15) not null,
Post varchar(50)
);


/* =================================== */
create table Subject
(
IDSubject int primary key not null,
Name varchar(100),
Unit_credit varchar(10),
Semester varchar(5)
);


/* =================================== */
create table Student
(
IDStudent int primary key not null,
Name varchar(100),
Lastname varchar(100),
Career varchar(50),
Tuition varchar(50)
);

/* =================================== */
create table reprobated		/*tabla reprovados*/
(
IDreprobated int primary key not null,
IDStudent int,
IDCodeSubject int,
NameSubject varchar(100),
NameStudent varchar(100)
);
