create table role
(
    code   varchar(50)  not null primary key,
    name   varchar(255) not null check (name <> ''),
    actual boolean      not null default false
);

create table role_permission
(
    code   varchar(100) not null primary key,
    name   varchar(255) not null check (name <> ''),
    actual boolean      not null default false
);

create table user_info
(
    id       varchar(50) not null primary key,
    username varchar(100) unique,
    password varchar(255),
    actual   boolean     not null default false
);
