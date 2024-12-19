package one.sentence_spring.user.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import one.sentence_spring.user.entity.User;
import one.sentence_spring.user.dto.AddUserRequest;
import one.sentence_spring.user.dto.UpdateUserInfoRequest;
import one.sentence_spring.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public void save(AddUserRequest request) {
    userRepository.save(User.builder()
        .email(request.email())
        .password(bCryptPasswordEncoder.encode(request.password())).build());
  }

  @Transactional
  public void update(Long userId, UpdateUserInfoRequest request) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new IllegalArgumentException("user not found"));

    user.update(request.getUserName(), request.getAboutMe(), request.getAvatarUrl());
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User getUser(Long userId) {
    return userRepository.findById(userId)
        .orElseThrow(() -> new IllegalArgumentException("user not found"));
  }
}
