package com.weteam.springboot2case;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MyApplication.class, args);
    }
}
