package com.esprit.tic.twin.project_backend.repositories;

import com.esprit.tic.twin.project_backend.entities.Bloc;
import com.esprit.tic.twin.project_backend.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {

   
}
