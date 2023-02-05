package com.example.haruchat.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@DiscriminatorValue("1")

public class Moderator extends User {
    public Moderator(Integer id, String password, String username, String email, List<User> friends, List<User> blockedUsers, List<Conversation> chats) {
        super(id, password, username, email, friends, blockedUsers, chats);
    }

    public Moderator() {

    }
}
