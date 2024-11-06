package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Reservation {
    @Id
    private String idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToMany(mappedBy = "reservations")
    private Set<Etudiant> etudiantSet;

}
