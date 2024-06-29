create table doctors(

                        id bigint not null auto_increment,
                        name varchar(100) not null,
                        email varchar(100) not null unique,
                        phone varchar(20) not null,
                        crm varchar(6) not null unique,
                        escpecialites varchar(100) not null,
                        street varchar(100) not null,
                        neighborhood varchar(100) not null,
                        cep varchar(9) not null,
                        complements varchar(100),
                        number varchar(20),
                        uf char(2) not null,
                        city varchar(100) not null,

                        primary key(id)

);