drop schema prod_price CASCADE;

CREATE SCHEMA prod_price;

CREATE TABLE prod_price.product
(
    id INT GENERATED ALWAYS AS IDENTITY,
    prod_name VARCHAR(100) NOT NULL,
    prod_desc VARCHAR(100),
    scu INT UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE prod_price.price
(
    id INT GENERATED ALWAYS AS IDENTITY,
    product_id INT NOT NULL REFERENCES prod_price.product(id),
    date_from DATE NOT NULL CHECK (date_from <= date_to),
    date_to DATE NOT NULL CHECK (date_to >= date_from),
    price NUMERIC(10, 2) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO prod_price.product(prod_name, prod_desc, scu) VALUES ('pastet', 'opisanie',12134);
INSERT INTO prod_price.product(prod_name, prod_desc, scu) VALUES ('kompot', '',2543463);
INSERT INTO prod_price.product(prod_name, prod_desc, scu) VALUES ('sirene', 'bla bla',876543);
INSERT INTO prod_price.product(prod_name, prod_desc, scu) VALUES ('tarator', '',234234 );
INSERT INTO prod_price.product(prod_name, prod_desc, scu) VALUES ('bira', 'shumensko', 54523423);

INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (1, '2020-05-30', '2020-06-30', 12.54);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (1, '2020-05-01', '2020-05-30', 25.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (1, '2020-04-01', '2020-04-30', 39.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (1, '2020-03-01', '2020-06-30', 5.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (1, '2020-02-01', '2020-06-30', 31.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (1, '2020-01-01', '2020-06-30', 12.99);

INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (2, '2007-01-05', '2018-01-01', 100.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (2, '2018-01-02', '2018-06-01', 75.74);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (2, '2018-06-02', '2019-06-02', 50.00);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (2, '2019-06-03', '2020-06-30', 25.00);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (2, '2020-06-30', '2020-12-30', 1.00);

INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (3, '2005-01-01', '2006-12-30', 424.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (3, '2006-01-01', '2007-12-30', 234.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (3, '2007-01-01', '2008-12-30', 541.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (3, '2008-01-01', '2009-12-30', 765.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (3, '2009-01-01', '2020-12-30', 746.99);

INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (4, '2012-06-15', '2013-06-15', 3.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (4, '2013-06-15', '2014-04-08', 15.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (4, '2014-04-08', '2017-08-17', 54.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (4, '2017-08-17', '2019-08-17', 100.99);
INSERT INTO prod_price.price(product_id, date_from, date_to, price) VALUES (4, '2019-08-17', '2030-12-30', 1.99);
