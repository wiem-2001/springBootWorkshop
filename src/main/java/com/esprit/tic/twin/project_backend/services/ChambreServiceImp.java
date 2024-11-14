package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Chambre;
import com.esprit.tic.twin.project_backend.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ChambreServiceImp implements IChambreService{
    ChambreRepository chambreRepository ;


    @Override
    public List<Chambre> retrieveAllChambres() {
        return null;
    }
}
