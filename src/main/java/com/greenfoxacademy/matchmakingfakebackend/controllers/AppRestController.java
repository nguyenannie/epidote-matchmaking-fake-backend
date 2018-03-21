package com.greenfoxacademy.matchmakingfakebackend.controllers;

import com.greenfoxacademy.matchmakingfakebackend.models.Admin;
import com.greenfoxacademy.matchmakingfakebackend.models.Apprentice;
import com.greenfoxacademy.matchmakingfakebackend.models.Cohort;
import com.greenfoxacademy.matchmakingfakebackend.models.Partner;
import com.greenfoxacademy.matchmakingfakebackend.models.enums.Program;
import com.greenfoxacademy.matchmakingfakebackend.models.enums.Status;
import com.greenfoxacademy.matchmakingfakebackend.services.AdminService;
import com.greenfoxacademy.matchmakingfakebackend.services.ApprenticeService;
import com.greenfoxacademy.matchmakingfakebackend.services.CohortService;
import com.greenfoxacademy.matchmakingfakebackend.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppRestController {

  private final ApprenticeService apprenticeService;
  private final PartnerService partnerService;
  private final AdminService adminService;
  private final CohortService cohortService;

  @Autowired
  public AppRestController(ApprenticeService apprenticeService, PartnerService partnerService, AdminService adminService, CohortService cohortService) {
    this.apprenticeService = apprenticeService;
    this.partnerService = partnerService;
    this.adminService = adminService;
    this.cohortService = cohortService;
  }

  @RequestMapping(value = "/api/apprentice", method = RequestMethod.GET)
  public List apprenticeSearch(@RequestParam(required = false) String cohort,
                               @RequestParam(required = false) String cohortClass,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String lastName,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) Status status,
                               @RequestParam(required = false)Program program) {
    Apprentice apprentice = new Apprentice();
    apprentice.setCohort(cohort);
    apprentice.setCohortClass(cohortClass);
    apprentice.setFirstName(firstName);
    apprentice.setLastName(lastName);
    apprentice.setEmail(email);
    apprentice.setStatus(status);
    apprentice.setProgram(program);
    return apprenticeService.apprenticeList(apprentice);
  }

  @RequestMapping(value = "/api/partner", method = RequestMethod.GET)
  public List partnerSearch(@RequestParam(required = false) String companyName,
                            @RequestParam(required = false) String email,
                            @RequestParam(required = false) Status status,
                            @RequestParam(required = false)Program program) {
    Partner partner = new Partner();
    partner.setCompanyName(companyName);
    partner.setEmail(email);
    partner.setStatus(status);
    partner.setProgram(program);
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

  @RequestMapping(value = "/api/cohort", method = RequestMethod.GET)
  public List cohortSearch(@RequestParam(required = false) String cohortName,
                           @RequestParam(required = false) Status status) {
    Cohort cohort = new Cohort();
    cohort.setCohortName(cohortName);
    cohort.setStatus(status);
    return cohortService.cohortList(cohort);
  }
}
