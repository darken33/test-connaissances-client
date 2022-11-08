package com.sqli.workshop.ddd.connaissance.client;

import com.sqli.workshop.ddd.connaissance.client.domain.ConnaissanceClientService;
import com.sqli.workshop.ddd.connaissance.client.domain.ConnaissanceClientServiceImpl;
import com.sqli.workshop.ddd.connaissance.client.domain.ports.ConnaissanceClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableMongoRepositories
@ComponentScan({"com.sqli.workshop.ddd.connaissance.client.*"})
public class ConnaissanceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConnaissanceClientApplication.class, args);
    }

    @Bean
    public ConnaissanceClientService getService(ConnaissanceClientRepository repository) {
        return new ConnaissanceClientServiceImpl(repository);
    }

}
