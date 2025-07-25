-- ================================================
-- SCRIPT: 05_package_comerciantes.sql
-- DESCRIPCIÓN: Paquete para reporte de comerciantes activos
-- AUTOR: Hugo Valderrama
-- FECHA: 2025-07-24
-- ================================================

CREATE OR REPLACE PACKAGE pkg_comerciantes IS

  -- Tipo de cursor referenciado
  TYPE ref_cursor IS REF CURSOR;

  -- Función pública para obtener comerciantes activos
  FUNCTION obtener_comerciantes_activos
    RETURN ref_cursor;

END pkg_comerciantes;
/


CREATE OR REPLACE PACKAGE BODY pkg_comerciantes IS

  FUNCTION obtener_comerciantes_activos
    RETURN ref_cursor
  IS
    resultado ref_cursor;
  BEGIN
    OPEN resultado FOR
      SELECT
        c.nombre_razon_social,
        c.municipio,
        c.telefono,
        c.correo_electronico,
        c.fecha_registro,
        c.estado,
        COUNT(e.id_establecimiento) AS cantidad_establecimientos,
        NVL(SUM(e.ingresos), 0) AS total_ingresos,
        NVL(SUM(e.numero_empleados), 0) AS total_empleados
      FROM
        comerciante c
        LEFT JOIN establecimiento e ON c.id_comerciante = e.id_comerciante
      WHERE
        c.estado = 'Activo'
      GROUP BY
        c.id_comerciante, c.nombre_razon_social, c.municipio, c.telefono,
        c.correo_electronico, c.fecha_registro, c.estado
      ORDER BY
        COUNT(e.id_establecimiento) DESC;

    RETURN resultado;
  END obtener_comerciantes_activos;

END pkg_comerciantes;
/
