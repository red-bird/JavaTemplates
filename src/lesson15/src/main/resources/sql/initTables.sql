create table if not exists books(
id bigserial not null,
name varchar(255) not null,
creationDate varchar(255) not null,
constraint books_pkey primary key (id)
);

create table if not exists authors(
id bigserial not null,
firstname varchar(255) not null,
lastname varchar(255) not null,
middlename varchar(255) not null,
birthdate varchar(255) not null,
constraint authors_pkey primary key (id)
);