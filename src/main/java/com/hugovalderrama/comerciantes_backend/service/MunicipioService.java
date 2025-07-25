package com.hugovalderrama.comerciantes_backend.service;

import com.hugovalderrama.comerciantes_backend.entity.Municipio;
import com.hugovalderrama.comerciantes_backend.repository.MunicipioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MunicipioService {

    private final MunicipioRepository municipioRepository;

    public List<Municipio> obtenerTodos() {
        return municipioRepository.findAll();
    }
}
