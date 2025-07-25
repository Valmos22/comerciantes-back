-- ================================================
-- SCRIPT: 04_insert_seed_data.sql
-- DESCRIPCIÓN: Inserta datos semilla para la prueba técnica
-- AUTOR: Hugo Valderrama
-- FECHA: 2025-07-24
-- ================================================

-- ==========================================
-- USUARIOS
-- ==========================================
INSERT INTO usuario (nombre, correo_electronico, contrasena, rol)
VALUES ('Administrador General', 'admin@gmail.com', 'admin123', 'Administrador');

INSERT INTO usuario (nombre, correo_electronico, contrasena, rol)
VALUES ('Auxiliar de Registro', 'auxiliar@gmail.com', 'aux123', 'Auxiliar');

-- ==========================================
-- COMERCIANTES
-- ==========================================
-- Para este ejemplo usaremos id_usuario = 1 como quien hace la inserción

INSERT INTO comerciante (nombre_razon_social, municipio, telefono, correo_electronico, fecha_registro, estado, usuario_actualizacion)
VALUES ('Comercial Andina S.A.S', 'Bogotá', '3001234567', 'andina@comercial.com', SYSDATE, 'Activo', 1);

INSERT INTO comerciante (nombre_razon_social, municipio, telefono, correo_electronico, fecha_registro, estado, usuario_actualizacion)
VALUES ('Distribuciones Alfa', 'Medellín', NULL, 'alfa@correo.com', SYSDATE, 'Activo', 1);

INSERT INTO comerciante (nombre_razon_social, municipio, telefono, correo_electronico, fecha_registro, estado, usuario_actualizacion)
VALUES ('Mercantil Beta Ltda.', 'Cali', '3106547890', NULL, SYSDATE, 'Activo', 1);

INSERT INTO comerciante (nombre_razon_social, municipio, telefono, correo_electronico, fecha_registro, estado, usuario_actualizacion)
VALUES ('Logística Gamma', 'Barranquilla', '3201234567', 'gamma@log.com', SYSDATE, 'Inactivo', 1);

INSERT INTO comerciante (nombre_razon_social, municipio, telefono, correo_electronico, fecha_registro, estado, usuario_actualizacion)
VALUES ('Importadora Zeta', 'Cartagena', NULL, NULL, SYSDATE, 'Activo', 1);

-- ==========================================
-- ESTABLECIMIENTOS (asignación aleatoria de comerciantes 1 a 5)
-- ==========================================
INSERT INTO establecimiento (nombre, ingresos, numero_empleados, id_comerciante, usuario_actualizacion)
VALUES ('Tienda Andina Centro', 1250000.00, 8, 1, 1);

INSERT INTO establecimiento (nombre, ingresos, numero_empleados, id_comerciante, usuario_actualizacion)
VALUES ('Sucursal Norte Alfa', 890000.00, 4, 2, 1);

INSERT INTO establecimiento (nombre, ingresos, numero_empleados, id_comerciante, usuario_actualizacion)
VALUES ('Almacen Beta Sur', 540000.00, 3, 3, 1);

INSERT INTO establecimiento (nombre, ingresos, numero_empleados, id_comerciante, usuario_actualizacion)
VALUES ('Tienda Gamma Express', 620000.00, 2, 4, 1);

INSERT INTO establecimiento (nombre, ingresos, numero_empleados, id_comerciante, usuario_actualizacion)
VALUES ('Zeta Principal', 1320000.00, 5, 5, 1);

INSERT INTO establecimiento (nombre, ingresos, numero_empleados, id_comerciante, usuario_actualizacion)
VALUES ('Zeta Sucursal 1', 760000.00, 3, 5, 1);

INSERT INTO establecimiento (nombre, ingresos, numero_empleados, id_comerciante, usuario_actualizacion)
VALUES ('Andina Calle 80', 970000.00, 6, 1, 1);

INSERT INTO establecimiento (nombre, ingresos, numero_empleados, id_comerciante, usuario_actualizacion)
VALUES ('Beta MiniMarket', 410000.00, 2, 3, 1);

INSERT INTO establecimiento (nombre, ingresos, numero_empleados, id_comerciante, usuario_actualizacion)
VALUES ('Sucursal Alfa Sur', 580000.00, 4, 2, 1);

INSERT INTO establecimiento (nombre, ingresos, numero_empleados, id_comerciante, usuario_actualizacion)
VALUES ('Tienda Zeta Bocagrande', 1150000.00, 7, 5, 1);
