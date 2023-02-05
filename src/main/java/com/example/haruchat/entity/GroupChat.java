package com.example.haruchat.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class GroupChat extends Conversation {
    @NotBlank
    @Size(min = 1, max = 32)
    private String title;
    @Size(min = 1, max = 128)
    private String description;
    @Size(min = 2, max = 512)
    private int limit;
    @NotEmpty
    @Size(max = 512)
    private List<Integer> admin;
    @NotEmpty
    @Size(max = 512)
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> participants;
    @NotNull
    private boolean isActive;

    public void deactivate() {
        //TODO:
    }

    public void reactivate() {
        //TODO:
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Integer> getAdmin() {
        return admin;
    }

    public void setAdmin(List<Integer> admin) {
        this.admin = admin;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
