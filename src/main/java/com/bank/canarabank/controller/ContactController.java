package com.bank.canarabank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping
    public String getContactDetails() {
        return "This is my contact Details";
    }
}
