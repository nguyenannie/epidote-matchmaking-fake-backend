package com.greenfoxacademy.matchmakingfakebackend.repositories;

import com.greenfoxacademy.matchmakingfakebackend.models.Cohort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepo extends CrudRepository<Cohort, Integer>, JpaSpecificationExecutor {
}
