package one.sentence_spring.todo.dao;

import java.util.List;
import one.sentence_spring.todo.entity.Todo;
import one.sentence_spring.todo.dto.AddTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao {

  private final static String SAVE_TODO_SQL = "insert into todo(content, folder_id, user_id, index) values(?, ?, ?, ?)";
  private final static String FIND_TODO_IN_PROGRESS_SQL = "select * from todo where user_id = ?";
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void saveTodo(AddTodoRequest request) {
    jdbcTemplate.update(SAVE_TODO_SQL, request.content(), request.folderId(), request.userId(),
        request.index());
  }

  public List<Todo> findTodosInProgress(Long id) {
    return jdbcTemplate.query(FIND_TODO_IN_PROGRESS_SQL, new BeanPropertyRowMapper<>(Todo.class),
        id);
  }

}
