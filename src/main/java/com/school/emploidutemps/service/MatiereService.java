package com.school.emploidutemps.service;

import com.school.emploidutemps.entity.Matiere;
import com.school.emploidutemps.repository.MatiereRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatiereService {

    private final MatiereRepository matiereRepository;

    public List<Matiere> getAll() {
        return matiereRepository.findAll();
    }

    public Matiere getById(Long id) {
        return matiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matière non trouvée avec id: " + id));
    }

    public Matiere create(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    public Matiere update(Long id, Matiere matiere) {
        Matiere existing = getById(id);
        existing.setNom(matiere.getNom());
        existing.setVolumeHoraire(matiere.getVolumeHoraire());
        return matiereRepository.save(existing);
    }

    public void delete(Long id) {
        matiereRepository.deleteById(id);
    }
}