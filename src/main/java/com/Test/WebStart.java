package com.Test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationExtensionsKt;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WebStart {
    public static void main(String[] args) {
        SpringApplication.run(WebStart.class);
    }
}
