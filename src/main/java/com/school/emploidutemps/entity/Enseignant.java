package com.school.emploidutemps.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enseignants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String specialite;
    private String disponibilite;

    @Column(unique = true)
    private String email;
}