package be.adrienhelin.project.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"be.adrienhelin.project.domain"})
@EnableJpaRepositories(basePackages = {"be.adrienhelin.project.domain"})
@SpringBootApplication(scanBasePackages = {"be.adrienhelin.project"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
