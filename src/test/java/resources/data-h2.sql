-- Inserir roles
INSERT INTO tb_role (name) VALUES ('ROLE_USER');
INSERT INTO tb_role (name) VALUES ('ROLE_ADMIN');

-- Inserir accounts
INSERT INTO tb_account (email, password, first_name, last_name) VALUES ('user1@example.com', 'password1', 'User1', 'LastName1');
INSERT INTO tb_account (email, password, first_name, last_name) VALUES ('admin@example.com', 'password2', 'Admin', 'LastName2');

-- Associar roles aos accounts
INSERT INTO tb_account_role (tb_account_id, tb_role_name) VALUES (1, 'ROLE_USER');
INSERT INTO tb_account_role (tb_account_id, tb_role_name) VALUES (2, 'ROLE_ADMIN');
