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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne()
//    @JoinColumn(name = "from_id")
    @NotNull(message = "FROM CANNOT BE NULL")
    private User from;
    @NotBlank (message = "CONTENT CANNOT BE BLANK")
    private String content;
    @Enumerated(EnumType.STRING)
    private ReadStatus status;
    @ManyToOne()
    @NotNull(message = "CONVERSATION CANNOT BE NULL")
    private Conversation conversation;
    @PositiveOrZero (message = "FORWARDCOUNT CANNOT BE NEGATIVE")
    private int forwardCount = 0;
    @NotNull
    private ZonedDateTime createdAt;
    @NotNull
    private ZonedDateTime updatedAt;

    public Message(User from, String content, Conversation conversation, int forwardCount) {
        this.from = from;
        this.content = content;
        this.status = ReadStatus.NOT_DELIVERED;
        this.conversation = conversation;
        this.forwardCount = forwardCount;
        this.createdAt = ZonedDateTime.now();
        this.updatedAt = ZonedDateTime.now();
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
