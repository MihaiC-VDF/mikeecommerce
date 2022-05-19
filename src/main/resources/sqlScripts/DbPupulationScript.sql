BEGIN;

USE ecommercedbmike;

insert into 
products(productId, productUuid, productName, productDescription, productImage, productPrice)
values
(1, "62155c27-ac8e-44df-a6ae-b82e63b9e642", "Magic Stick", "It is long, sparkly and magic", "picture1.jpeg", 9.99, "USD"),
(2, "62ecbed8-26f5-4b9f-8374-8143bb34e814", "Nano Tech Laptop", "All the GHZ", "picture2.jpeg", 500, "USD"),
(3, "e61fcb5f-ed13-4b2a-808c-636862f4b69c", "Fancy phone", "Iphone Killer", "picture3.jpeg", 1250.12, "USD");

insert into
categories(categoryId, categoryName, categoryParent)
values
(1, "Magic Weapon", null),
(2, "Technologie", null),
(3, "MagicCaller", 1);

insert into
products_categories(id, productUuid, categoryId)
values
(1, "62155c27-ac8e-44df-a6ae-b82e63b9e642", 1),
(2, "62ecbed8-26f5-4b9f-8374-8143bb34e814", 2),
(3, "e61fcb5f-ed13-4b2a-808c-636862f4b69c", 3);

insert into
stock(id, stockDate, stockExperation, quantity, productUuid)
values
(1, '2022-04-12', '2023-01-01', 100, "62155c27-ac8e-44df-a6ae-b82e63b9e642"),
(2, '2021-12-13', '2022-05-20', 13, "62155c27-ac8e-44df-a6ae-b82e63b9e642"),
(3, '2022-01-15', '2022-10-10', 22, "62ecbed8-26f5-4b9f-8374-8143bb34e814"),
(4, '2020-06-06', '2025-10-25', 5, "e61fcb5f-ed13-4b2a-808c-636862f4b69c"),
(5, '2022-05-05', '2027-05-23', 35, "e61fcb5f-ed13-4b2a-808c-636862f4b69c");


insert into
curencyConvertion(id, providedCurrency, targetCurrency, convertion)
values
(1, "USD", "EUR", 0.92),
(2, "USD", "RON", 4.1),
(3, "EUR", "RON", 4.95),
(4, "EUR", "USD", 1.13),
(5, "RON", "USD", 0.26),
(6, "RON", "EUR", 0.19);

commit;