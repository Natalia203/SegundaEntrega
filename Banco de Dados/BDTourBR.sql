create database agencia_brTour;
use  agencia_brTour;

create table destino (
id_destino int auto_increment primary key,
cidade varchar(30),
estado varchar(30),
descricao varchar(50)
);

create table viagem (
id_viagem int auto_increment primary key,
data_saida date,
data_volta date,
preco decimal(10),
id_destino int
);

create table cliente (
id_cliente int auto_increment primary key,
nome varchar(40),
cpf varchar(15),
telefone varchar(20),
email varchar(30),
endereco varchar(50)
);

create table reserva(
id_reserva int auto_increment primary key,
data_reserva datetime,
id_cliente int,
id_viagem int,
foreign key(id_cliente) references cliente (id_cliente),
foreign key(id_viagem) references viagem (id_viagem)
);

alter table viagem add foreign key(id_destino) references destino (id_destino);

show tables;

select * from reserva;




