package com.example.monitorapp.communication;

import com.example.monitorapp.user.User;

public interface CommunicationChannel {
    void sendNotification(User user, Notification notification);
}
