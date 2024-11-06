package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Foyer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IFoyerService {
    List<Foyer> retrieveAll();

    Foyer addFoyer(Foyer f);

    Foyer updateFoyer(Foyer f);

    Foyer retriveFoyeyr(Long idFoyer);

    void removeFoyer (Long idFoyer);
}
