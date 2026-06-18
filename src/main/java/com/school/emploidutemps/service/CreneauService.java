package com.school.emploidutemps.service;

import com.school.emploidutemps.entity.Creneau;
import com.school.emploidutemps.repository.CreneauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreneauService {

    private final CreneauRepository creneauRepository;

    public List<Creneau> getAll() {
        return creneauRepository.findAll();
    }

    public Creneau getById(Long id) {
        return creneauRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Créneau non trouvé avec id: " + id));
    }

    public Creneau create(Creneau creneau) {
        return creneauRepository.save(creneau);
    }

    public Creneau update(Long id, Creneau creneau) {
        Creneau existing = getById(id);
        existing.setJour(creneau.getJour());
        existing.setHeureDebut(creneau.getHeureDebut());
        existing.setHeureFin(creneau.getHeureFin());
        return creneauRepository.save(existing);
    }

    public void delete(Long id) {
        creneauRepository.deleteById(id);
    }
}