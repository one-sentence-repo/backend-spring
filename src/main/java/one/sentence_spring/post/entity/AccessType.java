package one.sentence_spring.post.entity;

import lombok.Getter;

@Getter
public enum AccessType {
  PUBLIC("public"),
  PRIVATE("private");

  private final String value;

  AccessType(String value) {
    this.value = value;
  }
}
