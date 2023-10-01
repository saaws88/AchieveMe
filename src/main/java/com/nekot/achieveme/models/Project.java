package com.nekot.achieveme.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "projects")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;
  @Column(name="project-name")
  private String name;
  @Column(name="project-description")
  private String description;
  @Column(name="project-tasks")
  private List<Task> tasks;
  @Column(name="project-creation-date")
  private Date creationDate;
  @Column(name="project-due-date")
  private Date dueDate;
  @Column(name="project-lead")
  private AchievemeUser projectLead;
  @Column(name="project-status")
  private Status status;

}
