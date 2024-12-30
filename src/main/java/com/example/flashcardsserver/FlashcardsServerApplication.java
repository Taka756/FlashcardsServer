package com.example.flashcardsserver;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class FlashcardsServerApplication {

    private static final Logger logger = LoggerFactory.getLogger(FlashcardsServerApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(FlashcardsServerApplication.class, args);
    }
    @Bean
    public CommandLineRunner logHelloWorld() {
        return args -> logger.info("Hello world");
    }


}
