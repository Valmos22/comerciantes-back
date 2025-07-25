package com.hugovalderrama.comerciantes_backend.repository;

import com.hugovalderrama.comerciantes_backend.dto.ComercianteEstadisticaResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.math.BigDecimal;
import java.util.*;


@Repository
@RequiredArgsConstructor
public class ComercianteEstadisticasRepository {

    private final DataSource dataSource;

    public List<ComercianteEstadisticaResponse> obtenerComerciantesActivos() {
        List<ComercianteEstadisticaResponse> resultado = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement callable = connection.prepareCall("{ ? = call pkg_comerciantes.obtener_comerciantes_activos }")) {

            callable.registerOutParameter(1, Types.REF_CURSOR);
            callable.execute();

            ResultSet rs = (ResultSet) callable.getObject(1);
            while (rs.next()) {
                resultado.add(new ComercianteEstadisticaResponse(
                        rs.getString("nombre_razon_social"),
                        rs.getString("municipio"),
                        rs.getString("telefono"),
                        rs.getString("correo_electronico"),
                        rs.getDate("fecha_registro").toLocalDate(),
                        rs.getString("estado"),
                        rs.getInt("cantidad_establecimientos"),
                        rs.getBigDecimal("total_ingresos"),
                        rs.getInt("total_empleados")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener estadísticas de comerciantes", e);
        }

        return resultado;
    }
}
