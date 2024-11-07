package com.esprit.tic.twin.project_backend.repositories;

import com.esprit.tic.twin.project_backend.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {


    List<Chambre> findByBlocNomBloc(String nom);

    List<Chambre> findByTypeCAndBlocNomBloc(String type,String nom);
    List<Chambre> findByReservationSet_EstValide(Boolean valide);

    List<Chambre> findByBlocNomBlocAndBlocCapaciteBloc(String nom,long capacite);
    @Query("select c from Chambre c where c.bloc.nomBloc=:nom")
    List<Chambre> retrieveChambreByBloc(@Param("nom")String nom);
    @Query("select c from Chambre c where c.typeC=:type and c.bloc.nomBloc=:nom ")
    List<Chambre> retrievechambrebytype(@Param("nom")String nom,@Param("type")String type);
    @Query("SELECT c FROM Chambre c JOIN c.reservationSet r WHERE r.estValide = :valide")
    List<Chambre> retrieveChambreByValidity(@Param("valide")Boolean valide);
    @Query("select c from Chambre c where c.bloc.nomBloc=:nom and c.bloc.capaciteBloc>:nombre")
    List<Chambre> retrieveChambreByNomBlocAndCapacity(@Param("nom")String nom,@Param("nombre")long nombre);
}

