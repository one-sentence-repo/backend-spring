package one.sentence_spring.todo.dto;

public record AddTodoRequest(String content, Long folderId, Long userId, int index) {
}
