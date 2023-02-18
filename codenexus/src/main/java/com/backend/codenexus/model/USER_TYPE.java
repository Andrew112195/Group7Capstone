package com.backend.codenexus.model;

public enum USER_TYPE {
    ADMIN,
    INSTRUCTOR,
    STUDENT;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}