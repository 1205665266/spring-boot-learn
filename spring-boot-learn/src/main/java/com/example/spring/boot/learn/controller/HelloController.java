package com.example.spring.boot.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloController {


    @GetMapping("/list")
    public String hello(){
        return "Hello World";
    }

}
