package one.sentence_spring.post.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

  private String title;

  private String content;

  private String emotionLevel;

  private int comment;

  private AccessType accessType;

  private PostType postType;

  private String[] tags;

}
