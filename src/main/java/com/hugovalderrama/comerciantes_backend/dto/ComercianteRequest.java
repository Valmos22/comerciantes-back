package com.hugovalderrama.comerciantes_backend.dto;

import jakarta.validation.constraints.*;

public record ComercianteRequest(
        @NotBlank String nombreRazonSocial,
        @NotBlank String municipio,
        String telefono,
        @Email String correoElectronico,
        @NotBlank String estado
) { }
