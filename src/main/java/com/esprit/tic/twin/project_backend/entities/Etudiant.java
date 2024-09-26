package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Etudiant {
    @Id
    private long idEtudiant ;
    private String nomEt;
    private String prenomEt;
    private  long cin;
    private String ecole;
    private Date dateNaissance;
}

