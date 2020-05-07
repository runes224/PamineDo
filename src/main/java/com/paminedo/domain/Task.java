package com.paminedo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
class Task {

  private @Id @GeneratedValue Long id;
  private String name;
  private String description;
  private boolean completedFlag;
  private boolean regularTaskFlag;

  Task() {
  }

  Task(String name, String description, boolean completedFlag, boolean regularTaskFlag) {
    this.name = name;
    this.description = description;
    this.completedFlag = completedFlag;
    this.regularTaskFlag = regularTaskFlag;
  }
}
