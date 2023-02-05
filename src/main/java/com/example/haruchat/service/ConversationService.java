package com.example.haruchat.service;

import com.example.haruchat.entity.Conversation;
import com.example.haruchat.repository.ConversationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;

    public Conversation save(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    public Conversation findById(int conversationId) {
        return conversationRepository.findById(conversationId).orElse(null);
    }

    public Iterable<Conversation> findAllByUserId(int userId) {
        return conversationRepository.findAllByUserId(userId);
    }
    public Iterable<Conversation> findAllActiveByUserId(int userId) {
        return conversationRepository.findAllActiveByUserId(userId);
    }

    public void deleteById(int conversationId) {
        try {
            conversationRepository.deleteById(conversationId);
        } catch (EntityNotFoundException e) {
            System.err.println("Unable to delete Conversation with ID: " + conversationId);
        }
    }

    public void deactivateOlderThan(ZonedDateTime zonedDateTime) {
        conversationRepository.deactivateOlderThan(zonedDateTime);
    }
}
