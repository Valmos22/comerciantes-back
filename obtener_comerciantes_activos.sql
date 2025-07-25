DECLARE
  rc pkg_comerciantes.ref_cursor;
  v_nombre comerciante.nombre_razon_social%TYPE;
  v_municipio comerciante.municipio%TYPE;
  v_tel comerciante.telefono%TYPE;
  v_correo comerciante.correo_electronico%TYPE;
  v_fecha comerciante.fecha_registro%TYPE;
  v_estado comerciante.estado%TYPE;
  v_establecimientos NUMBER;
  v_total_ingresos NUMBER;
  v_total_empleados NUMBER;
BEGIN
  rc := pkg_comerciantes.obtener_comerciantes_activos;

  LOOP
    FETCH rc INTO v_nombre, v_municipio, v_tel, v_correo, v_fecha, v_estado,
                 v_establecimientos, v_total_ingresos, v_total_empleados;
    EXIT WHEN rc%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE(
      v_nombre || ' | ' || v_municipio || ' | Establecimientos: ' || v_establecimientos
    );
  END LOOP;

  CLOSE rc;
END;
/
