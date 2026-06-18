package com.school.emploidutemps.controller;

import com.school.emploidutemps.entity.Classe;
import com.school.emploidutemps.service.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ClasseController {

    private final ClasseService classeService;

    @GetMapping
    public List<Classe> getAll() {
        return classeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classe> getById(@PathVariable Long id) {
        return ResponseEntity.ok(classeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Classe> create(@RequestBody Classe classe) {
        return ResponseEntity.ok(classeService.create(classe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classe> update(@PathVariable Long id, @RequestBody Classe classe) {
        return ResponseEntity.ok(classeService.update(id, classe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        classeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}