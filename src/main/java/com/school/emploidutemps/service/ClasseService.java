package com.school.emploidutemps.service;

import com.school.emploidutemps.entity.Classe;
import com.school.emploidutemps.repository.ClasseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClasseService {

    private final ClasseRepository classeRepository;

    public List<Classe> getAll() {
        return classeRepository.findAll();
    }

    public Classe getById(Long id) {
        return classeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée avec id: " + id));
    }

    public Classe create(Classe classe) {
        return classeRepository.save(classe);
    }

    public Classe update(Long id, Classe classe) {
        Classe existing = getById(id);
        existing.setNiveau(classe.getNiveau());
        existing.setEffectif(classe.getEffectif());
        return classeRepository.save(existing);
    }

    public void delete(Long id) {
        classeRepository.deleteById(id);
    }
}