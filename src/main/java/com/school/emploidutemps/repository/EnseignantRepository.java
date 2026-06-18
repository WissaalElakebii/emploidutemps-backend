package com.school.emploidutemps.repository;

import com.school.emploidutemps.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    Optional<Enseignant> findByEmail(String email);
    boolean existsByEmail(String email);
}