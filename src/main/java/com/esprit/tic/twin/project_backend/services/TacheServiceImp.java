package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.repositories.TacheRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TacheServiceImp implements  ITacheService{
    TacheRepository tacheRepository;
}
