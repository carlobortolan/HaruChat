package com.example.haruchat.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.ZonedDateTime;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "from_id")
    @NotNull
    private User from;
    @NotBlank
    private String content;
    @Enumerated(EnumType.STRING)
    private ReadStatus status;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull
    private Conversation conversation;
    @PositiveOrZero
    private int forwardCount = 0;
    @NotNull
    private ZonedDateTime createdAt;
    @NotNull
    private ZonedDateTime updatedAt;

    public Message(Integer id, User from, String content, ReadStatus status, Conversation conversation, int forwardCount, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.id = id;
        this.from = from;
        this.content = content;
        this.status = status;
        this.conversation = conversation;
        this.forwardCount = forwardCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Message() {
    }

    public void forward(User next) {
        //TODO:
    }

    public void send() {
        //TODO:
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.updatedAt = ZonedDateTime.now();
        this.from = from;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.updatedAt = ZonedDateTime.now();
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.updatedAt = ZonedDateTime.now();
        this.content = content;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.updatedAt = ZonedDateTime.now();
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = ZonedDateTime.now();
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.updatedAt = ZonedDateTime.now();
        this.conversation = conversation;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void setForwardCount(int forwardCount) {
        this.updatedAt = ZonedDateTime.now();
        this.forwardCount = forwardCount;
    }

    public ReadStatus getStatus() {
        return status;
    }

    public void setStatus(ReadStatus status) {
        this.updatedAt = updatedAt;
        this.status = status;
    }

}
