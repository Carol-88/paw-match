package com.example.demo.dto.mascota;

import com.example.demo.enums.Caracter;
import lombok.Data;

@Data
public class MascotaUpdateDTO {
    private String nombre;
    private Integer edad;
    private String descripcion;
    private Caracter caracter;
    private String fotoUrl;
}
