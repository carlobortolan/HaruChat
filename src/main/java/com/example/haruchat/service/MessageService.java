package com.example.haruchat.service;

import com.example.haruchat.entity.Message;
import com.example.haruchat.repository.MessageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.MessageFormat;
import java.time.ZonedDateTime;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public Message findById(int messageId) {
        return messageRepository.findById(messageId).orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Could not find message with ID: {0}", messageId)));
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
            System.err.println(MessageFormat.format("Unable to delete message with ID: {0}", messageId));
        }
    }

    public void deleteOlderThan(ZonedDateTime zonedDateTime) {
        messageRepository.deleteOlderThan(zonedDateTime);
    }

}
