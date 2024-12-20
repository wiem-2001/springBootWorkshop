package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

	@Query("SELECT COUNT(u) FROM Utilisateur u WHERE u.classe.niveau = :niveau")
	Integer nbUtilisateurParNiveau(@Param("niveau") Niveau niveau); 

}
