create table usuarios(

    id SERIAL,
    login varchar(100) not null,
    senha varchar(255) not null,

    primary key(id)

);