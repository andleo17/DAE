-- Fecha de creación	: 27 Agosto 2019
-- Última modificación	: 28 Agosto 2019
-- Autor		: Baldárrago Gastulo, Andrés Leonardo

CREATE TABLE usuario (
	id		INT			PRIMARY KEY,
	usuario		VARCHAR(20)		NOT NULL UNIQUE,
	clave		VARCHAR(20)		NOT NULL,
	nombre		VARCHAR(60)		NOT NULL,
	cargo		VARCHAR(30)		NULL,
	estado		BOOLEAN			NOT NULL
);

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

ALTER TABLE usuario ADD pregunta VARCHAR(50);
ALTER TABLE usuario ADD respuesta VARCHAR(50);

UPDATE usuario SET pregunta = 'Ciudad de nacimiento', respuesta = 'Lima' WHERE id = 1;
UPDATE usuario SET pregunta = 'Primer número de celular', respuesta = '976584237' WHERE id = 2;
UPDATE usuario SET pregunta = 'Nombre de tu mascota', respuesta = 'Otto' WHERE id = 3;

-- Validar vigencia de usuario
SELECT estado FROM usuario WHERE usuario.usuario = 'admin' AND usuario.clave = '1234656';

-- Inicio de sesión
SELECT nombre FROM usuario WHERE usuario.usuario = 'admin' AND clave = '123456' AND estado = TRUE;

-- Cambio de contraseña
UPDATE usuario SET clave = 'nuevaclave' WHERE nombre = 'nombre';

-- Mostrar pregunta secreta
SELECT pregunta FROM usuario WHERE usuario.usuario = 'admin';

-- Validar respuesta secreta
SELECT * FROM usuario WHERE usuario.usuario = 'admin' AND usuario.respuesta = 'respuesta' AND usuario.estado = TRUE;
