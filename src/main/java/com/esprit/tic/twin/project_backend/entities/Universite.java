package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Universite {
@Id
    private long idUniversite;
private String nomUniversite;
private String addresse;
}
