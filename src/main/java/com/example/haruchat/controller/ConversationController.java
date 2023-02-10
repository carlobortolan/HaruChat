package com.example.haruchat.controller;

import com.example.haruchat.entity.Conversation;
import com.example.haruchat.service.ConversationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConversationController {
    @Autowired
    private ConversationService conversationService;

    @PostMapping("/conversations")
    public ResponseEntity<?> newConversation(@Valid @RequestBody Conversation newConversation) {
        return new ResponseEntity<Conversation>(conversationService.save(newConversation), HttpStatus.CREATED);
    }

    @GetMapping("/conversations")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<Iterable<Conversation>>(conversationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/conversations/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<Conversation>(conversationService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/conversations/of/{id}")
    public ResponseEntity<?> findAllByUserId(@PathVariable int id) {
        return new ResponseEntity<Iterable<Conversation>>(conversationService.findAllByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/conversations/of/{id}/active")
    public ResponseEntity<?> findAllActive(@PathVariable int id) {
        return new ResponseEntity<Iterable<Conversation>>(conversationService.findAllActiveByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/conversations/by/{id}/inactive")
    public ResponseEntity<?> findAllInactive(@PathVariable int id) {
        return new ResponseEntity<Iterable<Conversation>>(conversationService.findAllInactiveByUserId(id), HttpStatus.OK);
    }

    @PutMapping("/conversations/{id}")
    public ResponseEntity<?> replaceConversation(@PathVariable int id, @Valid @RequestBody Conversation newConversation) {
        newConversation.setId(id);
        return new ResponseEntity<Conversation>(conversationService.save(newConversation), HttpStatus.OK);
    }

    @DeleteMapping("/conversations/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        conversationService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

}
