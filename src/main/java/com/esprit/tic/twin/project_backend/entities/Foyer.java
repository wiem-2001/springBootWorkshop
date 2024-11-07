package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idFoyer;
     String nomFoyer;
     long capaciteFoyer;

    @OneToOne(cascade = CascadeType.ALL)
     Universite universtie;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "foyer")
     Set<Bloc> blocs;
}
