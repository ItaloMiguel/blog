CREATE TABLE IF NOT EXISTS tb_role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(16)
);

CREATE TABLE IF NOT EXISTS tb_account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL UNIQUE,
    last_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tb_account_role (
    tb_account_id BIGINT NOT NULL,
    tb_role_name VARCHAR(16) NOT NULL,
    FOREIGN KEY (tb_account_id) REFERENCES tb_account(id),
    FOREIGN KEY (tb_role_name) REFERENCES tb_role(name),
    PRIMARY KEY (tb_account_id, tb_role_name)
);
