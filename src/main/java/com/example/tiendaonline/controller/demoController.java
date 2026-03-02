package com.example.tiendaonline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {
    @GetMapping("get")
    public String pediirGet(){
        return "Get";
    }

}
