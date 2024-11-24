package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Chambre;
import com.esprit.tic.twin.project_backend.repositories.BlocRepository;
import com.esprit.tic.twin.project_backend.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
@Slf4j
public class ChambreServiceImp implements IChambreService{
    ChambreRepository chambreRepository ;
    BlocRepository blocRepository ;


    @Override
    public List<Chambre> retrieveAllChambres() {
        return null;
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = blocRepository.findBlocByNomBloc(nomBloc);

        for(Long num : numChambre)
        {
            Chambre chambre=chambreRepository.findByNumeroChambre(num);
            chambre.setBloc(bloc);
            bloc.getChambreSet().add(chambre);
            chambreRepository.save(chambre);
        }
        blocRepository.save(bloc);
return bloc ;
    }
}
