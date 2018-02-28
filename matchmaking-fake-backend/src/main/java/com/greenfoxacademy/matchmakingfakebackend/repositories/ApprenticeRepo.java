package com.greenfoxacademy.matchmakingfakebackend.repositories;

import com.greenfoxacademy.matchmakingfakebackend.models.Apprentice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprenticeRepo extends CrudRepository<Apprentice, Integer> {

  List<Apprentice> findAllByCohort(String cohort);
  List<Apprentice> findAllByCohortClass(String cohortClass);
  Apprentice findAllByFirstNameAndLastName(String firstName, String lastName);
  Apprentice findByEmailIsContaining(String email);
  Apprentice findBySlackChannelIdContaining(String slackChannelId);
}
