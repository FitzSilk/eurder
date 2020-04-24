begin;

-- -- UNCOMMENT THESE LINES TO RESET THIS DB
-- --***************************************

--set schema 'eurder';
--drop table if exists item, customer, eurder cascade;
--drop schema eurder;

-- -- END UNCOMMENT
-- --**************

create schema if not exists eurder;

set schema 'eurder';

create table if not exists item(
                                   item_id serial not null primary key,
                                   item_name varchar(60) not null,
                                   item_description varchar(120) not null,
                                   item_price numeric(5,2) not null,
                                   item_amount int not null
);

create table if not  exists customer(
                                        customer_id serial not null primary key,
                                        first_name varchar(12) not null,
                                        last_name varchar(18) not null,
                                        email varchar(64) not null,
                                        password varchar(16) not null,
                                        street_number varchar(4) not null,
                                        street_name varchar(32) not null,
                                        zip_code varchar(6) not null,
                                        city varchar(12) not null,
                                        phone_number varchar(16) not null
);

create table if not exists eurder(
                                     eurder_id serial not null primary key,
                                     total_price int,
                                     customer_id int not null,
                                     foreign key (customer_id) references customer(customer_id)
);

-- rollback;

commit;






