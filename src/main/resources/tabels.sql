create table user
(
  id        int       not null primary key,
  name      varchar(255) null,
  surname   varchar(255) null,
  password  varchar(255) null,
  status    varchar(255) null,
  username  varchar(255) null,
  constraint UK_r43af9ap4edm43mmtq01oddj6
    unique (username),
  constraint UK_r53o2ojjw4fikudfnsuuga336
    unique (password)
)
  engine = MyISAM;

create table role
(
  id   int          not null
    primary key,
  role varchar(255) null
)
  engine = MyISAM;

create table user_role
(
  user_id bigint not null,
  role_id int    not null,
  primary key (user_id, role_id)
)
  engine = MyISAM;
create index FKa68196081fvovjhkek5m97n3y
  on user_role (role_id);
-- ======================================================================================================================================================

create table products
(
  id                 int          not null
    primary key,
  bar_code           varchar(255) null,
  count_in_shop      int          null,
  count_in_warehouse int          null,
  description        varchar(255) null,
  name               varchar(255) null,
  product_code       varchar(255) null,
  purchase_price     varchar(255) null,
  sale_price         varchar(255) null,
  type_id            varchar(255) null,
  constraint UK_922x4t23nx64422orei4meb2y
    unique (product_code),
  constraint UK_ks7bl2r407pphq72vxpufxqn
    unique (bar_code)
)
  engine = MyISAM;

create table type
(
  id   int          not null
    primary key,
  name varchar(255) null
)
  engine = MyISAM;




