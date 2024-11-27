package com.esprit.tic.twin.project_backend.repositories;

import com.esprit.tic.twin.project_backend.entities.Chambre;
import com.esprit.tic.twin.project_backend.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Reservation findByIdReservation(String idresrvation);

    @Query("SELECT r FROM Reservation r WHERE extract(year from r.anneeUniversitaire)  BETWEEN extract(year from :dateDebut)  AND extract(year from :dateFin) ")
    List<Reservation> retrieveReservationParAnneeUniversitaire(@Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);

}
