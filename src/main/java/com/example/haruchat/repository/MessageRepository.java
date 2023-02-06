package com.example.haruchat.repository;

import com.example.haruchat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query("SELECT m FROM Message m WHERE m.from.id = ?1")
    public Iterable<Message> findAllFromUserId(int userId);

    @Query("SELECT m FROM Message m")
    public Iterable<Message> findAllToUserId(int userId);

    @Query("DELETE Message m WHERE m.createdAt < ?1")
    public void deleteOlderThan(ZonedDateTime zonedDateTime);
}
