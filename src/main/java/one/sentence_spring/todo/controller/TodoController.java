package one.sentence_spring.todo.controller;

import java.util.List;
import one.sentence_spring.todo.entity.Todo;
import one.sentence_spring.todo.dto.AddTodoRequest;
import one.sentence_spring.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

  private TodoService todoService;

  @Autowired
  public void setTodoService(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/{userId}")
  public List<Todo> getTodoInProgress(@PathVariable Long userId) {
    return todoService.getTodoInProgress(userId);
  }

  @PostMapping
  public void addTodo(@RequestBody AddTodoRequest request) {
    todoService.addTodo(request);
  }

}
