package com.iotmars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.iotmars.mapper")
@EnableDiscoveryClient
public class SecurityOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOauth2Application.class, args);
    }

}
