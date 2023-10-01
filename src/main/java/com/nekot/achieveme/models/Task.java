package com.nekot.achieveme.models;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "usrs")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name="task-id")
  private Long id;
  @Column(name="task-project")
  private Project project;
  @Column(name="task-name")
  private String name;
  @Column(name="task-descriprion")
  private String description;
  @Column(name="task-creation-date")
  private Date creationDate;
  @Column(name="task-due-date")
  private Date dueDate;
  @Column(name="comment")
  private String comment;
  @Column(name="assigned-user")
  private AchievemeUser assignedUser;
  @Column(name="task-status")
  private Status status;
  @Column(name="tags")
  private List<String> tags;

}
