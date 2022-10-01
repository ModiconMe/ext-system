package edu.javacourse.register.config;

import edu.javacourse.register.dao.PersonDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/register.properties")
public class MarriageConfiguration {
    @Bean
    public PersonDAO buildPersonDAO() {
        System.out.println("PersonDAO is created");
        return new PersonDAO();
    }
}
