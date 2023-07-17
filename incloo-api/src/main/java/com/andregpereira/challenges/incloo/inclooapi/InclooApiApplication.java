package com.andregpereira.challenges.incloo.inclooapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InclooApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(InclooApiApplication.class, args);
    }
}
