package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.entities.Reservation;
import com.esprit.tic.twin.project_backend.services.IReservationService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class ReservationController {
    IReservationService reservationService;

    @GetMapping("/getReservationParAnneeUniversitaire/{dateDebut}/{dateFin}")
    public List<Reservation> getReservationParAnneeUniversitaire(@PathVariable("dateDebut") Date dateDebut, @PathVariable("dateFin") Date dateFin) {
        return  reservationService.getReservationParAnneeUniversitaire(dateDebut,dateFin);
    }
}
