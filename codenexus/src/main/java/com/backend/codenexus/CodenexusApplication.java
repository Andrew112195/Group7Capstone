package com.backend.codenexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.backend")
public class CodenexusApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodenexusApplication.class, args);
    }

}
