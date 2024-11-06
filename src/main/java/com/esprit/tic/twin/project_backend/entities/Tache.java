package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.time.LocalDate;
@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idTache;
    private LocalDate dateTache;
    private Integer duree;
    private Float tarifHoraire;
    @Enumerated(EnumType.STRING)
    private TypeTache typeTache;

    @ManyToOne
    private Etudiant etudiant;

    @OneToOne(mappedBy = "tache", cascade = CascadeType.ALL)
    private Etudiant etudiantTache;
}
