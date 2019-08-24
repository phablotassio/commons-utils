package com.commons.utils.enumns;

public enum  Message {

    OBJECTS_CANNOT_BE_NULL("Objects cannot be null"),
    OBJECTS_SAME_INTANCE("The objects are not of the same class");

    Message(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
