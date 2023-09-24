package com.manhnd.cloudnative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.manhnd.cloudnative")
public class CloudNativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNativeApplication.class, args);
    }

}
