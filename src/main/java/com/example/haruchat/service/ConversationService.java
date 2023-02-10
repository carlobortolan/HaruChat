package com.example.haruchat.service;

import com.example.haruchat.entity.Conversation;
import com.example.haruchat.repository.ConversationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.ZonedDateTime;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;


    public Conversation save(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    public Conversation findById(int conversationId) {
        return conversationRepository.findById(conversationId).orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Could not find conversation with ID: {0}", conversationId)));
    }

    public Iterable<Conversation> findAll() {
        return conversationRepository.findAll();
    }

    public Iterable<Conversation> findAllByUserId(int userId) {
        return conversationRepository.findAllByUserId(userId);
    }

    public Iterable<Conversation> findAllActiveByUserId(int userId) {
        return conversationRepository.findAllActiveByUserId(userId);
    }
    public Iterable<Conversation> findAllInactiveByUserId(int userId) {
        return conversationRepository.findAllInactiveByUserId(userId);
    }

    public void deleteById(int conversationId) {
        try {
            conversationRepository.deleteById(conversationId);
        } catch (EntityNotFoundException e) {
            System.err.println(MessageFormat.format("Unable to delete conversation with ID: {0}", conversationId));
        }
    }

    public void deactivateOlderThan(ZonedDateTime zonedDateTime) {
        conversationRepository.deactivateOlderThan(zonedDateTime);
    }
}
