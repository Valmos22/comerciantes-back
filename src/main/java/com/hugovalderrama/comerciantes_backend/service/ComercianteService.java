package com.hugovalderrama.comerciantes_backend.service;

import com.hugovalderrama.comerciantes_backend.dto.*;
import com.hugovalderrama.comerciantes_backend.entity.*;
import com.hugovalderrama.comerciantes_backend.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComercianteService {

    private final ComercianteRepository comercianteRepository;

    public List<ComercianteResponse> listarTodos() {
        return comercianteRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ComercianteResponse buscarPorId(Long id) {
        Comerciante comerciante = comercianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comerciante no encontrado"));
        return mapToResponse(comerciante);
    }

    @Transactional
    public ComercianteResponse crear(ComercianteRequest request) {
        Usuario usuarioActual = obtenerUsuarioAutenticado();

        Comerciante comerciante = Comerciante.builder()
                .nombreRazonSocial(request.nombreRazonSocial())
                .municipio(request.municipio())
                .telefono(request.telefono())
                .correoElectronico(request.correoElectronico())
                .estado(request.estado())
                .fechaRegistro(LocalDate.now())
                .usuarioActualizacion(usuarioActual)
                .build();

        comercianteRepository.save(comerciante);
        return mapToResponse(comerciante);
    }

    @Transactional
    public ComercianteResponse actualizar(Long id, ComercianteRequest request) {
        Comerciante comerciante = comercianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comerciante no encontrado"));

        comerciante.setNombreRazonSocial(request.nombreRazonSocial());
        comerciante.setMunicipio(request.municipio());
        comerciante.setTelefono(request.telefono());
        comerciante.setCorreoElectronico(request.correoElectronico());
        comerciante.setEstado(request.estado());
        comerciante.setUsuarioActualizacion(obtenerUsuarioAutenticado());

        comercianteRepository.save(comerciante);
        return mapToResponse(comerciante);
    }

    public void eliminar(Long id) {
        if (!comercianteRepository.existsById(id)) {
            throw new RuntimeException("Comerciante no encontrado");
        }
        comercianteRepository.deleteById(id);
    }

    // Helpers
    private ComercianteResponse mapToResponse(Comerciante c) {
        return new ComercianteResponse(
                c.getId(),
                c.getNombreRazonSocial(),
                c.getMunicipio(),
                c.getTelefono(),
                c.getCorreoElectronico(),
                c.getFechaRegistro(),
                c.getEstado(),
                c.getFechaActualizacion(),
                c.getUsuarioActualizacion() != null ? c.getUsuarioActualizacion().getId() : null
        );
    }

    private Usuario obtenerUsuarioAutenticado() {
        return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
