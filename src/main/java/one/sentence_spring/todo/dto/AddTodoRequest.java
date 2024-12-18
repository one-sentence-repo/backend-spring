package one.sentence_spring.todo.dto;

public record AddTodoRequest(String content, int folderId, int userId, int index) {
}
