package com.example.haruchat.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DirectChat extends Conversation {
//    @NotEmpty
//    @Size(max = 2)
//    @ManyToMany(cascade = CascadeType.PERSIST)
//    private List<User> participants;

    public DirectChat(Integer id, List<User> participants, LinkedList<Message> messages, boolean isActive, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        super(id, participants, messages, isActive, createdAt, updatedAt);
    }

    public DirectChat() {
    }


//    public List<User> getParticipants() {
//        return participants;
//    }

//    public void setParticipants(List<User> participants) {
//        this.participants = participants;
//    }
}
