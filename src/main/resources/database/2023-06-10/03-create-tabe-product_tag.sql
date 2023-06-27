--liquibase formatted sql
--changeset skuropatwa:10
CREATE TABLE product_tag (
    product_id bigint,
    tag_id bigint,
    PRIMARY KEY (product_id, tag_id),
    FOREIGN KEY (product_id) REFERENCES product (id),
    FOREIGN KEY (tag_id) REFERENCES tag (id)
);
