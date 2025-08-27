package com.example.demo.dto.mascota;

import com.example.demo.enums.Caracter;
import com.example.demo.enums.Medida;
import com.example.demo.enums.Sexo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MascotaRequestDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La especie no puede estar vacía")
    private String especie;

    @NotBlank(message = "La edad no puede estar vacía")
    private int edad;

    @NotBlank(message = "La raza no puede estar vacía")
    private String raza;

    @NotBlank(message = "El sexo no puede estar vacío")
    private Sexo genero;

    private Medida medida;
    private Caracter caracter;
    private String descripcion;
    private Long usuarioId;
    private String fotoUrl;
}
