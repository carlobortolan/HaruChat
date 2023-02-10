package com.example.haruchat.controller;

import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
@RequestMapping("/api")
public class WelcomeController {
    @GetMapping("/welcome")
    public ResponseEntity<?> welcome(Authentication authentication) {
        if (authentication != null) {
            return new ResponseEntity<>(MessageFormat.format("Welcome back {0}!", authentication.getName()), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Welcome to HaruChat!", HttpStatus.OK);
    }
}
