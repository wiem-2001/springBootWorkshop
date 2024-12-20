package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.EtatTache;
import com.esprit.tic.twin.project_backend.entities.Etudiant;
import com.esprit.tic.twin.project_backend.entities.Tache;
import com.esprit.tic.twin.project_backend.entities.TypeTache;
import com.esprit.tic.twin.project_backend.repositories.EtudiantRepository;
import com.esprit.tic.twin.project_backend.repositories.TacheRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class TacheServiceImp implements  ITacheService{
    TacheRepository tacheRepository;
    EtudiantRepository etudiantRepository;


    @Override
    public Integer findAllStudents(LocalDate dateDebut,LocalDate dateFin) {
        List<Tache> tacheList= tacheRepository.findAll();
        for (Tache tache : tacheList) {
            LocalDate dateFinTache = tache.getDateTache().plusDays(tache.getDuree());

            if (!tache.getDateTache().isBefore(dateDebut) && !dateFinTache.isAfter(dateFin)) {
                log.info("dateeeeeeeeeeeeeeeeeeeeeeeeeeeeee compar",tache.getDateTache().isBefore(dateDebut));
                return 1;

            }
        }
        return 0;
    }

    @Override
    public float studentsEfficacity(Etudiant etudiant) {
        List<Tache> tacheListTerminé = tacheRepository.findAllByEtatTacheAndEtudiant(etudiant,EtatTache.TERMINE);
        if (tacheListTerminé.isEmpty()) {
            return 0;
        } else {
            List<Tache> tacheListPlanifie = tacheRepository.findAllByEtatTacheAndEtudiant(etudiant,EtatTache.PLANIFIE);
            if (!tacheListPlanifie.isEmpty()) {
                int totalTachesPlanifie = 0;
                int tachesCompletees = 0;

                for (Tache task : tacheListPlanifie) {
                    LocalDate dateFinTache = task.getDateTache().plusDays(task.getDuree());

                        totalTachesPlanifie++;

                }
                for (Tache task : tacheListTerminé) {

                        tachesCompletees++;

                }
                return (float) tachesCompletees / totalTachesPlanifie * 100;
            } else {
                return 0;
            }
        }
    }


    @Override
    public float studentRevenu(Etudiant etudiant) {
        List<Tache> tasks = tacheRepository.findAllByEtatTacheAndEtudiant(etudiant,EtatTache.TERMINE);
        float totalRevenu = 0;
        if (!tasks.isEmpty()) {
            for (Tache tache : tasks) {
                totalRevenu += tache.getTarifHoraire() * tache.getDuree();
            }
        }

        return totalRevenu;
    }

    @Override
    public float studentVersatility(Etudiant etudiant) {
        List<Tache> tacheList = tacheRepository.findAllByEtatTacheAndEtudiant(etudiant,EtatTache.TERMINE);
        Integer nbTacheMenagere = 0;
        Integer nbTacheJardinage = 0;
        Integer nbTacheBricolage = 0;
        for (Tache tache : tacheList) {
                if (tache.getTypeTache() == TypeTache.MENAGERE) {
                    nbTacheMenagere++;
                } else if (tache.getTypeTache() == TypeTache.JARDINAGE) {
                    nbTacheJardinage++;
                } else if (tache.getTypeTache() == TypeTache.BRICOLAGE) {
                    nbTacheBricolage++;
                }
                if (nbTacheMenagere > 0 && nbTacheJardinage > 0 && nbTacheBricolage > 0) {
                    break;
                }
        }
        int totalTypesPerformed = 0;
        if (nbTacheMenagere > 0) totalTypesPerformed++;
        if (nbTacheJardinage > 0) totalTypesPerformed++;
        if (nbTacheBricolage > 0) totalTypesPerformed++;
        return (totalTypesPerformed / 3.0f) * 100;
    }

    public float studentPerformance(Etudiant etudiant )
    {
        float efficacity=this.studentsEfficacity(etudiant);
        float revenu=this.studentRevenu(etudiant);
        float versatility=this.studentVersatility(etudiant);
        return efficacity+revenu+versatility;
    }

    @Override
    public LinkedHashMap<Float, Etudiant> studentsPerformanceRanking() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        LinkedHashMap<Float, Etudiant> performanceMap = new LinkedHashMap<>();
        for (Etudiant etudiant : etudiants) {
            float performance = this.studentPerformance(etudiant);
            performanceMap.put(performance, etudiant);
        }
        return performanceMap;
                /*performanceMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Float, Etudiant>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));*/
    }
    //ken 3tani bch nsavi list a la fois mathalan : addtasks donc naaml : tacheRepositor.saveAll()


}
