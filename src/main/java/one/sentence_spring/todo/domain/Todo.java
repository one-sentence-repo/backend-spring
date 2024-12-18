package one.sentence_spring.todo.domain;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {

  private int id;

  private Timestamp createdAt;

  private int index;

  private String content;

  private String memo;

  private int folderId;

  private boolean isCompleted;

  private int userId;

}
