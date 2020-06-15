package com.iotmars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SecurityOauth2OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOauth2OrderApplication.class, args);
    }

}
