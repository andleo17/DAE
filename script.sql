-- Fecha de creación	: 27 Agosto 2019
-- Última modificación	: 27 Agosto 2019
-- Autor		: Baldárrago Gastulo, Andrés Leonardo

CREATE TABLE usuario (
	id		INT			PRIMARY KEY,
	usuario		VARCHAR(20)		NOT NULL UNIQUE,
	clave		VARCHAR(20)		NOT NULL,
	nombre		VARCHAR(60)		NOT NULL,
	cargo		VARCHAR(30)		NULL,
	estado		BOOLEAN			NOT NULL
);

SELECT * FROM usuario;

INSERT INTO usuario VALUES	(1, 'admin', '123456', 'Juan Perez Perez', 'Gerente General', TRUE),
				(2, 'invitado', 'USAT2019', 'María Mendoza', 'Supervisor', FALSE),
				(3, 'venta', 'chiclayo', 'Pedro Casas Merino', 'Jefe de ventas', TRUE);

CREATE TABLE marca(
	id		INT			PRIMARY KEY,
	nombre		VARCHAR(30)		NOT NULL
);

CREATE TABLE categoria(
	id		INT			PRIMARY KEY,
	nombre		VARCHAR(30)		NOT NULL,
	descripcion	VARCHAR(100)		NULL,
	vigencia	BOOLEAN			NOT NULL
);

CREATE TABLE producto(
	id		INT			PRIMARY KEY,
	nombre		VARCHAR(30)		NOT NULL,
	descripcion	VARCHAR(100)		NOT NULL,
	precio		DECIMAL(8, 2)		NOT NULL,
	stock		INT			NOT NULL,
	vigencia	BOOLEAN			NOT NULL,
	marca_id	INT			NOT NULL REFERENCES marca,
	categoria_id	INT			NOT NULL REFERENCES categoria
);

INSERT INTO marca VALUES (1, 'EPSON');

INSERT INTO categoria VALUES (1, 'Impresora', NULL, TRUE);

INSERT INTO producto VALUES (1, 'EPSON LX890', 'Esta impresora imprime bien chévere sus impresos', 345.89, 15, TRUE, 1, 1);

SELECT * FROM marca;

SELECT * FROM categoria;

SELECT * FROM producto;

SELECT producto.nombre, producto.descripcion, producto.precio, producto.stock, marca.nombre, categoria.nombre FROM
	producto INNER JOIN
	marca ON producto.marca_id = marca.id INNER JOIN
	categoria ON producto.categoria_id = categoria.id;

UPDATE producto SET precio = 950 WHERE id = 1;

DELETE FROM producto WHERE id = 1;