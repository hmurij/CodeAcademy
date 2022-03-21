drop schema if exists budget cascade;
create schema budget;

create table budget.record
(
    id       serial primary key,
    amount   double precision,
    comments varchar(255),
    date     date
);

create table budget.debit_record
(
    id           integer primary key
        references budget.record (id),
    debit_type   varchar(50),
    payment_type varchar(50),
    time         time
);

create table budget.income_record
(
    id              integer primary key
        references budget.record (id),
    income_received boolean,
    income_type     varchar(50)
);