package com.greenfoxacademy.matchmakingfakebackend.services;

import com.greenfoxacademy.matchmakingfakebackend.models.Apprentice;
import com.greenfoxacademy.matchmakingfakebackend.repositories.ApprenticeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprenticeService {

  @Autowired
  ApprenticeRepo apprenticeRepo;

  public List<Apprentice> getAll() {
    return (List<Apprentice>) apprenticeRepo.findAll();
  }

  public Apprentice getOneById(Integer id) {
    return apprenticeRepo.findOne(id);
  }

  public Apprentice getOneByEmail(String email) {
    return apprenticeRepo.findByEmailIsContaining(email);
  }

  public Apprentice getOneBySlackId(String slackChannelId) {
    return apprenticeRepo.findBySlackChannelIdContaining(slackChannelId);
  }

  public List<Apprentice> getAllByCohort(String cohort) {
    return apprenticeRepo.findAllByCohort(cohort);
  }

  public List<Apprentice> getAllByClassCohort(String cohortClass) {
    return apprenticeRepo.findAllByCohortClass(cohortClass);
  }

  public Apprentice getAllByName(String firstName, String lastName) {
    return apprenticeRepo.findAllByFirstNameAndLastName(firstName, lastName);
  }
}
