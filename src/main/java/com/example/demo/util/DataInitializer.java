package com.example.demo.util;

import com.example.demo.enums.Caracter;
import com.example.demo.enums.EstadoMatch;
import com.example.demo.enums.Medida;
import com.example.demo.enums.Sexo;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

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

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    MatchRepository matchRepository;

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
                .genero(Sexo.MACHO)
                .edad(3)
                .medida(Medida.GRANDE)
                .caracter(Caracter.JUGUETON)
                .descripcion("Un perro muy amigable y juguetón.")
                .propietario(usuarioRepository.findById(1L).orElse(null))
                .build();
        Mascota mascota2 = Mascota.builder()
                .nombre("Mimi")
                .especie("Gato")
                .raza("Siames")
                .genero(Sexo.HEMBRA)
                .edad(2)
                .medida(Medida.PEQUENO)
                .caracter(Caracter.TRANQUILO)
                .descripcion("Una gata muy cariñosa y tranquila.")
                .propietario(usuarioRepository.findById(2L).orElse(null))
                .build();
        Mascota mascota3 = Mascota.builder()
                .nombre("Rex")
                .especie("Perro")
                .raza("Pastor Alemán")
                .genero(Sexo.MACHO)
                .edad(5)
                .medida(Medida.GRANDE)
                .caracter(Caracter.ACTIVO)
                .descripcion("Un perro leal y protector.")
                .propietario(usuarioRepository.findById(1L).orElse(null))
                .build();
        mascotaRepository.saveAll(List.of(mascota1, mascota2, mascota3));

        //PREFERENCIAS
        Preferencias preferencias1 = Preferencias.builder()
                .usuario(usuarioRepository.findById(user1.getId()).orElse(null))
                .raza("Labrador")
                .edadMin(4)
                .build();
        Preferencias preferencias2 = Preferencias.builder()
                .usuario(usuarioRepository.findById(user2.getId()).orElse(null))
                .raza("Siames")
                .edadMin(1)
                .build();

        preferenciasRepository.saveAll(List.of(preferencias1, preferencias2));

        //MATCH
        Match match1 = Match.builder()
                .mascotaOrigen(mascota1)
                .mascotaDestino(mascota2)
                .estado(EstadoMatch.CONFIRMADO)
                .build();
        Match match2 = Match.builder()
                .mascotaOrigen(mascota3)
                .mascotaDestino(mascota2)
                .estado(EstadoMatch.PENDIENTE)
                .fechaMatch(LocalDateTime.parse("2024-06-20T10:15:30"))
                .build();
        matchRepository.saveAll(List.of(match1, match2));


//      CHAT
//        Chat chat1 = Chat.builder()
//                .usuario1(user1)
//                .usuario2(user2)
//                .matchId(1L)
//                .build();


        //MENSAJE
        System.out.println("+++++++++++++++++++++++++++++++++++ DATOS CARGADOS");
    }
}
