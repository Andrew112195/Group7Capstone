package com.backend.codenexus.model;

public enum Difficulty {
    EASY,
    MEDIUM,
    HARD;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
