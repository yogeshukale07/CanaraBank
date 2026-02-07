package com.bank.canarabank.controller;

import com.bank.canarabank.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class ContactController {


    @GetMapping("/contact")
    public String getContactDetails() {
        return "This is my contact Details";
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> saveContactDetails(@RequestBody List<Contact> contacts) {
        if (!contacts.isEmpty()) {
            Contact contact = contacts.getFirst();
            //contact.setContactId(getServiceRequestNumber());
            contact.setCreateDt(new Date(System.currentTimeMillis()));

        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
