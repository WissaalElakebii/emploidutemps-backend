package com.school.emploidutemps.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "salles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Integer capacite;

    @JsonIgnore
    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
    private List<Seance> seances;
}