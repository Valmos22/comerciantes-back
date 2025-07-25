package com.hugovalderrama.comerciantes_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "municipio")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;
}
