# ======================================================================================================================
#   CREATE DATABASE
# ======================================================================================================================
DROP DATABASE shopping_cart;
CREATE DATABASE shopping_cart CHARACTER SET utf8 COLLATE utf8_general_ci;
USE shopping_cart;

# ======================================================================================================================
#   CREATE TABLE
# ======================================================================================================================
DROP TABLE users;
DROP TABLE product;
DROP TABLE shopping_cart;
DROP TABLE cart_item;
DROP TABLE roles;
DROP TABLE user_roles;
DROP TABLE databasechangelog;
DROP TABLE databasechangeloglock;
# -----------------------------------------------
create table users
(
    id       bigint auto_increment
        primary key,
    email    varchar(255) not null,
    password varchar(255) not null,
    name     varchar(255) not null,
    surname  varchar(255) not null,
    constraint email
        unique (email)
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

create table product
(
    id             bigint auto_increment
        primary key,
    name           varchar(255)                          not null,
    price          int                                   not null,
    type           varchar(255)                          not null,
    count_in_stock int                                   not null,
    created_date   timestamp default current_timestamp() not null,
    updated_date   timestamp default current_timestamp() null
);

create table roles
(
    id   bigint auto_increment
        primary key,
    name varchar(255) not null
);

create table shopping_cart
(
    id      bigint auto_increment
        primary key,
    user_id bigint not null,
    constraint fk_users
        foreign key (user_id) references users (id)
            on delete cascade
);

create table cart_item
(
    id               bigint auto_increment
        primary key,
    quantity         int          not null,
    status           varchar(255) not null,
    shopping_cart_id bigint       not null,
    product_id       bigint       not null,
    constraint fk_product
        foreign key (product_id) references product (id)
            on delete cascade,
    constraint fk_shopping_cart
        foreign key (shopping_cart_id) references shopping_cart (id)
            on delete cascade
);
# ---------------------------------------------------------------------
# INSERT INTO roles(name)
# VALUES ('ROLE_USER');
# INSERT INTO roles(name)
# VALUES ('ROLE_ADMIN');
#
# INSERT INTO users(id, name, surname, email, password)
# VALUES (1, 'Admin', 'Admin', 'admin', '$2a$10$e3k3qKezkN3LMez1YPKkPeP8TDHknGZqiIya9hePClTnRzgC.T1u2');
# INSERT INTO user_roles(user_id, role_id)
# VALUES (1, 1);