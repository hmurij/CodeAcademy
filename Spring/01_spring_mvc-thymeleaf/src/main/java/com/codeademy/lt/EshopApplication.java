package com.codeademy.lt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@RestController
@SpringBootApplication
public class EshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopApplication.class, args);

    }

//    @GetMapping("/hello")
//    public String helloWorld() {
//        return "Hello World!";
//    }
}
