BEGIN;


CREATE DATABASE IF NOT EXISTS ecommercedbmike;

USE ecommercedbmike;

CREATE TABLE products (
	productId int NOT NULL unique,
    productUuid varchar(36) NOT NULL unique,
    productName varchar(50) NOT NULL,
    productDescription TEXT,
    productImage TEXT,
    productPrice double,
    currency varchar(3),
    primary key(productId)
);

create table categories (
	categoryId int NOT NULL unique,
    categoryName varchar(50) NOT Null,
    categoryParent int,
    primary key(categoryId),
    foreign key(categoryParent) references categories(categoryId)
);

create table products_categories (
id int NOT NULL unique,
productUuid varchar(36),
categoryId int,
primary key(id),
foreign key(productUuid) references products(productUuid),
foreign key(categoryId) references categories(categoryId) 
);



create table stock (
id int not null unique,
stockDate date,
stockExperation date,
quantity int,
productUuid varchar(36),
primary key (id),
foreign key (productUuid) references products(productUuid)
);

create table expiredStock (
id int not null unique,
stockExperation date,
quantity int,
productUuid varchar(36),
primary key (id),
foreign key (productUuid) references products(productUuid)
);

create table curencyConvertion(
id int not null unique,
providedCurrency varchar(3),
targetCurrency varchar(3),
convertion double,
primary key(id)
);

commit;
