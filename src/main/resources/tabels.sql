# ======================================================================================================================
#   CREATE DATABASE
# ======================================================================================================================
# DROP DATABASE shopping_cart;
# CREATE DATABASE shopping_cart CHARACTER SET utf8 COLLATE utf8_general_ci;
# USE shopping_cart;

# ======================================================================================================================
#   CREATE TABLE
# ======================================================================================================================
DROP TABLE users;
DROP TABLE product;
DROP TABLE shopping_cart;
DROP TABLE roles;
DROP TABLE user_roles;
# -----------------------------------------------
create table users
(
    id       bigint       not null
        primary key,
    email    varchar(50)  null,
    name     varchar(255) null,
    password varchar(255) null,
    surname  varchar(255) null,
    constraint UK_6dotkott2kjsp8vw4d0m25fb7
        unique (email)
);

create table product
(
    id             bigint       not null
        primary key,
    added_date     datetime     null,
    count_in_stock int          null,
    name           varchar(255) null,
    price          int          null,
    type           varchar(255) null,
    updated_date   datetime     null
);

create table roles
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table shopping_cart
(
    id         int          not null,
    product_id int null,
    quantity   int null,
    user_id    int null,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

create table shopping_cart
(
    id         bigint not null
        primary key,
    product_id int    null,
    quantity   int    null,
    user_id    int    null,
    constraint FKmy8drf9gpv759uv3glwegxt67
        foreign key (id) references product (id)
);

create table user_roles
(
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id),
    constraint FKh8ciramu9cc9q3qcqiv4ue8a6
        foreign key (role_id) references roles (id),
    constraint FKhfh9dx7w3ubf1co1vdev94g3f
        foreign key (user_id) references users (id)
);


-- auto-generated definition
create table hibernate_sequence
(
    next_val bigint null
);

# ---------------------------------------------------------------------
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users(id,name,surname,email,password) VALUES(1,'Admin','Admin','admin','admin');
INSERT INTO user_roles(user_id, role_id) VALUES(1,1);