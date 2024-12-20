package com.esprit.tic.twin.project_backend.services;


import com.esprit.tic.twin.project_backend.entities.Etudiant;
import com.esprit.tic.twin.project_backend.entities.Tache;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

public interface ITacheService {
    Integer findAllStudents(LocalDate dateDebut, LocalDate dateFin);

    float studentsEfficacity(Etudiant etudiant);
    float studentRevenu(Etudiant etudiant);
    float studentVersatility(Etudiant etudiant);
    LinkedHashMap<Float, Etudiant> studentsPerformanceRanking();
}
