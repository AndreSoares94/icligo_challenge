INSERT INTO detail values (1, 'leite agros', 6, 8.5);
INSERT INTO detail values (2, 'queijo', 1, 5);
INSERT INTO detail values (3, 'iogurte', 12, 4.78);
INSERT INTO detail values (4, 'sofa', 1, 75.50);
INSERT INTO detail values (5, 'bed', 12, 400);

INSERT INTO product_type values (1, 'dairies');
INSERT INTO product_type values (2, 'furniture');

INSERT INTO purchase values (1, '2022-12-31', 1, 1);
INSERT INTO purchase values (2, '2022-12-31', 2, 1);
INSERT INTO purchase values (3, '2022-10-05', 3, 1);
INSERT INTO purchase values (4, '2023-01-31', 4, 2);
INSERT INTO purchase values (5, '2022-12-31', 5, 2);

select * from detail;
select * from product_type;

select * from purchase;

SELECT * FROM purchase WHERE expires >= now();

SELECT * FROM purchase WHERE product_type_fk = 1;

SELECT * FROM purchase JOIN product_type WHERE product_type_fk = id_product_type;