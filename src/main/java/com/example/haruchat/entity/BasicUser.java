package com.example.haruchat.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;

import java.time.ZonedDateTime;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class BasicUser extends User {
    private ZonedDateTime lastSeen;

    public ZonedDateTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(ZonedDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }
}
