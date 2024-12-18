package one.sentence_spring.todo.dao;

import java.util.List;
import one.sentence_spring.todo.domain.Todo;
import one.sentence_spring.todo.dto.AddTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private final static String SAVE_TODO_SQL = "insert into todo(content, folder_id, user_id, index) values(?, ?, ?, ?)";
  private final static String FIND_TODO_IN_PROGRESS_SQL = "select * from todo where user_id = ?";

  public void saveTodo(AddTodoRequest request) {
    jdbcTemplate.update(SAVE_TODO_SQL, request.content(), request.folderId(), request.userId(), request.index());
  }

  public List<Todo> findAllTodoInProgress(int id) {
    return jdbcTemplate.query(FIND_TODO_IN_PROGRESS_SQL, new BeanPropertyRowMapper<>(Todo.class), id);
  }

}
