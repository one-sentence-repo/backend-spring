package one.sentence_spring.userinfo.controller;

import java.util.List;
import one.sentence_spring.userinfo.domain.UserInfo;
import one.sentence_spring.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<UserInfo> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public void addUser(@RequestBody String userName, @RequestBody String email) {
    userService.addUser(userName, email);
  }

  @GetMapping("/{userId}")
  public UserInfo getUser(@PathVariable int userId) {
    return userService.getUser(userId);
  }
}
