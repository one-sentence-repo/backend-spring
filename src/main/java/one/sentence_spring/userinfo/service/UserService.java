package one.sentence_spring.userinfo.service;

import one.sentence_spring.userinfo.dto.AddUserRequest;
import one.sentence_spring.userinfo.entity.UserInfo;
import one.sentence_spring.userinfo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(AddUserRequest request) {
        userRepository.saveUser(request);
    }

    public List<UserInfo> getUsers() {
        return userRepository.findAll();
    }

    public UserInfo getUser(Long id) {
        return userRepository.findById(id);
    }
}
