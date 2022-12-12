package com.example.wartatenieya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WartateniEyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WartateniEyaApplication.class, args);
    }

}
