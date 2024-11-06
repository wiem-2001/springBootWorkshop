package com.esprit.tic.twin.project_backend.services;

import com.esprit.tic.twin.project_backend.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationServiceImp {
    ReservationRepository reservationRepository;
}
