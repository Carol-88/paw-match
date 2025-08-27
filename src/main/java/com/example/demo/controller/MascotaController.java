package com.example.demo.controller;

import com.example.demo.dto.mascota.MascotaRequestDTO;
import com.example.demo.dto.mascota.MascotaResponseDTO;
import com.example.demo.dto.mascota.MascotaUpdateDTO;
import com.example.demo.service.interfaces.MascotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public ResponseEntity<List<MascotaResponseDTO>> getAllMascotas() {
        return ResponseEntity.ok(mascotaService.getAllMascotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaResponseDTO> getMascotaById(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.getMascotaById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<MascotaResponseDTO> createMascota(@RequestBody MascotaRequestDTO mascotaRequest) {
        return ResponseEntity.ok(mascotaService.createMascota(mascotaRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MascotaResponseDTO> updateMascota(@PathVariable Long id,
                                                            @RequestBody MascotaUpdateDTO mascotaUpdate) {
        return ResponseEntity.ok(mascotaService.updateMascota(id, mascotaUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Long id) {
        mascotaService.deleteMascota(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<MascotaResponseDTO>> getMascotasByPropietarioId(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.getMascotasByPropietarioId(id));
    }
}
