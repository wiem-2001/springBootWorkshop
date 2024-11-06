package com.esprit.tic.twin.project_backend.repositories;

import com.esprit.tic.twin.project_backend.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
