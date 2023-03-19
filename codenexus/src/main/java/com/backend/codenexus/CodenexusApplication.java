package com.backend.codenexus;

import com.backend.codenexus.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.config.Task;

@SpringBootApplication
@ComponentScan("com.backend")
public class CodenexusApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodenexusApplication.class, args);
    }

}
