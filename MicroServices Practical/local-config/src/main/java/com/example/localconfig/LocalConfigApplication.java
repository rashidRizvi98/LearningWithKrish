package com.example.localconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class LocalConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalConfigApplication.class, args);
    }

}
