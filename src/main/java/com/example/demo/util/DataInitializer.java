package com.example.demo.util;

import com.example.demo.enums.Caracter;
import com.example.demo.enums.Medida;
import com.example.demo.enums.Sexo;
import com.example.demo.model.Mascota;
import com.example.demo.model.Preferencias;
import com.example.demo.model.Usuario;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.PreferenciasRepository;
import com.example.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    //USUARIOS
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    PreferenciasRepository preferenciasRepository;

    @Override
    public void run(String... args) {
        Usuario user1 = Usuario.builder()
                .nombre("Juan")
                .email("juan@email.com")
                .password("12343465")
                .ubicacion("Barcelona")
                .ciudad("Barcelona")
                .telefono("666777888")
                .build();
        Usuario user2 = Usuario.builder()
                .nombre("Ana")
                .email("ana@email.com")
                .password("1234345")
                .ubicacion("Madrid")
                .ciudad("Madrid")
                .telefono("666777888")
                .build();
        usuarioRepository.save(user1);
        usuarioRepository.save(user2);

        //MASCOTAS

        Mascota mascota1 = Mascota.builder()
                .nombre("Firulais")
                .especie("Perro")
                .raza("Labrador")
                .sexo(Sexo.MACHO)
                .edad(3)
                .medida(Medida.GRANDE)
                .caracter(Caracter.JUGUETON)
                .descripcion("Un perro muy amigable y juguetón.")
                .propietario(usuarioRepository.findById(1L).orElse(null))
                .build();
        mascotaRepository.save(mascota1);

        //PREFERENCIAS
        Preferencias preferencias1 = Preferencias.builder()
                .usuario(usuarioRepository.findById(1L).orElse(null))
                .raza("Labrador")
                .edadMin(4)
                .build();
        preferenciasRepository.save(preferencias1);
    }
}
