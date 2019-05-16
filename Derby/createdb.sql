connect 'jdbc:derby:ksidb;create=true';

drop table POZYCJE;
drop table AUTOR;
drop table WYDAWCA;


create table AUTOR (
        AUTID integer not null generated by default as identity,
        NAME varchar(255) not null,
        PRIMARY KEY(AUTID)
        );

create table WYDAWCA (
        WYDID integer not null generated by default as identity,
        NAME varchar(255) not null,
        PRIMARY KEY(WYDID)
        );


CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE (null,'AUTOR','AUTOR.TXT',null,null,null,0);
CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE (null,'WYDAWCA','WYDAWCA.TXT',null,null,null,0);

create table POZYCJE (
        ISBN char(13) not null,
        AUTID integer not null,
        TYTUL varchar(255) not null,
        WYDID integer not null,
        ROK integer not null,
        CENA real,
        PRIMARY KEY(ISBN),
        FOREIGN KEY(AUTID) REFERENCES AUTOR(AUTID),
        FOREIGN KEY(WYDID) REFERENCES WYDAWCA(WYDID)
        );

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE (null,'POZYCJE','POZYCJE.TXT',null,null,null,0);

 