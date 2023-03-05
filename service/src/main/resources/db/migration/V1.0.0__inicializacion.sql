CREATE TABLE precio
(
    id_precio    BIGINT IDENTITY(1,1) NOT NULL,
    version      BIGINT,
    marca        INT,
    fecha_inicio TIMESTAMP,
    fecha_fin    TIMESTAMP,
    precio       DECIMAL,
    producto     INT,
    prioridad    INT,
    moneda       VARCHAR,
    fecha_hora_registracion datetime NULL,
    fecha_hora_modificacion datetime NULL,
    CONSTRAINT pk_producto PRIMARY KEY (id_precio)
);