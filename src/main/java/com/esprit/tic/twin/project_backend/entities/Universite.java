package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.*;

@Entity
public class Universite {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idUniversite;
private String nomUniversite;
private String addresse;

@OneToOne(mappedBy = "universtie")
    private Foyer foyer;
}
