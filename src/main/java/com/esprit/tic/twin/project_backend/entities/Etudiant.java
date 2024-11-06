package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

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
   @Enumerated(EnumType.STRING)

    private TypeEtudiant typeEtudiant ;
    private LocalDate dateNaissance;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations ;

    @OneToMany(mappedBy = "etudiant")
    private Set<Tache> tacheSet;

    @OneToOne
    private Tache tache;
}

