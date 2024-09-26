package com.esprit.tic.twin.project_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bloc {
    @Id
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc ;

}
