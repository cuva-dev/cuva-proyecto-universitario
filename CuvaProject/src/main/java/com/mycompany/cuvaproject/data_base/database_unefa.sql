-- crea la base de datos si no existe
create database if not exists database_unefa;

-- usa la base de datos
use database_unefa;


-- tabla de los cargos
create table if not exists Post
(
IDP varchar(50) primary key,
name varchar(50)
);


-- tabla usuario
create table if not exists User
(
Name varchar(100),
LastName varchar(100),
ID varchar(50) primary key not null unique, 
Email varchar(50) not null unique,
Password varchar(15) not null,
IDPost varchar(50),
foreign key (IDPost) references Post(IDP)
);

-- crea la tabla semestre
create table if not exists Semester
(
IDS int primary key not null unique,
Name varchar(100)
);

-- tabla materia
create table if not exists Subject
(
Code varchar(100) primary key not null unique,
Name varchar(100),
Unit_Credit int,
IDSemester int,
foreign key (IDSemester) references Semester(IDS)
);


-- crea la tabla estudiante
create table if not exists Student
(
ID varchar(50) primary key not null unique,
Name varchar(100),
Lastname varchar(100),
career text,
Tuition varchar(100)
);


-- tabla reprobados
create table if not exists reprobated
(
IDStudent varchar(50),
CodeSubject varchar(100),
-- foreign key (IDStudent) references Student(ID),
-- foreign key (CodeSubject) references Subject(code),
qualification varchar(50),
period varchar(50)
);

-- tabla bitacora
create table if not exists Bitacora
(
time timestamp , -- año,mes,dia,hora,minuto,seg
IDUser varchar(100),
action varchar(300),
foreign key (IDUser) references User(ID)

);

-- tabla pensum
create table if not exists Pensum
(
IDSemester int,
CodeSubject varchar(50),
foreign key (CodeSubject) references Subject(code),
foreign key (IDSemester) references Semester(IDS),
priority varchar(50),
priority2 varchar(50)

);

insert into post(IDP,Name) values("c","coordinador");
insert into semester(IDS,Name) 
values("1","1ro"),("2","2do"),("3","3ro"),("4","4to"),("5","5to"),("6","6to"),("7","7mo"),("8","8vo"),("9","9no"),("10","10mo");

INSERT INTO Subject (code, name, Unit_Credit, IDSemester) VALUES 
("ADG-25132", "EDUCACIÓN AMBIENTAL", 2, "1"),
("ADG-25123", "HOMBRE, SOCIEDAD, CIENCIA Y TEC", 2, "1"),
("IDM-24113", "INGLES I", 2, "1"),
("MAT-21212", "DIBUJO", 1, "1"),
("MAT-21215", "MATEMATICA I", 4, "1"),
("MAT-21524", "GEOMETRÍA ANALITICA", 3, "1"),
("DIN-21113", "DEFENSA INTEGRAL DE LA NACION I", 2, "1"),
("ADG-25131", "SEMINARIO I", 1, "2"),
("IDM-24123", "INGLES II", 2, "2"),
("QUF-22014", "QUÍMICA GENERAL", 4, "2"),
("QUF-23015", "FÍSICA I", 5, "2"),
("MAT-21225", "MATEMATICA II", 5, "2"),
("MAT-21114", "ALGEBRA LINEAL", 4, "2"),
("DIN-21123", "DEFENSA INTEGRAL DE LA NACION II", 2, "2"),
("ADG-25141", "SEMINARIO II", 1, "3"),
("QUF-23025", "FISICA II", 5, "3"),
("MAT-21235", "MATEMATICA III", 5, "3"),
("MAT-21414", "PROBABILIDADES Y ESTADISTICA", 4, "3"),
("SYC-22113", "PROGRAMACIÓN", 3, "3"),
("DIN-21133", "DEFENSA INTEGRAL DE LA NACION III", 2, "3"),
("AGG-22313", "SISTEMAS ADMINISTRATIVOS", 3, "4"),
("SYC-32114", "TEORÍA DE LOS SISTEMAS", 3, "4"),
("MAT-31214", "LOGICA MATEMATICA", 3, "4"),
("SYC-32225", "LENGUAJES DE PROGRAMACIÓN I", 4, "4"),
("DIN-31143", "DEFENSA INTEGRAL DE LA NACION IV", 2, "4"),
("AGL-30214", "SISTEMAS DE PRODUCCIÓN", 3, "5"),
("SYC-32414", "PROCESAMIENTO DE DATOS", 3, "5"),
("MAT-31714", "CALCULO NUMÉRICO", 3, "5"),
("MAT-31114", "TEORÍA DE GRAFOS", 3, "5"),
("SYC-32235", "LENGUAJES DE PROGRAMACIÓN II", 4, "5"),
("DIN-31153", "DEFENSA INTEGRAL DE LA NACION V", 2, "5"),
("MAT-30925", "INVESTIGACIÓN DE OPERACIONES", 4, "6"),
("ELN-30514", "CIRCUITOS LÓGICOS", 3, "6"),
("SYC-32514", "ANÁLISIS DE SISTEMAS", 3, "6"),
("SYC-32614", "BASES DE DATOS", 3, "6"),
("SYC-32245", "LENGUAJES DE PROGRAMACIÓN III", 4, "6"),
("DIN-31163", "DEFENSA INTEGRAL DE LA NACION VI", 2, "6"),
("MAT-30935", "OPTIMIZACIÓN NO LINEAL", 4, "7"),
("MAT-31414", "PROCESOS ESTOCÁSTICOS", 3, "7"),
("SYC-30525", "ARQUITECTURA DEL COMPUTADOR", 4, "7"),
("SYC-32524", "DISEÑO DE SISTEMAS", 3, "7"),
("SYC-30834", "SISTEMAS OPERATIVOS", 3, "7"),
("DIN-31173", "DEFENSA INTEGRAL DE LA NACION VII", 2, "7"),
("SYC-32714", "IMPLANTACIÓN DE SISTEMAS", 3, "8"),
("ADG-30214", "METODOLOGIA DE LA INVESTIGACION", 3, "8"),
("MAT-30945", "SIMULACIÓN Y MODELOS", 4, "8"),
("SYC-31644", "REDES", 3, "8"),
("ADG-30224", "GERENCIA DE LA INFORMÁTICA", 3, "8"),
("DIN-31183", "DEFENSA INTEGRAL DE LA NACION VIII", 2, "8"),
("MAT-31314", "TEORÍA DE DECISIONES", 3, "9"),
("SYC-32814", "AUDITORÍA DE SISTEMAS", 3, "9"),
("CJU-37314", "MARCO LEGAL PARA EL EJERCICIO DE LA INGENIERÍA", 4, "10"),
("TTC-31154", "TELEPROCESOS", 3, "10"),
("TGR-30010", "TRABAJO ESPECIAL DE GRADO", 0, "10");

insert into pensum(IDSemester,CodeSubject,priority,priority2) values
("1", "ADG-25132", "", ""),
("1", "ADG-25123", "", ""),
("1", "IDM-24113", "", ""),
("1", "MAT-21212", "", ""),
("1", "MAT-21215", "", ""),
("1", "MAT-21524", "", ""),
("1", "DIN-21113", "", ""),
("2", "ADG-25131", "", ""),
("2", "IDM-24123", "IDM-24113", ""),
("2", "QUF-22014", "MAT-21215", "MAT-21524"),
("2", "QUF-23015", "MAT-21215", "MAT-21524"),
("2", "MAT-21225", "MAT-21215", "MAT-21524"),
("2", "MAT-21114", "MAT-21215", "MAT-21524"),
("2", "DIN-21123", "DIN-21113", ""),
("3", "ADG-25141", "ADG-25131", ""),
("3", "QUF-23025", "QUF-23015", "MAT-21225"),
("3", "MAT-21235", "MAT-21225", ""),
("3", "MAT-21414", "MAT-21225", ""),
("3", "SYC-22113", "MAT-21114", ""),
("3", "DIN-21133", "DIN-21123", ""),
("4", "AGG-22313", "", ""),
("4", "SYC-32114", "", ""),
("4", "MAT-31214", "MAT-21114", ""),
("4", "SYC-32225", "SYC-22113", ""),
("4", "DIN-31143", "DIN-21133", ""),
("5", "AGL-30214", "AGG-22313", ""),
("5", "SYC-32414", "SYC-22113", ""),
("5", "MAT-31714", "MAT-21235", ""),
("5", "MAT-31114", "MAT-31213", "MAT-21413"),
("5", "SYC-32235", "SYC-32225", ""),
("5", "DIN-31153", "DIN-31143", ""),
("6", "MAT-30925", "MAT-31714", ""),
("6", "ELN-30514", "MAT-31214", ""),
("6", "SYC-32514", "SYC-32114", ""),
("6", "SYC-32614", "SYC-32414", ""),
("6", "SYC-32245", "SYC-32235", ""),
("6", "DIN-31163", "DIN-31153", ""),
("7", "MAT-30935", "MAT-30925", ""),
("7", "MAT-31414", "MAT-30925", "MAT-31114"),
("7", "SYC-30525", "ELN-30514", ""),
("7", "SYC-32524", "SYC-32514", ""),
("7", "SYC-30834", "", ""),
("7", "DIN-31173", "DIN-31163", ""),
("8", "SYC-32714", "SYC-32524", ""),
("8", "ADG-30214", "", ""),
("8", "MAT-30945", "MAT-30935", "MAT-31414"),
("8", "SYC-31644", "SYC-30834", ""),
("8", "ADG-30224", "", ""),
("8", "DIN-31183", "DIN-31173", ""),
("9", "MAT-31314", "MAT-30945", ""),
("9", "SYC-32814", "SYC-32714", ""),
("10", "CJU-37314", "", ""),
("10", "TTC-31154", "SYC-31644", ""),
("10", "TGR-30010", "", "");
