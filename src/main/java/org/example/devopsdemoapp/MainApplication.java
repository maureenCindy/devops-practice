package org.example.devopsdemoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author maureen on 24/5/2020
 */
@SpringBootApplication
@EntityScan(basePackages="org.example.devopsdemoapp.model")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
