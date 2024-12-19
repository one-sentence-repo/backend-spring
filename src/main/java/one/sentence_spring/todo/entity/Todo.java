package one.sentence_spring.todo.entity;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {

  private Long id;
  private Timestamp createdAt;
  private int index;
  private String content;
  private String memo;
  private Long folderId;
  private boolean isCompleted;
  private Long userId;

}
