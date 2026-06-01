package com.example.monitorapp.communication;

/**
 * Example class for demonstration purposes.
 * The Class pretends like it sends emails by printing it to the console.
 */
public class EmailCommunicationChannel implements CommunicationChannel {
    @Override
    public void sendNotification(CommunicationTarget target, Notification notification, float frequency) {
        String address = target.getEmail();

        System.out.println("Email sent to " + address + " with frequency of " + frequency + " :");
        System.out.println(notification.getContent());
        System.out.println();
    }
}
