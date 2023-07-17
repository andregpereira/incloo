package com.andregpereira.challenges.incloo.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InclooApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(InclooApiGatewayApplication.class, args);
    }
}
