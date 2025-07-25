-- ================================================
-- SCRIPT: 03_create_triggers.sql
-- DESCRIPCIÓN: Triggers para manejar IDs y auditoría
-- AUTOR: Hugo Valderrama
-- FECHA: 2025-07-24
-- ================================================

-- ============================================
-- TRIGGERS PARA USUARIO
-- ============================================

CREATE OR REPLACE TRIGGER trg_usuario_bi
BEFORE INSERT ON usuario
FOR EACH ROW
BEGIN
  :NEW.id_usuario := seq_usuario.NEXTVAL;
END;
/

-- ============================================
-- TRIGGERS PARA COMERCIANTE
-- ============================================

-- BEFORE INSERT: Asigna ID y fecha_actualizacion
CREATE OR REPLACE TRIGGER trg_comerciante_bi
BEFORE INSERT ON comerciante
FOR EACH ROW
BEGIN
  :NEW.id_comerciante := seq_comerciante.NEXTVAL;
  :NEW.fecha_actualizacion := SYSDATE;
END;
/

-- BEFORE UPDATE: Actualiza fecha y usuario
CREATE OR REPLACE TRIGGER trg_comerciante_bu
BEFORE UPDATE ON comerciante
FOR EACH ROW
BEGIN
  :NEW.fecha_actualizacion := SYSDATE;
  -- :NEW.usuario_actualizacion debe ser seteado desde la aplicación
END;
/

-- ============================================
-- TRIGGERS PARA ESTABLECIMIENTO
-- ============================================

-- BEFORE INSERT
CREATE OR REPLACE TRIGGER trg_establecimiento_bi
BEFORE INSERT ON establecimiento
FOR EACH ROW
BEGIN
  :NEW.id_establecimiento := seq_establecimiento.NEXTVAL;
  :NEW.fecha_actualizacion := SYSDATE;
END;
/

-- BEFORE UPDATE
CREATE OR REPLACE TRIGGER trg_establecimiento_bu
BEFORE UPDATE ON establecimiento
FOR EACH ROW
BEGIN
  :NEW.fecha_actualizacion := SYSDATE;
  -- :NEW.usuario_actualizacion debe ser seteado desde la aplicación
END;
/
