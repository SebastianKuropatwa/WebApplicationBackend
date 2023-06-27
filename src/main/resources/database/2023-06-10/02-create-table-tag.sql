--liquibase formatted sql
--changeset skuropatwa:9
create table Tag (
    id bigint not null auto_increment PRIMARY KEY,
    tags varchar(60) not null
);