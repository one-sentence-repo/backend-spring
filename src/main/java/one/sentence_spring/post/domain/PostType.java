package one.sentence_spring.post.domain;

import lombok.Getter;

@Getter
public enum PostType {

  ARTICLE("article"), JOURNAL("journal");

  private final String value;

  PostType(String value) {
    this.value = value;
  }
}
