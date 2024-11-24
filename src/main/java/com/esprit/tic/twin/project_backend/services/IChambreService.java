package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Chambre;
import com.esprit.tic.twin.project_backend.entities.Universite;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



public interface IChambreService {
    public List<Chambre> retrieveAllChambres();

    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);
}
