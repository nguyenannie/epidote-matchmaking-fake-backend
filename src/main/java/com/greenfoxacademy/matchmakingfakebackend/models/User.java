package com.greenfoxacademy.matchmakingfakebackend.models;

import javax.persistence.*;

@MappedSuperclass
public abstract class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected int id;
  @Column(nullable = false)
  protected String email;
  @Column(name = "phone_number")
  protected String phoneNumber;
  @Column(name = "is_active_user")
  protected boolean isActiveUser;

  public User() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public boolean isActiveUser() {
    return isActiveUser;
  }

  public void setActiveUser(boolean activeUser) {
    this.isActiveUser = activeUser;
  }
}
