package com.morinaga.christianportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.morinaga.christianportal")
public class ChristianPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChristianPortalApplication.class, args);
    }

}
