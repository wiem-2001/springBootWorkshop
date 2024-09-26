package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Universite {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idUniversite;
private String nomUniversite;
private String addresse;
}
