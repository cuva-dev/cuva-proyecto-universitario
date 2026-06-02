-- crea la base de datos si no existe
create database if not exists database_unefa;

-- usa la base de datos
use database_unefa;

-- crea la tabla usuario
create table if not exists User
(
Name varchar(100),
LastName varchar(100),
UserName varchar(50) primary key not null,
Email varchar(50) not null unique,
Password varchar(15),
Post varchar(50)
);

-- crea la tabla materia
create table if not exists Subject
(
Code int primary key not null,
Name varchar(100)not null,
Unit_credit varchar(100) not null,
Semester varchar(100) not null
);

-- crea la tabla estudiante
create table if not exists Student
(
ID int primary key not null,
Name varchar(100),
Lastname varchar(100),
career varchar(100),
Tuition varchar(100)
);

-- crea la tabla reprobados
create table if not exists reprobated
(
IDStudent int,
CodeSubject int,
foreign key(IDStudent) references Student(ID),
foreign key(CodeSubject) references Subject(Code)
);