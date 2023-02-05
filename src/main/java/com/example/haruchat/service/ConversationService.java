package com.example.haruchat.service;

import com.example.haruchat.entity.Conversation;
import com.example.haruchat.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;

    public Conversation findById() {
        return null;
    }

    public Iterable<Conversation> findAllByUserId(int userId) {
        return conversationRepository.findAllByUserId(userId);
    }

}
