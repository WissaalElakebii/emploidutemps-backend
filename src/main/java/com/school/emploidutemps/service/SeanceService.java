package com.school.emploidutemps.service;

import com.school.emploidutemps.entity.Seance;
import com.school.emploidutemps.repository.SeanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeanceService {

    private final SeanceRepository seanceRepository;

    public List<Seance> getAll() {
        return seanceRepository.findAll();
    }

    public List<Seance> getByClasse(Long classeId) {
        return seanceRepository.findByClasseId(classeId);
    }

    public List<Seance> getByEnseignant(Long enseignantId) {
        return seanceRepository.findByEnseignantId(enseignantId);
    }

    public Seance create(Seance seance) {
        verifierConflits(seance);
        return seanceRepository.save(seance);
    }

    public void delete(Long id) {
        seanceRepository.deleteById(id);
    }

    private void verifierConflits(Seance seance) {
        Long creneauId = seance.getCreneau().getId();

        if (seanceRepository.existsByEnseignantIdAndCreneauId(
                seance.getEnseignant().getId(), creneauId)) {
            throw new RuntimeException("Conflit : enseignant déjà occupé sur ce créneau");
        }
        if (seanceRepository.existsBySalleIdAndCreneauId(
                seance.getSalle().getId(), creneauId)) {
            throw new RuntimeException("Conflit : salle déjà occupée sur ce créneau");
        }
        if (seanceRepository.existsByClasseIdAndCreneauId(
                seance.getClasse().getId(), creneauId)) {
            throw new RuntimeException("Conflit : classe déjà occupée sur ce créneau");
        }
    }
}