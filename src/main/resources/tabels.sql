# ======================================================================================================================
#   CREATE DATABASE
# ======================================================================================================================
DROP DATABASE warehouse;
CREATE DATABASE warehouse CHARACTER SET utf8 COLLATE utf8_general_ci;
USE warehouse;

# ======================================================================================================================
#   CREATE TABLE
# ======================================================================================================================
#   DROP TABLE users;
#   DROP TABLE products;
#   DROP TABLE product_type;
#   DROP TABLE info;
#   DROP TABLE hibernate_sequence;

-- auto-generated definition
create table users
(
    id        bigint auto_increment
        primary key,
    active    bit          not null,
    last_name varchar(255) null,
    name      varchar(255) null,
    password  varchar(255) null,
    role      varchar(255) null,
    username  varchar(255) null,
    constraint UK_r43af9ap4edm43mmtq01oddj6
        unique (username),
    constraint UK_r53o2ojjw4fikudfnsuuga336
        unique (password)
)
    engine = MyISAM;

-- auto-generated definition
create table products
(
    id              int auto_increment
        primary key,
    barcode        varchar(255) null,
    description     varchar(255) null,
    name            varchar(255) null,
    product_code    varchar(255) null,
    product_type_id varchar(255) null,
    purchase_price  varchar(255) null,
    sale_price      varchar(255) null,
    constraint UK_ks7bl2r407pphq72vxpufxqn
        unique (barcode)
)
    engine = MyISAM;

-- auto-generated definition
create table product_type
(
    id   int auto_increment
        primary key,
    name varchar(255) null,
    constraint UK_bnu2aqss00w6he2vs4bmmy609
        unique (name)
)
    engine = MyISAM;

-- auto-generated definition
create table info
(
    id                       int auto_increment
        primary key,
    add_product_in_shop      int          null,
    add_product_in_warehouse int          null,
    barcode                 varchar(255) null,
    change_date              datetime     null,
    count                    int          null,
    increment_or_decrement   bit          null,
    info                     varchar(255) null,
    product_code             varchar(255) null,
    sell                     int          null,
    constraint UK_5ffillxg8dtoukouhaip6nbb9
        unique (barcode)
)
    engine = MyISAM;

-- auto-generated definition
create table quantity_of_product
(
    id                 int auto_increment
        primary key,
    barcode           varchar(255) null,
    count_in_shop      int          null,
    count_in_warehouse int          null,
    count_of_sell      int          null,
    constraint UK_qu33mhl9ayyvf35pbjbai709x
        unique (barcode)
)
    engine = MyISAM;

-- auto-generated definition
create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;



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
# -----------------------------------------------
ALTER TABLE users AUTO_INCREMENT = 1;
ALTER TABLE product AUTO_INCREMENT = 1;
ALTER TABLE shopping_cart AUTO_INCREMENT = 1;
# -----------------------------------------------
SELECT
#        *
    name,price,type
FROM
#      users
     product
# shopping_cart
;

# -----------------------------------------------
create table users
(
    id       int          not null
        primary key,
    email    varchar(255) null,
    name     varchar(255) null,
    password varchar(255) null,
    surname  varchar(255) null,
    constraint UK_6dotkott2kjsp8vw4d0m25fb7
        unique (email)
);

create table product
(
    id             int          not null
        primary key,
    added_date     datetime     null,
    count_in_stock int          null,
    name           varchar(255) null,
    price          int          null,
    type           varchar(255) null,
    updated_date   datetime     null
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


