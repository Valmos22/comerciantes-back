-- ================================================
-- SCRIPT: 01_create_tables.sql
-- DESCRIPCIÓN: Crea las tablas principales del modelo
-- AUTOR: Hugo Valderrama
-- FECHA: 2025-07-24
-- ================================================

-- Tabla: USUARIO
CREATE TABLE usuario (
  id_usuario NUMBER PRIMARY KEY,
  nombre VARCHAR2(100) NOT NULL,
  correo_electronico VARCHAR2(100) NOT NULL UNIQUE,
  contrasena VARCHAR2(255) NOT NULL,
  rol VARCHAR2(20) NOT NULL CHECK (rol IN ('Administrador', 'Auxiliar'))
);

-- Tabla: COMERCIANTE
CREATE TABLE comerciante (
  id_comerciante NUMBER PRIMARY KEY,
  nombre_razon_social VARCHAR2(150) NOT NULL,
  municipio VARCHAR2(100) NOT NULL,
  telefono VARCHAR2(20),
  correo_electronico VARCHAR2(100),
  fecha_registro DATE NOT NULL,
  estado VARCHAR2(10) NOT NULL CHECK (estado IN ('Activo', 'Inactivo')),
  fecha_actualizacion DATE,
  usuario_actualizacion NUMBER,
  CONSTRAINT fk_usuario_actualizacion_comerciante
    FOREIGN KEY (usuario_actualizacion)
    REFERENCES usuario(id_usuario)
);

-- Tabla: ESTABLECIMIENTO
CREATE TABLE establecimiento (
  id_establecimiento NUMBER PRIMARY KEY,
  nombre VARCHAR2(150) NOT NULL,
  ingresos NUMBER(12, 2) NOT NULL,
  numero_empleados NUMBER NOT NULL,
  id_comerciante NUMBER NOT NULL,
  fecha_actualizacion DATE,
  usuario_actualizacion NUMBER,
  CONSTRAINT fk_comerciante_est
    FOREIGN KEY (id_comerciante)
    REFERENCES comerciante(id_comerciante),
  CONSTRAINT fk_usuario_actualizacion_est
    FOREIGN KEY (usuario_actualizacion)
    REFERENCES usuario(id_usuario)
);

