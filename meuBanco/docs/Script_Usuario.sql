use teste;

CREATE TABLE teste.usuario (
	id BIGINT auto_increment NOT NULL,
	nome varchar(100) NULL,
	email varchar(100) NULL,
	celular varchar(100) NULL,
	PRIMARY KEY(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO usuario(nome,email,celular)VALUES('rubens leme', 'rubens@gmail', '11 966467667');
INSERT INTO usuario(nome,email,celular)VALUES('rubens leme2', 'rubens2@gmail', '11 966467667');

SELECT * FROM usuario;
--------------------------------------------------------------------------X------------------------------
CREATE TABLE teste.cliente (
	id BIGINT auto_increment NOT NULL,
	nome varchar(100) NULL,
	email varchar(100) NULL,
	celular varchar(100) NULL,
	cpf varchar(100) NULL,
	PRIMARY KEY(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO cliente(nome,email,celular,cpf)VALUES('rubens leme', 'rubens@gmail', '11 966467667','111111111');
INSERT INTO cliente(nome,email,celular,cpf)VALUES('rubens leme2', 'rubens2@gmail', '11 966467667', '222222222');

SELECT * FROM cliente;
--------------------------------------------------------------------------X------------------------------
CREATE TABLE teste.produto (
	id BIGINT auto_increment NOT NULL,
	descricao varchar(100) NULL,
	marca varchar(100) NULL,
	modelo varchar(100) NULL,
	fabricante varchar(100) NULL,
	PRIMARY KEY(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO produto(descricao,marca,modelo,fabricante)VALUES('acucar', 'da barra', 'pacote','da barra fabrica');
INSERT INTO produto(descricao,marca,modelo,fabricante)VALUES('acucar1', 'da barra', 'pacote','da barra fabrica');
INSERT INTO produto(descricao,marca,modelo,fabricante)VALUES('acucar2', 'da barra', 'pacote','da barra fabrica');
INSERT INTO produto(descricao,marca,modelo,fabricante)VALUES('acucar3', 'da barra', 'pacote','da barra fabrica');


SELECT * FROM produto;






