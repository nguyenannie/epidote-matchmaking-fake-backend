package com.greenfoxacademy.matchmakingfakebackend.services;

import com.greenfoxacademy.matchmakingfakebackend.models.Cohort;
import com.greenfoxacademy.matchmakingfakebackend.repositories.CohortRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CohortService {

  private final CohortRepo cohortRepo;

  @Autowired
  public CohortService(CohortRepo cohortRepo) {
    this.cohortRepo = cohortRepo;
  }

  public List cohortList(Cohort cohortFilter) {
    List cohorts = cohortRepo.findAll((root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (cohortFilter.getCohortName() != null) {
        predicates.add(cb.equal(root.get("cohortName"), cohortFilter.getCohortName()));
      }
      if (cohortFilter.getStatus() != null) {
        predicates.add(cb.equal(root.get("status"), cohortFilter.getStatus()));
      }
      return cb.and(predicates.toArray(new Predicate[0]));
    });
    return cohorts;
  }

}