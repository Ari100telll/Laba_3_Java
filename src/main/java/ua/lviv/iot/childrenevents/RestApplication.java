package ua.lviv.iot.childrenevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "ua.lviv.iot.childrenevents.dataaccess", "ua.lviv.iot.childrenevents.business",
    "ua.lviv.iot.childrenevents.controller" })
@EnableJpaRepositories({ "ua.lviv.iot.childrenevents.dataaccess" })
public class RestApplication {
  public static void main(String[] args) {
    System.out.println("-------------------------------------------");
    SpringApplication.run(RestApplication.class, args);
  }
}
