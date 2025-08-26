package com.example.demo.dto.preferencias;

import com.example.demo.enums.Caracter;
import com.example.demo.enums.Medida;
import com.example.demo.enums.Sexo;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PreferenciasRequestDTO {
    @NotBlank(message = "La raza no puede estar vacía")
    private String raza;

    @NotBlank(message = "El género no puede estar vacío")
    private Sexo genero;

    @NotBlank(message = "El tamaño no puede estar vacío")
    private Medida medida;

   @NotBlank(message = "La edad mínima no puede estar vacía")
    private Integer edadMin;

    private Integer edadMax;

    @NotBlank(message = "El carácter no puede estar vacío")
    private Caracter caracter;

    @NotBlank(message = "La distancia máxima no puede estar vacía")
    private Integer distanciaMaxKm;
}
