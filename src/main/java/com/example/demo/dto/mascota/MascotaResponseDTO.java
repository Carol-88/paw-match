package com.example.demo.dto.mascota;

import com.example.demo.enums.Caracter;
import com.example.demo.enums.Medida;
import com.example.demo.enums.Sexo;
import com.example.demo.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MascotaResponseDTO {
    private Long id;
    private String nombre;
    private String especie;
    private int edad;
    private String raza;
    private Sexo genero;
    private Medida medida;
    private Caracter caracter;
    private String descripcion;
    private Long usuarioId;
    private String fotoUrl;
    private Usuario propietario;
}
