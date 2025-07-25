package com.hugovalderrama.comerciantes_backend.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequest(
    @Email String correoElectronico,
    @NotBlank String contrasena
){}
