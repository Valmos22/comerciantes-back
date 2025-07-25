package com.hugovalderrama.comerciantes_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nombre;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "correo_electronico", unique = true)
    private String correoElectronico;

    @NotBlank
    @Size(max = 255)
    private String contrasena;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Rol rol;

    public enum Rol {
        Administrador,
        Auxiliar
    }
}
