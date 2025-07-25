package com.hugovalderrama.comerciantes_backend.dto;


import java.time.LocalDate;

public record ComercianteResponse(
        Long id,
        String nombreRazonSocial,
        String municipio,
        String telefono,
        String correoElectronico,
        LocalDate fechaRegistro,
        String estado,
        LocalDate fechaActualizacion,
        Long usuarioActualizacionId
) { }
