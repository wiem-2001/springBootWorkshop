package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChambreServiceImp implements IChambreService{
    ChambreRepository chambreRepository ;
}
