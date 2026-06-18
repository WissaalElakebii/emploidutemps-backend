package com.school.emploidutemps.controller;

import com.school.emploidutemps.entity.Creneau;
import com.school.emploidutemps.service.CreneauService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/creneaux")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CreneauController {

    private final CreneauService creneauService;

    @GetMapping
    public List<Creneau> getAll() {
        return creneauService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Creneau> getById(@PathVariable Long id) {
        return ResponseEntity.ok(creneauService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Creneau> create(@RequestBody Creneau creneau) {
        return ResponseEntity.ok(creneauService.create(creneau));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Creneau> update(@PathVariable Long id, @RequestBody Creneau creneau) {
        return ResponseEntity.ok(creneauService.update(id, creneau));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        creneauService.delete(id);
        return ResponseEntity.noContent().build();
    }
}