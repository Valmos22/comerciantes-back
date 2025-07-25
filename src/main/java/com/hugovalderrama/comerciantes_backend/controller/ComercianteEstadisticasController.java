package com.hugovalderrama.comerciantes_backend.controller;

import com.hugovalderrama.comerciantes_backend.dto.ComercianteEstadisticaResponse;
import com.hugovalderrama.comerciantes_backend.service.ComercianteEstadisticasService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;


import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/comerciantes/estadisticas")
@RequiredArgsConstructor
public class ComercianteEstadisticasController {

    private final ComercianteEstadisticasService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'AUXILIAR')")
    public List<ComercianteEstadisticaResponse> obtenerEstadisticas() {
        return service.obtenerEstadisticas();
    }

    @GetMapping("/csv")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<Resource> exportarCsv() {
        ByteArrayInputStream csvData = service.generarCsvComerciantesActivos();

        InputStreamResource resource = new InputStreamResource(csvData);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=comerciantes.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(resource);
    }
}
