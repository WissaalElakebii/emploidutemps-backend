package com.school.emploidutemps.controller;

import com.school.emploidutemps.entity.Salle;
import com.school.emploidutemps.service.SalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/salles")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class SalleController {

    private final SalleService salleService;

    @GetMapping
    public List<Salle> getAll() {
        return salleService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salle> getById(@PathVariable Long id) {
        return ResponseEntity.ok(salleService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Salle> create(@RequestBody Salle salle) {
        return ResponseEntity.ok(salleService.create(salle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salle> update(@PathVariable Long id, @RequestBody Salle salle) {
        return ResponseEntity.ok(salleService.update(id, salle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        salleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}