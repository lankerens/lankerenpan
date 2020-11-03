package com.lankeren.pan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class LankerenpanApplication {

    public static void main(String[] args) {
        SpringApplication.run(LankerenpanApplication.class, args);
    }

}
