package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EtudiantServiceImp implements IEtudiantService{
    EtudiantRepository etudiantRepository;
}
