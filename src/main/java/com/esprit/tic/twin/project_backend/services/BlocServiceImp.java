package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Foyer;
import com.esprit.tic.twin.project_backend.repositories.BlocRepository;
import com.esprit.tic.twin.project_backend.repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocServiceImp implements IBlocService{
BlocRepository blocRepository;
FoyerRepository foyerRepository;
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
        return blocRepository.save(b);
    }

    @Override
    public Optional<Bloc> retriveBloc(Long idbloc) {
        return blocRepository.findById(idbloc);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Foyer addFoyerWithBloc(Foyer f) {
        Set<Bloc> blocs = f.getBlocs();
        for (Bloc bloc:blocs)
        {
            bloc.setFoyer(f);
        }
        foyerRepository.save(f);
        return f;
    }


}
