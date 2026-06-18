package com.school.emploidutemps.controller;

import com.school.emploidutemps.entity.Matiere;
import com.school.emploidutemps.service.MatiereService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matieres")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class MatiereController {

    private final MatiereService matiereService;

    @GetMapping
    public List<Matiere> getAll() {
        return matiereService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matiere> getById(@PathVariable Long id) {
        return ResponseEntity.ok(matiereService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Matiere> create(@RequestBody Matiere matiere) {
        return ResponseEntity.ok(matiereService.create(matiere));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matiere> update(@PathVariable Long id, @RequestBody Matiere matiere) {
        return ResponseEntity.ok(matiereService.update(id, matiere));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        matiereService.delete(id);
        return ResponseEntity.noContent().build();
    }
}