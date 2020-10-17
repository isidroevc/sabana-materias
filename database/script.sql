create table usuario(
  id int primary key,
  username varchar(25) unique,
  nombre varchar(255),
  rol varchar(25),
  password varchar(255)
);

insert into usuario (id, username, nombre, rol, password) values
(1,'isidro', 'Isidro Emmanuel Vasquez Cortes', 'jefe', 'password'),
(2,'jose', 'José Gerardo Carpio Flores', 'profesor', 'password'),
(3,'luis', 'Luis Eduardo Gutiérrez Ayala', 'profesor', 'password');

create table materia(
  id int primary key,
  nombre varchar(255),
  creditos int
);

insert into materia (id, nombre, creditos) values
(1, 'Matemáticas discretas', 5),
(2, 'Lenguajes y Automatas', 5),
(3, 'Cálculo Diferencial', 5),
(4, 'Álgebra Lineal', 5),
(5, 'Simulación', 5);


create table turno(
  id int primary key,
  nombre varchar(255)
);

insert into turno (id, nombre) values
(1, 'Matutino'),
(2, 'Vespertino');

create table horario (
  id int AUTO_INCREMENT,
  id_turno int,
  detalle varchar(255),
  constraint fk_horario_turno foreign key(id_turno) references turno(id),
   primary key (id)
);

insert into horario (id_turno, detalle) 
values
  (1, '7:00 - 8:40'),
  (1, '8:45 - 10:25'),
  (1, '10:30 - 12:10'),
  (1, '12:15 - 14:30');


create table aula(
  id int primary key,
  nombre varchar(255)
);

insert into aula (id, nombre) values
(1, 'D-1'),
(3, 'D-3'),
(4, 'D-4'),
(5, 'D-5'),
(6, 'D-6'),
(7, 'D-7');


create table grupo(
  id int primary key,
  nombre varchar(255),
  numero_alumnos int
);

insert into grupo (id, nombre, numero_alumnos) values
(1, 'A', 35),
(3, 'B', 34),
(4, 'C', 40),
(5, 'D', 36);


create table profesor_tiene_materia_en_horario_con_grupo(
  id int AUTO_INCREMENT,
  id_profesor int,
  id_materia int,
  id_horario int,
  id_aula int,
  id_grupo int,
  constraint fk_horario_profesor foreign key (id_profesor) references usuario(id),
  constraint fk_horario_materia foreign key (id_materia) references materia(id),
  constraint fk_horario_horario foreign key (id_horario) references horario(id),
  constraint fk_horario_aula foreign key (id_aula) references aula(id),
  constraint fk_horario_grupo foreign key (id_grupo) references grupo(id),
  primary key(id)
);

