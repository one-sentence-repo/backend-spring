package one.sentence_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SentenceSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentenceSpringApplication.class, args);
    }

}
