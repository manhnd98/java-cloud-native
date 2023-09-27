package com.manhnd.cloudnative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CloudNativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNativeApplication.class, args);

    System.out.println("polar.greeting");
  }
}
