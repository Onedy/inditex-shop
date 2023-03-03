CREATE TABLE IF NOT EXISTS product (
    id BIGINT PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS brand (
    id BIGINT PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS price (
   id BIGINT PRIMARY KEY,
   product_id BIGINT NOT NULL,
   brand_id BIGINT NOT NULL,
   start_date TIMESTAMP WITH TIME ZONE NOT NULL,
   end_date TIMESTAMP WITH TIME ZONE NOT NULL,
   priority INTEGER NOT NULL,
   price NUMERIC(19, 2) NOT NULL,
   currency VARCHAR NOT NULL,
   FOREIGN KEY (product_id) REFERENCES product(id),
   FOREIGN KEY (brand_id) REFERENCES brand(id)
);

INSERT INTO product VALUES (35455, 'Zapatos');
INSERT INTO brand VALUES (1, 'ZARA');
INSERT INTO price VALUES
 (1, 35455, 1, '2020-06-14 00:00:00+01', '2020-12-31 23:59:59+01', 0, 35.50, 'EUR'),
 (2, 35455, 1, '2020-06-14 15:00:00+01', '2020-06-14 18:30:00+01', 1, 25.45, 'EUR'),
 (3, 35455, 1, '2020-06-15 00:00:00+01', '2020-06-15 11:00:00+01', 1, 30.50, 'EUR'),
 (4, 35455, 1, '2020-06-15 16:00:00+01', '2020-12-31 23:59:59+01', 1, 38.95, 'EUR');
