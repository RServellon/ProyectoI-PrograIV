
-- Se borran las secuencias
drop sequence sec_usuarios;
drop sequence sec_especialidades;
drop sequence sec_ciudades;
drop sequence sec_citas;

-- Se borran las tablas

drop table citas;
drop table calificaciones;
drop table horarios;
drop table medicos;
drop table ciudades;
drop table especialidades;
drop table pacientes;
drop table administradores;
drop table usuarios;


-- Se crean las secuencias
create sequence sec_usuarios 
	as int
	start with 100 
	increment by 1;
create sequence sec_especialidades 
	as int
	start with 1 
	increment by 1;
create sequence sec_ciudades 
	as int
	start with 1000 
	increment by 1;
create sequence sec_citas
    as int
    start with 2000
	increment by 1


--Se crean las tablas
create table usuarios(id int not null, nombre varchar(20) not null, clave varchar(20) not null, tipo varchar(10) not null);
create table administradores(id int not null);
create table medicos(id int not null, especialidad int null, costo decimal(11,4) null, ciudad int  null, clinica varchar(20) null, estado varchar(20) not null);
create table pacientes(id int not null);
create table horarios(id_medico int not null, fechaHoraInicio smalldatetime not null, fechaHoraFinal smalldatetime not null, frecuencia time not null);
create table ciudades(codigo int not null, nombre varchar(20) not null, provincia varchar(20) not null);
create table especialidades(codigo int not null, nombre varchar(20) not null, descripcion text null);
create table citas(codigo int not null, id_medico int not null, id_paciente int not null, fechaHora smalldatetime not null, estado varchar(20) not null, anotaciones text not null);
create table calificaciones(id_medico int not null, id_paciente int not null, calificacion varchar(20) not null);

-- Se crean todas las llaves
-- PK
alter table usuarios add constraint usuarios_pk primary key (id);
alter table administradores add constraint administradores_pk primary key(id);
alter table medicos add constraint medicos_pk primary key(id);
alter table pacientes add constraint pacientes_pk primary key(id);
alter table especialidades add constraint especialidades_pk primary key(codigo);
alter table ciudades add constraint ciudades_pk primary key(codigo);
alter table citas add constraint medicos_citas_pk primary key(codigo);

--PK compuestas
alter table horarios add constraint medicos_horarios_pk primary key(id_medico, fechaHoraInicio, fechaHoraFinal);
alter table calificaciones add constraint medicos_calificaciones_pk primary key(id_medico, id_paciente);

-- FK
alter table administradores
	add constraint administradores_id_fk foreign key(id) 
		references usuarios(id) on delete cascade;
alter table medicos
	add constraint medicos_id_fk foreign key(id) 
		references usuarios(id) on delete cascade;
alter table medicos
	add constraint medicos_especialidad_fk foreign key(especialidad) 
		references especialidades(codigo) on delete cascade;
alter table medicos
	add constraint medicos_ciudad_fk foreign key(ciudad) 
		references ciudades(codigo) on delete cascade;
alter table pacientes
	add constraint pacientes_fk foreign key(id) 
		references usuarios(id) on delete cascade;
alter table horarios
	add constraint horarios_medico_fk foreign key(id_medico) 
		references medicos(id) on delete cascade;
alter table citas
	add constraint citas_medico_fk foreign key(id_medico) 
		references medicos(id) on delete cascade;
alter table citas
	add constraint citas_paciente_fk foreign key(id_paciente) 
		references pacientes(id) on delete no action;
alter table calificaciones
	add constraint calificaciones_medico_fk	foreign key(id_medico) 
		references medicos(id) on delete cascade;
alter table calificaciones
	add constraint calificaciones_paciente_fk foreign key(id_paciente) 
		references pacientes(id) on delete no action;


-- CK
alter table usuarios 
	add constraint usuarios_ck1 Check (tipo in ('ADMIN','MEDICO','PACIENTE'));
alter table medicos 
	add constraint medicos_ck1 Check (estado in ('APRO','ESP','REC'));
alter table ciudades 
	add constraint ciudades_ck1 Check (provincia in ('SAN JOSE','HEREDIA','LIMON','CARTAGO','ALAJUELA','PUNTARENAS','GUANACASTE'));
alter table horarios 
	add constraint horarios_ck1 Check (frecuencia in ('00:30:00','01:00:00'));
alter table citas 
	add constraint citas_ck1 Check (estado in ('FINALIZADO','REGISTRADO', 'CANCELADO'));
alter table calificaciones 
	add constraint calificaciones_ck1 Check(calificacion in ('EXCELENTE','ACEPTABLE','DEFICIENTE'));

-- UK
alter table usuarios add constraint usuarios_nombre_uk unique (nombre);
alter table especialidades add constraint especialidades_nombre_uk unique (nombre);
alter table ciudades add constraint ciudades_nombre_uk unique (nombre);
alter table horarios add constraint medicos_horarios_uk unique(id_medico, fechaHoraInicio);
alter table citas add constraint medicos_citas_uk unique(id_medico, fechaHora);


-- Ingresando datos de prueba
-- Especialidades
insert into especialidades(codigo, nombre, descripcion) values (next value for sec_especialidades, 'General', 'Previene, detecta y trata enfermedades comunes.');
insert into especialidades(codigo, nombre, descripcion) values (next value for sec_especialidades, 'Cardiologia', 'Estudio, diagn??stico y tratamiento de las enfermedades del coraz??n y del sistema circulatorio.');
insert into especialidades(codigo, nombre, descripcion) values (next value for sec_especialidades, 'Psicologia', 'Estudia las funciones mentales y de comportamiento.');
insert into especialidades(codigo, nombre, descripcion) values (next value for sec_especialidades, 'Odontologia', 'Diagn??stico y tratamiento del aparato estomagn??tico.');
insert into especialidades(codigo, nombre, descripcion) values (next value for sec_especialidades, 'Pediatria', 'Atenci??n m??dica de beb??s, ni??os y adolescentes.');
insert into especialidades(codigo, nombre, descripcion) values (next value for sec_especialidades, 'Anestecia General',  null);


-- Ciudades
insert into ciudades(codigo, nombre, provincia) values (next value for sec_ciudades, 'San Jose', 'San Jose');
insert into ciudades(codigo, nombre, provincia) values (next value for sec_ciudades, 'Tibas', 'San Jose');
insert into ciudades(codigo, nombre, provincia) values (next value for sec_ciudades, 'Heredia', 'Heredia');
insert into ciudades(codigo, nombre, provincia) values (next value for sec_ciudades, 'Barva', 'Heredia');


-- Usuarios
insert into usuarios(id, nombre, clave, tipo) values (next value for sec_usuarios, 'Lucia Hernandez', 'Password100', 'admin');
insert into usuarios(id, nombre, clave, tipo) values (next value for sec_usuarios, 'Juan Leon', 'Password101', 'medico');
insert into usuarios(id, nombre, clave, tipo) values (next value for sec_usuarios, 'Nicolas Suarez', 'Password102', 'medico');
insert into usuarios(id, nombre, clave, tipo) values (next value for sec_usuarios, 'Joseph Romero', 'Password103', 'paciente');
insert into usuarios(id, nombre, clave, tipo) values (next value for sec_usuarios, 'Maria Vargas', 'Password104', 'paciente');
insert into usuarios(id, nombre, clave, tipo) values (next value for sec_usuarios, 'Felicia Ramirez', 'Password105', 'medico');

-- Admins
insert into administradores(id) values (100);

-- Medicos
insert into medicos(id, especialidad, costo, ciudad, clinica, estado) values (101, 1, 70000, 1000, 'Athena', 'APRO');
insert into medicos(id, especialidad, costo, ciudad, clinica, estado) values (102, 4, 100000, 1002, 'Pacific Global', 'APRO');
insert into medicos(id, especialidad, costo, ciudad, clinica, estado) values (105, 6, 100000, 1003, 'Salud', 'APRO');

-- Pacientes
insert into pacientes(id) values (103);
insert into pacientes(id) values (104);

-- Horarios
insert into horarios(id_medico, fechaHoraInicio, fechaHoraFinal, frecuencia) values (101, '2022-04-10 16:00:00', '2022-04-10 20:00:00','00:30:00');
insert into horarios(id_medico, fechaHoraInicio, fechaHoraFinal, frecuencia) values (101, '2022-04-11 13:00:00', '2022-04-11 17:00:00','01:00:00');
insert into horarios(id_medico, fechaHoraInicio, fechaHoraFinal, frecuencia) values (102, '2022-04-10 08:00:00', '2022-04-10 11:00:00','00:30:00');
insert into horarios(id_medico, fechaHoraInicio, fechaHoraFinal, frecuencia) values (102, '2022-04-11 18:00:00', '2022-04-11 21:00:00','00:30:00');

-- Citas
insert into citas(codigo, id_medico, id_paciente, fechaHora, estado, anotaciones) values (next value for sec_citas, 101, 103, '2022-04-10 16:00:00', 'FINALIZADO', 'Problemas respiratorios por asma.');
insert into citas(codigo, id_medico, id_paciente, fechaHora, estado, anotaciones) values (next value for sec_citas,101, 104, '2022-04-11 14:00:00', 'FINALIZADO', 'Chequeo general.');
insert into citas(codigo, id_medico, id_paciente, fechaHora, estado, anotaciones) values (next value for sec_citas,102, 103, '2022-04-10 09:30:00', 'FINALIZADO', 'Limpieza bucal.');
insert into citas(codigo, id_medico, id_paciente, fechaHora, estado, anotaciones) values (next value for sec_citas,102, 104, '2022-04-11 20:30:00', 'FINALIZADO', 'Extracci??n del molar superior izquierdo.');

-- Calificaciones
insert into calificaciones(id_medico, id_paciente, calificacion) values (101, 103, 'EXCELENTE');
insert into calificaciones(id_medico, id_paciente, calificacion) values (101, 104, 'ACEPTABLE');
insert into calificaciones(id_medico, id_paciente, calificacion) values (102, 103, 'EXCELENTE');
insert into calificaciones(id_medico, id_paciente, calificacion) values (102, 104, 'EXCELENTE');

select * from usuarios;
select * from administradores;
select * from pacientes;
select * from medicos;
select * from citas;
select * from ciudades;
select * from horarios;
select * from especialidades;
select * from calificaciones;
