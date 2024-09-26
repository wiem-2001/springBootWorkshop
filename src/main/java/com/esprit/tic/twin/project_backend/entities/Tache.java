package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;

import java.time.LocalDate;
@Entity
public class Tache {
    @Id
    private long idTache;
    private LocalDate dateTache;
    private Integer duree;
    private Float tarifHoraire;
    private TypeTache typeTache;
}
