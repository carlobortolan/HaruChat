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
    @JoinColumn(name = "from_id")
    @NotNull
    private User from;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "to_id")
    @NotNull
    private User to;
    @NotBlank
    private String content;
    @ManyToOne
    @NotNull
    private Conversation conversation;
    @PositiveOrZero
    private int forwardCount = 0;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

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

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.updatedAt = ZonedDateTime.now();
        this.to = to;
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
}