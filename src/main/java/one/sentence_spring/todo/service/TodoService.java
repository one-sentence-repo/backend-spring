package one.sentence_spring.todo.service;

import java.util.List;
import one.sentence_spring.todo.entity.Todo;
import one.sentence_spring.todo.dao.TodoDao;
import one.sentence_spring.todo.dto.AddTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private TodoDao todoDao;

  @Autowired
  public void setTodoDao(TodoDao todoDao) {
    this.todoDao = todoDao;
  }

  public void addTodo(AddTodoRequest request) {
    todoDao.saveTodo(request);
  }

  public List<Todo> getTodoInProgress(Long id) {
    return todoDao.findTodosInProgress(id);
  }

}
