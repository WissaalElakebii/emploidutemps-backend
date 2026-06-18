package com.school.emploidutemps.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "creneaux")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Creneau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String jour;

    @Column(name = "heure_debut", nullable = false)
    private LocalTime heureDebut;

    @Column(name = "heure_fin", nullable = false)
    private LocalTime heureFin;

    @JsonIgnore
    @OneToMany(mappedBy = "creneau", cascade = CascadeType.ALL)
    private List<Seance> seances;
}