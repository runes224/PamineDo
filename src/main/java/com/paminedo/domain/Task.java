package com.paminedo.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Task {

  private @Id @GeneratedValue Long id;
  private String name;
  private String description;
  private boolean completedFlag;
  private boolean regularTaskFlag;
  private LocalDate completedDate;

  Task() {
  }

  Task(String name, String description, boolean completedFlag, boolean regularTaskFlag, LocalDate completedDate) {
    this.name = name;
    this.description = description;
    this.completedFlag = completedFlag;
    this.regularTaskFlag = regularTaskFlag;
    this.completedDate = completedDate;
  }
}
