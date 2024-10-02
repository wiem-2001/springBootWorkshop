package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idEtudiant ;
    private String nomEt;
    private String prenomEt;
    private  long cin;
    private String ecole;
   /* @Temporal(TemporalType.DATE)
    private Date dateNaissance;*/

    private LocalDate dateNaissance;

}

