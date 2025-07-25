package com.hugovalderrama.comerciantes_backend.security;

import com.hugovalderrama.comerciantes_backend.entity.Usuario;
import com.hugovalderrama.comerciantes_backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreoElectronico(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));

        return User
                .withUsername(usuario.getCorreoElectronico())
                .password(usuario.getContrasena())
                .authorities(usuario.getRol().equals(Usuario.Rol.Administrador)
                        ? List.of(() -> "ROLE_ADMINISTRADOR")
                        : List.of(() -> "ROLE_AUXILIAR"))
                .build();
    }

}
