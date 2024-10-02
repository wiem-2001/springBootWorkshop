package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    @OneToOne(mappedBy = "foyer" ,cascade = CascadeType.ALL)
    private Universite universite;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "foyer")
    private Set<Bloc> blocs;
}
