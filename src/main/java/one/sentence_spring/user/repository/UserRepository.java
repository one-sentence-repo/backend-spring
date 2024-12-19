package one.sentence_spring.user.repository;

import java.util.Optional;
import one.sentence_spring.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
