package com.greenfoxacademy.matchmakingfakebackend.models;

import com.greenfoxacademy.matchmakingfakebackend.models.enums.Status;

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
  @Column(name = "status")
  @Enumerated(value = EnumType.STRING)
  protected Status status;

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

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
