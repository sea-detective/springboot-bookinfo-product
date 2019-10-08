package com.springboot.bookinfo.product.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans(value = {@ComponentScan(value = "com.springboot.bookinfo.product"),
        @ComponentScan(value = "com.springboot.bookinfo.details")})
public class SpringbootBookProductApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBookProductApiApplication.class, args);
    }

}
