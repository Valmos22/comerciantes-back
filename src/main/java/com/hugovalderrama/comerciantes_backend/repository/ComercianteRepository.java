package com.hugovalderrama.comerciantes_backend.repository;

import com.hugovalderrama.comerciantes_backend.entity.Comerciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercianteRepository extends JpaRepository<Comerciante, Long> {
}
