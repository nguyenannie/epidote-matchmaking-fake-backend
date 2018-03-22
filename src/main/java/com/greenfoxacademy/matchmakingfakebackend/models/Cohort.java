package com.greenfoxacademy.matchmakingfakebackend.models;

import com.greenfoxacademy.matchmakingfakebackend.models.enums.Status;

import javax.persistence.*;

@Entity
@Table(name = "cohort")
public class Cohort {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected int id;
  @Column(name = "cohort_name", nullable = false)
  private String cohortName;
  @Column(name = "status")
  @Enumerated(value = EnumType.STRING)
  private Status status;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCohortName() {
    return cohortName;
  }

  public void setCohortName(String cohortName) {
    this.cohortName = cohortName;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

}
