package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerDemo
{
    @RequestMapping("/say-hello")
    public String sayHello(){
        return "hello";
    }
}