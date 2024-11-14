package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Chambre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
}
