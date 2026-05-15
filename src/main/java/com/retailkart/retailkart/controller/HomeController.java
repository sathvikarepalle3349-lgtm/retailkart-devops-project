package com.retailkart.retailkart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "RetailKart DevOps Project Running Successfully 🚀";
    }
}
