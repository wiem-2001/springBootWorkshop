package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.entities.Reservation;
import com.esprit.tic.twin.project_backend.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImp implements IReservationService {
    ReservationRepository reservationRepository;


    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut, Date dateFin) {
        return reservationRepository.retrieveReservationParAnneeUniversitaire(dateDebut,dateFin);
    }
}
