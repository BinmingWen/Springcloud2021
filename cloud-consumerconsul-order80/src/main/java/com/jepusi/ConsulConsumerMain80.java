package com.jepusi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerMain80.class,args);
    }
}
