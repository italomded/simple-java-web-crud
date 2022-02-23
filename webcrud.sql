CREATE DATABASE webcrud;

USE webcrud;

CREATE TABLE product (
	id INT AUTO_INCREMENT,
    name VARCHAR(50),
    quantity INT,
    PRIMARY KEY (id)
); 

CREATE TABLE user (
	login VARCHAR(20),
    password VARCHAR(20),
	PRIMARY KEY (login)
);

INSERT INTO product (name, quantity) VALUES ('Smartphone', 35);
INSERT INTO user (login, password) VALUES ('root', 'root');