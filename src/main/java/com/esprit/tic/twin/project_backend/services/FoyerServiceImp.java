package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Foyer;
import com.esprit.tic.twin.project_backend.entities.Universite;
import com.esprit.tic.twin.project_backend.repositories.FoyerRepository;
import com.esprit.tic.twin.project_backend.repositories.UniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImp implements IFoyerService{

    FoyerRepository foyerRepository;
    UniversityRepository universityRepository;

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

    @Override
    public Universite addFoyerAuniversite(long idFoyer, String nomUniversite) {
        Universite universite = universityRepository.findUniversitesByNomUniversite(nomUniversite);
        // université parent dans l'association, donc affecter le foyer au parent
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        universite.setFoyer(foyer);
        // sauvegarder l'objet université avec le foyer affecté
        universityRepository.save(universite);
        return universite;

    }


}
