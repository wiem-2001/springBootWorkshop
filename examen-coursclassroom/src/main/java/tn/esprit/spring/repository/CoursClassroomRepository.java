package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CoursClassroom;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Specialite;

@Repository
public interface CoursClassroomRepository extends JpaRepository<CoursClassroom, Integer> {

	@Query("SELECT SUM(cc.nbHeures) FROM CoursClassroom cc WHERE cc.specialite =:specialite AND cc.classe.niveau = :niveau")
	Integer nbHeuresParSpecialiteEtdNiveau(@Param("specialite") Specialite specialite, @Param("niveau") Niveau niveau); 
	
}
