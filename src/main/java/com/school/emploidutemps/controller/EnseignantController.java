package com.school.emploidutemps.controller;

import com.school.emploidutemps.entity.Enseignant;
import com.school.emploidutemps.service.EnseignantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class EnseignantController {

    private final EnseignantService enseignantService;

    @GetMapping
    public List<Enseignant> getAll() {
        return enseignantService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getById(@PathVariable Long id) {
        return ResponseEntity.ok(enseignantService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Enseignant> create(@RequestBody Enseignant enseignant) {
        return ResponseEntity.ok(enseignantService.create(enseignant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enseignant> update(@PathVariable Long id, @RequestBody Enseignant enseignant) {
        return ResponseEntity.ok(enseignantService.update(id, enseignant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enseignantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}