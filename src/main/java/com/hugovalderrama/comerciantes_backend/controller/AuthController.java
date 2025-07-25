package com.hugovalderrama.comerciantes_backend.controller;

import com.hugovalderrama.comerciantes_backend.security.AuthenticationRequest;
import com.hugovalderrama.comerciantes_backend.security.AuthenticationResponse;
import com.hugovalderrama.comerciantes_backend.security.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody @Valid AuthenticationRequest request) {
        return authService.authenticate(request);
    }
}
