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
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class TacheServiceImp implements ITacheService {
    private final TacheRepository tacheRepository;
    private final EtudiantRepository etudiantRepository;

    @Override
    public Integer findAllStudents(LocalDate dateDebut, LocalDate dateFin) {
        List<Tache> tacheList = tacheRepository.findAll();
        for (Tache tache : tacheList) {
            LocalDate dateFinTache = tache.getDateTache().atStartOfDay().plusHours(tache.getDuree()).toLocalDate();
            if (!tache.getDateTache().isBefore(dateDebut) && !dateFinTache.isAfter(dateFin)) {
                log.info("Task within the range: {}", tache);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public float studentsEfficacity(Etudiant etudiant, LocalDate dateDebut, LocalDate dateFin) {
        List<Tache> tacheListTerminé = tacheRepository.findAllByEtatTacheAndEtudiant(etudiant, EtatTache.TERMINE);
        List<Tache> tacheListPlanifie = tacheRepository.findAllByEtatTacheAndEtudiant(etudiant, EtatTache.PLANIFIE);

        float totalTachesPlanifie = 0;
        float tachesCompletees = 0;

        for (Tache task : tacheListPlanifie) {
            LocalDate dateFinTache = task.getDateTache().plusDays(task.getDuree());
            if (!task.getDateTache().isBefore(dateDebut) && !dateFinTache.isAfter(dateFin)) {
                totalTachesPlanifie++;
            }
        }
        for (Tache task : tacheListTerminé) {
            LocalDate dateFinTache = task.getDateTache().plusDays(task.getDuree());
            if (!task.getDateTache().isBefore(dateDebut) && !dateFinTache.isAfter(dateFin)) {
                tachesCompletees++;
            }
        }

        if (totalTachesPlanifie == 0) {
            return 0;
        }

        return (tachesCompletees / totalTachesPlanifie) * 100;
    }

    @Override
    public float studentRevenu(Etudiant etudiant, LocalDate dateDebut, LocalDate dateFin) {
        List<Tache> tasks = tacheRepository.findAllByEtatTacheAndEtudiant(etudiant, EtatTache.TERMINE);
        float totalRevenue = 0;

        for (Tache task : tasks) {
            LocalDate dateFinTache = task.getDateTache().atStartOfDay().plusHours(task.getDuree()).toLocalDate();
            if (!task.getDateTache().isBefore(dateDebut) && !dateFinTache.isAfter(dateFin)) {
                totalRevenue += task.getTarifHoraire() * task.getDuree();
                log.info("revenu resultttttttt: {}", totalRevenue);
            }
        }

        return totalRevenue;
    }

        @Override
    public float studentVersatility(Etudiant etudiant, LocalDate dateDebut, LocalDate dateFin) {
        List<Tache> tacheList = tacheRepository.findAllByEtatTacheAndEtudiant(etudiant, EtatTache.TERMINE);

        float nbTacheMenagere = 0;
        float nbTacheJardinage = 0;
        float nbTacheBricolage = 0;

        for (Tache tache : tacheList) {
            LocalDate dateFinTache = tache.getDateTache().atStartOfDay().plusHours(tache.getDuree()).toLocalDate();
            if (!tache.getDateTache().isBefore(dateDebut) && !dateFinTache.isAfter(dateFin)) {
                if (tache.getTypeTache() == TypeTache.MENAGERE) {
                    nbTacheMenagere++;
                } else if (tache.getTypeTache() == TypeTache.JARDINAGE) {
                    nbTacheJardinage++;
                } else if (tache.getTypeTache() == TypeTache.BRICOLAGE) {
                    nbTacheBricolage++;
                }
            }
        }

        float totalTypesPerformed = 0;
        if (nbTacheMenagere > 0) totalTypesPerformed++;
        if (nbTacheJardinage > 0) totalTypesPerformed++;
        if (nbTacheBricolage > 0) totalTypesPerformed++;

        return (totalTypesPerformed / 3.0f) * 100;
    }

    public float studentPerformance(Etudiant etudiant, LocalDate dateDebut, LocalDate dateFin) {
        float efficacity = this.studentsEfficacity(etudiant, dateDebut, dateFin);
        float revenu = this.studentRevenu(etudiant, dateDebut, dateFin);
        float versatility = this.studentVersatility(etudiant, dateDebut, dateFin);

        log.info("Efficiency result: {}", efficacity);

        log.info("revenu result: {}", revenu);
        float result=efficacity + revenu + versatility;
        log.info("Versatility result: {}", result);
        return result;
    }

    @Override
    public LinkedHashMap<Float, Etudiant> studentsPerformanceRanking(LocalDate dateDebut, LocalDate dateFin) {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        Map<Float, Etudiant> performanceMap = new HashMap<>();
        for (Etudiant etudiant : etudiants) {
            float performance = this.studentPerformance(etudiant, dateDebut, dateFin);
            performanceMap.put(performance, etudiant);
        }

        return performanceMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Float, Etudiant>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }}
//ken 3tani bch nsavi list a la fois mathalan : addtasks donc naaml : tacheRepositor.saveAll()



