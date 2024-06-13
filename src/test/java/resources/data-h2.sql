INSERT INTO tb_role (id, name) values (1, 'ROLE_USER');
INSERT INTO tb_role (id, name) values (2, 'ROLE_ADMIN');

INSERT INTO tb_account (id, email, first_name, last_name, password) VALUES (1, 'admin.admin@email.com', 'admin', 'junior', 'password');
INSERT INTO tb_account (id, email, first_name, last_name, password) VALUES (2, 'user.user@email.com', 'user', 'junior', 'password');

INSERT INTO  tb_account_role (tb_account_id, tb_role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO  tb_account_role (tb_account_id, tb_role_name) VALUES (2, 'ROLE_USER');
