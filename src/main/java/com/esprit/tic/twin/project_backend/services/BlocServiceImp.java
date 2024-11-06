package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Foyer;
import com.esprit.tic.twin.project_backend.repositories.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImp implements IBlocService{
BlocRepository blocRepository;
    @Override
    public List<Bloc> retrieveAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return null;
    }

    @Override
    public Bloc retriveBloc(Long idbloc) {
        return null;
    }

    @Override
    public void removeBloc(Long idBloc) {

    }
}
