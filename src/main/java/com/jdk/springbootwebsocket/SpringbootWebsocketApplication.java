package com.jdk.springbootwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebsocketApplication.class, args);
    }
}
