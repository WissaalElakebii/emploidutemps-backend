package com.school.emploidutemps.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "classes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String niveau;

    @Column(nullable = false)
    private Integer effectif;

    @JsonIgnore
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<Seance> seances;
}