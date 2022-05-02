package com.codeademy.lt.product.controller;

import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
