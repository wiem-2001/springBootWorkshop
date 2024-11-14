package com.esprit.tic.twin.project_backend.repositories;

import com.esprit.tic.twin.project_backend.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UniversityRepository extends JpaRepository<Universite,Long> {

    Universite findUniversitesByNomUniversite(String nom);
}
