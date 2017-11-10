CREATE KEYSPACE market WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 2 };

USE market;

CREATE TABLE consumers (
    consumer_id int,
    name text,
    PRIMARY KEY (consumer_id)
);

CREATE TABLE products (
    product_id int,
    name text,
    price int,
    PRIMARY KEY (product_id)
);