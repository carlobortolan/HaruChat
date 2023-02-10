package com.example.haruchat.exception;

import jakarta.persistence.PersistenceException;

public class UniqueConstraintException extends PersistenceException {
    public UniqueConstraintException(String message) {
        super(message);
    }
}