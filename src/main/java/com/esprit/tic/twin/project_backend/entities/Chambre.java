package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idChmbre;
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @ManyToOne
    private Bloc bloc;

    @OneToMany
    private Set<Reservation> reservationSet;


}
