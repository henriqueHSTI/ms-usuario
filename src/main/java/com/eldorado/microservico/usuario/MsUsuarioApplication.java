package com.eldorado.microservico.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MsUsuarioApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsUsuarioApplication.class, args);
    }

}
