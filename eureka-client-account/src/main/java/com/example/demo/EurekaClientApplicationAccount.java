package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplicationAccount {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplicationAccount.class, args);
    }

}