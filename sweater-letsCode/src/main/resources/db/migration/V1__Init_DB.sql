create sequence hibernate_sequence start 1 increment 1;
create table message
(
    id       int8 not null,
    filename varchar(255),
    tag      varchar(255),
    text     varchar(2048) not null,
    primary key (id)
);
create table messages_user
(
    user_id    int8,
    message_id int8 not null,
    primary key (message_id)
);
create table user_role
(
    user_id int8 not null,
    roles   varchar(255)
);
create table usr
(
    id              int8    not null,
    activation_code varchar(255),
    active          boolean not null,
    email           varchar(255),
    password        varchar(255) not null,
    username        varchar(255) not null,
    primary key (id)
);
alter table if exists messages_user
    add constraint user_messages_fk foreign key (user_id) references usr;
alter table if exists messages_user
    add constraint messages_user_fk foreign key (message_id) references message;
alter table if exists user_role
    add constraint user_role_fk foreign key (user_id) references usr;
