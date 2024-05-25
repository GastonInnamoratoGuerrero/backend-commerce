package com.mscommerce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableEurekaClient
@SpringBootApplication
@Slf4j
public class MsCommerceApplication {

    public static void main(String[] args) {
        // Retrieve execution profile from environment variable. If not present, default profile is selected.
        String profile = System.getenv("PROFILE");
        System.setProperty("spring.profiles.active", profile != null ? profile : "default");
        // Railway's internal interface takes some time to start. We wait for it to be ready.
        log.debug("Waiting for Internal Interface to start...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        SpringApplication.run(MsCommerceApplication.class, args);
    }

}
