package com.example.demo.repository;

import com.example.demo.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    public List<Mascota> findByPropietarioId(Long id);
   // @Query() si quiesiera saber cuantos matches tiene mi mascota se hace a traver de query con una consulta SQL
}
