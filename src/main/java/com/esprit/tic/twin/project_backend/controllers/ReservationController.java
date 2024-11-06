package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.services.IReservationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    IReservationService reservationService;
}
