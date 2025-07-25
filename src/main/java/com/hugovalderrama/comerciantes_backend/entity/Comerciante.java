package com.hugovalderrama.comerciantes_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "comerciante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comerciante {
    @Id
    @Column(name = "id_comerciante")
    private Long id;

    @Column(name = "nombre_razon_social", nullable = false, length = 150)
    private String nombreRazonSocial;

    @Column(name = "municipio", nullable = false, length = 100)
    private String municipio;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "correo_electronico", length = 100)
    private String correoElectronico;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "estado", nullable = false, length = 10)
    private String estado; // "Activo" o "Inactivo"

    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_actualizacion", referencedColumnName = "id_usuario")
    private Usuario usuarioActualizacion;
}
