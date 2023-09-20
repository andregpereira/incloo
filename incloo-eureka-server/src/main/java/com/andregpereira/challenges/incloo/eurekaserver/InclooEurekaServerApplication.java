package com.andregpereira.challenges.incloo.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class InclooEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InclooEurekaServerApplication.class, args);
    }

}
