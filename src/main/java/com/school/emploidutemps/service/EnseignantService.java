package com.school.emploidutemps.service;

import com.school.emploidutemps.entity.Enseignant;
import com.school.emploidutemps.repository.EnseignantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnseignantService {

    private final EnseignantRepository enseignantRepository;

    public List<Enseignant> getAll() {
        return enseignantRepository.findAll();
    }

    public Enseignant getById(Long id) {
        return enseignantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé avec id: " + id));
    }

    public Enseignant create(Enseignant enseignant) {
        if (enseignantRepository.existsByEmail(enseignant.getEmail())) {
            throw new RuntimeException("Email déjà utilisé");
        }
        return enseignantRepository.save(enseignant);
    }

    public Enseignant update(Long id, Enseignant enseignant) {
        Enseignant existing = getById(id);
        existing.setNom(enseignant.getNom());
        existing.setPrenom(enseignant.getPrenom());
        existing.setSpecialite(enseignant.getSpecialite());
        existing.setDisponibilite(enseignant.getDisponibilite());
        existing.setEmail(enseignant.getEmail());
        return enseignantRepository.save(existing);
    }

    public void delete(Long id) {
        enseignantRepository.deleteById(id);
    }
}