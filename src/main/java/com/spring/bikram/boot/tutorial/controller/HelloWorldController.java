package com.spring.bikram.boot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String HelloWorld () {
        return "Hello World now with Auto";
    }
}
