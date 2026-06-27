package com.example.monitorapp;

import com.example.monitorapp.communication.CommunicationChannel;
import com.example.monitorapp.communication.EmailCommunicationChannel;
import com.example.monitorapp.user.Preferences;
import com.example.monitorapp.user.User;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: no arguments specified (args[0] must be a website url)");
            return;
        }

        Application application = new Application();
        CommunicationChannel emailCommunicationChannel = new EmailCommunicationChannel();
        User john = new User("John Doe");

        john.registerSubscription(args[0], new Preferences(1.0F, emailCommunicationChannel));
        application.addUser(john);
        application.run();
    }
}
