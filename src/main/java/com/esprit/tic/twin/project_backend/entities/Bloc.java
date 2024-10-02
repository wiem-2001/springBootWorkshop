package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc ;
    @ManyToOne
    private Foyer foyer;
    @OneToMany(mappedBy = "bloc")
    private Set<Chambre> chambreSet;

}
