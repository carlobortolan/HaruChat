package com.example.haruchat.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@DiscriminatorValue("0")
public class BasicUser extends User {
    private ZonedDateTime lastSeen;

    public BasicUser(Integer id, String password, String username, String email, List<User> friends, List<User> blockedUsers, List<Conversation> chats, List<Message> messagesSent, ZonedDateTime lastSeen) {
        super(id, password, username, email, friends, blockedUsers, chats, messagesSent);
        this.lastSeen = lastSeen;
    }

    public BasicUser(ZonedDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    public BasicUser() {

    }

    public ZonedDateTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(ZonedDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }
}
