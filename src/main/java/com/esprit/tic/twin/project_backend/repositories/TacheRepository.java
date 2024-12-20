package com.esprit.tic.twin.project_backend.repositories;

import com.esprit.tic.twin.project_backend.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface TacheRepository extends JpaRepository<Tache,Long> {

   Tache findTacheByEtudiant(Etudiant etudiant);

    @Query("SELECT t FROM Tache t WHERE t.etatTache = :etatTache and t.etudiant=:etudiant")
    List<Tache> findAllByEtatTacheAndEtudiant(@Param("etudiant") Etudiant etudiant,@Param("etatTache") EtatTache etatTache);






}
