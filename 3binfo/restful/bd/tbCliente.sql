
/* Drop Tables */

DROP TABLE IF EXISTS "tbCliente";




/* Create Tables */

CREATE TABLE "tbCliente"
(
	id bigserial NOT NULL,
	nome varchar(35),
	email varchar(35),
	senha varchar(6),
	PRIMARY KEY (id)
) WITHOUT OIDS;



