package com.hugovalderrama.comerciantes_backend.security;

import com.hugovalderrama.comerciantes_backend.entity.Usuario;
import com.hugovalderrama.comerciantes_backend.repository.UsuarioRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUsername(jwt);

        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Usuario usuario = usuarioRepository.findByCorreoElectronico(userEmail).orElse(null);

            if (usuario != null && jwtService.isTokenValid(jwt, usuario)) {
                var authToken = new UsernamePasswordAuthenticationToken(
                        usuario, null, usuario.getRol().equals(Usuario.Rol.Administrador)
                        ? List.of(() -> "ROLE_ADMINISTRADOR")
                        : List.of(() -> "ROLE_AUXILIAR")
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
