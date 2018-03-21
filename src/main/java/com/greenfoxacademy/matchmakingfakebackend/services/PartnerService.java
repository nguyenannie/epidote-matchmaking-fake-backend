package com.greenfoxacademy.matchmakingfakebackend.services;

import com.greenfoxacademy.matchmakingfakebackend.models.Partner;
import com.greenfoxacademy.matchmakingfakebackend.repositories.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PartnerService {

  private final PartnerRepo partnerRepo;

  @Autowired
  public PartnerService(PartnerRepo partnerRepo) {
    this.partnerRepo = partnerRepo;
  }

  public List partnerList(Partner partnerFilter) {
    List partners = partnerRepo.findAll((root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (partnerFilter.getCompanyName() != null) {
        predicates.add(cb.equal(root.get("companyName"), partnerFilter.getCompanyName()));
      }
      if (partnerFilter.getEmail() != null) {
        predicates.add(cb.equal(root.get("email"), partnerFilter.getEmail()));
      }
      if (partnerFilter.getStatus() != null) {
        predicates.add(cb.equal(root.get("status"), partnerFilter.getStatus()));
      }
      if (partnerFilter.getProgram() != null) {
        predicates.add(cb.equal(root.get("status"), partnerFilter.getProgram()));
      }
      return cb.and(predicates.toArray(new Predicate[0]));
    });
    return partners;
  }

}
