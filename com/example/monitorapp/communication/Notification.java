package com.example.monitorapp.communication;

public class Notification {
    private final String content;

    public Notification(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
