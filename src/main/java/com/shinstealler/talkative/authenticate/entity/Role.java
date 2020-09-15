package com.shinstealler.talkative.authenticate.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document("roles")
@Getter
@Setter
public class Role {
  @Id
  private String id;

  private ERole name;

  public Role() {
  }

  public Role(ERole name) {
    this.name = name;
  }
}
