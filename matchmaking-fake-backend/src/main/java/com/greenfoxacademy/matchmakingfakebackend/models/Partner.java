package com.greenfoxacademy.matchmakingfakebackend.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "partner")
public class Partner extends User {

  @Column(name = "company_name", nullable = false)
  private String companyName;

  public Partner() {
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  @Override
  public String toString() {
    return "Partner{ id : " + this.id
            + ", Company name : " + this.companyName
            + ", Email : " + this.email
            + ", Phone Number : " + this.phoneNumber
            + " }";
  }
}
