create table medicos(
    id bigint not null auto_increment,
    nome varchar(70) not null,
    email varchar(50) not null unique,
    crm varchar(6) not null unique,
    especialidade varchar(10) not null,
    rua varchar (50) not null,
    bairro varchar(50) not null,
    cep varchar(9) not null,
    complemento varchar(10),
    numero varchar(5),
    uf char(2) not null,
    cidade varchar(50) not null,

    primary key(id)

);