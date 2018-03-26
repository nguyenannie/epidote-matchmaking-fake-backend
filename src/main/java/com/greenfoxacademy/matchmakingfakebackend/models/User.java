package com.greenfoxacademy.matchmakingfakebackend.models;

import com.greenfoxacademy.matchmakingfakebackend.models.enums.Program;
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
  @Column(name = "program")
  @Enumerated(value = EnumType.STRING)
  protected Program program;
  @Column(name = "has_link_been_sent")
  private boolean hasLinkBeenSent;
  @Column(name = "has_form_been_submitted")
  private boolean hasFormSubmitted;
  @Column
  private boolean hasExpired;

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

  public Program getProgram() {
    return program;
  }

  public void setProgram(Program program) {
    this.program = program;
  }

  public boolean getHasLinkBeenSent() {
    return hasLinkBeenSent;
  }

  public void setHasLinkBeenSent(boolean hasLinkBeenSent) {
    this.hasLinkBeenSent = hasLinkBeenSent;
  }

  public boolean getHasFormSubmitted() {
    return hasFormSubmitted;
  }

  public void setHasFormSubmitted(boolean hasFormSubmitted) {
    this.hasFormSubmitted = hasFormSubmitted;
  }

  public boolean isHasExpired() {
    return hasExpired;
  }

  public void setHasExpired(boolean hasExpired) {
    this.hasExpired = hasExpired;
  }
}
