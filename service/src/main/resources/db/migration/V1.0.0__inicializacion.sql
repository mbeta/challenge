CREATE TABLE precio
(
    id_precio    BIGINT IDENTITY(1,1) NOT NULL,
    version      BIGINT,
    id_marca        INT,
    fecha_inicio TIMESTAMP,
    fecha_fin    TIMESTAMP,
    precio_final   DECIMAL,
    id_tarifa_precios INT,
    id_producto     INT,
    prioridad    INT,
    moneda       VARCHAR,
    fecha_hora_registracion datetime NULL,
    fecha_hora_modificacion datetime NULL,
    CONSTRAINT pk_producto PRIMARY KEY (id_precio)
);