package com.backend.codenexus.model;

public class enums{

    public enum USER_TYPE {
        ADMIN,
        INSTRUCTOR,
        STUDENT;
    
        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD;
    
    
    }
}

