begin;

-- -- UNCOMMENT THESE LINES TO RESET THIS DB
-- --***************************************

--set schema 'eeurder';
--drop table if exists item, customer, eurder, item_group cascade;
--drop schema eeurder;

-- -- END UNCOMMENT
-- --**************

create schema if not exists eeurder;

set schema 'eeurder';

create table if not exists item
(
    item_id          serial        not null primary key,
    item_name        varchar(60)   not null,
    item_description varchar(120)  not null,
    item_price       numeric(5, 2) not null,
    item_amount      int           not null,
    item_visualLink  varchar       not null
);

create table if not exists customer
(
    customer_id   serial      not null primary key,
    first_name    varchar(12) not null,
    last_name     varchar(18) not null,
    email         varchar(64) not null,
    password      varchar(16) not null,
    street_number varchar(4)  not null,
    street_name   varchar(32) not null,
    zip_code      varchar(6)  not null,
    city          varchar(12) not null,
    phone_number  varchar(16) not null
);

create table if not exists eurder
(
    eurder_id   serial not null primary key,
    total_price int,
    customer_id int    not null,
    foreign key (customer_id) references customer (customer_id)
);
create table if not exists item_group
(
    item_group_id serial not null primary key,
    item_id       int    not null,
    item_amount   int    not null DEFAULT 1,
    shipping_date date   not null,
    eurder_id     int    not null,
    foreign key (eurder_id) references eurder (eurder_id),
    foreign key (item_id) references item (item_id)
);


--rollback;

commit;


