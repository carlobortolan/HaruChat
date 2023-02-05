package com.example.haruchat.repository;

import com.example.haruchat.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Integer> {

    @Query("SELECT DISTINCT u.chats FROM User u WHERE u.id = ?1")
    public Iterable<Conversation> findAllByUserId(int userId);
}
