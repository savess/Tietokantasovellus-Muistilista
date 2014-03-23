

Create table kayttaja (
kid serial primary key,
tunnus varchar (10) unique,
nimi varchar (50), 
salasana varchar (20));

create table tarkeys (
tid serial primary key,
arvo integer,
kid integer references kayttaja(kid) on delete cascade,
selite varchar (50));


create table askare (
aid serial primary key,
nimi varchar (50) unique,
kid integer references kayttaja(kid) on delete cascade,
tid integer references tarkeys(tid) on delete cascade);

create table luokka (
lid serial primary key,
nimi varchar (50),
kid integer references kayttaja(kid) on delete cascade);


create table askareenluokka (
alid serial primary key,
kid integer references kayttaja(kid) on delete cascade,
lid integer references luokka(lid) on delete cascade);


