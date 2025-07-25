package com.hugovalderrama.comerciantes_backend.service;

import com.hugovalderrama.comerciantes_backend.dto.ComercianteEstadisticaResponse;
import com.hugovalderrama.comerciantes_backend.repository.ComercianteEstadisticasRepository;
import com.hugovalderrama.comerciantes_backend.dto.ComercianteEstadisticaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ComercianteEstadisticasService {

    private final ComercianteEstadisticasRepository repository;

    public List<ComercianteEstadisticaResponse> obtenerEstadisticas() {
        return repository.obtenerComerciantesActivos();
    }

    public ByteArrayInputStream generarCsvComerciantesActivos() {
        List<ComercianteEstadisticaResponse> comerciantes = repository.obtenerComerciantesActivos();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));

        writer.println("Nombre o razón social|Municipio|Teléfono|Correo Electrónico|Fecha Registro|Estado|Cantidad Establecimientos|Total Ingresos|Cantidad Empleados");

        for (ComercianteEstadisticaResponse c : comerciantes) {
            writer.printf(
                    Locale.US,
                    "%s|%s|%s|%s|%s|%s|%d|%.2f|%d%n",
                    c.nombreRazonSocial(),
                    c.municipio(),
                    c.telefono(),
                    c.correoElectronico(),
                    c.fechaRegistro(),
                    c.estado(),
                    c.cantidadEstablecimientos(),
                    c.totalIngresos(),
                    c.totalEmpleados()
            );
        }

        writer.flush();
        return new ByteArrayInputStream(out.toByteArray());
    }

}
