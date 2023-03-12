package com.mrv;
import java.util.Arrays;

import com.mrv.repository.ASYXProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Application {

    @Autowired
    ASYXProductRepository ASYXProductRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
