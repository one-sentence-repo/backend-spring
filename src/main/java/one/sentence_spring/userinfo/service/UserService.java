package one.sentence_spring.userinfo.service;

import one.sentence_spring.userinfo.domain.UserInfo;
import one.sentence_spring.userinfo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(String userName, String email) {
        userDao.saveUser(userName, email);
    }

    public List<UserInfo> getUsers() {
        return userDao.findAll();
    }

    public UserInfo getUser(int id) {
        return userDao.findById(id);
    }
}
