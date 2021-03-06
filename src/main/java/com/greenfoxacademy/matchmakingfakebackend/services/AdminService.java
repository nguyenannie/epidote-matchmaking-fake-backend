package com.greenfoxacademy.matchmakingfakebackend.services;

import com.greenfoxacademy.matchmakingfakebackend.models.Admin;
import com.greenfoxacademy.matchmakingfakebackend.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

  private final AdminRepo adminRepo;

  @Autowired
  public AdminService(AdminRepo adminRepo) {
    this.adminRepo = adminRepo;
  }

  public List adminList(Admin adminFilter) {
    List admins = adminRepo.findAll((root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (adminFilter.getFirstName() != null) {
        predicates.add(cb.equal(root.get("firstName"), adminFilter.getFirstName()));
      }
      if (adminFilter.getLastName() != null) {
        predicates.add(cb.equal(root.get("lastName"), adminFilter.getLastName()));
      }
      if (adminFilter.getEmail() != null) {
        predicates.add(cb.equal(root.get("email"), adminFilter.getEmail()));
      }
      if (adminFilter.getStatus() != null) {
        predicates.add(cb.equal(root.get("status"), adminFilter.getStatus()));
      }
      return cb.and(predicates.toArray(new Predicate[0]));
    });
    return admins;
  }

}
