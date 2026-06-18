package com.school.emploidutemps.repository;

import com.school.emploidutemps.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    List<Seance> findByClasseId(Long classeId);
    List<Seance> findByEnseignantId(Long enseignantId);
    boolean existsByEnseignantIdAndCreneauId(Long enseignantId, Long creneauId);
    boolean existsBySalleIdAndCreneauId(Long salleId, Long creneauId);
    boolean existsByClasseIdAndCreneauId(Long classeId, Long creneauId);
}