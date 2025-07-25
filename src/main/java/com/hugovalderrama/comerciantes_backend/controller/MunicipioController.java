package com.hugovalderrama.comerciantes_backend.controller;

import com.hugovalderrama.comerciantes_backend.dto.ApiResponse;
import com.hugovalderrama.comerciantes_backend.entity.Municipio;
import com.hugovalderrama.comerciantes_backend.service.MunicipioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipios")
@RequiredArgsConstructor
public class MunicipioController {

    private final MunicipioService municipioService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Municipio>>> listarMunicipios() {
        List<Municipio> municipios = municipioService.obtenerTodos();
        return ResponseEntity.ok(ApiResponse.ok("Lista de municipios", municipios));
    }
}
