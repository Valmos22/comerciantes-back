package com.hugovalderrama.comerciantes_backend.controller;

import com.hugovalderrama.comerciantes_backend.dto.*;
import com.hugovalderrama.comerciantes_backend.service.ComercianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comerciantes")
@RequiredArgsConstructor
public class ComercianteController {

    private final ComercianteService comercianteService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'AUXILIAR')")
    public ResponseEntity<ApiResponse<List<ComercianteResponse>>> listarTodos() {
        List<ComercianteResponse> lista = comercianteService.listarTodos();
        return ResponseEntity.ok(
                ApiResponse.<List<ComercianteResponse>>builder()
                        .success(true)
                        .message("Lista de comerciantes obtenida exitosamente")
                        .data(lista)
                        .build()
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'AUXILIAR')")
    public ResponseEntity<ApiResponse<ComercianteResponse>> buscarPorId(@PathVariable Long id) {
        ComercianteResponse response = comercianteService.buscarPorId(id);
        return ResponseEntity.ok(
                ApiResponse.<ComercianteResponse>builder()
                        .success(true)
                        .message("Comerciante encontrado")
                        .data(response)
                        .build()
        );
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<ApiResponse<ComercianteResponse>> crear(@RequestBody @Valid ComercianteRequest request) {
        ComercianteResponse response = comercianteService.crear(request);
        return ResponseEntity.ok(
                ApiResponse.<ComercianteResponse>builder()
                        .success(true)
                        .message("Comerciante creado exitosamente")
                        .data(response)
                        .build()
        );
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<ApiResponse<ComercianteResponse>> actualizar(
            @PathVariable Long id,
            @RequestBody @Valid ComercianteRequest request
    ) {
        ComercianteResponse response = comercianteService.actualizar(id, request);
        return ResponseEntity.ok(
                ApiResponse.<ComercianteResponse>builder()
                        .success(true)
                        .message("Comerciante actualizado exitosamente")
                        .data(response)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id) {
        comercianteService.eliminar(id);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message("Comerciante eliminado exitosamente")
                        .build()
        );
    }
}
