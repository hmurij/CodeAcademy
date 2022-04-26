create table product
(
    id                int primary key AUTO_INCREMENT,
    product_id        uuid           not null,
    name              varchar(50)    not null,
    quantity_in_stock int            not null,
    price             decimal(20, 2) not null,
    description       varchar(500) default null
);


