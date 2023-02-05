package com.example.haruchat.service;

import com.example.haruchat.entity.Message;
import com.example.haruchat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public Message findById(int messageId) {
        return messageRepository.findById(messageId).orElse(null);
    }

    public Iterable<Message> findAll() {
        return messageRepository.findAll();
    }

    public Iterable<Message> findAllFromUserId(int userId) {
        return messageRepository.findAllFromUserId(userId);
    }

    public Iterable<Message> findAllToUserId(int userId) {
        return messageRepository.findAllToUserId(userId);
    }

    public void deleteById(int messageId) {
        try {
            messageRepository.deleteById(messageId);
        } catch (Exception e) {
            System.err.println("Unable to delete Message with ID: " + messageId);
        }
    }

    public void deleteOlderThan(ZonedDateTime zonedDateTime) {
        messageRepository.deleteOlderThan(zonedDateTime);
    }

}
