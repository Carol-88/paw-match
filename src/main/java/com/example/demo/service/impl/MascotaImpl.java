package com.example.demo.service.impl;

import com.example.demo.dto.mascota.MascotaRequestDTO;
import com.example.demo.dto.mascota.MascotaResponseDTO;
import com.example.demo.dto.mascota.MascotaUpdateDTO;
import com.example.demo.model.Mascota;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.service.interfaces.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class MascotaImpl implements MascotaService {

    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public List<MascotaResponseDTO> getAllMascotas() {
        return mascotaRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MascotaResponseDTO getMascotaById(Long id) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
        return mapToResponseDTO(mascota);
    }

    @Override
    public MascotaResponseDTO createMascota(MascotaRequestDTO mascotaRequest) {
        Mascota mascota = new Mascota();
        mascota.setNombre(mascotaRequest.getNombre());
        mascota.setEspecie(mascotaRequest.getEspecie());
        mascota.setRaza(mascotaRequest.getRaza());
        mascota.setEdad(mascotaRequest.getEdad());
        mascota.setDescripcion(mascotaRequest.getDescripcion());
        mascota.setCaracter(mascotaRequest.getCaracter());
        mascota.setMedida(mascotaRequest.getMedida());
        mascota.setSexo(mascotaRequest.getSexo());
        mascota.setFotoUrl(mascotaRequest.getFotoUrl());
        Mascota savedMascota = mascotaRepository.save(mascota);
        return mapToResponseDTO(savedMascota);
    }

    @Override
    public MascotaResponseDTO updateMascota(Long id, MascotaUpdateDTO mascotaUpdate) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
        if (mascotaUpdate.getNombre() != null) mascota.setNombre(mascotaUpdate.getNombre());
        if (mascotaUpdate.getEdad() != 0) mascota.setEdad(mascotaUpdate.getEdad());
        if (mascotaUpdate.getDescripcion() != null) mascota.setDescripcion(mascotaUpdate.getDescripcion());
        if (mascotaUpdate.getCaracter() != null) mascota.setCaracter(mascotaUpdate.getCaracter());
        if (mascotaUpdate.getFotoUrl() != null) mascota.setFotoUrl(mascotaUpdate.getFotoUrl());
        Mascota updatedMascota = mascotaRepository.save(mascota);
        return mapToResponseDTO(updatedMascota);
    }


@Override
    public void deleteMascota(Long id) {
        if (!mascotaRepository.existsById(id)) {
            throw new RuntimeException("Mascota no encontrada con id: " + id);
        }
        mascotaRepository.deleteById(id);
    }

private MascotaResponseDTO mapToResponseDTO(Mascota mascota) {
    MascotaResponseDTO dto = new MascotaResponseDTO();
    dto.setId(mascota.getId());
    dto.setNombre(mascota.getNombre());
    dto.setEspecie(mascota.getEspecie());
    dto.setRaza(mascota.getRaza());
    dto.setEdad(mascota.getEdad());
    dto.setDescripcion(mascota.getDescripcion());
    dto.setCaracter(mascota.getCaracter());
    dto.setMedida(mascota.getMedida());
    dto.setSexo(mascota.getSexo());
    dto.setFotoUrl(mascota.getFotoUrl());
    dto.setPropietario(mascota.getPropietario());
    return dto;
    }
}
