package com.sportslive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SportsLiveServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsLiveServiceApplication.class, args);
    }
}
