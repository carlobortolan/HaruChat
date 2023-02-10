package com.example.haruchat.controller;

import com.example.haruchat.entity.Message;
import com.example.haruchat.repository.MessageRepository;
import com.example.haruchat.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/messages")
    public ResponseEntity<?> newMessage(@Valid @RequestBody Message newMessage) {
        return new ResponseEntity<Message>(messageService.save(newMessage), HttpStatus.CREATED);
    }
    @GetMapping("/messages/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<Message>(messageService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/messages")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<Iterable<Message>>(messageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/messages/by/{id}")
    public ResponseEntity<?> findAllFrom(@PathVariable int id) {
        return new ResponseEntity<Iterable<Message>>(messageService.findAllFromUserId(id), HttpStatus.OK);
    }

//    @GetMapping("/messages/to/{id}")
//    public ResponseEntity<?> findAllTo(@PathVariable int id) {
//        return new ResponseEntity<Iterable<Message>>(messageService.findAllToUserId(id), HttpStatus.OK);
//    }

    @PutMapping("/messages/{id}")
    public ResponseEntity<?> replaceMessage(@PathVariable int id, @Valid @RequestBody Message newMessage) {
        newMessage.setId(id);
        messageService.save(newMessage);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        messageService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @DeleteMapping("/messages/{time}")
    public ResponseEntity<?> deleteOlderThan(@PathVariable ZonedDateTime time) {
        messageService.deleteOlderThan(time);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
