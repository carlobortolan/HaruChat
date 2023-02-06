package com.example.haruchat.controller;

import com.example.haruchat.entity.BasicUser;
import com.example.haruchat.entity.User;
import com.example.haruchat.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> newUser(@Valid @RequestBody User newUser) {
        return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<Iterable<User>>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/basic")
    public ResponseEntity<?> findAllBasicUsers() {
        return new ResponseEntity<Iterable<BasicUser>>(userService.findAllBasicUsers(), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> replaceUser(@PathVariable int id, @Valid @RequestBody User newUser) {
        newUser.setId(id);
        userService.save(newUser);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
