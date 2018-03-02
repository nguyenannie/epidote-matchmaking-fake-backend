package com.greenfoxacademy.matchmakingfakebackend.repositories;

import com.greenfoxacademy.matchmakingfakebackend.models.Apprentice;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprenticeRepo extends CrudRepository<Apprentice, Integer>, JpaSpecificationExecutor {

  List<Apprentice> findByCohort(String cohort);
  List<Apprentice> findByCohortClass(String cohortClass);
}
