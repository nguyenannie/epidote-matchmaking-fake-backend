package com.greenfoxacademy.matchmakingfakebackend.services;

import com.greenfoxacademy.matchmakingfakebackend.models.Partner;
import com.greenfoxacademy.matchmakingfakebackend.repositories.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {

  @Autowired
  PartnerRepo partnerRepo;

  public List<Partner> getAll() {
    return (List<Partner>) partnerRepo.findAll();
  }

  public Partner getOneById(Integer id) {
    return partnerRepo.findOne(id);
  }

  public Partner getOneByEmail(String email) {
    return partnerRepo.findByEmailIsContaining(email);
  }

  public Partner getOneByCompanyName(String companyName) {
    return partnerRepo.findByCompanyNameContaining(companyName);
  }
}
