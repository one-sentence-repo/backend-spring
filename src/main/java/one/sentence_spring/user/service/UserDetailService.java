package one.sentence_spring.user.service;

import lombok.RequiredArgsConstructor;
import one.sentence_spring.user.entity.User;
import one.sentence_spring.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public User loadUserByUsername(String email) {
    return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException(email));
  }
}
