package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.entities.Etudiant;
import com.esprit.tic.twin.project_backend.entities.Tache;
import com.esprit.tic.twin.project_backend.services.ITacheService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@AllArgsConstructor
public class TacheController {
    ITacheService tacheService;

    @GetMapping("/studentsPerformanceRanking/{dateDebut}/{dateFin}")
    public LinkedHashMap<Float, Etudiant> studentsPerformanceRanking(@PathVariable LocalDate dateDebut,@PathVariable LocalDate dateFin) {
        return tacheService.studentsPerformanceRanking(dateDebut,dateFin);
    }

    @GetMapping("/taches/{dateDebut}/{dateFin}")
    public Integer students(@PathVariable("dateDebut") LocalDate dateDebut, @PathVariable("dateFin") LocalDate dateFin) {
        return tacheService.findAllStudents(dateDebut,dateFin);
    }

}
