package com.greenfoxacademy.matchmakingfakebackend.controllers;

import com.greenfoxacademy.matchmakingfakebackend.models.Admin;
import com.greenfoxacademy.matchmakingfakebackend.models.Apprentice;
import com.greenfoxacademy.matchmakingfakebackend.models.Partner;
import com.greenfoxacademy.matchmakingfakebackend.models.enums.Status;
import com.greenfoxacademy.matchmakingfakebackend.services.AdminService;
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

  @Autowired
  AdminService adminService;

  @RequestMapping(value = "/api/apprentice", method = RequestMethod.GET)
  public List apprenticeSearch(@RequestParam(required = false) String cohort,
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

  @RequestMapping(value = "/api/partner", method = RequestMethod.GET)
  public List partnerSearch(@RequestParam(required = false) String companyName,
                            @RequestParam(required = false) String email,
                            @RequestParam(required = false) Status status) {

    Partner partner = new Partner();

    partner.setCompanyName(companyName);
    partner.setEmail(email);
    partner.setStatus(status);

    return partnerService.partnerList(partner);
  }

  @RequestMapping(value = "/api/admin", method = RequestMethod.GET)
  public List adminSearch(@RequestParam(required = false) String firstName,
                          @RequestParam(required = false) String lastName,
                          @RequestParam(required = false) String email,
                          @RequestParam(required = false) Status status) {

    Admin admin = new Admin();

    admin.setFirstName(firstName);
    admin.setLastName(lastName);
    admin.setEmail(email);
    admin.setStatus(status);

    return adminService.adminList(admin);
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
//TODO: bug fix todo, should delete later
