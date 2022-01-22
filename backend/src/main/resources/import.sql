INSERT INTO tb_user (name, email, password) VALUES ('Andre Almeida', 'andre@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Thaina Ramos', 'thaina@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_USER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_supermarket (name, img) VALUES ('Serra Azul', 'https://bit.ly/3Kx0IjE')

INSERT INTO tb_market (title, body, date, total, user_id, supermarket_id) VALUES ('Compra de mês', 'realizar toda a compra do mês', TIMESTAMP WITH TIME ZONE '2020-11-20T03:00:00Z', 250.0, 1, 1);

INSERT INTO tb_product (name, amount, price, market_id) VALUES ('Banana', 2, 1.50, 1);
INSERT INTO tb_product (name, amount, price, market_id) VALUES ('Pizza Regina Calabresa', 400, 7.99, 1);
INSERT INTO tb_product (name, amount, price, market_id) VALUES ('Leite Longa Vida', 3, 3.49, 1);
INSERT INTO tb_product (name, amount, price, market_id) VALUES ('Ana Maria Tradicional', 1, 2.69, 1);
