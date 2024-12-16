package one.sentence_spring.todo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {

  private String content;
  private String memo;
  private int folderId;
  private boolean isCompleted;

}
