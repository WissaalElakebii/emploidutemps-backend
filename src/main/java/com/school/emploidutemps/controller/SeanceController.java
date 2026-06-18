package com.school.emploidutemps.controller;

import com.school.emploidutemps.entity.Seance;
import com.school.emploidutemps.service.SeanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/seances")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class SeanceController {

    private final SeanceService seanceService;

    @GetMapping
    public List<Seance> getAll() {
        return seanceService.getAll();
    }

    @GetMapping("/classe/{classeId}")
    public List<Seance> getByClasse(@PathVariable Long classeId) {
        return seanceService.getByClasse(classeId);
    }

    @GetMapping("/enseignant/{enseignantId}")
    public List<Seance> getByEnseignant(@PathVariable Long enseignantId) {
        return seanceService.getByEnseignant(enseignantId);
    }

    @PostMapping
    public ResponseEntity<Seance> create(@RequestBody Seance seance) {
        return ResponseEntity.ok(seanceService.create(seance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        seanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}