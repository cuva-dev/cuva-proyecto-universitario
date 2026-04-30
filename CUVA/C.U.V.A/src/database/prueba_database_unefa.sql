
create database database_unefa;

use database_unefa;
create table User
(
idUser int primary key not null,
Name varchar(50) not null,
LastName varchar(50),
UserName varchar(50),
Password varchar(50),
Email varchar(50),
Post varchar(50)
);

create table Materia
(
IDMateria int primary key not null,
Nombre varchar(50),
Codigo_Materia varchar(50),
Unit_credit varchar(50),
semestre varchar(50)
);

use database_unefa;
insert into user(Lastname,Name)
values("b","j");

insert into Materia(Nombre,Codigo_Materia)
values("a","b")

