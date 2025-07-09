package com.formmailly;

import com.formmailly.controller.EmailController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan(basePackages = "com.formmailly.controller")
@Import({ EmailController.class }) // Only import what's necessary

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}