package com.hugovalderrama.comerciantes_backend.security;

import com.hugovalderrama.comerciantes_backend.entity.Usuario;
import com.hugovalderrama.comerciantes_backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // 1. Buscar el usuario por correo
        Usuario usuario = usuarioRepository.findByCorreoElectronico(request.correoElectronico())
                .orElseThrow(() -> new BadCredentialsException("Usuario no encontrado"));

        // 2. Verificar la contraseña manualmente
        if (!passwordEncoder.matches(request.contrasena(), usuario.getContrasena())) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        // 3. Generar el token
        String jwtToken = jwtService.generateToken(usuario);
        return new AuthenticationResponse(jwtToken);
    }
}
