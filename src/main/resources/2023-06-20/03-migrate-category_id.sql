--liquibase formatted sql
--changeset skuropatwa:7
insert into category (id, name, description) values(1, 'Kategoria 1', '');
update product set category_id=1;
alter table product MODIFY category_id bigint not null;