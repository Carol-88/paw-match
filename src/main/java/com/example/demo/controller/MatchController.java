package com.example.demo.controller;

import com.example.demo.dto.match.MatchRequestDTO;
import com.example.demo.dto.match.MatchResponseDTO;
import com.example.demo.service.interfaces.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping
    public ResponseEntity<List<MatchResponseDTO>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResponseDTO> getMatchById(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getMatchById(id));
    }

    @PostMapping
    public ResponseEntity<MatchResponseDTO> createMatch(@RequestBody MatchRequestDTO matchRequest) {
        return ResponseEntity.ok(matchService.createMatch(matchRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}
