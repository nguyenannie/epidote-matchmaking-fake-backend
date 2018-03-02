package com.greenfoxacademy.matchmakingfakebackend.controllers;

import com.greenfoxacademy.matchmakingfakebackend.models.Apprentice;
import com.greenfoxacademy.matchmakingfakebackend.models.enums.Status;
import com.greenfoxacademy.matchmakingfakebackend.services.ApprenticeService;
import com.greenfoxacademy.matchmakingfakebackend.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppRestController {

  @Autowired
  ApprenticeService apprenticeService;

  @Autowired
  PartnerService partnerService;

  @RequestMapping(value = "/api/apprentice", method = RequestMethod.GET)
  public List complexSearch(@RequestParam(required = false) String cohort,
                            @RequestParam(required = false) String cohortClass,
                            @RequestParam(required = false) String firstName,
                            @RequestParam(required = false) String lastName,
                            @RequestParam(required = false) String email,
                            @RequestParam(required = false) String slackChannelId,
                            @RequestParam(required = false) Status status) {

    Apprentice apprentice = new Apprentice();

    apprentice.setCohort(cohort);
    apprentice.setCohortClass(cohortClass);
    apprentice.setFirstName(firstName);
    apprentice.setLastName(lastName);
    apprentice.setEmail(email);
    apprentice.setSlackChannelId(slackChannelId);
    apprentice.setStatus(status);

    return apprenticeService.apprenticeList(apprentice);
  }

  @RequestMapping(value = "api/apprentice/cohort/{cohort}", method = RequestMethod.GET)
  public List<Apprentice> apprenticesByCohort(@PathVariable String cohort) {
    return apprenticeService.getAllByCohort(cohort);
  }

  @RequestMapping(value = "/api/apprentice/class/{cohortClass}", method = RequestMethod.GET)
  public List<Apprentice> apprenticesByClass(@PathVariable String cohortClass) {
    return apprenticeService.getAllByClassCohort(cohortClass);
  }
}
