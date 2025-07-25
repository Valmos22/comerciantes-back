package com.hugovalderrama.comerciantes_backend.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public record ComercianteEstadisticaResponse(
        String nombreRazonSocial,
        String municipio,
        String telefono,
        String correoElectronico,
        LocalDate fechaRegistro,
        String estado,
        int cantidadEstablecimientos,
        BigDecimal totalIngresos,
        int totalEmpleados
) { }
