package com.school.emploidutemps.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "matieres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(name = "volume_horaire")
    private Integer volumeHoraire;

    @JsonIgnore
    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
    private List<Seance> seances;
}