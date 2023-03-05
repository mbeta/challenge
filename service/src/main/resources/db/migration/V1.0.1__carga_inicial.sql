insert into precio(id_precio, version, marca, fecha_inicio, fecha_fin, precio, producto, prioridad, moneda, fecha_hora_registracion, fecha_hora_modificacion ) VALUES
(1,0, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 35.50, 35455, 0, 'EUR', GETDATE(), null),
(2,0, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 25.45, 35455, 1, 'EUR', GETDATE(), null),
(3,0, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 30.50, 35455, 1, 'EUR', GETDATE(), null),
(4,0, 1, '2020-06-14 16:00:00', '2020-12-31 23:59:59', 38.95, 35455, 1, 'EUR', GETDATE(), null);