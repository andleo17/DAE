CREATE TABLE usuario (
    id                  INT                 PRIMARY KEY,
    usuario             VARCHAR(20)         NOT NULL UNIQUE,
    clave               VARCHAR(20)         NOT NULL,
    nombre              VARCHAR(60)         NOT NULL,
    cargo               VARCHAR(30)         NULL,
    estado              BOOLEAN             NOT NULL,
    pregunta            VARCHAR(50)         NOT NULL,
    respuesta           VARCHAR(50)         NOT NULL
);

CREATE TABLE marca (
    id                  INT                 PRIMARY KEY,
    nombre              VARCHAR(30)         NOT NULL,
    vigencia            BOOLEAN             NOT NULL
);

CREATE TABLE categoria (
    id                  INT                 PRIMARY KEY,
    nombre              VARCHAR(30)         NOT NULL,
    descripcion         VARCHAR(100)        NULL,
    vigencia            BOOLEAN             NOT NULL
);

CREATE TABLE producto (
    id                  INT                 PRIMARY KEY,
    nombre              VARCHAR(30)         NOT NULL,
    descripcion         VARCHAR(100)        NOT NULL,
    precio              DECIMAL(8, 2)       NOT NULL,
    stock               INT                 NOT NULL,
    vigencia            BOOLEAN             NOT NULL,
    marca_id            INT                 NOT NULL REFERENCES marca,
    categoria_id        INT                 NOT NULL REFERENCES categoria
);

CREATE TABLE movimiento (
    id                  SERIAL              PRIMARY KEY,
    id_usuario          INT                 NOT NULL REFERENCES usuario,
    fecha               DATE                NOT NULL DEFAULT CURRENT_DATE,
    hora                TIME                NOT NULL DEFAULT CURRENT_TIME,
    estado              BOOLEAN             NOT NULL
);

CREATE TABLE tipo_cliente (
    id                  INT                 PRIMARY KEY,
    nombre              VARCHAR(30)         NOT NULL
);

INSERT INTO tipo_cliente VALUES (1, 'Persona Jurídica'),
                                (2, 'Persona Natural'),
                                (3, 'Persona Natural con RUC');

CREATE TABLE cliente (
    id                  INT                 PRIMARY KEY,
    dni                 CHAR(8)             NULL,
    ruc                 CHAR(11)            NULL,
    nombres             VARCHAR(60)         NOT NULL,
    telefono            VARCHAR(13)         NULL,
    correo              VARCHAR(50)         NULL,
    direccion           VARCHAR(70)         NOT NULL,
    vigencia            BOOLEAN             NOT NULL,
    tipo_cliente_id     INT                 NOT NULL REFERENCES tipo_cliente
);

CREATE TABLE venta (
    id                  INT                 PRIMARY KEY,
    fecha               DATE                NOT NULL,
    subtotal            DECIMAL(10,2)       NULL,
    igv                 DECIMAL(10,2)       NULL,
    total               DECIMAL(10, 2)      NOT NULL,
    tipo_comprobante    BOOLEAN             NOT NULL,
    estado_pago         BOOLEAN             NOT NULL,
    cliente_id          INT                 NOT NULL REFERENCES cliente
);

CREATE TABLE detalle_venta (
    venta_id            INT                 NOT NULL REFERENCES venta,
    producto_id         INT                 NOT NULL REFERENCES producto,
    cantidad            INT                 NOT NULL,
    precio              DECIMAL(8, 2)       NOT NULL,
    descuento           SMALLINT            NOT NULL,
    subtotal            DECIMAL(10, 2)      NOT NULL,

    CONSTRAINT pk_detalle_venta
        PRIMARY KEY (venta_id, producto_id)
);

INSERT INTO usuario VALUES  (1, 'admin', '123456', 'Juan Perez Perez', 'Gerente General', TRUE, 'Ciudad de nacimiento', 'Lima'),
                            (2, 'invitado', 'USAT2019', 'María Mendoza', 'Supervisor', FALSE, 'Primer número de celular', '976584237'),
                            (3, 'venta', 'chiclayo', 'Pedro Casas Merino', 'Jefe de ventas', TRUE, 'Nombre de tu mascota', 'Otto');

INSERT INTO marca VALUES (1, 'EPSON', TRUE);

INSERT INTO categoria VALUES (1, 'Impresora', NULL, TRUE);

INSERT INTO producto VALUES (1, 'EPSON LX890', 'Esta impresora imprime bien chévere sus impresos', 345.89, 15, TRUE, 1, 1);

-- Validar vigencia de usuario
-- SELECT estado FROM usuario WHERE usuario.usuario = 'admin' AND usuario.clave = '1234656';

-- Inicio de sesión
-- SELECT nombre FROM usuario WHERE usuario.usuario = 'admin' AND clave = '123456' AND estado = TRUE;

-- Cambio de contraseña
-- UPDATE usuario SET clave = 'nuevaclave' WHERE nombre = 'nombre';

-- Mostrar pregunta secreta
-- pregunta FROM usuario WHERE usuario.usuario = 'admin';

-- Validar respuesta secreta
-- SELECT * FROM usuario WHERE usuario.usuario = 'admin' AND usuario.respuesta = 'respuesta' AND usuario.estado = TRUE;

CREATE OR REPLACE FUNCTION fn_tg_cambiarEstadoMovimiento () RETURNS TRIGGER AS
$$
DECLARE
    movimientoAnterior int;
    c CURSOR FOR
        SELECT id FROM movimiento WHERE id_usuario = NEW.id_usuario ORDER BY 1 DESC LIMIT 2;
BEGIN
    OPEN c;
    FETCH c INTO movimientoAnterior;
    WHILE FOUND LOOP
        IF movimientoAnterior <> NEW.id THEN
            UPDATE movimiento SET estado = FALSE WHERE id = movimientoAnterior;
        END IF;
        FETCH c INTO movimientoAnterior;
    END LOOP;
    CLOSE c;
    RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER tg_cambiarEstadoMovimiento AFTER INSERT ON movimiento FOR EACH ROW EXECUTE PROCEDURE fn_tg_cambiarEstadoMovimiento();