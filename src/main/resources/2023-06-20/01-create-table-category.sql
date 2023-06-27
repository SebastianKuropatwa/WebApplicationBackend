--liquibase formatted sql
--changeset skuropatwa:5
create table category(
     id bigint not null auto_increment PRIMARY KEY,
     name varchar(260) not null,
     description text
);