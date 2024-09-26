package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Chambre {
    @Id
    private long idChmbre;
    private long numeroChambre;
    private TypeChambre typeC;
}
