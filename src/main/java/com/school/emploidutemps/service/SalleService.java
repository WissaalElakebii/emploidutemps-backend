package com.school.emploidutemps.service;

import com.school.emploidutemps.entity.Salle;
import com.school.emploidutemps.repository.SalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalleService {

    private final SalleRepository salleRepository;

    public List<Salle> getAll() {
        return salleRepository.findAll();
    }

    public Salle getById(Long id) {
        return salleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salle non trouvée avec id: " + id));
    }

    public Salle create(Salle salle) {
        return salleRepository.save(salle);
    }

    public Salle update(Long id, Salle salle) {
        Salle existing = getById(id);
        existing.setNom(salle.getNom());
        existing.setType(salle.getType());
        existing.setCapacite(salle.getCapacite());
        return salleRepository.save(existing);
    }

    public void delete(Long id) {
        salleRepository.deleteById(id);
    }
}