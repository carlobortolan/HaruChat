package com.example.haruchat.repository;

import com.example.haruchat.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Integer> {

    @Query("SELECT DISTINCT u.chats FROM User u WHERE u.id = ?1")
    public Iterable<Conversation> findAllByUserId(int userId);
    @Query("SELECT DISTINCT u.chats FROM User u WHERE u.id = ?1 AND EXISTS (SELECT c FROM u.chats c WHERE c.isActive = true)")
    public Iterable<Conversation> findAllActiveByUserId(int userId);

    @Query("UPDATE Conversation c SET c.isActive = false WHERE c.updatedAt < ?1")
    public void deactivateOlderThan(ZonedDateTime zonedDateTime);


}
