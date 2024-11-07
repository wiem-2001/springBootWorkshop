package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idTache;
     LocalDate dateTache;
     Integer duree;
     Float tarifHoraire;
    @Enumerated(EnumType.STRING)
     TypeTache typeTache;

    @ManyToOne
     Etudiant etudiant;

    @OneToOne(mappedBy = "tache", cascade = CascadeType.ALL)
     Etudiant etudiantTache;
}
