package one.sentence_spring.user.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import one.sentence_spring.user.entity.User;
import one.sentence_spring.user.dto.AddUserRequest;
import one.sentence_spring.user.dto.UpdateUserInfoRequest;
import one.sentence_spring.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @GetMapping
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public void addUser(@RequestBody AddUserRequest request) {
    userService.save(request);
  }

  @PutMapping("/{userId}")
  public void updateUser(@PathVariable Long userId, @RequestBody UpdateUserInfoRequest request) {
    userService.update(userId, request);
  }

  @GetMapping("/{userId}")
  public User getUser(@PathVariable Long userId) {
    return userService.getUser(userId);
  }
}
