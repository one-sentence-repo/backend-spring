package one.sentence_spring;

import one.sentence_spring.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentenceSpringApplication {

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("string");
        String userName = user.getUserName();

        System.out.println(userName);
        SpringApplication.run(SentenceSpringApplication.class, args);
    }

}
