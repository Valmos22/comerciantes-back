-- ================================================
-- SCRIPT: 02_create_sequences.sql
-- DESCRIPCIÓN: Crea las secuencias necesarias para cada tabla
-- AUTOR: Hugo Valderrama
-- FECHA: 2025-07-24
-- ================================================

-- Secuencia para la tabla USUARIO
CREATE SEQUENCE seq_usuario
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

-- Secuencia para la tabla COMERCIANTE
CREATE SEQUENCE seq_comerciante
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

-- Secuencia para la tabla ESTABLECIMIENTO
CREATE SEQUENCE seq_establecimiento
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;


