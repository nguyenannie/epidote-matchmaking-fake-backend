package com.greenfoxacademy.matchmakingfakebackend.services;

import com.greenfoxacademy.matchmakingfakebackend.models.Apprentice;
import com.greenfoxacademy.matchmakingfakebackend.repositories.ApprenticeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApprenticeService {

  private final ApprenticeRepo apprenticeRepo;

  @Autowired
  public ApprenticeService(ApprenticeRepo apprenticeRepo) {
    this.apprenticeRepo = apprenticeRepo;
  }

  public List apprenticeList(Apprentice apprenticeFilter) {
    List apprentices = apprenticeRepo.findAll((root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (apprenticeFilter.getCohort() != null) {
        predicates.add(cb.equal(root.get("cohort"), apprenticeFilter.getCohort()));
      }
      if (apprenticeFilter.getCohortClass() != null) {
        predicates.add(cb.equal(root.get("cohortClass"), apprenticeFilter.getCohortClass()));
      }
      if (apprenticeFilter.getFirstName() != null) {
        predicates.add(cb.equal(root.get("firstName"), apprenticeFilter.getFirstName()));
      }
      if (apprenticeFilter.getLastName() != null) {
        predicates.add(cb.equal(root.get("lastName"), apprenticeFilter.getLastName()));
      }
      if (apprenticeFilter.getEmail() != null) {
        predicates.add(cb.equal(root.get("email"), apprenticeFilter.getEmail()));
      }
      if (apprenticeFilter.getStatus() != null) {
        predicates.add(cb.equal(root.get("status"), apprenticeFilter.getStatus()));
      }
      if (apprenticeFilter.getProgram() != null) {
        predicates.add(cb.equal(root.get("program"), apprenticeFilter.getProgram()));
      }
      return cb.and(predicates.toArray(new Predicate[0]));
    });
    return apprentices;
  }

}
