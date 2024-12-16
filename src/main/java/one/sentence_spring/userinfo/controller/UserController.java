package one.sentence_spring.userinfo.controller;

import java.util.List;
import one.sentence_spring.userinfo.dto.AddUserRequest;
import one.sentence_spring.userinfo.entity.UserInfo;
import one.sentence_spring.userinfo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<UserInfo> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public void createUser(@RequestBody AddUserRequest request) {
    userService.addUser(request);
  }

  @GetMapping("/{userId}")
  public UserInfo getUser(@PathVariable Long userId) {
    return userService.getUser(userId);
  }
}
