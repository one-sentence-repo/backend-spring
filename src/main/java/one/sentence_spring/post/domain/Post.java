package one.sentence_spring.post.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

  private Long id;
  private String title;
  private String content;
  private String emotionLevel;
  private AccessType accessType;
  private PostType postType;
  private String[] tags;
  private int commentCount;
  private int likeCount;
}
