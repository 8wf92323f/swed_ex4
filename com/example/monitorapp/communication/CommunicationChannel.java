package com.example.monitorapp.communication;

public interface CommunicationChannel {
    void sendNotification(CommunicationTarget target, Notification notification, float frequency);
}
