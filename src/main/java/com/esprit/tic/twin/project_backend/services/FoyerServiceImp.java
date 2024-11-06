package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Foyer;
import com.esprit.tic.twin.project_backend.repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImp implements IFoyerService{

    FoyerRepository foyerRepository;

    @Override
    public List<Foyer> retrieveAll() {
            return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retriveFoyeyr(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(Long idFoyer) {
      foyerRepository.deleteById(idFoyer);
    }


}
